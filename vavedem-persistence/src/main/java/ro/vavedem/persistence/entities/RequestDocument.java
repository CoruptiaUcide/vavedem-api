package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This entity is used for saving a document on the file system and to store it's metadata into the DB
 */

@Entity
@Table(name = "request_document")
@Data
public class RequestDocument implements Serializable {

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
