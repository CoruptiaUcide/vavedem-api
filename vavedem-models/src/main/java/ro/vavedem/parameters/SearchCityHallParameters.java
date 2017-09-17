package ro.vavedem.parameters;

import lombok.Data;

@Data
public class SearchCityHallParameters {
    private String name;
    private String email;
    private String countyName;
    private String countyCode;
}
