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
public class EmailAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String fromAddress;

    @Column
    @NotNull
    private String toAddress;

    @Column
    @NotNull
    private String subject;

    @Column
    @NotNull
    private String content;

    @Column
    private String formular;

}
