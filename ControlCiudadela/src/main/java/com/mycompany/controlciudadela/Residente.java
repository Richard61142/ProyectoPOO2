/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kennyn Balseca
 */
public class Residente extends Usuario implements Serializable {
    private String mz;
    private String villa;
    private String genero;
    private String pin;
    private ArrayList<Vehiculo> misVehiculos;
    
    public Residente(String nombre, String correo, String contrasena,String genero,String mz, String villa, String pin) {
        super(nombre, correo, contrasena);
        this.mz = mz;
        this.villa = villa;
        this.genero = genero;
        this.pin = pin;
    }

    public String getMz() {
        return mz;
    }

    public String getVilla() {
        return villa;
    }

    public String getGenero() {
        return genero;
    }

    public String getPin() {
        return pin;
    }
    
    //metodos Residente
    
    
    //Informacion y Cambio de Pin
    @Override
    public String toString(){
        return ("Nombre Residente: "+ super.getNombre()+"\nCorreo: "+super.getCorreo()+"\nContraseña: "+super.getContrasena() 
                +"\nGenero: "+genero+"\nManzana: "+mz+"\nVilla: "+villa+"\nPin: "+pin);
    }
    
    /*public String Info_CambioPin(String correo){
       
    }*/
    
    //Registrar vehiculo
    
    
    //Registro de visitantes
   
    
    //Listado de visitantes ACTIVOS
    
    
}
