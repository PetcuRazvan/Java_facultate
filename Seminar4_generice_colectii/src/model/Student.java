package model;
import java.util.*;

public class Student {
    private int id;
    private String nume;
    private Map<String, Integer> note;

    public Student(int id, String nume) {
        if (id <= 0) {
            throw new IllegalArgumentException(id + " este mai mic sau egal decat 0");
        }

        if (nume == null || nume.trim().isEmpty()) {//trim elimina toate whitespace-urile de la capete
            throw new IllegalArgumentException("Nume invalid");
        }

        this.id = id;
        this.nume = nume;

        this.note = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public Set<String> getDisciplina() { //returnam ca Set pt ca cheile sunt valori unice
        return note.keySet();
    }

    public boolean areNota(String disciplina) {
        return note.containsKey(disciplina); //bool daca are valoare cheia disciplina sau nu
    }

    public int getNota(String disciplina) {
        if (note.get(disciplina) == null) {
            throw new IllegalArgumentException(String.format("Studentul %s nu are nota la disciplina %s", this.nume, disciplina));
        }

        return note.get(disciplina);
    }

    public void adaugaNote(String disciplina, int nota) {
        if (disciplina == null || disciplina.trim().isEmpty()) {
            throw new IllegalArgumentException("Nume invalid");
        }

        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("Nota " + nota + " invalida");
        }

        note.put(disciplina, nota);
    }

    public void stergeNota(String disciplina) {
        note.remove(disciplina.trim());
    }
}
