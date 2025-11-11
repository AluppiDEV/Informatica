package Java.Carrello_spesa;

public class Elettronico extends Prodotto{

    protected static final int IVA = 22;
    private int garanzia;

    public Elettronico(String codiceProdotto, String descrizione, double prezzoBase, int garanzia) {
        super(codiceProdotto, descrizione, prezzoBase);
        this.garanzia = Math.max(0, garanzia);
    }

    @Override
    public double prezzoFinale() {
        if (garanzia <= 12) {
            return prezzoBase * (1 + IVA / 100);
        } else {
            return prezzoBase * (1 + (3 / 100) + (IVA / 100));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Prezzo: " + prezzoFinale();
    }
}
