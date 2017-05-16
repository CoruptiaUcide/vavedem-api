package ro.vavedem.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ro.vavedem.enums.LocalityType;

import javax.validation.constraints.NotNull;

/**
 * LocalitateModel - modelul trimis la client in format JSON (aplicatie web,
 * android, etc)
 *
 * @author CoruptiaUcide
 */
@Data
public class LocalitateModel {

    private Long id;

    @NotNull
    private String nume;

    @NotNull
    private Long idJudet;

    @NotNull
    private LocalityType tip;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private PrimarieModel unitateAdministrativa;

    private Long populatie;

}
