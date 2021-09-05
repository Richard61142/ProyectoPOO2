/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Kennyn Balseca
 */
public class OpcionesResidenteController implements Initializable {

    @FXML
    private TabPane PanelOpciones;
    @FXML
    private Button btnRegistratVisita;
   
    @FXML
    private TableView<Visitante> tblVisitasRegistradas;
    @FXML
    private TableColumn<Visitante,String> clNombre;
    @FXML
    private TableColumn<Visitante,String> clCedulaVisita;
    @FXML
    private TableColumn<Visitante,String> clCodigoAcceso;
    @FXML
    private TableColumn<Visitante,String> clFecha;
    @FXML
    private TableColumn<Visitante,String> clEstado;
    
    private ObservableList<Visitante> visitantes;
    @FXML
    private VBox vbInfo;
    @FXML
    private Button btnCambiarPin;
    @FXML
    private TableView<Vehiculo> tblRegistroVehiculo;
    
    private ObservableList<Vehiculo> vehiculos;
    @FXML
    private TableColumn<Vehiculo, String> clMatricula;
    @FXML
    private TableColumn<Vehiculo, String> clNombrePropietario;
    @FXML
    private VBox vbImgCarrito;
    @FXML
    private Button btnRegistrarVehiculo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RegistrarVisita();
        
        visitantes = FXCollections.observableArrayList();  
        clNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        clCedulaVisita.setCellValueFactory(new PropertyValueFactory("Cedula"));
        clCodigoAcceso.setCellValueFactory(new PropertyValueFactory("PinAcceso"));
        clFecha.setCellValueFactory(new PropertyValueFactory("Fecha"));
        clEstado.setCellValueFactory(new PropertyValueFactory("Estado"));
        
        MiInformacion();
        
        MiVehiculo();
        vehiculos= FXCollections.observableArrayList();
        clMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        clNombrePropietario.setCellValueFactory(new PropertyValueFactory("propietario"));
        
    }
    
    public void RegistrarVisita(){
        btnRegistratVisita.setOnMouseClicked(e->{
            Stage st = new Stage();
            
            VBox ContenedorPrincipal= new VBox();
            
            //Ingreso de nombre de la visita
            Label nombreVisita= new Label("Nombre Visita:");
            TextField txtNomVisita= new TextField();
            HBox NombreV= new HBox(nombreVisita, txtNomVisita);
            ////////
            Label numCedula= new Label("Número Cédula:");
            TextField txtNumCedula= new TextField();
            HBox CedulaV= new HBox(numCedula,txtNumCedula);
            ////////
            Label correoVisita= new Label("Correo Visita:");
            TextField txtcorreoVisita= new TextField();
            HBox CorreoV= new HBox(correoVisita, txtcorreoVisita);
            ////////
            Label FechaVisita= new Label("Fecha Visita:");
            TextField txtFechaVisita= new TextField();
            HBox FechaV= new HBox(FechaVisita, txtFechaVisita);
            ////////
            
            Button btnRegistra= new Button("Registrar");
            btnRegistra.setOnMouseClicked(a->{
                
                try(BufferedWriter escritor= new BufferedWriter(new FileWriter("RegistroVisitantes.txt",true))){
                    String Nombre=txtNomVisita.getText();
                    String Cedula=txtNumCedula.getText();
                    String Correo=txtcorreoVisita.getText();
                    String Fecha=txtFechaVisita.getText();
                    escritor.write(Nombre+","+Cedula+","+Correo+","+Fecha);
                    
                     Visitante v = new Visitante(Nombre,Cedula,Correo,"6910",Fecha,"En Espera");
           
                     AgregarVisita(v);
                    }catch(IOException ex){
                    System.out.println("Error al registrar visita");
                }
                 
                st.close();
                System.out.println("Registrado");
            });
            //Agregamos al Contenedor Principal
            ContenedorPrincipal.getChildren().addAll(NombreV,CedulaV,CorreoV,FechaV,btnRegistra);
            
            //seteamos la scena
            Scene sc = new Scene(ContenedorPrincipal,300,150);
            st.setScene(sc);
            st.show();
            st.setTitle("Datos del Visitante");
            ///////////
            
        });
        
    }
    
    public void AgregarVisita(Visitante v){
        //colocar try de formatos
        if(!visitantes.contains(v)){
           visitantes.add(v);
           tblVisitasRegistradas.setItems(visitantes);
           }else{
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setTitle("Error");
           alert.setContentText("Error al Registrar");
           alert.showAndWait();
        } 
    }
    
    
    //Información Personal
    public void MiInformacion(){
        
       ArrayList<Residente> residente= Admin.LeerRegistro();
       for(Residente rst:residente){
     
           try(InputStream ruta= new FileInputStream("src\\main\\resources\\com\\mycompany\\controlciudadela\\InfoRst\\"+rst.getNombre()+".jpg")){
               
           Image img= new Image(ruta);
           ImageView imgV= new ImageView(img);
           imgV.setFitHeight(200);
           imgV.setFitWidth(200);
           
           Label lblnombre= new Label("Nombre Residente: ");
           Label NombreRst= new Label(rst.getNombre());
           HBox hbnombre= new HBox(lblnombre,NombreRst);
           
           Label lblcorreo= new Label("Correo: ");
           Label CorreoRst= new Label(rst.getCorreo());
           HBox hbcorreo= new HBox(lblcorreo,CorreoRst);
           
           Label lblmanzana= new Label("Manzana: ");
           Label ManzanaRst= new Label(rst.getMz());
           HBox hbmanzana= new HBox(lblmanzana,ManzanaRst);
           
           Label lblvilla= new Label("Villa: ");
           Label VillaRst= new Label(rst.getVilla());
           HBox hbvilla= new HBox(lblvilla,VillaRst);
           
           Label lblpin= new Label("Pin Acceso: ");
           Label PinRst= new Label(rst.getPin());
           HBox hbpin= new HBox(lblpin,PinRst);
           
           vbInfo.getChildren().addAll(imgV,hbnombre,hbcorreo,hbmanzana,hbvilla,hbpin);
           
       }catch(FileNotFoundException ex){
               System.out.println("No se encontró Foto");
       }catch(IOException ex){
           
       }
           btnCambiarPin.setOnMouseClicked(e->{
               Stage st= new Stage();
               VBox desicion= new VBox();
               Label msj= new Label("Desea Cambiar su Pin?");
               HBox opciones= new HBox();
               
               
               Button afirmativo= new Button("Sí");
               afirmativo.setOnMouseClicked(a->{
                   Stage stCambio= new Stage();
                   VBox Cambio= new VBox();
                   HBox PinActual= new HBox();
                   Label lblPinActual= new Label("Ingrese Pin Actual");
                   TextField txtPinActual= new TextField();
                   PinActual.getChildren().addAll(lblPinActual,txtPinActual);
                   HBox PinNuevo= new HBox();
                   Label lblPinNuevo= new Label("Ingrese Pin Nuevo");
                   TextField txtPinNuevo= new TextField();
                   PinNuevo.getChildren().addAll(lblPinNuevo,txtPinNuevo);
                   Button Cambiar = new Button("Cambiar");
                   Cambio.getChildren().addAll(PinActual,PinNuevo,Cambiar);
                   Scene sc= new Scene(Cambio,100,100);
                   stCambio.setScene(sc);
                   stCambio.show();
               });
               
               Button negativo= new Button("No");
               negativo.setOnMouseClicked(n->{
                  st.close(); 
               });
               
               opciones.getChildren().addAll(afirmativo,negativo);
               desicion.getChildren().addAll(msj,opciones);
               Scene sc= new Scene(desicion,300,100);
         
               st.setTitle("Cambio de Pin");
               st.setScene(sc);
               st.show();
               
               
           });
        }
    }
    
    public void MiVehiculo(){
        try(InputStream ruta= new FileInputStream("src\\main\\resources\\com\\mycompany\\controlciudadela\\InfoRst\\carrito.png")){
            
            Image imgCarrito= new Image(ruta);
            ImageView imgVCarrito= new ImageView(imgCarrito);
            imgVCarrito.setFitHeight(260);
            imgVCarrito.setFitWidth(210);
            vbImgCarrito.getChildren().addAll(imgVCarrito);
            
        }catch(FileNotFoundException ex){
            System.out.println("No se encontró carrito");
        }catch(IOException ex){
            
        }
        btnRegistrarVehiculo.setOnMouseClicked(r->{
            Stage st= new Stage();
            VBox vbMatricula= new VBox();
            HBox hbMatricula= new HBox();
            Label lblmatricula= new Label("Ingrese Matricula: ");
            TextField txtMatricula= new TextField();
            hbMatricula.getChildren().addAll(lblmatricula,txtMatricula);
            
            HBox hbPropietario= new HBox();
            Label lblPropietario= new Label("Nombre Propietario: ");
            TextField txtPropietario= new TextField();
            hbPropietario.getChildren().addAll(lblPropietario,txtPropietario);
            
            Button btnRegistrar= new Button("Registrar");
            btnRegistrar.setOnMouseClicked(re->{
                String matricula= txtMatricula.getText();
                String propietario= txtPropietario.getText();
                Vehiculo vcl= new Vehiculo(matricula,propietario);
                if(!vehiculos.contains(vcl)){
                    vehiculos.add(vcl);
                    tblRegistroVehiculo.setItems(vehiculos);
                    }else{
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Error al Registrar");
                    alert.showAndWait();
                 } st.close();  
            });
            
            vbMatricula.getChildren().addAll(hbMatricula,hbPropietario,btnRegistrar);
            Scene sc= new Scene(vbMatricula,200,100);
            st.setScene(sc);
            st.show();
        });
    }
}
