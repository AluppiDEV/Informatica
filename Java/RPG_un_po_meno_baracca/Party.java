package Java.RPG_un_po_meno_baracca;

import java.util.Scanner;

public class Party {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inizializzazione dei due giocatori
        Personaggio p1 = new Mago("Maghetto", 100, 10, 200);
        Personaggio p2 = new Guerriero("Guerriero", 100, 30);

        // Aggiungi oggetti iniziali a entrambi i giocatori
        p1.aggiungiOggetto(new PozioneMana("Pozione mana"));
        p1.aggiungiOggetto(new PozioneCurativa("Pozione curativa"));
        p1.aggiungiOggetto(new PozioneCurativa("Pozione curativa"));

        p2.aggiungiOggetto(new PozioneMana("Pozione mana"));
        p2.aggiungiOggetto(new PozioneCurativa("Pozione curativa"));
        p2.aggiungiOggetto(new PozioneCurativa("Pozione curativa"));

        System.out.println("===========================================");
        System.out.println("       BENVENUTO AL GIOCO RPG!");
        System.out.println("===========================================");
        System.out.println();

        // Mostra informazioni iniziali
        System.out.println("GIOCATORE 1:");
        System.out.println(p1);
        System.out.println();
        System.out.println("GIOCATORE 2:");
        System.out.println(p2);
        System.out.println();

        // Inizia il gioco
        iniziaPartita(p1, p2);

        scanner.close();
    }

    /**
     * Gestisce il loop principale del gioco a turni
     */
    private static void iniziaPartita(Personaggio p1, Personaggio p2) {
        int turno = 1;
        Personaggio giocatoreCorrente = p1;
        Personaggio avversario = p2;

        while (p1.isAlive() && p2.isAlive()) {
            System.out.println("===========================================");
            System.out.println("              TURNO " + turno);
            System.out.println("===========================================");
            System.out.println();

            // Mostra stato attuale
            mostraStatoGioco(giocatoreCorrente, avversario);

            // Esegui il turno del giocatore corrente
            eseguiTurno(giocatoreCorrente, avversario);

            // Controlla se qualcuno è morto
            if (!avversario.isAlive()) {
                System.out.println();
                System.out.println("===========================================");
                System.out.println("           PARTITA TERMINATA!");
                System.out.println("===========================================");
                System.out.println();
                System.out.println("🏆 VITTORIA PER " + giocatoreCorrente.toString().split("Nome: ")[1].split("\n")[0] + "! 🏆");
                System.out.println();
                System.out.println("Stato finale:");
                System.out.println(giocatoreCorrente);
                System.out.println(avversario);
                break;
            }

            // Scambia i giocatori per il prossimo turno
            Personaggio temp = giocatoreCorrente;
            giocatoreCorrente = avversario;
            avversario = temp;

            turno++;
            System.out.println();
        }
    }

    /**
     * Mostra lo stato attuale del gioco
     */
    private static void mostraStatoGioco(Personaggio giocatoreCorrente, Personaggio avversario) {
        System.out.println(">>> È il turno di: " + giocatoreCorrente.toString().split("Nome: ")[1].split("\n")[0]);
        System.out.println();
        System.out.println("Il tuo personaggio:");
        System.out.println(giocatoreCorrente);
        System.out.println();
        System.out.println("Avversario:");
        String[] avversarioInfo = avversario.toString().split("\n");
        for (int i = 0; i < Math.min(4, avversarioInfo.length); i++) {
            System.out.println(avversarioInfo[i]);
        }
        System.out.println("-------------------");
        System.out.println();
    }

    /**
     * Gestisce il turno di un singolo giocatore
     */
    private static void eseguiTurno(Personaggio giocatoreCorrente, Personaggio avversario) {
        boolean azioneValida = false;

        while (!azioneValida) {
            System.out.println("Scegli un'azione:");
            System.out.println("1. Attacca");
            System.out.println("2. Usa oggetto dall'inventario");
            System.out.print("Scelta (1-2): ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    // Attacca
                    int danno = giocatoreCorrente.attacca(avversario);
                    System.out.println();
                    System.out.println("⚔️  Hai inflitto " + danno + " danni all'avversario!");
                    azioneValida = true;
                    break;

                case "2":
                    // Usa oggetto dall'inventario
                    azioneValida = gestisciUsoOggetto(giocatoreCorrente);
                    break;

                default:
                    System.out.println("❌ Scelta non valida! Riprova.");
                    System.out.println();
                    break;
            }
        }
    }

    /**
     * Gestisce la selezione e l'uso di un oggetto dall'inventario
     */
    private static boolean gestisciUsoOggetto(Personaggio giocatore) {
        String inventarioList = giocatore.getInventarioList();
        
        if (inventarioList.equals("(vuoto)")) {
            System.out.println();
            System.out.println("❌ Il tuo inventario è vuoto!");
            System.out.println();
            return false;
        }

        System.out.println();
        System.out.println("--- Inventario ---");
        
        // Mostra l'inventario con indici
        String[] oggetti = inventarioList.split(", ");
        for (int i = 0; i < oggetti.length; i++) {
            System.out.println(i + ". " + oggetti[i]);
        }
        System.out.println("------------------");
        System.out.print("Scegli l'indice dell'oggetto da usare (0-" + (oggetti.length - 1) + ") o 'c' per annullare: ");
        
        String scelta = scanner.nextLine().trim();
        
        if (scelta.equalsIgnoreCase("c")) {
            System.out.println("Azione annullata.");
            System.out.println();
            return false;
        }
        
        try {
            int indice = Integer.parseInt(scelta);
            String risultato = giocatore.usaOggetto(indice);
            System.out.println();
            
            if (risultato != null) {
                System.out.println(risultato);
                return true;
            } else {
                System.out.println("❌ Non è stato possibile usare l'oggetto!");
                System.out.println();
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("❌ Indice non valido! Riprova.");
            System.out.println();
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("❌ Indice fuori range! Riprova.");
            System.out.println();
            return false;
        }
    }
}
