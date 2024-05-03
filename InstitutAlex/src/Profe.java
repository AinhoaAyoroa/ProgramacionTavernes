public class Profe extends Persona {

    public Profe(String nom) {

        super(nom);

    }

    @Override

    public void mostraNom() {

        System.out.println("Profe: " + nom);

    }

}