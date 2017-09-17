package ro.vavedem.restapi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.vavedem.parameters.DownloadParameters;
import ro.vavedem.parameters.SearchDocumentParameters;
import ro.vavedem.parameters.StoringMetadata;
import ro.vavedem.persistence.entities.RequestDocument;
import ro.vavedem.persistence.repository.LocalitateRepository;
import ro.vavedem.persistence.repository.PrimarieRepository;
import ro.vavedem.persistence.repository.RequestDocumentRepository;
import ro.vavedem.projections.ProjWithFilename;
import ro.vavedem.services.StorageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * This controller will handle the documents that are sent back and fourth between server and client
 */

@Controller
@RequestMapping(value = "/document")
public class RequestDocumentController {

    private static final Logger logger = Logger.getLogger(RequestDocumentController.class);

    final static String dateTimeMillisFormat = "yyyy-MM-dd-H:mm:ss:SSS";

    final static String EMPTY_STRING = "";
    final static String DOT = ".";
    final static String DEFAULT_FILE_TYPE = "doc"; // editable word
    final static String UPLOADS = "uploads";
    private static final String SLASH = "/";

    @Value("${spring.documents.rootServerLocation}")
    private String rootServerDocumentsLocation;

    @Value("${spring.documents.templatesServerRelativeLocation}")
    private String templatesServerRelativeLocation;

    @Value("${spring.documents.uploadedServerRelativeLocation}")
    private String uploadedServerRelativeLocation;

    @Autowired
    private RequestDocumentRepository documentRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private LocalitateRepository localitateRepository;

    @Autowired
    private PrimarieRepository primarieRepository;

    /**
     * This method will retrieve a list of document names that are the templates for different types of request
     * The template documents will have a dedicated server location
     */
    @RequestMapping("/getTemplates")
    @ResponseBody
    public Page<ProjWithFilename> getTemplates(Pageable pageable) {
        return documentRepository.findByFilenameContainsAndServerLocation(EMPTY_STRING, templatesServerRelativeLocation, pageable);
    }

    /**
     * Search templates by filename - for now
     */
    @RequestMapping("/searchTemplates")
    @ResponseBody
    public Page<ProjWithFilename> searchTemplates(@ModelAttribute SearchDocumentParameters parameters, Pageable pageable) {
        String searchData = parameters != null && !StringUtils.isEmpty(parameters.getFilename()) ? parameters.getFilename() : EMPTY_STRING;

        return documentRepository.findByFilenameContainsAndServerLocation(searchData, templatesServerRelativeLocation, pageable);
    }

    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(@ModelAttribute DownloadParameters downloadParameters, HttpServletResponse response) {
        // rootServerLocation + /templates + filename + . + fileType
        if (StringUtils.isEmpty(downloadParameters) || StringUtils.isEmpty(downloadParameters.getFileName())) {
            logger.debug("No filename or fileType to /downloadTemplate");

            return;
        }

        // by default, the templates will be in .doc format
        if (StringUtils.isEmpty(downloadParameters.getExtension())) {
            downloadParameters.setExtension(DEFAULT_FILE_TYPE);
        }

        final String requestedFile = downloadParameters.getFileName() + DOT + downloadParameters.getExtension();

        // check if it exist in the DB first
        if (null == documentRepository.findByFilenameAndExtension(downloadParameters.getFileName(), downloadParameters.getExtension())) {
            logger.debug("File " + requestedFile + " was not found in the database");

            return;
        }

        String dataDirectory = rootServerDocumentsLocation + templatesServerRelativeLocation;
        Path file = Paths.get(dataDirectory, requestedFile);


        if (Files.exists(file) && !Files.isDirectory(file)) {
            try {
                // find the content type of the given file
                response.setContentType(Files.probeContentType(file));
                response.addHeader("Content-Disposition", "attachment; filename=" + requestedFile);

                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                logger.error(Arrays.toString(e.getStackTrace()));
            }
        } else {
            logger.debug("The requested file: " + file.toString() + " was not found or it is a directory");
        }
    }

    // todo refactor to use a single method of uploading - more details required from caller
    /**
     * For test: cd to file location then use:
     * curl -i -X POST -H "Content-Type: multipart/form-data" -F "file=@cerere2.pdf" localhost:8090/document/uploadDocument
     * Upload single file to filesystem and save it's metadata into the database
     */
    @PostMapping("/uploadTemplateDocument")
//    @PreAuthorize("isFullyAuthenticated()")
    public ResponseEntity<?> handleTemplateUpload(@RequestParam("file") MultipartFile file, Principal principal) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Please select a file", HttpStatus.OK);
        }

        RequestDocument documentMetadata = storageService.extractMetadata(file);
        StoringMetadata storingMetadata = new StoringMetadata();
        storingMetadata.setStoragePath(rootServerDocumentsLocation + templatesServerRelativeLocation + SLASH);
        storingMetadata.setTimestamp(LocalDate.now().toString());
        storingMetadata.setFileCategory("template");

        boolean stored = storageService.store(Arrays.asList(file), documentMetadata, storingMetadata);

        if (stored) {
            // save it to the DB
            RequestDocument requestDocument = new RequestDocument();
            requestDocument.setFilename(documentMetadata.getFilename());
            requestDocument.setExtension(documentMetadata.getExtension());
            requestDocument.setServerLocation(templatesServerRelativeLocation);
            requestDocument.setDocumentCategory("request");
            requestDocument.setDocumentType("upload");
            requestDocument.setFullName(documentMetadata.getFullName());

            RequestDocument saved = documentRepository.save(requestDocument);

            if (null == saved) {
                logger.warn("document not saved to DB");
            }
        }

        return new ResponseEntity("Successfully uploaded - " + file, HttpStatus.OK);
    }

    /**
     * Upload a request document that needs to be sent to a institution
     * <p/>
     * Steps:
     * 1. Upload file to the file system
     * 2. Save document metadata into the database
     * 3. Send email to the institution with the attached document TODO to be discussed exactly how to do that
     */
    @PostMapping("/uploadRequestDocument")
//    @PreAuthorize("isFullyAuthenticated()")
    public ResponseEntity<?> handleRequestUpload(@RequestParam("file") MultipartFile file, Principal principal) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Please select a file", HttpStatus.OK);
        }

        RequestDocument documentMetadata = storageService.extractMetadata(file);
        StoringMetadata storingMetadata = new StoringMetadata();
        storingMetadata.setStoragePath(rootServerDocumentsLocation + uploadedServerRelativeLocation + SLASH);
        storingMetadata.setTimestamp(LocalDate.now().toString());
        storingMetadata.setFileCategory("request");

        boolean stored = storageService.store(Arrays.asList(file), documentMetadata, storingMetadata);

        if (stored) {
            // save it to the DB
            RequestDocument requestDocument = new RequestDocument();
            requestDocument.setFilename(file.getName());
            requestDocument.setExtension(file.getContentType());
            requestDocument.setServerLocation(UPLOADS);
            requestDocument.setDocumentCategory("request");
            requestDocument.setDocumentType("upload");

            RequestDocument saved = documentRepository.save(requestDocument);

            if (null == saved) {
                logger.warn("document not saved to DB");
            }
        }

        return new ResponseEntity("Successfully uploaded - " + file, HttpStatus.OK);
    }
}
