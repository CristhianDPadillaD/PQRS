<%-- 
    Document   : Estado
    Created on : 4/05/2024, 9:55:12 p. m.
    Author     : Lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectofinal.Registros"%>
<%@page import="com.mycompany.proyectofinal.Registros"%>
<%@page import="com.mycompany.proyectofinal.GestorRegistros"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <%
        GestorRegistros gestor = new GestorRegistros();
        HttpSession se = request.getSession();
        int idUsuario = (int) se.getAttribute("userId");
        List<Registros> registro = gestor.listarRegistrosUsuario(idUsuario);
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




        <script>
            // Evento para cargar los detalles del tutorial seleccionado al abrir la modal de edición
            $('#editarModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); // Botón que desencadenó el evento
                var idTutorial = button.data('nombre'); // Obtener el ID del tutorial

                $('#SvEditarTutorial').val(idTutorial);
            });

        </script>
        <script>
            function editarContacto() {
                var nombreEdit = $('#nombreEdit').val().trim();
                if (nombreEdit === "") {
                    alert("Por favor, ingrese un nombre para el tutorial.");
                    return false; // Evitar que se envíe el formulario si el nombre está vacío
                }
                // Si el nombre no está vacío, enviar el formulario al servlet
                $('#editarForm').submit();
            }

        </script>
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#page-top">PQRS</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="Formulario.jsp">Enviar PQRS</a></li>
                        <li class="nav-item"><a class="nav-link" href="Estado.jsp">Estado PQRS</a></li>
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
                            <h1 class="display-5 fw-bolder text-white mb-2">Estado de tu PQRS</h1>
                            <p class="lead text-white-50 mb-4">Mira el estado en el que se encuentra tu PQRS</p>
                            <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <br>
        <section class="page-section" id="contact">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 col-xl-6 text-center">
                        <h2 class="mt-0">Mira el estado de tu PQRS</h2>
                        <hr class="divider" />
                        <p class="text-muted mb-5">Enviar tus Peticiones, Quejas, Reclamos y Sugerencias de forma rápida.</p>
                        <p class="text-muted mb-5">Obtener respuestas y soluciones eficientes.</p>

                    </div>
                </div>

                <div class="row gx-4 gx-lg-5 justify-content-center mb-5">
                    <div class="col-lg-6">
                    </div>
                </div>
                <br>
                <center> <h1>Registros de PQRS</h1></center>
                <br>
                <table class="table table-dark table-borderless">
                    <thead>
                        <tr>
                            <th scope="col">Correo</th>
                            <th scope="col">Peticion</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Archivo</th>
                            <th scope="col">Opcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (registro.isEmpty()) { %>
                        <tr>
                            <td colspan="7" class="text-center">No se ha realizado registros</td>
                        </tr>
                        <% } else { %>
                        <% for (Registros regis : registro) {%>
                        <tr>
                            <td><%=regis.getCorreoUsuario()%></td>
                            <td><%=regis.getNombreOpcion()%></td>
                            <td><%=regis.getEstado()%></td>
                            <td><%=regis.getFechaEnvio()%></td>
                            <% if (regis.getDescripcion().isBlank()) { %>
                            <td>Sin descripción</td>
                            <% } else {%>
                            <td><%=regis.getDescripcion()%></td>    
                            <% } %>
                            <% if (regis.getPdf().isBlank()) { %>
                            <td>Sin documento</td>
                            <% } else {%>
                            <td><a href="<%=regis.getPdf()%>" target="_blank"><%=regis.getPdf()%> </a></td>
                            
                            <% }%>
                            <td style="white-space: nowrap;"> 
                                <%if (regis.getIdEstado() == 1){%>
                                <a href="#" type= "button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="<%=regis.getIdRegistro()%>"><i class="fa-solid fa-eye"></i> Editar</a>
                                <a href="#" type= "button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#eliminarTareaModal" data-id="<%=regis.getIdRegistro()%>"><i class="fa-solid fa-trash"></i> Eliminar</a>
                                   <%}else {%>
                                   
                                   <a href="#" type= "button" class="btn btn-secondary disabled" ><i class="fa-solid fa-eye"></i> Editar</a>
                                <a href="#" type= "button" class="btn btn-outline disabled" ><i class="fa-solid fa-trash"></i> Eliminar</a>
                                   
                                   <%}%>
                            </td>
                        </tr>
                        <% } %>
                        <% }%>
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
                                <form id="eliminarForm" action="SvEliminarRegistro" method="POST">
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



                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
                    <div class="modal-dialog"> 
                        <div class="modal-content"> 
                            <div class="modal-header"> 
                                <h5 class="modal-title" id="exampleModalLabel"style="color: #000;">Detalles del tutorial</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> 
                            </div>
                            <div class="modal-body"> 
                                <form action="SvEditarRegistro" method="Post">
                                    <div id="libro-details"> 
                                        <!-- AquÃ­ se aÃ±ade los detalles del Tutorial-->
                                    </div>
                            </div> 
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button> 
                                <input type = "Submit" value = "Actualizar">
                                </form>
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

                <script>
                    // funcion para mostrar los datos en la ventana modal
                    $('#exampleModal').on('show.bs.modal', function (event) {
                        var button = $(event.relatedTarget); // BotÃ³n que desencadenÃ³ el evento
                        var id = button.data('id'); // ObtÃ©n el nombre del perro

                        // Realiza una solicitud AJAX al servlet para obtener los detalles del perro por su nombre
                        $.ajax({
                            url: 'SvEditarRegistro?id=' + id, // Cambia 'id' por el nombre del parÃ¡metro que esperas en tu servlet
                            method: 'GET',
                            success: function (data) {
                                // Actualiza el contenido del modal con los detalles del perro
                                $('#libro-details').html(data);
                            },
                            error: function () {
                                // Maneja errores aquÃ­ si es necesario y se imprime en consola
                                console.log('Error al cargar los detalles del registro.');
                            }
                        });
                    });

                </script>


                </html>
