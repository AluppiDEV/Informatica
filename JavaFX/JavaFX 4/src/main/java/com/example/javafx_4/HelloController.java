package com.example.javafx_4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller class following MVC pattern.
 * Handles user interactions and updates the view based on the model.
 */
public class HelloController {

    private final EventModel model;

    @FXML
    private ListView<String> eventList;

    @FXML
    private ImageView imageView;

    @FXML
    private MenuItem menuShowStats;

    @FXML
    private MenuItem menuClearList;

    @FXML
    private MenuItem menuHideImage;

    public HelloController() {
        this.model = new EventModel();
    }

    /**
     * Called when the FXML is loaded
     */
    @FXML
    public void initialize() {
        // Initially hide the image
        imageView.setVisible(false);
        imageView.setManaged(false);
    }

    /**
     * Handles key press events - adds event to model and updates view
     */
    public void handleKeyPress() {
        // Add event to model
        model.addEvent();

        // Update the list view
        eventList.getItems().add(model.getLastEventFormatted());

        // Show image if 10 or more events
        if (model.shouldShowImage()) {
            showImage();
        }
    }

    /**
     * Shows statistics in an alert dialog
     */
    @FXML
    private void showStatistics() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Statistiche Pressioni");
        alert.setHeaderText("Informazioni sulle pressioni dei tasti");

        String content = String.format(
            "Numero totale di pressioni: %d%n%nPrima pressione: %s%n%nUltima pressione: %s",
            model.getTotalEvents(),
            model.getFirstEventFormatted().isEmpty() ? "Nessuna" : model.getFirstEventFormatted(),
            model.getLastEventFormatted().isEmpty() ? "Nessuna" : model.getLastEventFormatted()
        );

        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Clears the event list
     */
    @FXML
    private void clearList() {
        model.clearEvents();
        eventList.getItems().clear();
        
        // Hide image when list is cleared
        hideImage();
    }

    /**
     * Hides the image
     */
    @FXML
    private void hideImage() {
        imageView.setVisible(false);
        imageView.setManaged(false);
    }

    /**
     * Shows the image
     */
    private void showImage() {
        if (!imageView.isVisible()) {
            try {
                // Try to load the image
                Image image = new Image(getClass().getResourceAsStream("/img/celebration.png"));
                imageView.setImage(image);
                imageView.setVisible(true);
                imageView.setManaged(true);
            } catch (Exception e) {
                System.err.println("Impossibile caricare l'immagine: " + e.getMessage());
            }
        }
    }
}
