package personajes;

import Teclat.Pantalla;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Alien extends Jugador {

    // CONSTRUCTORES

    /**
     *
     * @param nombre
     * @param puntosAtaque
     * @param puntosDefensa
     * @param vidas
     */
    public Alien(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        super(nombre, puntosAtaque, puntosDefensa, vidas);

        // System.out.println("Soy el constructor de Alien pero estoy creando un " + this.getClass().getSimpleName());
    }

    //TODO

    /**
     *
     * @param jugadorAtacado
     */
    @Override
    public void ataca(Jugador jugadorAtacado) throws InterruptedException {
        if (this.vidas < 20) {
            this.puntosAtaque = puntosAtaque + 3;
            this.puntosDefensa = puntosDefensa - 3;
        }
        super.ataca(jugadorAtacado);
    }
}
