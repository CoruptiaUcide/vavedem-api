package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Data
public class Role implements Serializable {

    @Id
    private Integer id;

    @Column
    private String role;
}
