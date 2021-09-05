/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import com.mycompany.controlciudadela.App;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    private ArrayList<Residente> rst;
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
        rst= Admin.LeerRegistro();
        
        
    } 
    
    @FXML
    private void ValidarUsuario(MouseEvent event) throws IOException{
            Residente rstIngresado;
            //List<Residente> residentes =Admin.Registro();
            for(Residente elemt:rst){
                try{
                if( (UsuarioIngresado.getText().equals(elemt.getNombre())) && 
                ( ContrasenaUsuarioIngresado.getText().equals(elemt.getContrasena())) ){
                //si los datos coinciden con un residente pasa a la vista de opciones del residente
                //de ser diferente debe mostrar ERROR*/
                    rstIngresado=elemt;
                IngresarCuenta.setOnMouseClicked(e ->{
                    try{
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("OpcionesResidente.fxml"));
                        Parent vistaOpcionesResidente = loader.load();
                         Scene sc = new Scene(vistaOpcionesResidente);
                         Stage st = new Stage();
                        st.setScene(sc);
                        st.setTitle("Opciones Residente");
                        st.show();
                
                
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
               
                });
                
            }else if(UsuarioIngresado.getText().equals("admin") && 
                ContrasenaUsuarioIngresado.getText().equals("admin")){
                
                FXMLLoader loader = new FXMLLoader(App.class.getResource("MapaCiudadela.fxml"));
                Parent vistaMapaCiudadela= loader.load();
                Scene sc = new Scene(vistaMapaCiudadela);
                Stage st = new Stage();
                st.setScene(sc);
                st.setTitle("Opciones Admin");
                st.show();
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
}
