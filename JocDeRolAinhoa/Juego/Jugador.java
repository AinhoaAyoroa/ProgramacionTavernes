package Juego;

import Teclat.Pantalla;

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
    // este lo he hecho 100 por ciento sola
    public void ataca(Jugador jugadorAtacado) {
        Pantalla.titolCentrat2("ANTES DEL ATAQUE");
        System.out.println("Atacant: " +  this.toString());
        System.out.println("Atacat: " +  jugadorAtacado.toString());
        Pantalla.titolCentrat2("ATAQUE");
        jugadorAtacado.esColpejatAmb(puntosAtaque);
        esColpejatAmb(jugadorAtacado.puntosAtaque);
        Pantalla.titolCentrat2("DESPUES DEL ATAQUE");
        System.out.println("Atacant: " +  this.toString());
        System.out.println("Atacat: " +  jugadorAtacado.toString());
    }
    // es que este lo hice con abdo *llora* entonces no entiendo que está mal
    protected void esColpejatAmb(int paGolpean) {
        int dany = this.puntosDefensa - paGolpean;
        int vidasAntes = this.vidas;

        if (dany < this.vidas) {
            this.vidas = this.vidas - dany;
        } else {
            this.vidas = 0;
        }

        System.out.println(this.nombre + " es golpeado con " + paGolpean
                + " puntos y se defiende con " + this.puntosDefensa + "."
                + " Vidas: " + vidasAntes + " - " + dany + " = "
                + this.vidas);
    }

    @Override
    public String toString() {
        return nombre + " ( " + this.getClass().getSimpleName() + ", PA:" + puntosAtaque + ", PD:" + puntosDefensa + ", PV:" + vidas + " )";
    }

}
