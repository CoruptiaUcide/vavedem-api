package ro.vavedem.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * AdresaModel - modelul trimis la client in format JSON (aplicatie web,
 * android, etc)
 *
 * @author CoruptiaUcide
 */
@Data
public class AdresaModel {

    private Long id;
    @NotNull
    private String localitatea;
    @NotNull
    private String strada;
    @NotNull
    private Integer nr;
    @NotNull
    private Long codPostal;
}
