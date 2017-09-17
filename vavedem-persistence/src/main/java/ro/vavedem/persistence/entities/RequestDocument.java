package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;

/**
 *  This entity
 */

@Entity
@Table(name = "request_document")
@Data
public class RequestDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String filename;

    @Column
    private String extension;

    @Column
    private String fullName;

    @Column
    private String serverLocation;

    @Column
    private String documentType;

    @Column
    private String documentCategory;
}
