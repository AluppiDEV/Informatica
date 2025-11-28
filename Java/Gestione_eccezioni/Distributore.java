package Java.Gestione_eccezioni;

import java.util.ArrayList;

public class Distributore {

    private ArrayList<Prodotto> listino;

    public Distributore() {
        listino = new ArrayList<>();
    }

    public String compra(int index) {
        try {
            listino.get(index).preleva();
            return "prodotto prelevato con successo, " + listino.get(index).getNumero() + " rimanenti";
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println(err);
            return "Prodotto inesistente";
        }
    }
}
