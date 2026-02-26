import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        System.out.print("Nume: ");
//        String nume = scanner.nextLine();
//        System.out.println("Hello " + nume + '!');

        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        float b = scanner.nextFloat();

        System.out.printf("%d + %.2f = %.2f", a, b, a + b); //merge si .2 si 3.2
    }
}