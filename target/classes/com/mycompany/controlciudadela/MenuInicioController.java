/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Kennyn Balseca
 */
public class MenuInicioController implements Initializable {


    @FXML
    private Button InicioSesion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void mostrarInicioSesion(MouseEvent event) {
    try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("IngresoUsuario.fxml"));
            Parent vistaInicioSesion= loader.load();
            Scene sc = new Scene(vistaInicioSesion,300,150);
            Stage st = new Stage();
            st.setScene(sc);
            st.setTitle("Iniciando Sesión");
            st.show();
            
        }catch(IOException ex){
            System.out.println("No se pudo mostrar vista");
        }
    }

}
