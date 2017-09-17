package ro.vavedem.models;

import lombok.Data;

/**
 * Data transfer object for RequestDocument
 */
@Data
public class DocumentModel {

    private String filename;

    private String extension;

    private String serverLocation;

    private String documentType;

    private String documentCategory;
}
