/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Registros {
    int idRegistro;
     String Descripcion;
     String Pdf;
     Date FechaEnvio;
     int idUsuario;
     int idEstado;
       int idOpcion;
       
    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPdf() {
        return Pdf;
    }

    public void setPdf(String Pdf) {
        this.Pdf = Pdf;
    }

    public Date getFechaEnvio() {
        return FechaEnvio;
    }

    public void setFechaEnvio(Date FechaEnvio) {
        this.FechaEnvio = FechaEnvio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    public String getNombreOpcion (){
          String nombreOpcion = "Opcion no encontrada"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorRegistros registro = new GestorRegistros();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            nombreOpcion = registro.buscarNombreOpcion(this.idOpcion);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la opcion: " + e.getMessage());
        }
        
        return nombreOpcion;
    }
    
    public String getCorreoUsuario(){
         String correo  = "Correo no encontrada"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorRegistros registro = new GestorRegistros();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            correo = registro.buscarCorreo(this.idUsuario);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la opcion: " + e.getMessage());
        }
        
        return correo;
        
    }
    
    public String getEstado(){
         String estado  = "Estado no encontrada"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorRegistros registro = new GestorRegistros();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            estado = registro.buscarEstado(this.idEstado);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la opcion: " + e.getMessage());
        }
        
        return estado;
        
    }
      public String getnombreUsuario(){
         String nombre  = "nombre no encontrado"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorRegistros registro = new GestorRegistros();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            nombre = registro.buscarNombreUsuario(this.idUsuario);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la opcion: " + e.getMessage());
        }
        
        return nombre;
        
    }
      public String getCedula(){
         String cedula  = "cedula no encontrado"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorRegistros registro = new GestorRegistros();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            cedula = registro.buscarCedula(this.idUsuario);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la opcion: " + e.getMessage());
        }
        
        return cedula;
        
    }
      
      
}
