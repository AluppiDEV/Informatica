package Java.Gestione_ospedaliera;

import java.util.ArrayList;

public class Ospedale {

    private ArrayList<Dipendente> personale = new ArrayList<>();

    // Metodo per assumere un nuovo dipendente
    public void assumiDipendente(Dipendente d) {
        personale.add(d);
    }

    // Metodo per licenziare un dipendente tramite matricola
    public void licenziaDipendente(String matricola) {
        Dipendente daRimuovere = null;
        
        for (Dipendente d : personale) {
            if (d.getMatricola().equalsIgnoreCase(matricola)) {
                daRimuovere = d;
                break;
            }
        }

        if (daRimuovere != null) {
            personale.remove(daRimuovere);
        }
    }

    // Visualizza tutti i dipendenti
    public void visualizzaPersonale() {
        System.out.println("=== PERSONALE OSPEDALIERO ===");
        for (Dipendente d : personale) {
            System.out.println(d.stampaDati());
        }
    }

    public double calcolaTotaleStipendi() {
        double totale = 0;
        for (Dipendente d : personale) {
            totale += d.calcolaStipendioMensile();
        }
        return totale;
    }
}
