package Java.Carrello_spesa;

public abstract class Prodotto {

    protected String codiceProdotto;
    protected String descrizione;
    protected double prezzoBase;

    public Prodotto(String codiceProdotto, String descrizione, double prezzoBase) {
        this.codiceProdotto = codiceProdotto;
        this.descrizione = descrizione;
        this.prezzoBase = prezzoBase;
    }

    public abstract double prezzoFinale();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Codice: " + codiceProdotto).append(", Descrizione: " + descrizione);
        return str.toString();
    }
}
