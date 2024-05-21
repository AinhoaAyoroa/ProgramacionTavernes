package otros;

import personajes.Jugador;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Noa
 */
public class Equipo {

    // ATRIBUTOS
    private String nombre;
    protected ArrayList<Jugador> jugadores = new ArrayList();

    // CONSTRUCTOR

    /**
     *
     * @param nombre
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
     
    // MÉTODOS

    /**
     *
     * @param jugador
     */
    public void posa(Jugador jugador) {
        boolean contiene = this.jugadores.contains(jugador);
        if (contiene == false) {
            this.jugadores.add(jugador);
            if (jugador.getEquipo() != this) {
                jugador.setEquipo(this);
                System.out.println("Jugador:" + jugador.getNombre() + " anadido con exito");
            }
        }
    }

    /**
     *
     * @param nombre
     */
    public void quita(Jugador nombre) {
        boolean contiene = this.jugadores.contains(nombre);
        if (contiene == true) {
            this.jugadores.remove(nombre);
            nombre.setEquipo(null);
            System.out.println("Jugador:" + nombre.getNombre() + " eliminado del equipo");
        } 
    }

    // GETTERS

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    // SETTERS

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param jugadores
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String equipo = "Jugadores en el equipo: \n";
    
    for (Jugador jugador : jugadores) {
        equipo += jugador.toString() + "\n";
    }
    
    return equipo;
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
        final Equipo other = (Equipo) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

}
