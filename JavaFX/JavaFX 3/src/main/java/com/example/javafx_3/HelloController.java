package com.example.javafx_3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button helloButton;
    @FXML
    private VBox root;

    private ImageView imageView = new ImageView();
    private List<String> imagePaths = List.of(
            "images/arancio.jpg",
            "images/banane.jpg",
            "images/ciliegie.jpg",
            "images/cocomero.jpg",
            "images/limone.jpg",
            "images/iconaSlotMachine.png",
            "images/perso.jpg",
            "images/play.png",
            "images/prugna.jpg",
            "images/sette.jpg",
            "images/vinto.jpg"
    );
    private int clickCount = 0;
    private final Random random = new Random();

    @FXML
    public void initialize() {
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);

        // Nasconde l'immagine quando ci passi sopra col mouse
        imageView.setOnMouseEntered(e -> imageView.setVisible(false));
        imageView.setOnMouseExited(e -> imageView.setVisible(true));

        // Clic destro per riattivare il bottone
        helloButton.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                helloButton.setDisable(false);
                clickCount = 0;
                welcomeText.setText("Bottone riattivato!");
            }
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        clickCount++;
        if (clickCount >= 10) {
            helloButton.setDisable(true);
            welcomeText.setText("Hai raggiunto 10 click!");
            return;
        }

        // Mostra immagine casuale
        int index = random.nextInt(imagePaths.size());
        String path = imagePaths.get(index);

        InputStream stream = getClass().getResourceAsStream("/" + path);
        if (stream == null) {
            welcomeText.setText("Errore: immagine non trovata (" + path + ")");
            return;
        }

        Image image = new Image(stream);
        imageView.setImage(image);
        welcomeText.setText("Immagine: " + path.substring(path.lastIndexOf("/") + 1));
    }
}
