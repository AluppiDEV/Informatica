package com.talpa.rubrica_telefonica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Segreteria {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField numeroField;

    @FXML
    private ListView<String> viewListaContatti;

    @FXML
    private Label statoSalvataggio;

    @FXML
    private Label statoCaricamento;

    // ObservableList to hold contacts for the ListView
    private ObservableList<String> rubrica;
    private static final String FILE_NAME = "rubrica.csv";

    private void printAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        rubrica = FXCollections.observableArrayList();
        viewListaContatti.setItems(rubrica);
        
        // Carica i contatti esistenti all'avvio
        loadByFile();
    }

    @FXML
    protected void onAggiungiContattoClick() {
        String nome = nomeField.getText().trim();
        String numero = numeroField.getText().trim();

        // Controlli
        if (nome.isEmpty() || numero.isEmpty()) {
            printAlert(Alert.AlertType.WARNING, "Campi vuoti", "Impossibile aggiungere il contatto", 
                      "Uno o più campi vuoti, per favore inserisci sia il nome che il numero di telefono");
            return;
        }

        Contatto newC = new Contatto(nome, numero);
        rubrica.add(newC.toString());

        // Salva su file
        saveOnFile();

        // Reset degli input
        nomeField.clear();
        numeroField.clear();
    }

    /**
     * Salva l'ultimo contatto aggiunto sul file in modalità append.
     * Aggiunge il contatto alla fine del file senza riscrivere tutto.
     */
    private boolean saveOnFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            // Salva solo l'ultimo contatto aggiunto
            pw.println(rubrica.getLast());
            statoSalvataggio.setText("✓ Salvataggio riuscito");
            return true;
        } catch (IOException e) {
            printAlert(Alert.AlertType.ERROR, "Scrittura file", 
                      "Errore durante la scrittura del file", 
                      "Impossibile salvare il contatto: " + e.getMessage());
            statoSalvataggio.setText("✗ Salvataggio non riuscito");
            return false;
        }
    }

    /**
     * Carica i contatti dal file CSV.
     * Gestisce righe vuote e malformate in modo sicuro.
     */
    private void loadByFile() {
        File file = new File(FILE_NAME);
        
        // Se il file non esiste, non fare nulla (è la prima esecuzione)
        if (!file.exists()) {
            statoCaricamento.setText("Nessun file da caricare");
            return;
        }
        
        rubrica.clear();
        int contattiCaricati = 0;
        int righeIgnorate = 0;
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String riga = scanner.nextLine().trim();
                
                // Ignora righe vuote
                if (riga.isEmpty()) {
                    continue;
                }
                
                String[] campi = riga.split(",");
                
                // Verifica che ci siano esattamente 2 campi
                if (campi.length != 2) {
                    righeIgnorate++;
                    System.err.println("Riga malformata ignorata: " + riga);
                    continue;
                }
                
                String nome = campi[0].trim();
                String numero = campi[1].trim();
                
                // Verifica che i campi non siano vuoti
                if (nome.isEmpty() || numero.isEmpty()) {
                    righeIgnorate++;
                    continue;
                }
                
                rubrica.add(new Contatto(nome, numero).toString());
                contattiCaricati++;
            }
            
            if (righeIgnorate > 0) {
                statoCaricamento.setText(String.format("✓ %d contatti caricati (%d righe ignorate)",
                                                     contattiCaricati, righeIgnorate));
            } else {
                statoCaricamento.setText(String.format("✓ %d contatti caricati", contattiCaricati));
            }
            
        } catch (IOException e) {
            statoCaricamento.setText("✗ Errore caricamento: " + e.getMessage());
            printAlert(Alert.AlertType.ERROR, "Lettura file", 
                      "Errore durante la lettura del file", 
                      "Impossibile caricare i contatti: " + e.getMessage());
        }
    }
}
