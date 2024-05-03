package exercici33;

import java.util.ArrayList;


public class Grup {
    private String codi;
    private int curs;
    private String cicle;
    ArrayList <Alumne> alumnes = new ArrayList();

    Grup() {
    
    }

    

    Grup(String codiGrup) {
        this.codi = codiGrup;
    
    }
    
    
    public boolean llevarAlumne(Alumne alumne){
        // No hem de recórrer primer amb el contains perquè el remove ja ho fa
//        if (this.alumnes.contains( alumne  )){
//            this.alumnes.remove(alumne);
//            return true;
//        }
//        return false;
        return this.alumnes.remove(alumne);

    }  
    
    // Exemple de crida: sout(   g1.quantitat() ) ;
    public int quantitat(){
        return this.alumnes.size();
    }
    
    public Alumne getAlumne(String dni  ){
        // No cal recórrer la llista:
//        for (Alumne alumne : this.alumnes) {
//            if (alumne.equals(new Alumne(dni))){
//                return alumne;
//            }
//        }
//        return null;

        // Obtindre la posició on està
        int posBuscar = this.alumnes.indexOf( new Alumne(dni)    );
        
        if (posBuscar<0){
            return null;
        }
        
        // Obtindre eixe alumne
        Alumne aluBuscar = this.alumnes.get(posBuscar);
        
        // Retornar-lo
        return aluBuscar;


    }    

    @Override
    public String toString() {
        // GRUP: 1DAM Curs: 1 Cicle: Desenv.Aplic.Informàtiques
        String cadena = "GRUP: " + codi + " Curs: " + curs + " Cicle:" + cicle +  '\n';
        // Afegir dades de cada alumne;
        
        for (Alumne alumne : alumnes) {
            cadena += alumne.toString() + "\n";
        }
        
        
        return cadena;
        
        
    }
    
    
     public boolean llevarAlumne(String dniAlumne){
         
         
        return (this.alumnes.remove( new Alumne(dniAlumne ) ));
        
         
     }
    
    
    
    // Exemple de crida: grup1.afegirAlumne( alu2 );  --> no estàtic
     /**
      * Afig un alumne al grup si no estava ja posat
      * @param alumne L'alumne que vols inserir
      * @return -1 si ja estava
      * -2 si no cap
      * quantitat d'alumnes que encara caben
      */
    public int afegirAlumne(Alumne alumne){
        if (  this.alumnes.contains(alumne)   ){
            return -1;
        }
        if ( this.alumnes.size() >=20 ){
            return -2;
        }
        this.alumnes.add(alumne);
        return 20 - this.alumnes.size();
        
    }
    
    
    

    public Grup(String codi, int curs, String cicle) {
        this.codi = codi;
        this.curs = curs;
        this.cicle = cicle;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getCurs() {
        return curs;
    }

    public void setCurs(int curs) {
        this.curs = curs;
    }
    

}
