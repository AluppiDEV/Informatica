package Java.RPG_un_po_meno_baracca;

import java.util.ArrayList;

public class Inventario {

    private Personaggio personaggio;
    private ArrayList<Oggetto> inventario;

    public Inventario(Personaggio personaggio) {
        this.personaggio = personaggio;
        inventario = new ArrayList<>();
    }

    public void aggiungiOggetto(Oggetto oggetto) {
        inventario.add(oggetto);
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        inventario.remove(oggetto);
    }

    public boolean usaOggetto(Tipi tipo) {
        for (Oggetto o : inventario) {
            if (o.getTipo() == tipo) {
                boolean stato = o.usa(personaggio);
                if (stato) inventario.remove(o);
                return stato;

            }
        }
        return false; // non trovato
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
