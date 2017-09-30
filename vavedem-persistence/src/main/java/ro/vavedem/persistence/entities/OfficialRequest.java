package ro.vavedem.persistence.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The OfficialRequest hold the information about an user request towards an institution
 */
@Table
@Entity
@Data
public class OfficialRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Primarie institution;

    @OneToOne
    @JoinColumn(name = "request_document_id")
    private RequestDocument document;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @Column
    private String status;
}
