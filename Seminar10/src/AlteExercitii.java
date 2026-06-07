import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AlteExercitii {
    public static void main(String[] args) throws Exception {
        Class<?> clasaThread = Class.forName("java.lang.Thread");
        System.out.println(clasaThread.getName());

        for (Method metoda : clasaThread.getDeclaredMethods()) {
            if (metoda.getReturnType() == void.class) {
                System.out.println(metoda.getName());
            }
        }

        AltaPersoana persoana = new AltaPersoana(1, "Shutzu");
        Class<?> classPersoana = persoana.getClass();
        System.out.println(classPersoana.getName());

        Field campCod = classPersoana.getDeclaredField("cod");
        campCod.setAccessible(true);
        campCod.set(persoana, 12);
        System.out.println(persoana);

        Field campNume = classPersoana.getDeclaredField("nume");
        campNume.setAccessible(false);
        int modificatori = campNume.getModifiers();
        System.out.println(Modifier.toString(modificatori));
    }
}

class AltaPersoana {
    private int cod;
    public transient String nume;

    public AltaPersoana(int cod, String nume) {
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