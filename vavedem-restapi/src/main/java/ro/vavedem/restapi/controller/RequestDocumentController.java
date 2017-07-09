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
import ro.vavedem.persistence.repository.RequestDocumentRepository;
import ro.vavedem.projections.ProjWithFilename;
import ro.vavedem.services.StorageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * This controller will handle the documents that are sent back and fourth between server and client
 */

@Controller
@RequestMapping(value = "/document")
public class RequestDocumentController {

    private static final Logger logger = Logger.getLogger(RequestDocumentController.class);

    final static String EMPTY_STRING = "";
    final static String DOT = ".";
    final static String DEFAULT_FILE_TYPE = "doc"; // editable word

    @Value("${spring.documents.rootServerLocation}")
    private String rootServerDocumentsLocation;

    @Value("${spring.documents.templatesServerRelativeLocation}")
    private String templatesServerRelativeLocation;

    @Autowired
    private RequestDocumentRepository documentRepository;

    @Autowired
    private StorageService storageService;

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
        if (StringUtils.isEmpty(downloadParameters.getFileType())) {
            downloadParameters.setFileType(DEFAULT_FILE_TYPE);
        }

        final String requestedFile = downloadParameters.getFileName() + DOT + downloadParameters.getFileType();

        // check if it exist in the DB first
        if (null == documentRepository.findByFilenameAndFileType(downloadParameters.getFileName(), downloadParameters.getFileType())) {
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

    // TODO user authentication
    @PostMapping("/uploadDocument")
    public ResponseEntity<?> handleUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Please select a file", HttpStatus.OK);
        }

        storageService.store(Arrays.asList(file));

        return new ResponseEntity("Successfully uploaded - " + file, HttpStatus.OK);
    }

}
