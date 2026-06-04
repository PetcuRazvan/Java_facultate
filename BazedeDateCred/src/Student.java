public class Student {
    private int cod;
    private String nume;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Student(int cod, String nume) {
        this.cod = cod;
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Nume: " + nume + " Cod: " + cod;
    }
}
