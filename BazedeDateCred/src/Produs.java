public class Produs {
    private int cod;
    private String denumire;
    private float pret;
    private int cantitate;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Produs(int cod, String denumire, float pret, int cantitate) {
        this.cod = cod;
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
    }
}
