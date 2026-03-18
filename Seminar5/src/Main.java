import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            PrintWriter writer = new PrintWriter("output.txt");

            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();

                writer.println(linie);
            }

            scanner.close();
            writer.close(); //daca nu inchidem writer este posibilitatea ca fisierul sa nu se salveze la final

        } catch (Exception e) {
            System.out.println("Eroare" + e.getMessage());
        }
    }
}