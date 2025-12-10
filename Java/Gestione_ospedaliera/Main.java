package Java.Gestione_ospedaliera;

public class Main {
    public static void main(String[] args) {

        Ospedale ospedale = new Ospedale();

        // Stipendio base
        double stipendioBase = 1500;

        // Creazione Medici
        Medico m1 = new Medico("Mario", "Rossi", stipendioBase, "Cardiologia", 10);
        Medico m2 = new Medico("Luigi", "Bianchi", stipendioBase, "Neurologia", 5);

        // Creazione Infermieri
        Infermiere i1 = new Infermiere("Anna", "Verdi", stipendioBase, "Pediatria", 8);
        Infermiere i2 = new Infermiere("Marco", "Neri", stipendioBase, "Pronto Soccorso", 3);

        // Aggiunta al personale
        ospedale.assumiDipendente(m1);
        ospedale.assumiDipendente(m2);
        ospedale.assumiDipendente(i1);
        ospedale.assumiDipendente(i2);

        // Visualizzazione personale
        ospedale.visualizzaPersonale();

        // Calcolo stipendio totale
        System.out.println("\nTotale stipendi: " + ospedale.calcolaTotaleStipendi() + " €");

        // Licenziamento di un infermiere
        System.out.println("\n------------------------------------------------");
        System.out.println(">>> Licenzio l'infermiere con matricola I002...");
        System.out.println("------------------------------------------------");
        ospedale.licenziaDipendente("I002");

        // Totale aggiornato
        System.out.println("\nNuovo totale stipendi: " + ospedale.calcolaTotaleStipendi() + " €");
    }
}
