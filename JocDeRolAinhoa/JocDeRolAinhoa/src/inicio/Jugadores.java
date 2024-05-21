package inicio;

import Teclat.*;
import static inicio.Equipos.listaEquipos;
import java.util.ArrayList;
import otros.Equipo;
import otros.Poder;
import personajes.*;

/**
 *
 * @author Noa
 */
public class Jugadores {

    // ATRIBUTOS
    /**
     *
     */
    protected static ArrayList<Jugador> lista = new ArrayList();

    // MËTODOS
    static public void menu() {
        int eleccion;
        do {
            eleccion = Teclat.lligOpcio("JUGADORES", "crear", "consultar", "eliminar", "asignar a equipo", "quitar de equipo", "Asignar poder");
            switch (eleccion) {
                case 1 ->
                    crear();
                case 2 ->
                    consultar();
                case 3 ->
                    eliminar();
                case 4 ->
                    asignarEquipo();
                case 5 ->
                    quitarDelEquipo();
                case 6 ->
                    asignarPoder();
                case 0 ->
                    System.out.println("Adios");
                default ->
                    System.out.println("Opcion no valida. Intentalo de nuevo");
            }
        } while (eleccion != 0);
    }

    static public void crear() {
        char eleccionJugador = Teclat.lligChar("Elige el tipo de jugador, humano, guerrero o alien:", "HGA");
        String nombre = Teclat.lligString("Elige el nombre");
        int puntosAtaque = Teclat.lligInt("Introduce los PA (puntos ataque): ", 1, 100);
        int puntosDefensa = 100 - puntosAtaque;
        Jugador jugador = null;
        switch (eleccionJugador) {
            case 'H' -> {
                jugador = new Humano(nombre, puntosAtaque, puntosDefensa, 100);
            }
            case 'G' -> {
                jugador = new Guerrero(nombre, puntosAtaque, puntosDefensa, 100);
            }
            case 'A' -> {
                jugador = new Alien(nombre, puntosAtaque, puntosDefensa, 100);
            }
        }
        lista.add(jugador);
    }

    static public void consultar() {
        for (Jugador jugador : lista) {
            System.out.println(jugador);
        }
    }

    static public void eliminar() {
        String nombreABuscar = Teclat.lligString("Introduce el nombre del jugador: ");
        Jugador jugadorABuscar = new Jugador(nombreABuscar, 0, 0, 0);
        if (lista.remove(jugadorABuscar)) {
            System.out.println("Personaje eliminado");
        } else {
            System.out.println("No se ha encontrado ningun personaje con ese nombre");
        }
    }

    static public void asignarEquipo() {
        String nombreJugador = Teclat.lligString("Introduce el nombre del personaje: ");
        String nombreEquipo = Teclat.lligString("Introduce el nombre del equipo: ");

        Jugador jugadorBuscado = new Jugador(nombreJugador, 0, 0, 0);
        otros.Equipo equipoBuscado = new otros.Equipo(nombreEquipo);

        int indexJugador = lista.indexOf(jugadorBuscado);
        int indexEquipo = Equipos.listaEquipos.indexOf(equipoBuscado);

        if (indexJugador != -1 && indexEquipo != -1) {
            Jugador jugadorReal = lista.get(indexJugador);
            Equipo equipoReal = Equipos.listaEquipos.get(indexEquipo);
            equipoReal.posa(jugadorReal);
        } else {
            if (indexJugador == -1) {
                System.out.println("Jugador no encontrado.");
            }
            if (indexEquipo == -1) {
                System.out.println("Equipo no encontrado.");
            }
        }
    }

    static public void quitarDelEquipo() {
        String nombreJugador = Teclat.lligString("Introduce el nombre del jugador: ");
        Jugador jugadorTemp = new Jugador(nombreJugador, 0, 0, 0);
        int indexJugador = lista.indexOf(jugadorTemp);

        if (indexJugador != -1) {
            Jugador jugadorReal = lista.get(indexJugador);
            Equipo equipo = jugadorReal.getEquipo();
            if (equipo != null) {
                equipo.quita(jugadorReal);
            } else {
                System.out.println("El jugador no está asignado a ningún equipo.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void asignarPoder() {
        String nombreJugador = Teclat.lligString("Introduce el nombre del personaje: ");
        String nombrePoder = Teclat.lligString("Introduce el nombre del poder: ");

        Jugador jugadorBuscado = new Jugador(nombreJugador, 0, 0, 0);
        Poder poderBuscado = new Poder(nombrePoder, 5, 5);

        int indexJugador = lista.indexOf(jugadorBuscado);
        int indexPoder = Poderes.listaPoderes.indexOf(poderBuscado);

        if (indexJugador != -1 && indexPoder != -1) {
            Jugador jugadorReal = lista.get(indexJugador);
            Poder poderReal = Poderes.listaPoderes.get(indexPoder);
            jugadorReal.posa(poderReal);
        } else {
            if (indexJugador == -1) {
                System.out.println("Jugador no encontrado.");
            }
            if (indexPoder == -1) {
                System.out.println("Poder no encontrado.");
            }
        }
    }

}
