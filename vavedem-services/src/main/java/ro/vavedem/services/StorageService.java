package ro.vavedem.services;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {

    boolean store(List<MultipartFile> file);

}
