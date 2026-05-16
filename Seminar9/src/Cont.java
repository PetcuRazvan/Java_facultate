import java.util.ArrayList;
import java.util.List;

public class Cont {
    int sold = 0;

    public int getSold() {
        return sold;
    }

    public synchronized void depune(int suma) {
        sold += suma;
    }
}

class  SoldCont {
    static void main(String[] args) throws InterruptedException {
        var cont = new Cont();
        List<Thread> fire = new ArrayList<>();

        for (int i =0; i < 10; i++) {
            var fir = new Thread(() -> {
                for (int index = 0; index < 1000; index++) {
                    cont.depune(1);
                }
            });

            fire.add(fir);
            fir.start();
        }

        for (var fir : fire) {
            fir.join();
        } //nu prea am inteles, dar ideea e ca fara asta nu afiseaza 10000

        System.out.println(cont.getSold());
    }
}
