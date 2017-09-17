package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ro.vavedem.parameters.StoringMetadata;
import ro.vavedem.persistence.entities.RequestDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = Logger.getLogger(StorageService.class);

    private static final String SLASH = "/";

    @Value("${spring.documents.rootServerLocation}")
    private String rootServerPath;

    @Value("${spring.documents.uploadedServerRelativeLocation}")
    private String uploadsLocation;

    /**
     * The storing method should be able to adapt to all types of storing: requests, templates and responses from institutions
     *
     * @param files a list files that will be uploaded
     */
    @Override
    public boolean store(List<MultipartFile> files, RequestDocument requestDocumentMetadata, StoringMetadata storingMetadata) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue; // give me another one
                }

                byte[] bytes = file.getBytes();

                Path path = Paths.get(storingMetadata.getStoragePath() +
                        (!StringUtils.isEmpty(storingMetadata.getCountyCode()) ? storingMetadata.getCountyCode() : "") +
                        (!StringUtils.isEmpty(storingMetadata.getCityHallId()) ? storingMetadata.getCityHallId() : "") +
                        requestDocumentMetadata.getFilename() +
                        storingMetadata.getTimestamp() +
                        requestDocumentMetadata.getExtension());
                Files.write(path, bytes);
            }
        } catch (IOException ioe) {
            logger.error(ioe.getStackTrace());

            return false;
        }

        return true;
    }

    /**
     * Given a MultipartFile, extract the required metadata information for a RequestDocument in order to be used
     * in filesystem storage, database storage and email text
     */
    @Override
    public RequestDocument extractMetadata(MultipartFile file) {
        if (null == file || file.isEmpty()) {
            logger.warn("null file given to extract metadata from");

            return null;
        }

        String fullName = file.getOriginalFilename(); // full name - including extension (docFormat)
        String extension = fullName.substring(fullName.lastIndexOf('.')); // doc, pdf, etc
        String fileName = fullName.substring(0, fullName.lastIndexOf('.')); // without extension

        RequestDocument requestDocument = new RequestDocument();
        requestDocument.setFilename(fileName);
        requestDocument.setExtension(extension);
        requestDocument.setFullName(fullName);
        // other fields will be completed depending on the scope

        return requestDocument;
    }
}
