package Java.FileWriter;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String name = "file.txt";
        String pkName = "FileWriter";

        try (
                FileWriter fw = new FileWriter("./"+pkName+"/"+name, true);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("RIGA 2");

            System.out.println("Scrittura eseguita");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file -> " + e.getMessage());
        }
    }

}
