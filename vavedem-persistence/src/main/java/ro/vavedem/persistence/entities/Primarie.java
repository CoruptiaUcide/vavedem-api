package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
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
    private String nume;

    @Column
    private Long codFiscal;

    @Column
    private String telefon;

    @Column
    private String email;

    @Column
    private Long populatie;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "`Id_Adresa`")
    private Adresa adresa;
}
