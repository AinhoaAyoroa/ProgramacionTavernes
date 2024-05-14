package Juego;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Guerrero extends Humano{
    // ATRIBUTOS
    private String nombre;
    private int puntosAtaque;
    private int puntosDefensa;
    private int vidas;
    
    // CONSTRUCTORES
    public Guerrero(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        super(nombre, puntosAtaque, puntosDefensa, vidas);
        System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
        
    }
}
