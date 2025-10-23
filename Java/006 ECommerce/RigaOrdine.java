public class RigaOrdine {

    private Prodotto prodotto;
    private int quantita;

    public RigaOrdine(Prodotto p, int quantita) {
        prodotto = new Prodotto(p);
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getSubtotale() {
        double tot = 0;
        tot = prodotto.getPrezzoUnitario() * quantita;
        return tot;

    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(prodotto.getNome()).append(", \tQta: " + quantita).append(", \tSubtotale: " + getSubtotale());
        return str.toString();
    }

}
