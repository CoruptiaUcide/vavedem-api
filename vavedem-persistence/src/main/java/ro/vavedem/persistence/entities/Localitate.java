package ro.vavedem.persistence.entities;

import lombok.Data;
import ro.vavedem.models.PrimarieModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author CoruptiaUcide
 */
@Entity
@Table(name="localitate")
@Data
public class Localitate {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private String nume;
        private PrimarieModel unitateAdministrativa;
        @NotNull
        private Integer tip;
}
