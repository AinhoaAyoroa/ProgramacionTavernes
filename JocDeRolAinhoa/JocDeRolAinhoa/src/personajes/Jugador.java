package personajes;

import otros.Equipo;
import Teclat.Pantalla;
import inicio.Poderes;
import java.util.ArrayList;
import java.util.Objects;
import otros.Poder;

/**
 *
 * @author Ainhoa Ayoroa
 */
public class Jugador {

    // ATRIBUTOS
    private String nombre;
    protected int puntosAtaque;
    protected int puntosDefensa;
    protected int vidas;
    private Equipo equipo;
    private ArrayList<Poder> poderes = new ArrayList();

    // CONSTRUCTORES ---------------------------------------------   
    /**
     *
     * @param nombre
     * @param puntosAtaque
     * @param puntosDefensa
     * @param vidas
     */
    public Jugador(String nombre, int puntosAtaque, int puntosDefensa, int vidas) {
        // System.out.println("Soy el constructor de Jugador pero estoy creando un " + this.getClass().getSimpleName());
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.vidas = vidas;
    }

    // MËTODOS -------------------------------------------------------
    /**
     *
     * @param atacado
     */
    // Lo llaman con  j1.ataca(j2)
    // la iea és hacer j1.esColpejatAmb( puntos de ataque de j2)
    //                 j2.esColpejatAmb( puntos de ataque de j1
    // Como accedo a j2? Con jugadorAtacado
    // Coomo acceo a j1? Con this
    public void ataca(Jugador atacado) throws InterruptedException {
        Jugador atacante = this;
        // ATAQUE TOTAL DEL ATACANTE
        int ataqueTotalAtacante = atacante.puntosAtaque;
        for (Poder poder : atacante.poderes) {
            ataqueTotalAtacante += poder.getBonusAtaque();
        }
        // ATAQUE TOTAL DEL ATACADO
        int ataqueTotalAtacado = atacado.puntosAtaque;
        for (Poder poder : atacado.poderes) {
            ataqueTotalAtacado += poder.getBonusAtaque();
        }

        Pantalla.titolCentrat2("ANTES DEL ATAQUE");
        System.out.println("Atacante: " + atacante.toString());
        System.out.println("Atacado: " + atacado.toString());
        Pantalla.titolCentrat2("ATAQUE");
        atacado.esColpejatAmb(ataqueTotalAtacante);
        Thread.sleep(5000);
        atacante.esColpejatAmb(ataqueTotalAtacado);
        Thread.sleep(5000);
        Pantalla.titolCentrat2("DESPUES DEL ATAQUE");
        System.out.println("Atacante: " + atacante.toString());
        System.out.println("Atacado: " + atacado.toString());
        Thread.sleep(3000);
    }

    /**
     *
     * @param paGolpean
     */
    protected void esColpejatAmb(int paGolpean) {
        Jugador victima = this;
        int dany = 0;
        int defensaTotal = victima.puntosDefensa;
        for (Poder poder : victima.poderes) {
            defensaTotal += poder.getBonusDefensa();
        }

        dany = paGolpean - defensaTotal;

        int vidasAntes = this.vidas;

        if (dany < 0) {
            dany = 0;
            System.out.println("No ha surgido efecto.");
        }

        if (dany < this.vidas) {
            this.vidas -= dany;
        } else {
            this.vidas = 0;
        }

        System.out.println(this.nombre + " es golpeado con " + paGolpean
                + " puntos y se defiende con " + defensaTotal + "."
                + " Vidas: " + vidasAntes + " - " + dany + " = "
                + this.vidas);
    }

    public void posa(Poder poder) {
        if (!poderes.contains(poder)) {
            poderes.add(poder);
            System.out.println("poder añadido");
        } else {
            System.out.println("no se ha podido añadir el poder");
        }

    }

    public void quita(Poder poder) {
        if (poderes.remove(poder)) {
            System.out.println("poder eliminado");
        } else {
            System.out.println("no se ha podido eliminar el poder");
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Jugador)) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    // GETTERS -------------------------
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;

    }

    /**
     *
     * @return
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     *
     * @return
     */
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    /**
     *
     * @return
     */
    public int getVidas() {
        return vidas;
    }

    /**
     *
     * @return
     */
    public Equipo getEquipo() {
        return equipo;
    }

    // SETTERS ---------------------------
    /**
     *
     * @param nombre
     */
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param puntosAtaque
     */
    protected void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     *
     * @param puntosDefensa
     */
    protected void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    /**
     *
     * @param vidas
     */
    protected void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     *
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        if (this.equipo != equipo) {
            Equipo equipoAntiguo = this.equipo;
            this.equipo = equipo;
            if (equipo != null) {
                equipo.posa(this);
            }
            if (equipoAntiguo != null) {
                equipoAntiguo.quita(this);
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String equipoNombre = (equipo != null) ? equipo.getNombre() : "";
        return nombre + " [" + equipoNombre + "] " + " ( " + this.getClass().getSimpleName() + ", PA:" + puntosAtaque
                + ", PD:" + puntosDefensa + ", PV:" + vidas + " ) tiene los poderes: " + poderes + "\n";
    }

}
