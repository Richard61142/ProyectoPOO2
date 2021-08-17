/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
public class IngresoUsuarioController implements Initializable {


    @FXML
    private Button IngresarCuenta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //List<Residente> residentes =Admin.Registro();
        //for(Residente elemt:residentes){
            
        //}
    } 
    
    @FXML
    private void ValidarUsuario(MouseEvent event){
         try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("OpcionesResidente.fxml"));
            Parent vistaOpcionesResidente= loader.load();
            Scene sc = new Scene(vistaOpcionesResidente);
            Stage st = new Stage();
            st.setScene(sc);
            st.setTitle("Opciones Residente");
            st.show();
            
        }catch(IOException ex){
            System.out.println("No se pudo mostrar vista");
        }
    }
    
    
    
}
