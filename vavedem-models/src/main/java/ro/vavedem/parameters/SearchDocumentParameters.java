package ro.vavedem.parameters;

import lombok.Data;

@Data
public class SearchDocumentParameters {
    private String filename;
    private String fileType;
    private String documentType;
    private String documentCategory;
}
