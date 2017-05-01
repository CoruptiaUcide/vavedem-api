package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
*
* @author CoruptiaUcide
*/
@Entity
@Table(name="primarie")
@Data
public class Primarie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nume;

    @Column
    @NotNull
    private Long codFiscal;

    @Column
    @NotNull
    private String telefon;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private Long populatie;

    @NotNull
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "`Id_Adresa`")
    private Adresa adresa;
}
