package com.example.javafx_for_beginners;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private Label text;
    @FXML
    private Label text2;
    @FXML
    private Button btn;

    @FXML
    protected void onHelloButtonClick() {
        text.setText("Welcome to JavaFX Application!");
        btn.setText("Bye!");
    }

    @FXML
    protected void onHelloButtonClick2() {
        String oraCorrente = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        text2.setText(oraCorrente);
    }
}
