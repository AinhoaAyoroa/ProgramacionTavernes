package otros;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Noa
 */
public class Poder {
    private String nombre;
    private int bonusAtaque;
    private int bonusDefensa;

    public Poder(String nombre, int bonusAtaque, int bonusDefensa) {
        this.nombre = nombre;
        this.bonusAtaque = bonusAtaque;
        this.bonusDefensa = bonusDefensa;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public int getBonusDefensa() {
        return bonusDefensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public void setBonusDefensa(int bonusDefensa) {
        this.bonusDefensa = bonusDefensa;
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
        final Poder other = (Poder) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (BA:" + bonusAtaque + ", " + "BD:"+ bonusDefensa + ')' + "\n";
    }
    
    
}
