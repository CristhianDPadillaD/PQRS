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
@WebServlet(name = "SvOrdenar", urlPatterns = {"/SvOrdenar"})
public class SvOrdenar extends HttpServlet {

    GestorRegistros gestor = new GestorRegistros();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     processRequest(request, response);
 
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("id"));
// Obtén el ID del usuario de alguna manera
  
    // Establecer valores predeterminados para la columna y la dirección de ordenamiento
    String columnaOrdenamiento = request.getParameter("columna");
    
      String pqrs = request.getParameter("tipoPQRS");

    String direccionOrdenamiento = request.getParameter("direccion");
 
    if (pqrs!= null){
        System.out.println(columnaOrdenamiento);
        System.out.println(pqrs);
        System.out.println(direccionOrdenamiento);
        List<Registros>registro = gestor.listarRegistrosUsuarioOrdenadosPorTipo(idUsuario, columnaOrdenamiento, direccionOrdenamiento, pqrs);
        
            request.setAttribute("registros", registro);

    // Redirigir a la página JSP
request.getRequestDispatcher("Estado.jsp").forward(request, response);
    }else{
    // Obtener registros del usuario ordenados según los parámetros
       List<Registros> registros = gestor.listarRegistrosUsuarioOrdenados(idUsuario, columnaOrdenamiento, direccionOrdenamiento);

       
        System.out.println(registros);
    // Guardar los registros en el alcance de la solicitud
    request.setAttribute("registros", registros);

    // Redirigir a la página JSP
request.getRequestDispatcher("Estado.jsp").forward(request, response);
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
