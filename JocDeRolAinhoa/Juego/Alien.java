package Juego;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Alien extends Jugador {
    // ATRIBUTOS
    private String nombre;
    private int puntosAtaque;
    private int puntosDefensa;
    private int vidas;
    
    // CONSTRUCTORES
    public Alien(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        super(nombre, puntosAtaque, puntosDefensa, vidas);
        System.out.println("Soy el constructor de Alien pero estoy creando un " + this.getClass().getSimpleName());
    }
}
