/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Lenovo
 */
public class GestorUsuario {
    Conexion con = new Conexion();
    
    public void AgregarUsuario(String nombre, String apellido, String cedula, String correo, String contrasenia, int idroll, Connection conectar){
            if (conectar != null) {
            try {
                // Llamar al procedimiento almacenado para agregar el tutorial
                CallableStatement stmt = conectar.prepareCall("{call AgregarUsuario(?, ?, ?, ?, ?,?)}");
                stmt.setString(1, nombre);
                stmt.setString(2, apellido);
                stmt.setString(3, cedula);
                stmt.setString(4, correo);
               stmt.setString(5, contrasenia);
                stmt.setInt(6, idroll);
            
                stmt.execute();
                conectar.close();
                System.out.println("Se agregó con éxito ");
            } catch (SQLException e) { // Manejar cualquier error de SQL
                System.out.println("Error al agregar, pruebe de nuevo: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer una conexión a la base de datos.");
        }
        
        
        
    }

public void AgregarPQRS(String descripcion, String pdf, Date fechaEnvio, int idOpcion, int idUsuario, int idEstado, Connection conectar) {
        if (conectar != null) {
            try {
                // Llamar al procedimiento almacenado para agregar el PQRS
                CallableStatement stmt = conectar.prepareCall("{call AgregarRegistro(?, ?, ?, ?, ?, ?)}");
                stmt.setString(1, descripcion);
                stmt.setString(2, pdf);
                stmt.setDate(3, fechaEnvio);
                stmt.setInt(4, idOpcion);
                stmt.setInt(5, idUsuario);
                stmt.setInt(6, idEstado);
                
                stmt.execute();
                conectar.close();
                System.out.println("PQRS agregado con éxito");
            } catch (SQLException e) {
                System.out.println("Error al agregar el PQRS: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer una conexión a la base de datos.");
        }
    }


    
     public String[] loginUsuario(String correo, String contrasenia) throws SQLException {
    String[] resultado = new String[4]; // Array para almacenar el nombre de usuario, el rol y la cédula
    Connection conexion = con.Conectar();
    String consulta = "SELECT Nombre, idroll, Cedula, idUsuario FROM usuario WHERE Correo = ? AND Contraseña = ?";
    PreparedStatement statement = conexion.prepareStatement(consulta);
    statement.setString(1, correo);
    statement.setString(2, contrasenia);
    ResultSet resultSet = statement.executeQuery();
    
    if (resultSet.next()) {
        // Las credenciales coinciden, usuario autenticado
        resultado[0] = resultSet.getString("Nombre"); // Obtener el nombre de usuario
        resultado[2] = resultSet.getString("Cedula"); // Obtener la cédula del usuario
        resultado[3] = resultSet.getString("idUsuario");
        
        // Obtener el id del rol del usuario
        int idRol = resultSet.getInt("idroll");
        
        // Determinar si el usuario es un superusuario o no
        if (idRol == 2) {
            resultado[1] = "Superusuario"; // Si el id del rol es 2, es un superusuario
        } else {
            resultado[1] = "Usuario"; // De lo contrario, es un usuario regular
        }
        
        resultSet.close();
        statement.close();
        
        return resultado; // Devolver el nombre de usuario, el rol y la cédula
    }
    
    resultSet.close();
    statement.close();

    // Si no se encontró ninguna coincidencia o las credenciales son incorrectas, el inicio de sesión falla
    return null;
}
     
}


