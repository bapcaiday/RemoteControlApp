module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
}