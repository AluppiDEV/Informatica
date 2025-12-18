package pkg002javaoffstream;

import java.io.*;
import java.util.*;

/**
 *
 * @author m.malavasi
 */
public class Main {
    public static void main(String[] args) {
        String nomeFile = "rubrica.csv";
        int scelta = 0;
        int tempInt = 0;
        String tempNome = "";
        String tempNum = "";
        Rubrica rubrica = new Rubrica();
        FileManager fileManager = new FileManager(nomeFile);
        HtmlGenerator html = new HtmlGenerator(rubrica);

        Scanner ioScanner = new Scanner(System.in);
        
        while(scelta != 6){
            System.out.println("1. Inserisci contatti manualmente" +
                    "\n2. Inserisci i contatti da file" +
                    "\n3. Lista contatti" +
                    "\n4. Esporta contatti su file" +
                    "\n5. Genera HTML" +
                    "\n6. Esci:");
            
            scelta = ioScanner.nextInt();
            
            switch(scelta){
                case 1 -> {
                    System.out.println("Inserisci nome del contatto:");
                    tempNome = ioScanner.next();
                    System.out.println("Inserisci numero del contatto:");
                    tempNum = ioScanner.next();

                    rubrica.aggiungiContatto(tempNome, tempNum);
                }
                
                case 2 -> {
                    if(fileManager.caricaDaFile(rubrica)) System.out.println("Contatti caricati correttamente!");
                    else System.out.println("Errore durante il caricamento dei contatti!");
                }
                
                case 3 -> System.out.println(rubrica.visualizzaRubrica());

                case 4 -> {
                    fileManager.salvaSuFile(nomeFile, rubrica);
                    System.out.println("Contatti salva su file correttamente!");
                }

                case 5 -> {
                    HtmlGenerator.generaHTMLcontatti();
                    System.out.println("HTML GENERATO!");
                }

                case 6 -> System.out.println("Arrivederci!");

                default -> System.err.println("Errore nella lettura delle comando.");
            }
        }
    }
    
}
