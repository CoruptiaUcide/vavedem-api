package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private String localitatea;

    @Column
    @NotNull
    private String strada;

    @Column
    @NotNull
    private Integer nr;

    @Column
    @NotNull
    private Long codPostal;
}
