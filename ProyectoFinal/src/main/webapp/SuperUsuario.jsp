<%-- 
    Document   : SuperUsuario
    Created on : 2/05/2024, 9:56:39 p. m.
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectofinal.Registros"%>
<%@page import="com.mycompany.proyectofinal.GestorRegistros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        GestorRegistros gestorRegistro = new GestorRegistros();
        List<Registros> registro = gestorRegistro.listarTodosRegistros();
        List<Registros> registroOrdenado = (List<Registros>) request.getAttribute("registros");
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
                            <h1 class="display-5 fw-bolder text-white mb-2">Registros de PQRS</h1>
                            <p class="lead text-white-50 mb-4">Registros de todas las PQRS Ingresadas </p>
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
                    <th scope="col"><a href="SvOrdenarTodos?columna=idUsuario&direccion=<%= (request.getParameter("direccion") != null && request.getParameter("direccion").equals("desc")) ? "asc" : "desc" %>">Usuario</a></th>
                    <th scope="col">Correo</th>
                                    <th scope="col">
                                
                            <form action="SvOrdenarTodos" method="GET" id="selectForm">
                                <select class="form-select" name="tipoPQRS" id="tipoPQRS" onchange="submitForm()"  >
                                        <option hidden disabled selected value="">Ordenar </option>
                                    <option value="1">Peticiones</option>
                                    <option value="2">Quejas</option>
                                    <option value="3">Reclamos</option>
                                    <option value="4">Sugerencias</option>
                                </select>
                                <input type="hidden" name="direccion" value="asc">
                                <input type="hidden" name="columna" value="idOpcion">
                            </form>
                        </th>
                         <th scope="col"><a href="SvOrdenarTodos?columna=FechaEnvio&direccion=<%= (request.getParameter("direccion") != null && request.getParameter("direccion").equals("desc")) ? "asc" : "desc" %>">Fecha envio</a></th>
                         <th scope="col"><a href="SvOrdenarTodos?columna=idEstado&direccion=<%= (request.getParameter("direccion") != null && request.getParameter("direccion").equals("desc")) ? "asc" : "desc" %>">Estado</a></th>
                     <th scope="col">Responder</th>
                    
                </tr>
            </thead>
            <tbody>
                  <% if (registro.isEmpty()) { %>
                        <tr>
                            <td colspan="7" class="text-center">No hay registros</td>
                        </tr>
                        <% } else { %>
                         <%if (registroOrdenado != null){%>            
                <tr>
                     <% // Iteramos sobre la lista de tutoriales y mostramos los detalles de cada tutorial en una tabla HTML
                                for (Registros regis : registroOrdenado) {
                            %> 
                        <tr>
                    <th><%=regis.getnombreUsuario()%></th>
                    <td><%=regis.getCorreoUsuario()%></td>
                    <td><%=regis.getNombreOpcion()%></td>
                    <td><%=regis.getFechaEnvio()%></td>
                    <td><%=regis.getEstado()%> </td>
                   
                    <td> <%if (regis.getIdEstado() == 1){%>
                        <a href="SvCambioEstado?id=<%=regis.getIdRegistro()%> "class="btn btn-primary" <i class="fa-solid fa-eye"></i> Responder</a>
                     <%}else{%>
                        <a href="#" type= "button" class="btn btn-secondary disabled" ><i class="fa-solid fa-eye"></i> Responder</a>
                    <%}%>
                    </td>
                    </tr>
                   
                    
                        <% }%>
                         
                         
                           <%}else{%>
                         
                <tr>
                     <% // Iteramos sobre la lista de tutoriales y mostramos los detalles de cada tutorial en una tabla HTML
                                for (Registros regis : registro) {
                            %> 
                        <tr>
                    <th><%=regis.getnombreUsuario()%></th>
                    <td><%=regis.getCorreoUsuario()%></td>
                    <td><%=regis.getNombreOpcion()%></td>
                    <td><%=regis.getFechaEnvio()%></td>
                    <td><%=regis.getEstado()%> </td>
                   
                    <td> <%if (regis.getIdEstado() == 1){%>
                        <a href="SvCambioEstado?id=<%=regis.getIdRegistro()%> "class="btn btn-primary" <i class="fa-solid fa-eye"></i> Responder</a>
                     <%}else{%>
                        <a href="#" type= "button" class="btn btn-secondary disabled" ><i class="fa-solid fa-eye"></i> Responder</a>
                    <%}%>
                    </td>
                    </tr>
                   
                    
                        <% }%>
                          <% }%>
                           <% }%>
                    
                </tr>

            </tbody>
        </table>
                           
<script>
        function submitForm() {
            document.getElementById("selectForm").submit();
        }
</script>
</html>
