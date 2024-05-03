package Juego;


/**
 *
 * @author Ainhoa 
 */
public class Humano extends Jugador{
    // ATRIBUTOS
    private String nombre;
    private int puntosAtaque;
    private int puntosDefensa;
    private int vidas;
    
    /**
     *
     * @param nombre
     * @param puntosAtaque
     * @param puntosDefensa
     * @param vidas
     */
    
    // CONSTRUCTORES
    public Humano(String nombre, int puntosAtaque, int puntosDefensa, int vidas){
        super(nombre, puntosAtaque, puntosDefensa, vidas); 
        System.out.println("soy el constructor de Humano pero estoy creando un " + this.getClass().getSimpleName());
       
    }
}
