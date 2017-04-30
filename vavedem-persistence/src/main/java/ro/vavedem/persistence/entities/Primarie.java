package ro.vavedem.persistence.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ro.vavedem.models.AdresaModel;

/**
 *
 * @author CoruptiaUcide
 */
@Entity
@Table(name = "administratie")
public class Primarie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nume;
    private Long codFiscal;
    private AdresaModel adresa;
    private String telefon;
    private String email;
    private Long populatie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Long getCodFiscal() {
        return codFiscal;
    }

    public void setCodFiscal(Long codFiscal) {
        this.codFiscal = codFiscal;
    }

    public AdresaModel getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaModel adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPopulatie() {
        return populatie;
    }

    public void setPopulatie(Long populatie) {
        this.populatie = populatie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.nume);
        hash = 19 * hash + Objects.hashCode(this.codFiscal);
        hash = 19 * hash + Objects.hashCode(this.telefon);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.populatie);
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
        final Primarie other = (Primarie) obj;
        if (!Objects.equals(this.nume, other.nume)) {
            return false;
        }
        if (!Objects.equals(this.telefon, other.telefon)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codFiscal, other.codFiscal)) {
            return false;
        }
        if (!Objects.equals(this.populatie, other.populatie)) {
            return false;
        }
        return true;
    }

}
