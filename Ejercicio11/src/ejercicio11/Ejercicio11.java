package ejercicio11;
import Teclat.Teclat;



/**
 *
 * @author ainhoa ayoroa rubio
 */

class Fecha {

    int dia;
    int mes;
    int año;
}

class Coche{
    String matricula;
    String marca;
    int modelo;
    Fecha fecha;
    int kms;
}
public class Ejercicio11 {
    public static void main(String[] args) {
        // a) Implementa la estructura necesaria para guardar 100 coches sin reservar memoria
        Coche[] coches = new Coche[2];
        
        
        
        // b) Haz un bucle para llenar los datos de los coches        
        for (int i = 0; i < coches.length; i++) {
            System.out.println("--- COCHE " + i + " ---");
            coches[i] = new Coche(); 
            coches[i].fecha = new Fecha();
            coches[i].matricula = Teclat.lligString("matricula - " + i + ": ");
            coches[i].marca = Teclat.lligString("marca - " + i + ": ");
            coches[i].modelo = Teclat.lligInt("modelo - " + i + ": ");
            coches[i].fecha.año = Teclat.lligInt("año - " + i + ": ");
            coches[i].fecha.mes = Teclat.lligInt("mes - " + i + ": ");
            coches[i].fecha.dia = Teclat.lligInt("dia - " + i + ": ");
            coches[i].kms = Teclat.lligInt("kms - " + i + ": ");
        }    
        
        // c) Muestra los datos de todos los coches
        
        for (int i = 0; i < coches.length; i++) {
            System.out.println("\t" + coches[i].matricula + "\t" + 
                    coches[i].marca + "\t" + coches[i].modelo + "\t" +
                    coches[i].fecha.año + "\t" + coches[i].fecha.mes + "\t" +
                    coches[i].fecha.dia + "\t" + coches[i].kms );
        }
    }
}
