/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Lenovo
 */
public class GestorUsuario {
    Conexion con = new Conexion();
    
    public void AgregarTutorial (String nombre, String apellido, String cedula, String correo, String contrasenia, int idroll, Connection conectar){
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
     public String loginUsuario(String correo, String contrasenia) throws SQLException {
         Connection conexion = con.Conectar();
        String consulta = "SELECT Nombre FROM usuario WHERE Correo = ? AND Contraseña = ?";
        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setString(1, correo);
        statement.setString(2, contrasenia);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            // Las credenciales coinciden, usuario autenticado
            String nombreUsuario = resultSet.getString("Nombre");
            resultSet.close();
            statement.close();
            return nombreUsuario; // Devolver el nombre de usuario
        }
        
        resultSet.close();
        statement.close();

        // Si no se encontró ninguna coincidencia o las credenciales son incorrectas, el inicio de sesión falla
        return null;
    }
}
