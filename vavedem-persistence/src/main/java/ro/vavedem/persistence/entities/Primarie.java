package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author CoruptiaUcide
 */

@Entity
@Table(name = "primarie")
@Data
public class Primarie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nume;

    // numerical value of length between 6 and 9
    @Column
    @NotNull
    private Long codFiscal;

    @Column
    @NotNull
    private String telefon;

    // numerical value of fixed length of 6
    @Column
    @NotNull
    private Long codSiruta;

    @Column
    @NotNull
    private String email;


    @Transient
    private Adresa adresa;

    @ManyToOne
    @JoinColumn(name = "id_judet")
    private Judet judet;
}
