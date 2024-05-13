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
@WebServlet(name = "SvCambioEstado", urlPatterns = {"/SvCambioEstado"})
public class SvCambioEstado extends HttpServlet {
    GestorRegistros x = new GestorRegistros();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int id= Integer.parseInt(request.getParameter("id"));
        Registros regis = x.RegistrosUsuario(id);
        int estado = 2; 
        String cuerpo = "Hola " +regis.getnombreUsuario()+",\n\nSe ha revisado tu solicitud por lo tanto se tendrá en cuenta en nuestro servicios.\n\nGracias por darnos su opinion, \n Sistema PQRS";
        
        try {
            x.cambiarEstado(id, estado);
            String destinatario = regis.getCorreoUsuario();
            x.enviarCorreo(destinatario, cuerpo);
            response.sendRedirect("SuperUsuario.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(SvCambioEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
