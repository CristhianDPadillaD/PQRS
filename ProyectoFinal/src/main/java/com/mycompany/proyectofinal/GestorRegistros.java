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
 * @author ADMIN
 */
public class GestorRegistros {
    
    
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
    public String buscarNombreOpcion(int idOpcion) throws SQLException {
    String nombreOpcion = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

    // Consulta SQL para obtener el nombre de la opción por su idOpcion
    String sql = "SELECT Opcion FROM PQRS WHERE idOpcion = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Establecer el idOpcion como parámetro de la consulta
        statement.setInt(1, idOpcion);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                nombreOpcion = resultSet.getString("Opcion");
            } else {
                System.out.println("No se encontró una opción con el ID proporcionado: " + idOpcion);
            }
        }
    }   

    return nombreOpcion;
}
    
       public String buscarCorreo(int idUsuario) throws SQLException {
    String correo = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

    // Consulta SQL para obtener el nombre de la opción por su idOpcion
    String sql = "SELECT Correo FROM usuario WHERE idUsuario = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Establecer el idOpcion como parámetro de la consulta
        statement.setInt(1, idUsuario);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                correo = resultSet.getString("Correo");
            } else {
                System.out.println("No se encontre el correocon el ID proporcionado: " + idUsuario);
            }
        }
    }   

    return correo;
}
         public String buscarEstado(int idEstado) throws SQLException {
    String estado = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

    // Consulta SQL para obtener el nombre de la opción por su idOpcion
    String sql = "SELECT Estado FROM Estados WHERE idEstado = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Establecer el idOpcion como parámetro de la consulta
        statement.setInt(1, idEstado);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                estado = resultSet.getString("Estado");
            } else {
                System.out.println("No se encontro el estado con el ID proporcionado: " + idEstado);
            }
        }
    }   

    return estado;
}
 public List<Registros> listarTodosRegistros() {
    List<Registros> registros = new ArrayList<>();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM Registros";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Registros registro = new Registros();
                registro.setDescripcion(resultSet.getString("Descripcion"));
                registro.setPdf(resultSet.getString("Pdf"));
                registro.setFechaEnvio(resultSet.getDate("FechaEnvio"));
                registro.setIdOpcion(resultSet.getInt("idOpcion"));
                registro.setIdUsuario(resultSet.getInt("idUsuario"));
                registro.setIdEstado(resultSet.getInt("idEstado"));
                registros.add(registro);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar los registros: " + ex.getMessage());
    }
    return registros;
}
 public List<Registros> listarRegistrosUsuario(int idUsuario) {
    List<Registros> registros = new ArrayList<>();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM Registros WHERE idUsuario = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Registros registro = new Registros();
                    registro.setDescripcion(resultSet.getString("Descripcion"));
                    registro.setPdf(resultSet.getString("Pdf"));
                    registro.setFechaEnvio(resultSet.getDate("FechaEnvio"));
                    registro.setIdOpcion(resultSet.getInt("idOpcion"));
                    registro.setIdUsuario(resultSet.getInt("idUsuario"));
                    registro.setIdEstado(resultSet.getInt("idEstado"));
                    registros.add(registro);
                }
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar los registros del usuario " + idUsuario + ": " + ex.getMessage());
    }
    return registros;
}



}
