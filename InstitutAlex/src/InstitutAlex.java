
import java.util.ArrayList;

public class InstitutAlex {

    public static void main(String[] args) {

        ArrayList<Persona> persones = new ArrayList();

        Persona profe = new Profe("Abdo");

        Persona alu = new Alumne("Alex", "1DAM");

        Persona pers = new Persona("Pep");

        persones.add(profe);

        persones.add(alu);

        persones.add(pers);

        for (Persona per : persones) {

            per.mostraNom();

        }

        for (Persona per : persones) {

            if (per instanceof Alumne) {

                ((Alumne) per).mostraCurs();

            }

        }

    }

}
