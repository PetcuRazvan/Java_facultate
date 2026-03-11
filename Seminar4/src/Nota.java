public class Nota {
    private String numeDisciplina;
    private int nota;

    public Nota(String numeDisciplina, int nota) {
        this.numeDisciplina = numeDisciplina;
        setNota(nota);
    }

    public String getNumeDisciplina() {
        return numeDisciplina;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return numeDisciplina + " - " + nota;
    }

    public void setNota(int nota) {
        if(nota < 1 || nota > 10) {
            throw new IllegalArgumentException("Nota invalida");
        }

        this.nota = nota;
    }
}
