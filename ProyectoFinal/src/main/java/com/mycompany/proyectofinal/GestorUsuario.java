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
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Lenovo
 */
public class GestorUsuario {
    Conexion con = new Conexion();
    
    
    //metodo para agregar un usuario
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
    
    //metodo para agregar usuario
     public void eliminarUsuario(int idUsuario) {
        try (Connection conexion = new Conexion().Conectar()) {
            String sql = "DELETE FROM usuario WHERE idUsuario = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setInt(1, idUsuario);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Tutorial con ID " + idUsuario + " eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró un tutorial con ID " + idUsuario + " para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al intentar borrar el tutorial con ID " + idUsuario + ": " + ex.getMessage());
        }
    }

     
     //metodo para cambiar de roll un usuario
public void cambiarRoll(int idUsuario, int idRoll) throws SQLException {
    String query = "UPDATE usuario SET idroll = ? WHERE idUsuario = ?";
    try (Connection connection = new Conexion().Conectar();
         PreparedStatement statement = connection.prepareStatement(query)) {
        // Establecer los parámetros en la consulta preparada
        statement.setInt(1, idRoll);
        statement.setInt(2, idUsuario);

        // Ejecutar la consulta
        int filasModificadas = statement.executeUpdate();
        if (filasModificadas != 1) {
            throw new SQLException("No se pudo modificar el registro con ID: " + idUsuario);
        }
    } catch (SQLException e) {
        // Manejar la excepción
        e.printStackTrace();
        throw e; // Relanzar la excepción para que sea manejada por quien llame al método
    }
}


    //metodo para verficar el usuario al momento de hacer login
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
        resultado[3 ] = resultSet.getString("idUsuario");
        
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
     
     
     //metodo para buscar el roll segun el idRoll
      public String buscarRoll(int idRoll) throws SQLException {
    String roll = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

  
    String sql = "SELECT Roll FROM Roles WHERE idroll = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
     
        statement.setInt(1, idRoll);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                
                roll = resultSet.getString("Roll");
            } else {
                
                System.out.println("No se encontró el roll con el ID proporcionado: " + idRoll);
            }
        }
    }

    return roll;
}
      //metodo para listar todos los usuarios
       public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt("idUsuario"));
                user.setNombre(resultSet.getString("Nombre"));
                user.setApellido(resultSet.getString("Apellido"));
                user.setCedula(resultSet.getString("Cedula"));
                user.setCorreo(resultSet.getString("Correo"));
                user.setContraseña(resultSet.getString("Contraseña"));
                user.setIdroll(resultSet.getInt("idroll"));
                usuarios.add(user);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar los usuarios: " + ex.getMessage());
    }
    return usuarios;
}
       
       
       //metodo para modificar usuario
   public void modificarUsuario(String nombre, String apellido, String cedula, String correo, String contraseña, int idUsuario) throws SQLException {
    String query = "UPDATE usuario SET Nombre = ?, Apellido = ?, Cedula = ?, Correo = ?, Contraseña = ? WHERE idUsuario = ?";
    
    try (Connection connection = new Conexion().Conectar();
         PreparedStatement statement = connection.prepareStatement(query)) {
        // Establecer los parámetros en la consulta preparada
        statement.setString(1, nombre);
        statement.setString(2, apellido);
        statement.setString(3, cedula);
        statement.setString(4, correo);
        statement.setString(5, contraseña);
        statement.setInt(6, idUsuario);

        // Ejecutar la consulta
        int filasModificadas = statement.executeUpdate();
        if (filasModificadas != 1) {
            throw new SQLException("No se pudo modificar el registro con ID: " + idUsuario);
        }
    } catch (SQLException e) {
        // Manejar la excepción
        e.printStackTrace();
        throw e; // Relanzar la excepción para que sea manejada por quien llame al método
    }
}
   
   
   //metodo para modificar solo una parte del usuario (usado para la parte del formumario donde no esta completo)
   public void modificarParteUsuario(String nombre, String cedula, String correo, int idUsuario) throws SQLException {
    String query = "UPDATE usuario SET Nombre = ?,  Cedula = ?, Correo = ? WHERE idUsuario = ?";
    
    try (Connection connection = new Conexion().Conectar();
         PreparedStatement statement = connection.prepareStatement(query)) {
        // Establecer los parámetros en la consulta preparada
        statement.setString(1, nombre);
        statement.setString(2, cedula);
        statement.setString(3, correo);
        statement.setInt(4, idUsuario);

        // Ejecutar la consulta
        int filasModificadas = statement.executeUpdate();
        if (filasModificadas != 1) {
            throw new SQLException("No se pudo modificar el registro con ID: " + idUsuario);
        }
    } catch (SQLException e) {
        // Manejar la excepción
        e.printStackTrace();
        throw e; // Relanzar la excepción para que sea manejada por quien llame al método
    }
}
   
   //metodo para obtener el objeto usuario con el idUsuario
       public Usuario obtenerUsuario(int idUsuario) {
              Usuario usuario = new Usuario();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
           
                    usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                    usuario.setNombre(resultSet.getString("Nombre"));
                    usuario.setApellido(resultSet.getString("Apellido"));
                    usuario.setCedula(resultSet.getString("Cedula"));
                    usuario.setCorreo(resultSet.getString("Correo"));
                    usuario.setContraseña(resultSet.getString("Contraseña"));
                    usuario.setIdroll(resultSet.getInt("idroll"));
               
                }
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar los registros del usuario " + idUsuario + ": " + ex.getMessage());
    }
    return usuario;
}
     
}


