package ro.vavedem.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Role {

    @Id
    private Integer id;

    @Column
    private String role;

}
