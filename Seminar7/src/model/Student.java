package model;

public class Student {
    private final int id;
    private final String nume;
    private final String prenume;
    private final int nota;

    public Student(int id, String nume, String prenume, int nota) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getNumeComplet() {
        return this.getNume() + " " + this.getPrenume();
    }

    @Override
    public String toString() {
        return String.format("Student(id = %d, nume = %s, prenume = %s, nota = %d)", this.id, this.nume ,this.prenume, this.nota);
    }
}
