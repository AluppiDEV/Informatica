package Java.Flotta_spaziale;

public class Main {
    public static void main(String[] args) {

        // 1. Creazione stazione
        StazioneSpaziale stazione = new StazioneSpaziale("Deep Space 9");

        // 2. Creazione navi
        NaveDaCarico cargo1 = new NaveDaCarico("CARGO-01", 100, StatoNave.DISPONIBILE, true);
        NaveDaCarico cargo2 = new NaveDaCarico("CARGO-02", 100, StatoNave.DISPONIBILE, false);
        IncrociatoreDaBattaglia incrociatore = new IncrociatoreDaBattaglia("WAR-01", 200, StatoNave.DISPONIBILE, 9, 12);

        // Aggiunta alla flotta
        stazione.aggiungiNaveAFlotta(cargo1);
        stazione.aggiungiNaveAFlotta(cargo2);
        stazione.aggiungiNaveAFlotta(incrociatore);

        // 3. Creazione missioni
        Missione facile = new Missione("M1", "Settore Alpha", 2);
        facile.aggiungiContainer(new Container("C1", 10, false));

        Missione pericolosa = new Missione("M2", "Settore Beta", 8);
        pericolosa.aggiungiContainer(new Container("C2", 8, false));

        Missione speciale = new Missione("M3", "Settore Gamma", 2);
        speciale.aggiungiContainer(new Container("C3", 20, true));

        // Aggiunta missioni
        stazione.aggiungiMissione(facile);
        stazione.aggiungiMissione(pericolosa);
        stazione.aggiungiMissione(speciale);

        // 4. Assegnazione e stampa risultati
        assegnaEMostra(stazione, facile);
        assegnaEMostra(stazione, pericolosa);
        assegnaEMostra(stazione, speciale);
    }

    private static void assegnaEMostra(StazioneSpaziale stazione, Missione missione) {
        NaveSpaziale nave = stazione.assegnaNaveOttimale(missione);
        if (nave != null) {
            System.out.println("Missione " + missione.getIdMissione() + " assegnata a: " + nave.getIdRegistrazione());
        } else {
            System.out.println("Nessuna nave disponibile per la missione " + missione.getIdMissione());
        }
    }
}
