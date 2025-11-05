package Java.Flotta_spaziale;

import java.util.ArrayList;

public class Missione {

    private String idMissione;
    private String destinazione;
    private int livelloPericoloSettore;
    private ArrayList<Container> caricoDellaMissione;

    public Missione(String idMissione, String destinazione, int livelloPericoloSettore) {
        this.idMissione = idMissione;
        this.destinazione = destinazione;
        this.livelloPericoloSettore = livelloPericoloSettore;
        caricoDellaMissione = new ArrayList<>();
    }

    public int getLivelloPericoloSettore() {
        return livelloPericoloSettore;
    }

    public String getIdMissione() {
        return idMissione;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void aggiungiContainer(Container c) {
        caricoDellaMissione.add(c);
    }

    public double getPesoTotale() {
        double pesoTotale = 0;
        for (Container c : caricoDellaMissione) {
            pesoTotale += c.getPesoTonnellate();
        }
        return pesoTotale;
    }

    public boolean isMissionePericolosa() {
        if (livelloPericoloSettore > 5) {
            return true;
        } else {
            boolean isMissionePericolosa = false;
            for (Container c : caricoDellaMissione) {
                if (c.isMaterialePericoloso()) {
                    isMissionePericolosa = true;
                }
            }
            return isMissionePericolosa;
        }
    }
}
