<%-- 
    Document   : Usuarios
    Created on : 4/05/2024, 10:57:45 p. m.
    Author     : Lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectofinal.Usuario"%>
<%@page import="com.mycompany.proyectofinal.Usuario"%>
<%@page import="com.mycompany.proyectofinal.GestorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <% 
    GestorUsuario gestoUsuario = new GestorUsuario();
    List<Usuario> user = gestoUsuario.listarUsuarios();
    
    %>
    <head>
        <link rel="stylesheet" href="templates/Style2.css">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Business Frontpage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
               <script src="script/script.js" type="text/javascript"></script>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="SuperUsuario.jsp">PQRS</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="SuperUsuario.jsp">Opciones PQRS</a></li>
                        <li class="nav-item"><a class="nav-link" href="Usuarios.jsp">Usuarios Registrados</a></li>
                        <li class="nav-item"><a class="nav-link" href="index.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav> 
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-5">
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-6">
                        <div class="text-center my-5">
                            <h1 class="display-5 fw-bolder text-white mb-2">Usuarios Registrados</h1>
                            <p class="lead text-white-50 mb-4">Usuarios activos presentes </p>
                            <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <br>
    <center> <h1>Registros de PQRS</h1></center>
        <br>
        <table class="table table-dark table-borderless">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Roll</th>
                    <th scope="col">Cedula</th>
                    <th scope="col">Opcion</th>
                </tr>
            </thead>
            <tbody>
                
                <tr>
                        <% // Iteramos sobre la lista de tutoriales y mostramos los detalles de cada tutorial en una tabla HTML
                                for (Usuario usuario :user) {
                            %> 
                <tr>
                    <th><%=usuario.getNombre()%></th>
                    <th><%=usuario.getApellido()%></th>
                    <td><%=usuario.getCorreo()%></td>
                    <td><%=usuario.getRoll()%></td>
                    <td><%=usuario.getCedula()%></td>
                    <td> 
                        <a href="SvCambiarRoll?id=<%= usuario.getIdUsuario()%>" class="btn btn-outline-primary" data-bs-toggle="modal"  data-id="" <i class="fa-solid fa-trash"></i> Cambiar roll </a>
                       <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#eliminarTareaModal" data-id="<%= usuario.getIdUsuario()%>" <i class="fa-solid fa-trash"></i> Eliminar usuario </a>
                    </td>
                    </tr>
                                          <% } %>
                </tr>

            </tbody>
        </table>
                
                
                <div class="modal fade" id="eliminarTareaModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="eliminarLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2 class="modal-title" id="eliminarLabel"style="color: #000;">Eliminar Registro</h2>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>¿Estás seguro de que deseas eliminar este registro?</h4>
                                <p id="contactoNombre"></p>
                                <form id="eliminarForm" action="SvEliminarUsuario" method="POST">
                                    <input type="hidden" id="Identificador" name="inputEliminar">
                                </form>
                            </div>
                            <div class="modal-footer justify-content-center">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-danger" onclick="eliminarContacto()">Eliminar</button>

                            </div>
                        </div>
                    </div>
                </div>
                
                  <script>
                    $('#eliminarTareaModal').on('show.bs.modal', function (event) {
                        var button = $(event.relatedTarget); // Botón que desencadenó el evento
                        var id = button.data('id'); // Obtén el nombre del contacto desde data-nombre

                        // Establecer el valor del campo oculto con el nombre del contacto
                        $('#Identificador').val(id);
                    });
                </script>   

                <script>
                    function eliminarContacto() {
                        $('#eliminarForm').submit(); // Enviar el formulario al servlet
                    }
                </script>

</html>
