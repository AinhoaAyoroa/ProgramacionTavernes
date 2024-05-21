package personajes;


/**
 *
 * @author Ainhoa 
 */
public class Humano extends Jugador{
    
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
        if (vidas > 100 ) {
            vidas = 100;
        }
        // System.out.println("soy el constructor de Humano pero estoy creando un " + this.getClass().getSimpleName());
       
    }
}
