/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Usuario {
    String Nombre;
    String Apellido;
    String Cedula;
    String Correo;
    String Contraseña;
    int idroll;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getIdroll() {
        return idroll;
    }

    public void setIdroll(int idroll) {
        this.idroll = idroll;
    }
    
     public String getRoll (){
          String roll = "Roll no encontrado"; // Valor por defecto
        
        // Crear una instancia de GestorCategorias
        GestorUsuario registro = new GestorUsuario();
        
        try {
            // Llamar al método buscarCategoria de la instancia de GestorCategorias para obtener el nombre de la categoría
            roll = registro.buscarRoll(this.idroll);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del roll: " + e.getMessage());
        }
        
        return roll;
    }
}
