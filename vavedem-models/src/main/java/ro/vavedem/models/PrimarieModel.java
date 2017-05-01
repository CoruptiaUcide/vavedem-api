package ro.vavedem.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PrimarieModel - modelul trimis la client in format JSON (aplicatie web,
 * android, etc)
 *
 * @author CoruptiaUcide
 */
@Data
public class PrimarieModel {

    private Long id;
    @NotNull
    private String nume;
    @NotNull
    private Long codFiscal;
    @NotNull
    private AdresaModel adresa;
    @NotNull
    private String telefon;
    @NotNull
    private String email;
    @NotNull
    private Long populatie;
}
