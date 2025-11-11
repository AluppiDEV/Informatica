package Java.Carrello_spesa;

public class Alimento extends Prodotto {

    protected static final int IVA = 4;
    private boolean scade;

    public Alimento(String codiceProdotto, String descrizione, double prezzoBase, boolean scade) {
        super(codiceProdotto, descrizione, prezzoBase);
        this.scade = scade;
    }

    @Override
    public double prezzoFinale() {
        if (!scade) {
            return prezzoBase * (1 + IVA / 100);
        } else {
            return prezzoBase * (1 - (20 / 100) + (IVA / 100));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Prezzo: " + prezzoFinale();
    }
}
