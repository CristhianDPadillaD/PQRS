/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.net.Authenticator;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author ADMIN
 */
public class GestorRegistros {
    
    public void enviarCorreo(String destinatario, String cuerpo) {
    // Configurar las propiedades del servidor de correo
    String asunto = "Respuesta peticion";
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true");

    // Establecer las credenciales del remitente
    String correoRemitente = "enviarcorreos87@gmail.com";
    String contraseñaRemitente = "whnb kxni dgya rltn";     

    // Crear una sesión de correo
    Session session = Session.getInstance(props, new javax.mail.Authenticator() 
    {
    @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(correoRemitente, contraseñaRemitente);
        }
    });

    try {
        // Crear un mensaje de correo
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(correoRemitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject(asunto);
        message.setText(cuerpo);

        // Enviar el correo electrónico
        Transport.send(message);

        System.out.println("Correo electrónico enviado exitosamente a " + destinatario);
    } catch (MessagingException e) {
        throw new RuntimeException("Error al enviar el correo electrónico", e);
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

 public void borrarRegistro(int idRegistro) {
        try (Connection conexion = new Conexion().Conectar()) {
            String sql = "DELETE FROM Registros WHERE id_Registros = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setInt(1, idRegistro);
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Tutorial con ID " + idRegistro + " eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró un tutorial con ID " + idRegistro + " para eliminar.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al intentar borrar el tutorial con ID " + idRegistro + ": " + ex.getMessage());
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
public void modificarRegistro(String Descripcion, String pdf, int idOpcion, int idRegistro) throws SQLException {
    String query = "UPDATE Registros SET Descripcion = ?, Pdf = ?, idOpcion = ? WHERE id_Registros = ?";
    
    try (Connection connection = new Conexion().Conectar();
         PreparedStatement statement = connection.prepareStatement(query)) {
        // Establecer los parámetros en la consulta preparada
        statement.setString(1, Descripcion);
        statement.setString(2, pdf);
        statement.setInt(3, idOpcion);
        statement.setInt(4, idRegistro);

        // Ejecutar la consulta
        int filasModificadas = statement.executeUpdate();
        if (filasModificadas != 1) {
            throw new SQLException("No se pudo modificar el registro con ID: " + idRegistro);
        }
    } catch (SQLException e) {
        // Manejar la excepción
        e.printStackTrace();
        throw e; // Relanzar la excepción para que sea manejada por quien llame al método
    }
}

public void cambiarEstado(int idRegistro, int estado) throws SQLException {
    String query = "UPDATE Registros SET idEstado = ? WHERE id_Registros = ?";
    try (Connection connection = new Conexion().Conectar();
         PreparedStatement statement = connection.prepareStatement(query)) {
        // Establecer los parámetros en la consulta preparada
        statement.setInt(1, estado);
        statement.setInt(2, idRegistro);

        // Ejecutar la consulta
        int filasModificadas = statement.executeUpdate();
        if (filasModificadas != 1) {
            throw new SQLException("No se pudo modificar el registro con ID: " + idRegistro);
        }
    } catch (SQLException e) {
        // Manejar la excepción
        e.printStackTrace();
        throw e; // Relanzar la excepción para que sea manejada por quien llame al método
    }
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
    }      return estado;
         }
    
     public String buscarNombreUsuario (int idUsuario) throws SQLException {
    String nombre = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

    // Consulta SQL para obtener el nombre de la opción por su idOpcion
    String sql = "SELECT Nombre FROM usuario WHERE idUsuario = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Establecer el idOpcion como parámetro de la consulta
        statement.setInt(1, idUsuario);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                nombre = resultSet.getString("Nombre");
            } else {
                System.out.println("No se encontro el nombre con el ID proporcionado: " + idUsuario);
            }
        }
    }   
return nombre;
 
}
     
        public String buscarCedula (int idUsuario) throws SQLException {
    String Cedula = null;

    // Establecer la conexión a la base de datos
    Conexion conexion = new Conexion();
    Connection connection = conexion.Conectar();

    // Consulta SQL para obtener el nombre de la opción por su idOpcion
    String sql = "SELECT Cedula FROM usuario WHERE idUsuario = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Establecer el idOpcion como parámetro de la consulta
        statement.setInt(1, idUsuario);

        // Ejecutar la consulta
        try (ResultSet resultSet = statement.executeQuery()) {
            // Si se encuentra una fila, obtener el nombre de la opción
            if (resultSet.next()) {
                Cedula = resultSet.getString("Cedula");
            } else {
                System.out.println("No se encontro el nombre con el ID proporcionado: " + idUsuario);
            }
        }
    }   
return Cedula;
 
}
 public List<Registros> listarTodosRegistros() {
    List<Registros> registros = new ArrayList<>();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM Registros";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Registros registro = new Registros();
                  registro.setIdRegistro(resultSet.getInt("id_Registros"));
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
                    registro.setIdRegistro(resultSet.getInt("id_Registros"));
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
  

 public Registros RegistrosUsuario(int idRegistro) {
              Registros registro = new Registros();
    try (Connection conexion = new Conexion().Conectar()) {
        String sql = "SELECT * FROM Registros WHERE id_Registros = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idRegistro);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
           
                    registro.setIdRegistro(resultSet.getInt("id_Registros"));
                    registro.setDescripcion(resultSet.getString("Descripcion"));
                    registro.setPdf(resultSet.getString("Pdf"));
                    registro.setFechaEnvio(resultSet.getDate("FechaEnvio"));
                    registro.setIdOpcion(resultSet.getInt("idOpcion"));
                    registro.setIdUsuario(resultSet.getInt("idUsuario"));
                    registro.setIdEstado(resultSet.getInt("idEstado"));
               
                }
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al listar los registros del usuario " + idRegistro + ": " + ex.getMessage());
    }
    return registro ;
}



}
