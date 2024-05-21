package inicio;

import java.util.ArrayList;
import otros.Poder;
import Teclat.*;
import java.util.Random;

/**
 *
 * @author Noa
 */
public class Poderes {

    protected static ArrayList<Poder> listaPoderes = new ArrayList();

    static void menu() {
        int eleccion;
        do {
            eleccion = Teclat.lligOpcio("PODERES", "crear", "consultar", "eliminar");
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
        String nombrePoder = Teclat.lligString("Introduce el nombre del poder: ");
        Random random = new Random();
        int bonoAtaque = 1 + random.nextInt(30); 
        int bonoDefensa = 1 + random.nextInt(301
        ); 
        Poder poder = new Poder(nombrePoder, bonoAtaque, bonoDefensa);

        if (!listaPoderes.contains(poder)) {
            listaPoderes.add(poder);
            System.out.println("Poder creado correctamente");
        } else {
            System.out.println("Ya existe un poder con ese nombre");
        }
    }

    static public void consultar() {
        for (Poder poder : listaPoderes) {
            System.out.println("[ " + poder.getNombre() + " ] " + poder);
        }
    }

    static public void eliminar() {
        String nombrePoder = Teclat.lligString("Introduce el nombre del poder: ");
        Poder poder = new Poder(nombrePoder, 5, 5);
        if (listaPoderes.remove(poder)) {
            System.out.println("Poder eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado ningun poder con ese nombre");
        }
    }
}
