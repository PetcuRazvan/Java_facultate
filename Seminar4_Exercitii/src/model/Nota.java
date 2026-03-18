package model;

public class Nota {
    private String disciplina;
    private int nota;

    public Nota(String disciplina, int nota) {
        setDisciplina(disciplina);
        setNota(nota);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina == null || disciplina.trim().isEmpty()) {
            throw new IllegalArgumentException("Disciplina nu poate fi vida!");
        }
        this.disciplina = disciplina;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("Nota invalida!");
        }
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("%-18s - %d", disciplina, nota);

        //disciplina = 'Java'; nota = 10
        //"Java               - 10"   %-18s
        //"              Java - 10"   %18s
        //"java = 10"                 %s
    }
}
