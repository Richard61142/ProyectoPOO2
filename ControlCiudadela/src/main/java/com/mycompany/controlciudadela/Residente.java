/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

/**
 *
 * @author Kennyn Balseca
 */
public class Residente extends Usuario {
    private String mz;
    private String villa;
    private String genero;
    private String pin;

    
    public Residente(String mz, String villa, String genero, String pin, String nombre, String correo, String contrasena) {
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
        return ("Nombre Residente: "+ super.getNombre() +"\nGenero: "+ genero +"\n Manzana: "+ mz +"\nVilla: "+villa+"\nPin: "+ pin);
    }
    
    /*public String Info_CambioPin(String correo){
       
    }*/
    
    //Registrar vehiculo
    
    
    //Registro de visitantes
    
    
    //Listado de visitantes ACTIVOS
    
    
}
