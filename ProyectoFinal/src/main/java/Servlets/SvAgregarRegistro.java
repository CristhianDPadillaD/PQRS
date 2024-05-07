/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.Conexion;
import com.mycompany.proyectofinal.GestorUsuario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SvAgregarRegistro", urlPatterns = {"/SvAgregarRegistro"})
@MultipartConfig
public class SvAgregarRegistro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            
    // Obtener parámetros del formulario HTML
    String descripcion = request.getParameter("descripcion");
     System.out.println(descripcion);
     int idOpcion = Integer.parseInt(request.getParameter("opciones"));
     
    Part filePart = request.getPart("pdf");
    String fileName = "";
    if (filePart != null) {
        fileName = filePart.getSubmittedFileName();
    }

    int idUsuario = Integer.parseInt(request.getParameter("id"));
    int idEstado = 1;
    
    // Obtener la fecha actual
     Date fechaEnvio = new Date(System.currentTimeMillis());
    
    // Convertir la fecha a formato SQL date
    java.sql.Date sqlDate = new java.sql.Date(fechaEnvio.getTime());
    
    // Conectar a la base de datos
    Conexion con = new Conexion();
    Connection conexion = con.Conectar();
    
    // Instanciar el gestor de PQRS
    GestorUsuario gestor = new GestorUsuario();
    
       out.println(fileName);
         out.println(idOpcion);
        
    // Agregar el PQRS a la base de datos
    gestor.AgregarPQRS(descripcion, fileName, sqlDate, idOpcion, idUsuario, idEstado, conexion);
    // Redirigir a una página de confirmación o mostrar un mensaje de éxito
    response.sendRedirect("Formulario.jsp");

}   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
