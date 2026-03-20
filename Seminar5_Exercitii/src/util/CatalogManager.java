package util;

import model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CatalogManager {
    private final List<Student> studenti;

    public CatalogManager() {
        this.studenti = new ArrayList<Student>();
    }

    public void adaugaStudent(Student student) {
        for (var s : this.studenti) {
            if (s.getId() == student.getId()) {
                throw new IllegalArgumentException("Studentul deja exista!");
            }
        }

        this.studenti.add(student);
    }

    public Student cautaStudent(int id) {
        for (var student : this.studenti) {
            if (student.getId() == id) {
                return student;
            }
        }

        throw new IllegalArgumentException("Studentul cu id-ul respectiv nu exista!");
    }

    public void afiseazaStudentii() {
        List<Student> copie = new ArrayList<Student>(this.studenti);

        Collections.sort(copie); //Student trebuie sa aibe implementat compareable

        for (var c : copie) {
            System.out.println(c);
        }
    }
}