package com.example.javafx_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        
        // Get the controller to handle key events
        HelloController controller = fxmlLoader.getController();
        
        // Add key press event handler to the scene
        scene.setOnKeyPressed(event -> {
            controller.handleKeyPress();
        });
        
        stage.setTitle("Event Tracker - MVC JavaFX");
        stage.setScene(scene);
        stage.show();
        
        // Request focus so key events are captured
        scene.getRoot().requestFocus();
    }
}
