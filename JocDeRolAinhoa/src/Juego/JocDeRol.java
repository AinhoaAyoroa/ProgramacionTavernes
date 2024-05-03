package Juego;
import Teclat.*;

/**
 *
 * @author Ainhoa Ayoroa
 */

public class JocDeRol{
    
    public static void provaFase1(){
        System.out.println("Voy a crear a un humano");
        Humano humano1 = new Humano("Federico", 10, 20, 30);
        System.out.println("Voy a crear a un guerrero");
        Guerrero guerrero1 = new Guerrero("Guerrero", 10, 30, 30);
        System.out.println("Voy a crear a un alien");
        Alien alien1 = new Alien("Alien", 20, 20, 30);
    }
    
    public static void main(String[] args) {
        provaFase1();
    }
    
    
}

