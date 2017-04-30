package ro.vavedem.models;

import lombok.Data;

/**
 * AdresaModel - modelul trimis la client in format JSON (aplicatie web,
 * android, etc)
 *
 * @author CoruptiaUcide
 */
@Data
public class AdresaModel {

    private Long id;
    private String localitatea;
    private String strada;
    private Integer nr;
    private Long codPostal;
}
