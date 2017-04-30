package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author CoruptiaUcide
 */
@Entity
@Table
@Data
public class Adresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String localitatea;

    @Column
    private String strada;

    @Column
    private Integer nr;

    @Column
    private Long codPostal;
}
