package ro.vavedem.persistence.entities;

import lombok.Data;
import ro.vavedem.enums.LocalityType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author CoruptiaUcide
 */
@Entity
@Table
@Data
public class Localitate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nume;

    @Column
    private Long idJudet;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private LocalityType tip;

    @OneToOne
    @JoinColumn(name = "id_uat")
    private Primarie unitateAdministrativa;

    @Column
    private Long populatie;
}