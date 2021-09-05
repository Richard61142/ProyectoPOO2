/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlciudadela;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Kennyn Balseca
 */
public class Admin extends Usuario implements Serializable{
    
    public Admin(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }
    
    public static ArrayList<Residente> LeerRegistro(){
        /*String ruta = "RegistroResidentes.txt";
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
        }
        return residentes;*/
        ArrayList<Residente> listaResidentes= new ArrayList<>();
        Path archivoR= Paths.get("src\\main\\resources\\com\\mycompany\\controlciudadela\\RegistroResidentes.txt");
        try(BufferedReader lector= new BufferedReader(new FileReader(archivoR.toString(),Charset.forName("UTF-8")))){
            String linea;
            while((linea=lector.readLine())!= null){
                System.out.println(linea);
                String[] data=linea.split(",");
                listaResidentes.add(new Residente(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
           }
        }catch(IOException ex){
            System.out.println("No hay archivo");
        }
        return listaResidentes;
    }
    
    public static List<Residente> Registrar(){
       //por el momento
        return null;
    }
}

