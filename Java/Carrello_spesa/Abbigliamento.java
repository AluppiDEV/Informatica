package Java.Carrello_spesa;

public class Abbigliamento extends Prodotto {

    protected static final int IVA = 22;
    private Taglia taglia;
    private boolean saldo;

    public Abbigliamento(String codiceProdotto, String descrizione, double prezzoBase, Taglia taglia, boolean saldo) {
        super(codiceProdotto, descrizione, prezzoBase);
        this.taglia = taglia;
        this.saldo = saldo;
    }

    @Override
    public double prezzoFinale() {
        if (!saldo) {
            return prezzoBase * (1 + IVA / 100);
        } else {
            return prezzoBase * (1 - (30 / 100) + (IVA / 100));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Prezzo: " + prezzoFinale();
    }
}
