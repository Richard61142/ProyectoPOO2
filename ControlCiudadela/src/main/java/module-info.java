module com.mycompany.controlciudadela {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.controlciudadela to javafx.fxml;
    exports com.mycompany.controlciudadela;
}
