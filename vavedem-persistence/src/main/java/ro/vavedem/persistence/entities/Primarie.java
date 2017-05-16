package ro.vavedem.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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


//    @OneToOne(mappedBy = "unitateAdministrativa")
//    private Localitate localitate;

    // unidirectional Localitate -> Adresa
//    @NotNull
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "id_adresa")
    @Transient
    private Adresa adresa;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_judet")
    private Judet judet;
}
