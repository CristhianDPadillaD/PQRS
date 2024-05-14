/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.GestorRegistros;
import com.mycompany.proyectofinal.Registros;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SvEditarRegistro", urlPatterns = {"/SvEditarRegistro"})
public class SvEditarRegistro extends HttpServlet {

    GestorRegistros gestor = new GestorRegistros();

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
                + "    <input class=\"form-control\" id=\"nombreEdit\" type=\"text\" placeholder=\"Enter your name...\" required value=\"" + reg.getnombreUsuario() + "\" />\n"
                + "    <label for=\"name\">Nombre Completo</label>\n"
                + "    <div class=\"invalid-feedback\" data-sb-feedback=\"name:required\">Complete este espacio.</div>\n"
                + "</div>\n"
                 +"  <input type =\" numb\" hidden value=\""+reg.getIdRegistro()+"\" name=\"identificador\" >\n"
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
                + "    <input class=\"form-control\" id=\"email\" type=\"email\" placeholder=\"name@example.com\" required value=\"" + reg.getCorreoUsuario() + "\"/>\n"
                + "    <label for=\"email\">Correo Electronico</label>\n"
                + "    <div class=\"invalid-feedback\" data-sb-feedback=\"email:required\">An email is required.</div>\n"
                + "    <div class=\"invalid-feedback\" data-sb-feedback=\"email:email\">Email is not valid.</div>\n"
                + "</div>\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "    <input class=\"form-control\" id=\"phone\" type=\"tel\" placeholder=\"(123) 456-7890\" required value=\"" + reg.getCedula() + "\" />\n"
                + "    <label for=\"phone\">Cedula</label>\n"
                + "    <div class=\"invalid-feedback\" data-sb-feedback=\"phone:required\">A phone number is required.</div>\n"
                + "</div>\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "    <textarea class=\"form-control\" id=\"descripcionEdit\" name=\"descripcion\" type=\"text\" placeholder=\"Enter your message here...\" style=\"height: 10rem\">" + reg.getDescripcion() + "</textarea>\n"
                + "    <label for=\"message\">Descripcion</label>\n"
                + "    <div class=\"invalid-feedback\" data-sb-feedback=\"message:required\">A message is required.</div>\n"
                + "</div>\n"
                + "<div>\n"
                + "    <label for=\"formFileLg\" class=\"form-label\">Archivo PDF Actual: </label>\n"
                + "    <input class=\"form-control form-control-lg\" id=\"formFileLg\" name=\"pdf\" type=\"text\" value=\"" + reg.getPdf() + "\" readonly>\n"
                + "</div>\n"
                + "<br>\n"
                + "<div>\n"
                + "    <label for=\"newFile\" class=\"form-label\">Seleccionar un nuevo archivo PDF:</label>\n"
                + "    <input class=\"form-control form-control-lg\" id=\"newFile\" name=\"NewPdf\" type=\"file\" accept=\".pdf\">\n"
                + "</div>\n"
                + "<br>\n"
                ;

        response.setContentType("text/html");

        response.getWriter().write(tutorialHtml);
        // Enviar la respuesta al cliente

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int id = Integer.parseInt(request.getParameter("identificador"));
          int opciones= Integer.parseInt(request.getParameter("opciones"));
          String Descripcion = request.getParameter("descripcion");
               String nuevoPdf = request.getParameter("NewPdf");
                 String pdf = request.getParameter("pdf");
          if(nuevoPdf.isBlank() && !pdf.isBlank()){
              
              try {
                  gestor.modificarRegistro(Descripcion, pdf, opciones, id);
                      
              } catch (SQLException ex) {
                  Logger.getLogger(SvEditarRegistro.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else {
             try {
                 gestor.modificarRegistro(Descripcion, nuevoPdf, opciones, id);
                      
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
