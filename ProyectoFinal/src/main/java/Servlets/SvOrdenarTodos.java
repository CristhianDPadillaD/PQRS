/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.mycompany.proyectofinal.GestorRegistros;
import com.mycompany.proyectofinal.Registros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SvOrdenarTodos", urlPatterns = {"/SvOrdenarTodos"})
public class SvOrdenarTodos extends HttpServlet {
  GestorRegistros gestor = new GestorRegistros();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String columnaOrdenamiento = request.getParameter("columna");
    
      String pqrs = request.getParameter("tipoPQRS");

    String direccionOrdenamiento = request.getParameter("direccion");
        if (pqrs!= null){
    
        List<Registros>registro = gestor.listarRegistrosOrdenadosPorTipo( columnaOrdenamiento, direccionOrdenamiento, pqrs);
        
            request.setAttribute("registros", registro);

    // Redirigir a la página JSP
       request.getRequestDispatcher("SuperUsuario.jsp").forward(request, response);
    }else{
    // Obtener registros del usuario ordenados según los parámetros
       List<Registros> registros = gestor.listarRegistrosOrdenados(columnaOrdenamiento, direccionOrdenamiento);

       
       
    // Guardar los registros en el alcance de la solicitud
    request.setAttribute("registros", registros);

    // Redirigir a la página JSP
request.getRequestDispatcher("SuperUsuario.jsp").forward(request, response);
    }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
