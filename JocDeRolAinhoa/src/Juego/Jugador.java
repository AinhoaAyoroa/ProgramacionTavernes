package Juego;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private int puntosAtaque;
    private int puntosDefensa;
    private int vidas;

    // CONSTRUCTORES ---------------------------------------------   
    /**
     *
     * @param nombre
     * @param puntosAtaque
     * @param puntosDefensa
     * @param vidas
     */
    public Jugador(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        System.out.println("Soy el constructor de Jugador pero estoy creando un " + this.getClass().getSimpleName());
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.vidas = vidas;
    }

    // MËTODOS -------------------------------------------------------
    // GETTERS -------------------------
    public String getNombre() {
        return nombre;

    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public int getVidas() {
        return vidas;
    }

    // SETTERS ---------------------------
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    protected void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    protected void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void ataca(Object Jugador) {
    }
    //TODO
    protected void esColpejatAmb(int puntosAtaque) {
        if (puntosAtaque - puntosDefensa > 0) {
            int dany = puntosAtaque - puntosDefensa;
            if (dany < vidas) {
                System.out.println(nombre + " es golpeado con " + puntosAtaque 
                                  + " puntos y se defiende con " + puntosDefensa + "." + "Vidas: " + vidas + "-" + dany + " = " + (this.vidas = dany - vidas) );
            }
        }else{
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return nombre + " ( " + this.getClass().getSimpleName() + ", PA:" + puntosAtaque + ", PD" + puntosDefensa + ", PV" + vidas + " )";
    }

}
