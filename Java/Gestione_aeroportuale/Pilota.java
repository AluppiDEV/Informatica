package Java.Gestione_aeroportuale;

import java.util.List;

public class Pilota extends Persona {
    private List<String> modelliAbilitati;
    private boolean occupato;

    public Pilota(String nome, String matricola, List<String> modelliAbilitati) {
        super(nome, matricola);
        this.modelliAbilitati = modelliAbilitati;
        this.occupato = false;
    }

    public boolean isAbilitatoPer(String modello) {
        return modelliAbilitati.contains(modello);
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
