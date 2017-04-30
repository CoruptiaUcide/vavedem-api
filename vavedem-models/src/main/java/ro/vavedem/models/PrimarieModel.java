package ro.vavedem.models;

import lombok.Data;

/**
 * PrimarieModel - modelul trimis la client in format JSON (aplicatie web,
 * android, etc)
 *
 * @author CoruptiaUcide
 */
@Data
public class PrimarieModel {

    private Long id;
    private String nume;
    private Long codFiscal;
    private AdresaModel adresa;
    private String telefon;
    private String email;
    private Long populatie;
}
