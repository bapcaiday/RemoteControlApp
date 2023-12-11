module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jnativehook;
    requires java.logging;
    requires slf4j.api;
    requires java.desktop;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}