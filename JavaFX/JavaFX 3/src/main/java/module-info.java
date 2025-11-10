module com.example.javafx_3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx_3 to javafx.fxml;
    exports com.example.javafx_3;
}