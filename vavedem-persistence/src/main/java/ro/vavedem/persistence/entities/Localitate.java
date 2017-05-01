package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author CoruptiaUcide
 */
@Entity
@Table(name="localitate")
@Data
public class Localitate implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private String nume;
        private Primarie unitateAdministrativa;
        @NotNull
        private Integer tip;
}
