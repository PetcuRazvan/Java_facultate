public class Adresa {
    private String strada;

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public Adresa(String strada) {
        this.strada = strada;
    }

    public String getStrada() {
        return strada;
    }
}

class PersoanaX implements Cloneable {
    public PersoanaX clone() {
        try {
            var rezultat = (PersoanaX) super.clone();
            rezultat.adresa = new Adresa(this.adresa.getStrada());

            return rezultat;
        } catch(CloneNotSupportedException e) {return null;}
    }

    private int cod;

    private Adresa adresa;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public PersoanaX(int cod, Adresa adresa) {
        this.cod = cod;
        this.adresa = adresa;
    }
}

//asa se face enum manual, putem scrie doar enum zisapt {luni, marti, ....} si face in spate asta
class ZiSaptamana {
    public final static ZiSaptamana LUNI = new ZiSaptamana(1);
    public final static ZiSaptamana MARTI = new ZiSaptamana(2);


    private ZiSaptamana(int cod) {
        this.cod = cod;
    }

    private final int cod;

    public int getCod() {
        return this.cod;
    }
}

class TestClone {

    static void test() throws Exception{
        throw new Exception();
    }

    public static void main(String[] args) {
        ZiSaptamana zi;
        zi = ZiSaptamana.LUNI;

        try {
            test();
        } catch(Exception e) {} //Exception este o exceptie checked, exceptiile checked trebuie tratate cu try si catch, cele unchecked nu trebuie, vezi mai multe pe curs
    }
}