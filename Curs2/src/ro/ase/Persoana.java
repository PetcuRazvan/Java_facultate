package ro.ase;

abstract class Afisabil {
    public abstract void Afiseaza();
}

public class Persoana extends Afisabil {

//    var x = new Afisabil() {
//
//        @Override
//        public void Afiseaza() {
//            System.out.println("Un test");
//        }
//    };

    static class Adresa {

    }

    @Override
    public void Afiseaza() {
        System.out.println("salut");

        class TestStudent implements Comparable {
            public String nume;
            public double medie;

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        } //vizibil doar in metoda

        TestStudent Temp;
    }


}

