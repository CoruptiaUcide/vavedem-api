package ro.vavedem.services;


import org.springframework.web.multipart.MultipartFile;
import ro.vavedem.parameters.StoringMetadata;
import ro.vavedem.persistence.entities.RequestDocument;

import java.nio.file.Path;
import java.util.List;

public interface StorageService {

    boolean storeRequestDocument(List<MultipartFile> file, RequestDocument requestDocument, StoringMetadata storingMetadata);

    boolean store(List<MultipartFile> file, Path path);

    RequestDocument extractMetadata(MultipartFile file);

}
