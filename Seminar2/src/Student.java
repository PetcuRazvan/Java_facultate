import java.util.Arrays;

public class Student {

    private int idStudent;
    private String nume;
    private int grupa;
    private int anul;
    private Nota[] note;

    public Student() {
        this.idStudent = 0;
        this.nume = "-";
        this.grupa = 0;
        this.anul = 0;
    }

    public Student(int _idStudent, String _nume, int _grupa, int _anul) {
        this.idStudent = _idStudent;
        this.nume = _nume;
        this.grupa = _grupa;
        this.anul = _anul;
        setNote(new Nota[0]);
    }

    public int getIdStudent() {
        return this.idStudent;
    }

    public void setIdStudent(int _idStudent) {
        this.idStudent = _idStudent;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public Nota[] getNote() {
        return note;
    }

    public void setNote(Nota[] note) {
        this.note = note;
    }

    public void addNota(Nota nota) {

        for (var notaExistenta : this.note)
            if(nota.getNumeDisciplina().equals(notaExistenta.getNumeDisciplina())) {
                notaExistenta.setNota(nota.getNota());
                return;
            }

        note = (Nota[])Arrays.copyOf(note, note.length + 1); //merge si fara cast la Nota[]
        note[note.length - 1] = nota;
    }
}
