package ro.vavedem.models;

import lombok.Data;

@Data
public class SearchCityHallParameters {
    private String name;
    private String email;
    private String countyName;
    private String countyCode;
}
