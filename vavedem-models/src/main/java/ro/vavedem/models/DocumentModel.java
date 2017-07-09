package ro.vavedem.models;

import lombok.Data;

/**
 * Data transfer object for RequestDocument
 */
@Data
public class DocumentModel {

    private String filename;

    private String fileType;

    private String serverLocation;

    private String documentType;

    private String documentCategory;
}
