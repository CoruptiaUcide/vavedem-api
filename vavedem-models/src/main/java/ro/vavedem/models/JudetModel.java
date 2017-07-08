package ro.vavedem.models;

import lombok.Data;

/**
 * Data transfer object for {@see ro.vavedem.persistence.entities.Judet}
 */

@Data
public class JudetModel {
    private Long id;
    private String code;
    private String name;
}
