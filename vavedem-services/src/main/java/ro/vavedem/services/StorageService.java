package ro.vavedem.services;


import org.springframework.web.multipart.MultipartFile;
import ro.vavedem.parameters.StoringMetadata;
import ro.vavedem.persistence.entities.RequestDocument;

import java.util.List;

public interface StorageService {

    boolean store(List<MultipartFile> file, RequestDocument requestDocument, StoringMetadata storingMetadata);

    RequestDocument extractMetadata(MultipartFile file);

}
