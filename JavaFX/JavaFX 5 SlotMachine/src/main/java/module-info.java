module talpa.javafx5_slotmachine {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens talpa.javafx5_slotmachine to javafx.fxml;
    exports talpa.javafx5_slotmachine;
}