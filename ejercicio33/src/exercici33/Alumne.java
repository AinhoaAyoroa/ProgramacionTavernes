package exercici33;

import java.util.Objects;


public class Alumne {
    private String dni;
    private String nom;
    private String cognoms;
    private int edat;
    private String poble;

    public Alumne(String dni) {
        this.dni = dni;
    }

    Alumne() {
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Alumne other = (Alumne) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        // 12999999 Pep Garcia Garcia, 21 anys (Sueca)
        return  dni + " " + nom + " " + cognoms + ", " + edat + " anys (" + poble + ')';
    }

    public Alumne(String dni, String nom, String cognoms, int edat, String poble) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.poble = poble;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getPoble() {
        return poble;
    }

    public void setPoble(String poble) {
        this.poble = poble;
    }

}
