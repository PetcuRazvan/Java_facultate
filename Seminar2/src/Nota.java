public class Nota {

    private String numeDisciplina;
    private int nota;

    public Nota() {
        this.numeDisciplina = "-";
        this.nota = 1;
    }

    public Nota(String _numeDisciplina, int _nota) {
        this.numeDisciplina = _numeDisciplina;

        if(nota < 1 || nota > 10)
            throw new IllegalArgumentException("Nota invalida: " + nota);

        this.nota = _nota;
    }

    public String getNumeDisciplina() {
        return numeDisciplina;
    }

    public void setNumeDisciplina(String numeDisciplina) {
        this.numeDisciplina = numeDisciplina;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if(nota < 1 || nota > 10)
            throw new IllegalArgumentException("Nota invalida: " + nota);

        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("%-18s - %2d", this.numeDisciplina, this.nota); //max 18 caractere, liniuta la stanga = aliniere la stanga

        //programare         - 10
        //POO                -  9    avem acel 2 l d, deci muta nota 9 la stanga
    }
}
