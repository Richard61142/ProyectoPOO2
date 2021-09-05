/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.util.Objects;

/**
 *
 * @author Kennyn Balseca
 */
public class Visitante {
    private String Nombre;
    private String Cedula;
    private String Correo;
    private String Fecha;
    private String Estado;
    private String PinAcceso;

    public Visitante(String Nombre, String Cedula, String Correo, String PinAcceso,String Fecha,String Estado) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Correo = Correo;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.PinAcceso = PinAcceso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getPinAcceso() {
        return PinAcceso;
    }

    public void setPinAcceso(String PinAcceso) {
        this.PinAcceso = PinAcceso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visitante other = (Visitante) obj;
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Cedula, other.Cedula)) {
            return false;
        }
        if (!Objects.equals(this.Correo, other.Correo)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        if (!Objects.equals(this.PinAcceso, other.PinAcceso)) {
            return false;
        }
        return true;
    }
    
            
    
}
