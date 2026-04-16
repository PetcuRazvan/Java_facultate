package app;

import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        try {
            List<Student> studenti = citireStudenti("studenti.txt");

            System.out.println("=== Lista studentilor ");
            studenti.forEach(System.out::println);

            Predicate<Student> filtruNotaStudent = s -> s.getNota() >= 8; //interfata pentru filtrare studenti cu nota mai mare sau egala decat 8
            System.out.println("=== Studenti cu nota >= 8");
            studenti.stream()
                    .filter(filtruNotaStudent)
                    .forEach(System.out::println);

            Function<Student, String> numeComplet = s -> s.getNumeComplet();
            System.out.println("=== Nume complete + nota >= 8 ===");
            studenti.stream()
                    .filter(filtruNotaStudent)
                    .map(numeComplet)
                    .forEach(System.out::println);

            System.out.println("=== Studenti soratti desc dupa nota ===");
            studenti.stream()
                    .sorted((s1, s2) -> Integer.compare(s2.getNota(), s1.getNota()))
                    .forEach(System.out::println);

            System.out.println("=== Grupare dupa nume de familie ===");
            Map<String, List<Student>> studentiGrupatiDupaNume = studenti.stream()
                    .collect(Collectors.groupingBy(Student::getNume));

            studentiGrupatiDupaNume.forEach((nume, listaStudenti) -> {
                System.out.println(nume + ":");
                listaStudenti.forEach(student -> System.out.println(" " + student));
            });

        } catch(Exception e) {
            System.out.println("A aparut o eroare:" + e.getMessage());
        }
    }

    public static List<Student> citireStudenti(String numeFisier) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            return br.lines()
                    .map(linie -> linie.split(";"))
                    .map(valori -> new Student(
                            Integer.parseInt(valori[0]),
                            valori[1],
                            valori[2],
                            Integer.parseInt(valori[3])
                    ))
                    .collect(Collectors.toList());
        }
    }
}
