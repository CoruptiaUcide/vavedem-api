package ro.vavedem.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Data
public class Judet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    // TODO fix this - now it's an empty set
    @JsonBackReference
    @OneToMany(mappedBy = "judet", cascade = CascadeType.ALL)
    private Set<Primarie> primarii;
}
