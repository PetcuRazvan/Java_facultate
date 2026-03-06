import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProgramStudenti {

    private static Student[] centralizator = new Student[0];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        afisare("Inițial");
//        citireStudenti();
//        afisare("După citire studenți");

        Student s1 = new Student(1, "Popescu Ion", 1057, 2);
        Student s2 = s1.clone();

        System.out.println(s1);
        System.out.println(s2);

        s1.add(new Nota("Structuri de date", 9));
        System.out.println(s1);
        System.out.println(s2);

        String test = "Salut"; //String este o clasa imutabila
        test = test + "!"; //cand facem asta face o copie, nu modifica
    }

    static void afisare(String mesaj) {
        System.out.println(mesaj + ":\n");
        for (var student : centralizator) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------------------");
    }

    static void citireStudenti() {
        int numarStudenti = Integer.parseInt(scanner.nextLine());

        centralizator = new Student[numarStudenti];

        for (int index = 0; index < numarStudenti; index++) {

            String linieStudent = scanner.nextLine();
            String linieNote = scanner.nextLine();

            var student = new Student(
                    Integer.parseInt(linieStudent.split(",")[0]),
                    linieStudent.split(",")[1],
                    Integer.parseInt(linieStudent.split(",")[2]),
                    Integer.parseInt(linieStudent.split(",")[3])
            );

            var elementeNote = linieNote.split(",");
            for (int indexNota = 1; indexNota < elementeNote.length; indexNota += 2) {
                var disciplina = elementeNote[indexNota - 1];
                var nota = Integer.parseInt(elementeNote[indexNota]);

                student.add(new Nota(disciplina, nota));
            }

            centralizator[index] = student;
        }
    }
}
