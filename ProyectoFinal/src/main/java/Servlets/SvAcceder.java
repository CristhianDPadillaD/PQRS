    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
     */
    package Servlets;

    import com.mycompany.proyectofinal.Conexion;
    import com.mycompany.proyectofinal.GestorUsuario;
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
    @WebServlet(name = "SvAcceder", urlPatterns = {"/SvAcceder"})
    public class SvAcceder extends HttpServlet {

      GestorUsuario gest = new GestorUsuario();
      Conexion con = new Conexion();


        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        }


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String Correo = request.getParameter("correo");
             String Contrasenia = request.getParameter("contrasenia"); 
             
       try {
            String[] resultadoAutenticacion = gest.loginUsuario(Correo, Contrasenia);
            if (resultadoAutenticacion != null) {
                // Las credenciales son válidas
                String nombreUsuario = resultadoAutenticacion[0];
                String rol = resultadoAutenticacion[1];
                String cedula = resultadoAutenticacion[2];
                request.getSession().setAttribute("usuario", nombreUsuario);
                request.getSession().setAttribute("rol", rol);
                if (rol.equals("Superusuario")) {
                    // Si el usuario es un superusuario, redireccionar a la página de superusuario
                    response.sendRedirect("SuperUsuario.jsp");
                } else {
                    request.getSession().setAttribute("usuario", nombreUsuario);
                request.getSession().setAttribute("correo", Correo);
                
                    request.getSession().setAttribute("cedula", cedula);
                    // Si el usuario es un usuario regular, redireccionar a la página de usuario regular
                    response.sendRedirect("Formulario.jsp");
                }
            } else {
                // Las credenciales no son válidas, redireccionar a "index.jsp" con un parámetro de alerta
                response.sendRedirect("index.jsp?alert=error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SvAcceder.class.getName()).log(Level.SEVERE, null, ex);
        }
        }


        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

    }
