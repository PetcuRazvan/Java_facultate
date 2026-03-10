import java.util.*;

class Colectie <T> {
    private Object[] elemente = new Object[0];

    public void addElement(T element) {
        elemente = Arrays.copyOf(elemente, elemente.length + 1);
        elemente[elemente.length - 1] = element;
    }

    public T getElement(int index) {return (T)elemente[index];}

    public int getNumarElemente() {return elemente.length;}

    public void afisareElemente() {
        for(var element : elemente)
            System.out.println(element);
    }
}

public void main(String[] args) {
    Colectie<String> v1 = new Colectie<>();
    v1.addElement("Ana");
    v1.addElement("are");
    v1.addElement("mere");
    v1.afisareElemente();

    Colectie<Integer> v2 = new Colectie<>(); //trebuie sa folosim clasa Integer deoarece, in clasa Colectie, avem o lista de Object, iar Integer e derivat din Object
    v2.addElement(1);
    v2.addElement(2);
    v2.addElement(3);
    v2.afisareElemente();

    Colectie v3 = new Colectie();
    v3.addElement(7);
    v3.addElement("Pisici"); //Huh????
    v3.afisareElemente();
}
