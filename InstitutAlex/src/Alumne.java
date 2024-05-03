public class Alumne extends Persona {

    String curs;

    public Alumne(String nom, String curs) {

        super(nom);

        this.curs = curs;

    }

    public void mostraCurs() {

        System.out.println("Curs: " + this.curs);

    }

}