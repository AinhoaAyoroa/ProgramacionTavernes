package exercici33;

import Teclat.*;
import java.util.ArrayList;

public class Exercici33 {

    public static void main(String[] args) {
        ArrayList<Grup> grupsInsti = new ArrayList();

        ArrayList<Alumne> alumnesInsti = new ArrayList();

        int opcio;
        do {
            opcio = Teclat.lligOpcio("INSTITUT", "Crear grups",
                    "Crear alumnes",
                    "Assignar alumne a un grup",
                    "Desassignar alumne de grups");

            switch (opcio) {
                case 1:
                    Grup gIns = new Grup();
                    gIns.setCodi(Teclat.lligString("Codi"));
                    gIns.setCurs(Teclat.lligInt("Curs"));
                    gIns.setCicle(Teclat.lligString("Cicle"));

                    grupsInsti.add(gIns);
                    System.out.println("Grup inserit");
                    break;
                case 2:
                    Alumne aIns = new Alumne();

                    aIns.setDni(Teclat.lligString("Dni"));

                    if (alumnesInsti.contains(aIns)) {
                        System.out.println("L'alumne ja estava creat");
                    } else {
                        aIns.setNom(Teclat.lligString("Nom"));
                        aIns.setCognoms(Teclat.lligString("Cognoms"));
                        aIns.setEdat(Teclat.lligInt("Edat"));
                        aIns.setPoble(Teclat.lligString("Poble"));
                        alumnesInsti.add(aIns);
                        System.out.println("Alumne inserit");
                    }

                    break;
                case 3:
                    assignarAlumneGrup(alumnesInsti, grupsInsti);

                    // Assignar alumne a grup
                    break;
                case 4:
                       desassignarAlumneGrup(alumnesInsti, grupsInsti);
                    break;
            }

        } while (opcio != 0);

    }

    private static void assignarAlumneGrup(ArrayList<Alumne> alumnesInsti, ArrayList<Grup> grupsInsti) {
        // Demanar dades i fer comprovacions i obtindre posicions on estan alumne i grup
        String dni = Teclat.lligString("DNI de l'alumne");
       
        int posAlu = alumnesInsti.indexOf(new Alumne(dni));
        if (posAlu < 0) {
            System.out.println("No existeix alumne");
            return;
        } 
        
        String codiGrup = Teclat.lligString("Codi del grup");
        
        int posGru = grupsInsti.indexOf(new Grup(codiGrup));
        if (posGru < 0){
            System.out.println("No existeix el grup");
            return;
        }
        
        // Obtindre els objectes: grup i alumne
        Alumne aIns = alumnesInsti.get(posAlu);
        Grup gIns = grupsInsti.get(posGru);
        
        
        // Assignar l'alumne al grup
        // gIns.alumnes.add(aIns); // Així no perquè no comprova si ja existia o si no cabia
        gIns.afegirAlumne(aIns);
    }
    
    
    
     private static void desassignarAlumneGrup(ArrayList<Alumne> alumnesInsti, ArrayList<Grup> grupsInsti) {
        // Demanar dades i fer comprovacions i obtindre posicions on estan alumne i grup
        String dniAluLlevar = Teclat.lligString("DNI de l'alumne");
       
      
        
        String codiGrup = Teclat.lligString("Codi del grup");
        
        int posGru = grupsInsti.indexOf(new Grup(codiGrup));
        if (posGru < 0){
            System.out.println("No existeix el grup");
            return;
        }
        
        // Obtindre els objectes: grup
       
        Grup gLlevar = grupsInsti.get(posGru);
        
        
        // DesAssignar l'alumne al grup
        // gLlevar.alumnes.remove(aLlevar); // 
        gLlevar.llevarAlumne(dniAluLlevar);
        
        
        
        
        
        
    }


}
