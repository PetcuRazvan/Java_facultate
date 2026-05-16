import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionSimple {
    public static void main(String[] args) throws Exception {
        Persoana pers = new Persoana(1, "Ion");

        //3 metode de a lua o clasa:
        Class<?> clasaPersoana = pers.getClass(); //primim un obiect de tip Class
        Class<?> clasaString = Class.forName("java.lang.String");
        Class<?> clasaInt = int.class;

        System.out.println(clasaPersoana);
        System.out.println(clasaString);
        System.out.println(clasaInt);

        //putem vedea si modificatorii de acces (public, private, ...)
        System.out.println("Modificatori de acces pentru String");
        int modificatori = clasaString.getModifiers(); //nu se stie de ce e int
        System.out.println(Modifier.toString(modificatori));

        //putem vedea si campurile
        for (Field camp : clasaPersoana.getDeclaredFields()) {
            camp.setAccessible(true); //e nevoie numai la alea private
            System.out.printf("%s, %s, %s = %s%n",
                    Modifier.toString(camp.getModifiers()),
                    camp.getType().getName(),
                    camp.getName(),
                    camp.get(pers));
        }

        //putem modifica campurile private si trece de orice filtru din setter
        var campCod = clasaPersoana.getDeclaredField("cod");
        campCod.setAccessible(true);
        campCod.set(pers, 0);
        System.out.println(pers);

        //putem vedea si metodele
        for (Method metoda : clasaPersoana.getDeclaredMethods()) {
            String modif = Modifier.toString(metoda.getModifiers());
            Class<?> tipReturnat = metoda.getReturnType();
            String denumire = metoda.getName();
            System.out.printf("%s %s %s, param: ",
                    modif, tipReturnat.getName(), denumire);
            for (Parameter param : metoda.getParameters()) {
                System.out.printf("%s ", param.getType().getName());
            }
            System.out.println();
        }

        //putem accesa si metode private, mai trebuie sa adaugam setAccesible(true)
        Method metodaSetCod = clasaPersoana.getDeclaredMethod("setCod", int.class);
        metodaSetCod.invoke(pers, 2);
        System.out.println(pers);
    }
}

class Persoana {
    private int cod;
    public transient String nume;

    public Persoana(int cod, String nume) {
        this.cod = cod;
        this.nume = nume;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        if (cod == 0) {
            System.out.println("Codul trebuie sa fie nenul");
            return;
        }

        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "cod = " + cod +
                ", nume = " + nume +
                "}";
    }
}