package inicio;

import Teclat.Pantalla;
import Teclat.Teclat;
import static inicio.Jugadores.lista;
import java.util.Random;
import personajes.Jugador;

/**
 *
 * @author Noa
 */
public class Menu {

    static int eleccion;

    static public void menu() throws InterruptedException {
        do {
            eleccion = Teclat.lligOpcio("JUEGO DE ROL", "configuracion", "jugar");
            if (eleccion == 1) {
                menuConfiguracion();
            } else {
                jugar();
            }
        } while (eleccion != 0);
        System.out.println("Gracias por jugar");
    }

    static protected void menuConfiguracion() throws InterruptedException {
        do {
            eleccion = Teclat.lligOpcio("CONFIGURACION", "jugadores", "equipos", "poderes");
            switch (eleccion) {
                case 1 ->
                    Jugadores.menu();
                case 2 ->
                    Equipos.menu();
                case 3 ->
                    Poderes.menu();
                case 0 ->
                    Pantalla.titolet("Volviendo al menu principal");
                default ->
                    System.out.println("Opcion no valida. Intentalo de nuevo");
            }
        } while (eleccion != 0);
        menu();
    }

    static public void jugar() throws InterruptedException {
        Random random = new Random();
        int batallas = 0;

        while (lista.size() > 1) {
            int indiceAtacante = random.nextInt(lista.size());
            Jugador atacante = lista.get(indiceAtacante);

            int indiceAtacado;
            do {
                indiceAtacado = random.nextInt(lista.size());
            } while (indiceAtacado == indiceAtacante);

            Jugador atacado = lista.get(indiceAtacado);

            int vidasAtacanteAntes = atacante.getVidas();
            int vidasAtacadoAntes = atacado.getVidas();

            atacante.ataca(atacado);

            int vidasAtacanteDespues = atacante.getVidas();
            int vidasAtacadoDespues = atacado.getVidas();

            if (vidasAtacanteAntes == vidasAtacanteDespues && vidasAtacadoAntes == vidasAtacadoDespues) {
                batallas++;
            } else {
                batallas = 0;
            }

            if (batallas >= 3) {
                System.out.println("Empate. Ningun jugador esta quitando vida al otro.");
                return;
            }

            lista.removeIf(jugador -> jugador.getVidas() <= 0);
            Pantalla.titolet("Estado actual de los jugadores:");
            for (Jugador jugador : lista) {
                System.out.println(jugador);
            }
        }

        if (lista.size() == 1) {
            Pantalla.titol("El ganador es: " + lista.get(0).getNombre());
        } else {
            Pantalla.titol("No hay jugadores vivos.");
        }
    }
}
