module com.example.javafx_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx_2 to javafx.fxml;
    exports com.example.javafx_2;
}