package app;

import functional.FiltruComanda;
import model.Comanda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            List<Comanda> comenzi = citireComenziDinFisier("comenzi.txt");

            System.out.println("=== TOATE COMENZILE ===");
            comenzi.forEach(System.out::println);

            System.out.println("== COMENZI CU VALOARE > 200 ===");
            List<Comanda> comenziMari = filtreazaComenzi(comenzi, c -> c.getValoare() > 200);
            comenziMari.forEach(System.out::println);

            System.out.println("=== COMENZI DIN BUCURESTI ===");
            List<Comanda> comenziBucuresti = filtreazaComenzi(comenzi, c -> c.getOras().equalsIgnoreCase("bucuresti"));
            comenziBucuresti.forEach(System.out::println);

            System.out.println("=== GRUPARE DUPA ORAS ===");
            Map<String, List<Comanda>> comenziOrase = comenzi.stream()
                    .collect(Collectors.groupingBy(Comanda::getOras));

            comenziOrase.forEach((oras, listaComenzi) -> {
                long numarComenzi = listaComenzi.size();
                double total = listaComenzi.stream()
                        .mapToDouble(Comanda::getValoare)
                        .sum();

                System.out.println(oras);
                System.out.println(" numar comenzi = " + numarComenzi);
                System.out.println(" valoare totala " + total);
            });

        } catch(Exception e) {
            System.out.println("A aparut o eroare: " + e.getMessage());
        }
    }

    public static List<Comanda> citireComenziDinFisier(String numeFisier) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            return br.lines()
                    .map(linie -> linie.split(";"))
                    .map(valori -> new Comanda(
                            Integer.parseInt(valori[0]),
                            valori[1],
                            valori[2],
                            Double.parseDouble(valori[3]),
                            valori[4]
                    ))
                    .collect(Collectors.toList());
        }
    }

    public static List<Comanda> filtreazaComenzi(List<Comanda> comenzi, FiltruComanda filtru) {
        return comenzi.stream()
                .filter(filtru::accepta)
                .collect(Collectors.toList());
    }
}