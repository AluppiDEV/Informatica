module com.example.javafx_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_4 to javafx.fxml;
    exports com.example.javafx_4;
}