import java.util.ArrayList;
import java.util.List;

class Numerare extends Thread {
    private int n = 0;
    static volatile long idCastigator = 0;

    @Override
    public void run() {
        for (int n = 1; n <= 100; n++) {
            try {
                Thread.sleep(1 + (int) (Math.random() * 100));
            } catch (InterruptedException e) {

            }

            if (idCastigator > 0) {
                System.out.println(getId() + " - a ajuns pana la " + n);
                return;
            }

        }
        idCastigator = getId();
    }
}

public class ex1 {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> fire = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var fir = new Numerare();
            fire.add(fir);
            fir.start();
        }

        while (fire.stream().anyMatch(fir -> fir.isAlive())) { //huh?
        }
        System.out.println("Thread-ul castigator care a ajuns la 100 este " + Numerare.idCastigator);
    }
}
