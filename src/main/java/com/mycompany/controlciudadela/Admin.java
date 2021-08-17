/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kennyn Balseca
 */
public class Admin extends Usuario{
    //private ArrayList<Residente> residentes;
    public Admin(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }
    
    public static List<Residente> Registro(){
        String ruta = "RegistroResidentes.txt";
        List<Residente> residentes = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                Residente residente = new Residente(p[0],p[1],p[2],p[3],p[4],p[5],p[6]);
                
                residentes.add(residente);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los residentes");
            ex.printStackTrace();
        }
        return residentes;
    }
    }

