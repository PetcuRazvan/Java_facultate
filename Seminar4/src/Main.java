import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Disciplina: ");
            String disciplina = scanner.nextLine();

            System.out.println("Nota: ");
            int valoare = Integer.parseInt(scanner.nextLine());

            Nota nota = new Nota(disciplina, valoare);
            System.out.println("Obiectul a fost creat");
            System.out.println(nota);

        } catch(NumberFormatException e) {
            System.out.println("Eroare: " + e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println("Eroare: " + e.getMessage());
        }

        System.out.println("Program terminat");
    }
}
