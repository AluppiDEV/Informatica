package com.example.javafx_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

public class MainController {

    @FXML
    protected void loadView1(ActionEvent event) throws IOException {
        switchScene(event, "view1.fxml");
    }

    @FXML
    protected void loadView2(ActionEvent event) throws IOException {
        switchScene(event, "view2.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected Label text;

    @FXML
    protected void showDate() {
        // Ottieni data e ora attuali
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatta data e ora come desideri

        // Mostra nel label
        text.setText(now.format(formatter));
    }
}
