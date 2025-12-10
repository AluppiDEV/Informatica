package Java.Gestione_aeroportuale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Aeroporto aeroporto;
    private static Scanner scanner;

    public static void main(String[] args) {
        aeroporto = new Aeroporto();
        scanner = new Scanner(System.in);

        inizializzaAeroporto();

        System.out.println("=== SISTEMA INTERATTIVO AEROPORTO SKYHUB ===\n");

        boolean continua = true;
        while (continua) {
            mostraMenu();
            int scelta = leggiIntero("Scelta: ");

            switch (scelta) {
                case 1:
                    aggiungiVelivoloInArrivo();
                    break;
                case 2:
                    aggiungiPilota();
                    break;
                case 3:
                    aggiungiTecnico();
                    break;
                case 4:
                    aggiungiInfrastruttura();
                    break;
                case 5:
                    System.out.print(aeroporto.simulaTurno());
                    break;
                case 6:
                    simulaMultipliTurni();
                    break;
                case 7:
                    visualizzaStatoAeroporto();
                    break;
                case 0:
                    continua = false;
                    System.out.println("Uscita dal sistema.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void inizializzaAeroporto() {
        aeroporto.aggiungiInfrastruttura(new Pista("Pista-1", 2500));
        aeroporto.aggiungiInfrastruttura(new Pista("Pista-2", 1800));
        aeroporto.aggiungiInfrastruttura(new PiazzolaSosta("Piazzola-A"));
        aeroporto.aggiungiInfrastruttura(new HangarRiparazioni("Hangar-1"));

        aeroporto.aggiungiPilota(new Pilota("Mario Rossi", "P001", List.of("Boeing 737", "Airbus A320")));
        aeroporto.aggiungiPilota(new Pilota("Luca Bianchi", "P002", List.of("Bell 206", "Cessna Citation")));

        aeroporto.aggiungiTecnico(new TecnicoManutentore("Franco", "T001"));

        System.out.println("Aeroporto inizializzato con configurazione base.\n");
    }

    private static void mostraMenu() {
        System.out.println("========================================");
        System.out.println("1. Aggiungi velivolo in arrivo");
        System.out.println("2. Aggiungi pilota");
        System.out.println("3. Aggiungi tecnico");
        System.out.println("4. Aggiungi infrastruttura");
        System.out.println("5. Simula un turno");
        System.out.println("6. Simula multipli turni");
        System.out.println("7. Visualizza stato aeroporto");
        System.out.println("0. Esci");
        System.out.println("========================================");
    }

    private static void aggiungiVelivoloInArrivo() {
        System.out.println("\n--- Aggiungi Velivolo ---");
        System.out.println("Tipo velivolo:");
        System.out.println("1. Aereo di Linea");
        System.out.println("2. Aereo Cargo");
        System.out.println("3. Jet Privato");
        System.out.println("4. Elicottero");
        System.out.println("5. Aliante");

        int tipo = leggiIntero("Scegli tipo: ");
        String id = leggiStringa("Inserisci ID velivolo: ");
        String modello = leggiStringa("Inserisci modello: ");

        Velivolo velivolo = null;

        switch (tipo) {
            case 1:
                int passeggeri = leggiIntero("Capienza passeggeri: ");
                velivolo = new AereoDiLinea(id, modello, passeggeri);
                break;
            case 2:
                double carico = leggiDouble("Capacità carico (kg): ");
                velivolo = new AereoCargo(id, modello, carico);
                break;
            case 3:
                velivolo = new JetPrivato(id, modello);
                break;
            case 4:
                velivolo = new Elicottero(id, modello);
                break;
            case 5:
                velivolo = new Aliante(id, modello);
                break;
            default:
                System.out.println("Tipo non valido.");
                return;
        }

        double carburanteIniziale = leggiDouble("Carburante iniziale (0-100): ");
        velivolo.consumaCarburante(100.0 - carburanteIniziale);

        double integritaIniziale = leggiDouble("Integrità iniziale (0-100): ");
        velivolo.riduciIntegrita(100.0 - integritaIniziale);

        aeroporto.aggiungiVelivoloInArrivo(velivolo);
        System.out.println("Velivolo " + id + " aggiunto alla lista di arrivi.");
    }

    private static void aggiungiPilota() {
        System.out.println("\n--- Aggiungi Pilota ---");
        String nome = leggiStringa("Nome pilota: ");
        String matricola = leggiStringa("Matricola: ");

        System.out.println("Inserisci modelli abilitati (termina con 'fine'):");
        List<String> modelli = new ArrayList<>();
        while (true) {
            String modello = leggiStringa("Modello (o 'fine'): ");
            if (modello.equalsIgnoreCase("fine")) {
                break;
            }
            modelli.add(modello);
        }

        Pilota pilota = new Pilota(nome, matricola, modelli);
        aeroporto.aggiungiPilota(pilota);
        System.out.println("Pilota " + nome + " aggiunto.");
    }

    private static void aggiungiTecnico() {
        System.out.println("\n--- Aggiungi Tecnico ---");
        String nome = leggiStringa("Nome tecnico: ");
        String matricola = leggiStringa("Matricola: ");

        TecnicoManutentore tecnico = new TecnicoManutentore(nome, matricola);
        aeroporto.aggiungiTecnico(tecnico);
        System.out.println("Tecnico " + nome + " aggiunto.");
    }

    private static void aggiungiInfrastruttura() {
        System.out.println("\n--- Aggiungi Infrastruttura ---");
        System.out.println("Tipo infrastruttura:");
        System.out.println("1. Pista");
        System.out.println("2. Piazzola Sosta");
        System.out.println("3. Hangar Riparazioni");

        int tipo = leggiIntero("Scegli tipo: ");
        String id = leggiStringa("Inserisci ID infrastruttura: ");

        Infrastruttura infrastruttura = null;

        switch (tipo) {
            case 1:
                int lunghezza = leggiIntero("Lunghezza pista (metri): ");
                infrastruttura = new Pista(id, lunghezza);
                break;
            case 2:
                infrastruttura = new PiazzolaSosta(id);
                break;
            case 3:
                infrastruttura = new HangarRiparazioni(id);
                break;
            default:
                System.out.println("Tipo non valido.");
                return;
        }

        aeroporto.aggiungiInfrastruttura(infrastruttura);
        System.out.println("Infrastruttura " + id + " aggiunta.");
    }

    private static void simulaMultipliTurni() {
        int numTurni = leggiIntero("Numero di turni da simulare: ");
        for (int i = 0; i < numTurni; i++) {
            System.out.print(aeroporto.simulaTurno());
        }
    }

    private static void visualizzaStatoAeroporto() {
        System.out.println("\n=== STATO ATTUALE AEROPORTO ===");
        System.out.println("Questa funzionalità mostra lo stato durante i turni.");
        System.out.println("Esegui una simulazione per vedere dettagli operativi.");
    }

    private static String leggiStringa(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int leggiIntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int valore = Integer.parseInt(scanner.nextLine());
                return valore;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero intero valido.");
            }
        }
    }

    private static double leggiDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double valore = Double.parseDouble(scanner.nextLine());
                return valore;
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero valido.");
            }
        }
    }
}