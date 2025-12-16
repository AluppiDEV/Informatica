package JavaFile.Gestione_magazzino;

import java.io.*;
import java.util.ArrayList;

public class GestoreLogistica {
    private ArrayList<Articolo> articoli;

    public GestoreLogistica() {
        articoli = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo a) {
        articoli.add(a);
    }

    public String stampaTutti() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n=== CATALOGO (Totale articoli creati: ").append(articoli.size()).append(") ===\n");
        for (Articolo a : articoli) {
            temp.append(a.stampaEtichetta());
            temp.append("\n");
        }
        return temp.toString();
    }

    // FASE B: Serializzazione
    public boolean serializza(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(articoli);
            return true;
        } catch (IOException e) {
            System.err.println("Errore serializzazione: " + e.getMessage());
            return false;
        }
    }

    // FASE C: Deserializzazione
    @SuppressWarnings("unchecked")
    public boolean deserializza(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            articoli = (ArrayList<Articolo>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore deserializzazione: " + e.getMessage());
            return false;
        }
    }
}