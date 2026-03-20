package model;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    private final int id;
    private final String nume;
    private final List<Nota> note;

    public Student(int id, String nume) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id invalid!");
        }

        if (nume == null || nume.trim().isEmpty()) {
            throw new IllegalArgumentException("Nume invalid!");
        }

        this.id = id;
        this.nume = nume;
        this.note = new ArrayList<Nota>();
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void adaugaSauModificaNota(String disciplina, int nota) {
        for (var index : this.note) {
            if (index.getDisciplina().equals(disciplina)) {
                index.setNota(nota);

                return;
            }
        }

        this.note.add(new Nota(disciplina, nota));
    }

    public void stergeNota(String disciplina) {
        Nota deSters = null;

        for (var index : this.note) {
            if (index.getDisciplina().equals(disciplina)) {
                deSters = index;
                break;
            }
        }

        if (deSters == null) {
            throw new IllegalArgumentException("Disciplina nu exista in catalog");
        }

        this.note.remove(deSters);
    }

    public int getNota(String disciplina) {
        for (var index : this.note) {
            if (index.getDisciplina().equals(disciplina)) {
                return index.getNota();
            }
        }

        throw new IllegalArgumentException("Disciplina nu exista in catalog");
    }

    @Override
    public String toString() {
        return String.format("%-18s - %d", this.nume, this.id);
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.id, student.getId());
    }
}
