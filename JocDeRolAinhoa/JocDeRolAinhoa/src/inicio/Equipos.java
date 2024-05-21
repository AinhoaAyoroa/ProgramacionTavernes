package inicio;

import Teclat.Teclat;
import java.util.ArrayList;
import otros.Equipo;

/**
 *
 * @author Noa
 */
public class Equipos {

    // ATRIBUTOS
    /**
     *
     */
    protected static ArrayList<Equipo> listaEquipos = new ArrayList();

    // MËTODOS
    /**
     *
     */
    static public void menu() {
        int eleccion;
        do {
            eleccion = Teclat.lligOpcio("EQUIPOS", "crear", "consultar", "eliminar");
            switch (eleccion) {
                case 1 ->
                    crear();
                case 2 ->
                    consultar();
                case 3 ->
                    eliminar();
                case 0 ->
                    System.out.println("Adios");
                default ->
                    System.out.println("Opcion no valida. Intentalo de nuevo");
            }
        } while (eleccion != 0);
    }

    static public void crear() {
        String nombreEquipo = Teclat.lligString("Introduce el nombre del equipo: ");
        Equipo equipo = new Equipo(nombreEquipo);
        if (!listaEquipos.contains(equipo)) {
            listaEquipos.add(equipo);
            System.out.println("Equipo creado correctamente");
        } else {
            System.out.println("Ya existe un equipo con ese nombre");
        }
    }

    static public void consultar() {
        for (Equipo equipo : listaEquipos) {
            System.out.println("[ " + equipo.getNombre() + " ] " + equipo);
        }
    }

    static public void eliminar() {
        String nombreEquipo = Teclat.lligString("Introduce el nombre del equipo: ");
        Equipo equipo = new Equipo(nombreEquipo);
        if (listaEquipos.remove(equipo)) {
            System.out.println("Equipo eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado ningun equipo con ese nombre");
        }
    }
}
