package ro.vavedem.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
        @JsonProperty(access= JsonProperty.Access.READ_ONLY)
        private PrimarieModel unitateAdministrativa;
        @NotNull
        private Integer tip;
}
