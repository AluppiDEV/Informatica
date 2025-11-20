package com.example.javafx_4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    int count = 0;

    @FXML
    private Label orario;

    @FXML
    private ImageView immagine;

    @FXML
    protected void getTime() {
        LocalTime ora = LocalTime.now();
        String testo = ora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        count++;
        orario.setText(testo);
        if (count == 10 ){
            immagine.setImage(new javafx.scene.image.Image("file:src/main/resources/img/ciao.png"));
        }
    }

    @FXML
    private ListView<HBox> lista;

    public void initialize() {
        for (int i = 1; i <= 5; i++) {
            Button b = new Button("Pulsante " + i);
            b.setOnAction(e -> System.out.println("Hai cliccato: " + b.getText()));

            HBox box = new HBox(10);
            box.getChildren().add(b);

            lista.getItems().add(box);
        }
    }
}
