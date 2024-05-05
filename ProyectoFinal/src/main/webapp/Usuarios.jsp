<%-- 
    Document   : Usuarios
    Created on : 4/05/2024, 10:57:45 p. m.
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                    <th>marcos</th>
                    <td>alonzo</td>
                    <td>Mark@gmail.com</td>
                    <td>usuario</td>
                    <td>124332424</td>
                    <td> 
                        
                        <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#eliminarTareaModal" data-id="" <i class="fa-solid fa-trash"></i> Cambiar roll </a>
                       
                    </td>
                </tr>

            </tbody>
        </table>
</html>
