package Java.Carrello_spesa;

import java.util.ArrayList;

public class Carrello {

    private ArrayList<Prodotto> carrello;

    public Carrello() {
        carrello = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto p) {
        carrello.add(p);
    }

    private double prezzoTotale() {
        double tot = 0;
        for (Prodotto p : carrello) {
            tot += p.prezzoFinale();
        }
        return tot;
    }

    public String generaScontrino() {
        StringBuilder str = new StringBuilder();
        for (Prodotto p : carrello) {
            str.append(p.toString()).append("\n");
        }
        str.append("Prezzo totale: ").append(prezzoTotale()).append("\n");
        return str.toString();
    }
}
