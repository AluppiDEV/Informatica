module com.example.javafx_for_beginners {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_for_beginners to javafx.fxml;
    exports com.example.javafx_for_beginners;
}