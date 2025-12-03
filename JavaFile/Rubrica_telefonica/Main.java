package JavaFile.Rubrica_telefonica;

import JavaFile.Scrittura_file_csv.Studente;

import java.util.*;
import java.io.*;

public class Main {

    static String pkName = "Rubrica_telefonica";

    public static void main(String[] args) {

        String fName = "rubrica.csv";
        ArrayList<Contatto> rubrica = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Seleziona cosa fare \n1. Aggiungi numero \n2. Carica i numeri dalla rubrica \n3. Stampa rubrica \n4. Esci");
            switch (input.nextInt()) {

                case 1: {
                    try (PrintWriter out = new PrintWriter(new FileWriter("./" + pkName + "/" + fName, true))) {

                        System.out.println("Quanti contatti vuoi registrare?");
                        int n = input.nextInt();

                        for (int i = 0; i < n; i++) {
                            input.reset();
                            System.out.println("Inserisci nome del contatto:");
                            String nome = input.nextLine();
                            System.out.println("Inserisci numero di telefono:");
                            String numero = input.nextLine();

                            Contatto c = new Contatto(nome, numero);
                            rubrica.add(c);

                            out.println(c.toString());
                        }

                    } catch (IOException e) {
                        System.err.println("Errore: " + e);
                    }
                    break;
                }

                // ---------- PUNTO 2: CARICA DA FILE ----------
                case 2: {
                    rubrica.clear();

                    try (Scanner file = new Scanner(new File("./" + pkName + "/" + fName))) {

                        while (file.hasNextLine()) {
                            String riga = file.nextLine();
                            String[] campi = riga.split(",");

                            String nome = campi[0];
                            String numero = campi[1];

                            rubrica.add(new Contatto(nome, numero));
                        }

                        System.out.println("Contatti caricati.");

                    } catch (IOException e) {
                        System.err.println("Errore: " + e);
                    }
                    break;
                }

                // ---------- PUNTO 3: STAMPA RUBRICA ----------
                case 3: {
                    if (rubrica.isEmpty()) {
                        System.out.println("Rubrica vuota.");
                    } else {
                        for (Contatto c : rubrica) {
                            System.out.println(c);
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("Arrivederci");
                    break;
                }

                default: {
                    System.out.println("\nScelta non valida, riprova\n");
                }
            }

        }

    }
}
