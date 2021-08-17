package com.mycompany.controlciudadela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @FXML 
     private VBox imgInicio;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MenuInicio"), 600, 400);
        stage.setScene(scene);
        stage.show();
        
        stage.setTitle("Control Acceso a la Ciudadela");
        
        //ImageView imgv= new ImageView(new Image("/resources/com/mycompany/controlciudadela/icono_admisión_new.png"));
        //imgInicio.getChildren().add(imgv);
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}