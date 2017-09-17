package ro.vavedem.parameters;

import lombok.Data;

@Data
public class StoringMetadata {
    private String storagePath;
    private String timestamp;
    private String countyCode;
    private String cityHallId;
    private String fileCategory; // request, template, response from an institution

}
