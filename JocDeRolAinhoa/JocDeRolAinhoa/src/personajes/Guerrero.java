package personajes;

import Teclat.Pantalla;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Guerrero extends Humano {

    // CONSTRUCTORES

    /**
     *
     * @param nombre
     * @param puntosAtaque
     * @param puntosDefensa
     * @param vidas
     */
    public Guerrero(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        super(nombre, puntosAtaque, puntosDefensa, vidas);
        // System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
    }

    /**
     *
     * @param paGolpean
     */
    @Override
    protected void esColpejatAmb(int paGolpean) {
        int dany;  
        dany = paGolpean -this.puntosDefensa ;
        if (dany < 5) {
            dany = 0;
            super.esColpejatAmb(0);
        }else{
         super.esColpejatAmb(paGolpean);
        }
    }
}
