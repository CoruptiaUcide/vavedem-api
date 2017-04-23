package ro.vavedem.models;

import java.util.Objects;

/**
 *
 * @author CoruptiaUcide
 */
public class Primarie {

    private String nume;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nume);
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
        return true;
    }

}
