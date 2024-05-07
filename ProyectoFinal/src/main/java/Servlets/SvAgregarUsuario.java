/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.Conexion;
import com.mycompany.proyectofinal.GestorUsuario;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SvAgregarUsuario", urlPatterns = {"/SvAgregarUsuario"})
public class SvAgregarUsuario extends HttpServlet {

  GestorUsuario gest = new GestorUsuario();
  Conexion con = new Conexion();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cedula = request.getParameter("cedula");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contrasenia");
        int id = 1;
        Connection conectar = con.Conectar();
        
        gest.AgregarUsuario(nombre, apellido, cedula, correo, contraseña, id, conectar);
        
        response.sendRedirect("index.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
