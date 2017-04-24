/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.vavedem.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author CoruptiaUcide
 */
public class Adresa implements Serializable {

    private Long id;
    private String localitatea;
    private String strada;
    private Integer nr;
    private String codPostal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalitatea() {
        return localitatea;
    }

    public void setLocalitatea(String localitatea) {
        this.localitatea = localitatea;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.localitatea);
        hash = 89 * hash + Objects.hashCode(this.strada);
        hash = 89 * hash + Objects.hashCode(this.nr);
        hash = 89 * hash + Objects.hashCode(this.codPostal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresa other = (Adresa) obj;
        if (!Objects.equals(this.localitatea, other.localitatea)) {
            return false;
        }
        if (!Objects.equals(this.strada, other.strada)) {
            return false;
        }
        if (!Objects.equals(this.codPostal, other.codPostal)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nr, other.nr)) {
            return false;
        }
        return true;
    }


}
