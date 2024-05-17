/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.GestorRegistros;
import com.mycompany.proyectofinal.GestorUsuario;
import com.mycompany.proyectofinal.Registros;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvEditarRegistro", urlPatterns = {"/SvEditarRegistro"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class SvEditarRegistro extends HttpServlet {
    

    GestorRegistros gestor = new GestorRegistros();
    GestorUsuario usuariGestor = new GestorUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Obtener los detalles del tutorial según el identificador
        Registros reg = gestor.RegistrosUsuario(id);

        // Mover aquí la configuración del tipo de contenido y la codificación de caracteres
     String tutorialHtml = "<div class=\"form-floating mb-3\">\n"
        + "    <input class=\"form-control\" id=\"nombreEdit\" type=\"text\" placeholder=\"Enter your name...\" name=\"nombre\" required  value=\"" + reg.getnombreUsuario() + "\" />\n"
        + "    <label for=\"name\">Nombre Completo</label>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"name:required\">Complete este espacio.</div>\n"
        + "</div>\n"
        + "<input type =\"number\" hidden value=\"" + reg.getIdRegistro() + "\" name=\"identificador\" >\n"
        + "<input type =\"number\" hidden value=\"" + reg.getIdUsuario() + "\" name=\"identificadorUsuario\" >\n"
        + "<div class=\"form-floating mb-3\">\n"
        + "    <select class=\"form-select\" id=\"opcion\" name=\"opciones\" required>\n"
        + "        <option hidden disabled value=\"\">Selecciona una opción</option>\n"
        + "        <option value=\"1\"" + (reg.getIdOpcion() == 1 ? " selected" : "") + ">Pregunta</option>\n"
        + "        <option value=\"2\"" + (reg.getIdOpcion() == 2 ? " selected" : "") + ">Queja</option>\n"
        + "        <option value=\"3\"" + (reg.getIdOpcion() == 3 ? " selected" : "") + ">Reclamo</option>\n"
        + "        <option value=\"4\"" + (reg.getIdOpcion() == 4 ? " selected" : "") + ">Sugerencias</option>\n"
        + "    </select>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"opcion:required\">Debes seleccionar una opción.</div>\n"
        + "</div>\n"
        + "<div class=\"form-floating mb-3\">\n"
        + "    <input class=\"form-control\" id=\"email\" type=\"email\" placeholder=\"name@example.com\" name=\"correo\" required value=\"" + reg.getCorreoUsuario() + "\"/>\n"
        + "    <label for=\"email\">Correo Electronico</label>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"email:required\">An email is required.</div>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"email:email\">Email is not valid.</div>\n"
        + "</div>\n"
        + "<div class=\"form-floating mb-3\">\n"
        + "    <input class=\"form-control\" id=\"phone\" type=\"tel\" placeholder=\"(123) 456-7890\" name=\"cedula\" required value=\"" + reg.getCedula() + "\" />\n"
        + "    <label for=\"phone\">Cedula</label>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"phone:required\">A phone number is required.</div>\n"
        + "</div>\n"
        + "<div class=\"form-floating mb-3\">\n"
        + "    <textarea class=\"form-control\" id=\"descripcionEdit\" name=\"descripcion\" type=\"text\" placeholder=\"Enter your message here...\" style=\"height: 10rem\">" + reg.getDescripcion() + "</textarea>\n"
        + "    <label for=\"message\">Descripcion</label>\n"
        + "    <div class=\"invalid-feedback\" data-sb-feedback=\"message:required\">A message is required.</div>\n"
        + "</div>\n"
        + "<div>\n";

if (!reg.getPdf().isEmpty()) {
    tutorialHtml += "<label for=\"formFileLg\" class=\"form-label\">Archivo PDF Actual: </label>\n"
            + "<input hidden class=\"form-control form-control-lg\" id=\"formFileLg\" name=\"pdf\" type=\"text\" value=\"" + reg.getPdf() + "\" readonly>\n"
            + "<td><a href=\"pdf/" + reg.getPdf() + "\" target=\"_blank\">" + reg.getPdf() + "</a></td>\n";
} else {
    tutorialHtml += "<span>No hay archivo PDF adjunto</span>\n"
             + "<input hidden class=\"form-control form-control-lg\" id=\"formFileLg\" name=\"pdf\" type=\"text\" value=\"" + reg.getPdf() + "\" readonly>\n";
}

tutorialHtml += "</div>\n"
        + "<br>\n"
        + "<div>\n"
        + "    <label for=\"newFile\" class=\"form-label\">Seleccionar un nuevo archivo PDF:</label>\n"
        + "    <input class=\"form-control form-control-lg\" id=\"newFile\" name=\"NewPdf\" type=\"file\" accept=\".pdf\">\n"
        + "</div>\n"
        + "<br>\n";

        response.setContentType("text/html");

        response.getWriter().write(tutorialHtml);
        // Enviar la respuesta al cliente

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("identificador"));
            int idUser = Integer.parseInt(request.getParameter("identificadorUsuario"));
        int opciones = Integer.parseInt(request.getParameter("opciones"));
        String Descripcion = request.getParameter("descripcion");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String cedula = request.getParameter("cedula");
             Part filePart = request.getPart("NewPdf");
        String pdf = request.getParameter("pdf");
                 
                 
          if(filePart ==null && !pdf.isBlank()){
              
              try {
                  
                  gestor.modificarRegistro(Descripcion, pdf, opciones, id);
                  usuariGestor.modificarParteUsuario(nombre, cedula, correo, idUser);
                      
              } catch (SQLException ex) {
                  Logger.getLogger(SvEditarRegistro.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else {
             try {
                 
                 
                 
   
      String fileName = "";
      
      if(filePart != null && filePart.getSize() > 0){
          
      
        fileName = filePart.getSubmittedFileName();

        // Get the file upload directory
      String uploadDir = request.getServletContext().getRealPath("/pdf");
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
}
                 
                 
                 
                 
                 gestor.modificarRegistro(Descripcion, fileName, opciones, id);
                        usuariGestor.modificarParteUsuario(nombre, cedula, correo, idUser);
             } catch (SQLException ex) {
                 Logger.getLogger(SvEditarRegistro.class.getName()).log(Level.SEVERE, null, ex);
             }
              
          }
          response.sendRedirect("Estado.jsp");
            
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
