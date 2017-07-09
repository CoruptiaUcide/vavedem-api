package ro.vavedem.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param files a list files that will be uploaded in the upload path
     * @return
     */
    @Override
    public boolean store(List<MultipartFile> files) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue; // give me another one
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(rootServerPath + uploadsLocation + SLASH + file.getOriginalFilename());
                Files.write(path, bytes);
            }
        } catch (IOException ioe) {
            logger.error(ioe.getStackTrace());

            return false;
        }

        return true;
    }
}
