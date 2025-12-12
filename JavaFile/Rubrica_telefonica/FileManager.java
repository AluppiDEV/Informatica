package JavaFile.Rubrica_telefonica;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private static final String PK_NAME = "Rubrica_telefonica";
    private static final String DEFAULT_FILE_NAME = "rubrica.ser";

    /**
     * Salva la rubrica su file CSV (default)
     *
     * @param rubrica la rubrica da salvare
     * @return true se salvato con successo
     */
    public boolean salvaRubrica(Rubrica rubrica) {
        return salvaRubrica(rubrica, DEFAULT_FILE_NAME);
    }

    /**
     * Salva la rubrica su file CSV specificato
     *
     * @param rubrica  la rubrica da salvare
     * @param fileName il nome del file dove salvare
     * @return true se salvato con successo
     * @throws IllegalArgumentException se fileName è vuoto o nullo
     */
    public boolean salvaRubrica(Rubrica rubrica, String fileName) {
        if (rubrica == null || fileName == null || fileName.trim().isEmpty()) {
            return false;
        }

        String path = "./" + PK_NAME + "/" + fileName.trim();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(rubrica);
            return true;
        } catch (IOException e) {
            System.err.println("Errore nel trovare il file");
            return false;
        }
    }

    /**
     * Carica la rubrica dal file CSV (default)
     *
     * @return ArrayList di contatti caricati dal file
     */
    public ArrayList<Contatto> caricaRubrica() {
        return caricaRubrica(DEFAULT_FILE_NAME);
    }

    /**
     * Carica la rubrica dal file CSV specificato
     *
     * @param fileName il nome del file da cui caricare
     * @return ArrayList di contatti caricati dal file
     * @throws IllegalArgumentException se fileName è vuoto o nullo
     */
    public ArrayList<Contatto> caricaRubrica(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String path = "./" + PK_NAME + "/" + fileName.trim();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (ArrayList<Contatto>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore lettura file: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    /**
     * Verifica se il file esiste
     *
     * @param fileName nome del file da verificare
     * @return true se il file esiste
     */
    public boolean fileEsiste(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return false;
        }
        File file = new File("./" + PK_NAME + "/" + fileName.trim());
        return file.exists() && file.isFile();
    }

    /**
     * Elimina il file specificato
     *
     * @param fileName nome del file da eliminare
     * @return true se eliminato con successo
     */
    public boolean eliminaFile(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return false;
        }
        File file = new File("./" + PK_NAME + "/" + fileName.trim());
        return file.delete();
    }
}
