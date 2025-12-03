package Java.Scrittura_file_csv;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

    // nome del package corrente
    static String pkName = Main.class.getPackage().getName().replace(".", "/");

    public static void main(String[] args) {
        String fName = "studenti.csv";
        String defaultLine = "Nome,Voto";

        ArrayList<Studente> classe = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int scelta = input.nextInt();

        switch (scelta) {

            case 1: {
                System.out.println("Quanti studenti?");
                int n = input.nextInt();

                // scrivo intestazione solo una volta
                try (PrintWriter out = new PrintWriter(new FileWriter("./" + pkName + "/" + fName, true))) {
                    out.println(defaultLine);
                } catch (IOException e) {
                    System.err.println("Errore: " + e);
                }

                for (int i = 0; i < n; i++) {
                    System.out.println("Inserisci nome e voto:");
                    classe.add(new Studente(input.next(), input.nextInt()));

                    try (PrintWriter out = new PrintWriter(new FileWriter("./" + pkName + "/" + fName, true))) {
                        out.println(classe.get(i).toString());
                    } catch (IOException e) {
                        System.err.println("Errore: " + e);
                    }
                }

                break;
            }

            case 2: {
                System.out.println("Funzione non ancora fatta");
                break;
            }

            default: {
                System.out.println("Puoi scegliere solo 1 o 2");
            }
        }
    }
}
