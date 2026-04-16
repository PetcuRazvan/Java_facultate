package model;

public class Comanda {
    private final int idComanda;
    private final String client;
    private final String oras;
    private final double valoare;
    private final String status;

    public Comanda(int idComanda, String client, String oras, double valoare, String status) {
        this.idComanda = idComanda;
        this.client = client;
        this.oras = oras;
        this.valoare = valoare;
        this.status = status;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public String getStatus() {
        return status;
    }

    public double getValoare() {
        return valoare;
    }

    public String getOras() {
        return oras;
    }

    public String getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Comanda" +
                " { id comanda = " + idComanda +
                ", client = " + client +
                ", oras = " + oras +
                ", valoare = " + valoare +
                ", status = " + status +
                " }";
    }
}
