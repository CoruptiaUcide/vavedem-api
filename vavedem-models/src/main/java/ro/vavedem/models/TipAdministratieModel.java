package ro.vavedem.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by CoruptiaUcide
 */
@Data
public class TipAdministratieModel {

    private Long id;
    @NotNull
    private String nume;

}
