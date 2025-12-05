package JavaFile.Rubrica_telefonica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        FileManager fileManager = new FileManager();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU RUBRICA ===");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Carica da file");
            System.out.println("3. Stampa rubrica");
            System.out.println("4. Cerca contatto");
            System.out.println("5. Rimuovi contatto (per nome)");
            System.out.println("6. Rimuovi contatto (per posizione)");
            System.out.println("7. Salva su file");
            System.out.println("8. Esci");

            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine(); // Consuma newline

            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    System.out.print("Numero: ");
                    String numero = input.nextLine();
                    rubrica.aggiungiContatto(nome, numero);
                    System.out.println("Contatto aggiunto in memoria!");
                    break;

                case 2:
                    ArrayList<Contatto> contattiCaricati = fileManager.caricaRubrica();
                    rubrica.setContatti(contattiCaricati);
                    System.out.println("Caricati " + contattiCaricati.size() + " contatti da file.");
                    break;

                case 3:
                    System.out.println(rubrica.stampaRubrica());
                    break;

                case 4:
                    System.out.print("Nome da cercare: ");
                    String cerca = input.nextLine();
                    System.out.println(rubrica.cercaContatto(cerca));
                    break;

                case 5:
                    System.out.print("Nome da rimuovere: ");
                    String nomeRimuovi = input.nextLine();
                    if (rubrica.rimuoviContatto(nomeRimuovi)) {
                        System.out.println("Contatto rimosso dalla memoria!");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;

                case 6:
                    System.out.println(rubrica.stampaRubrica());
                    if (!rubrica.isVuota()) {
                        System.out.print("Posizione da rimuovere (1-" + rubrica.getDimensione() + "): ");
                        int indice = input.nextInt() - 1;
                        if (rubrica.rimuoviContatto(indice)) {
                            System.out.println("Contatto rimosso dalla memoria!");
                        } else {
                            System.out.println("Posizione non valida.");
                        }
                    }
                    input.nextLine();
                    break;

                case 7:
                    if (fileManager.salvaRubrica(rubrica)) {
                        System.out.println("Rubrica salvata su file con successo!");
                    } else {
                        System.out.println("Errore nel salvataggio.");
                    }
                    break;

                case 8:
                    System.out.println("Arrivederci!");
                    return;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }
}
