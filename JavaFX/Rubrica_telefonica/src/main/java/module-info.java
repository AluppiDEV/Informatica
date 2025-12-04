module com.talpa.rubrica_telefonica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.talpa.rubrica_telefonica to javafx.fxml;
    exports com.talpa.rubrica_telefonica;
}