package Java.RPG_un_po_meno_baracca;

import java.util.ArrayList;

public class Inventario {

    private final ArrayList<Oggetto> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public void aggiungiOggetto(Oggetto oggetto) {
        inventario.add(oggetto);
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        inventario.remove(oggetto);
    }

    public String usaOggetto(int indice, Personaggio personaggio) {
        if (indice < 0 || indice >= inventario.size()) {
            return null; // indice non valido
        }
        
        Oggetto o = inventario.get(indice);
        String risultato = o.usa(personaggio);
        if (risultato != null) {
            inventario.remove(indice);
        }
        return risultato;
    }

    public String getInventarioList() {
        if (inventario.isEmpty()) {
            return "(vuoto)";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inventario.size(); i++) {
            str.append(inventario.get(i).getNome());
            if (i < inventario.size() - 1) {
                str.append(", ");
            }
        }
        return str.toString();
    }

    // Informazioni inventario
    @Override
    public String toString() {
        if (inventario.isEmpty()) {
            return "(vuoto)";
        }

        StringBuilder str = new StringBuilder();
        str.append("\n  - Contenuto:\n");

        for (Oggetto o : inventario) {
            str.append("    ").append(o).append("\n");
        }

        return str.toString();
    }
}
