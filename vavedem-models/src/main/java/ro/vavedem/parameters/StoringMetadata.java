package ro.vavedem.parameters;

import lombok.Data;

@Data
public class StoringMetadata {
    private String storagePath;
    private Long timestamp;
    private String date; //yyyy-MM-dd-SS-mm-SSSS
    private String countyCode;
    private String cityHallId;
    private String fileCategory; // request, template, response from an institution

}
