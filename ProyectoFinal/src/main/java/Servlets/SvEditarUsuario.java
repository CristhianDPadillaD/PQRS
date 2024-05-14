/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.GestorUsuario;
import com.mycompany.proyectofinal.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {
    GestorUsuario gestor = new GestorUsuario();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               int id = Integer.parseInt(request.getParameter("id"));
               System.out.println(id);
               Usuario user = gestor.obtenerUsuario(id);
               
               String tutorialHtml = "<div class=\"form-floating mb-3\">\n"
                + "    <input class=\"form-control\" id=\"nombreEdit\" type=\"text\" placeholder=\"Enter your name...\" name=\"nombre\" required value=\"" + user.getNombre() + "\" />\n"
                + "    <label for=\"name\">Nombre </label>\n"
                + "</div>\n"
                + "  <input type =\" numb\" hidden value=\"" + user.getIdUsuario() + "\" name=\"identificador\" >\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "    <input class=\"form-control\" id=\"email\" type=\"text\" placeholder=\"name@example.com\" name=\"apellido\"required value=\"" + user.getApellido() + "\"/>\n"
                + "    <label for=\"email\">Apellido</label>\n"
                + "</div>\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "    <input class=\"form-control\" id=\"phone\" type=\"text\" placeholder=\"(123) 456-7890\" name=\"cedula\" required value=\"" + user.getCedula() + "\" />\n"
                + "    <label for=\"phone\">Cedula</label>\n"
                + "</div>\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "    <input class=\"form-control\" id=\"correo\" type=\"email\" placeholder=\"Enter your name...\" name=\"correo\" required value=\"" + user.getCorreo() + "\" />\n"
                + "<label for=\"correo\">Correo</label>\n"
                + "</div>\n"
                + "<div class=\"form-floating mb-3\">\n"
                + "   <input class=\"form-control\" id=\"password\" type=\"text\" placeholder=\"Enter your name...\"  name=\"contrasenia\" required value=\"" + user.getContraseña() + "\" />\n"
                + "<label for=\"password\">Contraseña</label>\n"
                + "</div>\n";

                    response.setContentType("text/html");

        response.getWriter().write(tutorialHtml);
        // Enviar la respuesta al cliente

        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("identificador"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cedula = request.getParameter("cedula");
        String correo = request.getParameter("correo");
        String password = request.getParameter("contrasenia");
        
        try {
            gestor.modificarUsuario(nombre, apellido, cedula, correo, password, id    );
            response.sendRedirect("Formulario.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(SvEditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
                                          
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
