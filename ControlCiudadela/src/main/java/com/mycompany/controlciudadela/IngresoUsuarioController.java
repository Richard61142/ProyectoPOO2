/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import com.mycompany.controlciudadela.App;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField UsuarioIngresado;
    @FXML
    private TextField ContrasenaUsuarioIngresado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
    
    @FXML
    private void ValidarUsuario(MouseEvent event){
        try{ 
            List<Residente> residentes =Admin.Registro();
            for(Residente elemt:residentes){
                if(UsuarioIngresado.getText().equalsIgnoreCase(elemt.getNombre()) && 
                ContrasenaUsuarioIngresado.getText().equalsIgnoreCase(elemt.getContrasena())){
                //si los datos coinciden con un residente pasa a la vista de opciones del residente
                //de ser diferente debe iniciar sesión de admin por el momento
                
                FXMLLoader loader = new FXMLLoader(App.class.getResource("OpcionesResidente.fxml"));
                Parent vistaOpcionesResidente= loader.load();
                Scene sc = new Scene(vistaOpcionesResidente);
                Stage st = new Stage();
                st.setScene(sc);
                st.setTitle("Opciones Residente");
                st.show();
                
            }else if(UsuarioIngresado.getText().equalsIgnoreCase("admin") && 
                ContrasenaUsuarioIngresado.getText().equalsIgnoreCase("admin")){
                
                FXMLLoader loader = new FXMLLoader(App.class.getResource("MapaCiudadela.fxml"));
                Parent vistaMapaCiudadela= loader.load();
                Scene sc = new Scene(vistaMapaCiudadela);
                Stage st = new Stage();
                st.setScene(sc);
                st.setTitle("Opciones Admin");
                st.show();
            }
            
        }
        }catch(IOException ex){
            
            Alert AlertaError = new Alert(Alert.AlertType.NONE);
            EventHandler<ActionEvent> UsuarioNoExiste = (ActionEvent e) -> {
                AlertaError.setHeaderText("USUARIO NO REGISTRADO");
                AlertaError.setAlertType(Alert.AlertType.ERROR);
                AlertaError.show();
                };
                IngresarCuenta.setOnAction(UsuarioNoExiste);
            
            System.out.println("No se pudo mostrar vista");
        }
    }
    
    
    
}
