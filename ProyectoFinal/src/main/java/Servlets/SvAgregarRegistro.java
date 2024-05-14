/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.Conexion;
import com.mycompany.proyectofinal.GestorRegistros;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.ServletContext;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)  // 50MB

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
         ServletContext context = getServletContext();
    // Obtener parámetros del formulario HTML
    String descripcion = request.getParameter("descripcion");
     System.out.println(descripcion);
     int idOpcion = Integer.parseInt(request.getParameter("opciones"));

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
    GestorRegistros gestor = new GestorRegistros();
    
        
      Part filePart = request.getPart("pdf");
        String fileName = filePart.getSubmittedFileName();

        // Get the file upload directory
      String uploadDir = context.getRealPath("/pdf");
      //String pdfFilePath = uploadDir + File.separator + fileName;
      File uploadFolder = new File(uploadDir);
  if (!uploadFolder.exists()) {
    uploadFolder.mkdir();
  }
  File destFile = new File(uploadFolder, fileName);

  // Copy the uploaded file to the destination path
  try (InputStream input = filePart.getInputStream(); OutputStream output = new FileOutputStream(destFile)) {
    byte[] buffer = new byte[1024];
    int length;
    while ((length = input.read(buffer)) > 0) {
      output.write(buffer, 0, length);
    }
  }
    
       out.println(uploadDir);
         out.println(uploadFolder);
        
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
