package pkg002javaoffstream;
import java.io.*;
import java.util.*;

public class FileManager {
    String nomeFile;

    public FileManager(String nomeFile){
        this.nomeFile = nomeFile;
    }

    public boolean caricaDaFile(Rubrica rubrica){
        try{
            Scanner scanner = new Scanner(new File(nomeFile));

            while(scanner.hasNext()){
                String[] temp = scanner.nextLine().split(",");
                rubrica.aggiungiContatto(temp[0], temp[1]);
            }
            return true;

        } catch (FileNotFoundException e) {
            System.err.println("Errore: " + e.getMessage());
            return false;
        }
    }

    public void salvaSuFile(String nomeFile, Rubrica r){
        try{
            PrintWriter printWriter = new PrintWriter(new FileWriter(nomeFile, false), true);
            printWriter.println(r.visualizzaRubricaPerFile());
        } catch (IOException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }

    public boolean scriviSuFile(String nameFile, Rubrica r, String contenuto){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(nameFile, true), true);
            pw.println(contenuto);
            return true;
        } catch (IOException e) {
            System.out.println("errore: " + e.getMessage());
            return false;
        }
    }
}
