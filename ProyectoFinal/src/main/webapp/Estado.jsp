<%-- 
    Document   : Estado
    Created on : 4/05/2024, 9:55:12 p. m.
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
                                 <button class="btn btn-primary btn-lg px-4 me-sm-3" data-bs-toggle="modal" data-bs-target="#exampleModal">Editar PQRS</button>
                                <a class="btn btn-outline-light btn-lg px-4" href="#gugugugug">Eliminar PQRS</a>
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
                        <tr>

                            <td>Mark@gmail.com</td>
                            <td>Pregunta</td>
                            <td>Sin revisar</td>
                            <td>holis</td>
                            <td>124332424</td>
                            <td>pdf</td>
                            <td> 

                                <a href="#" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#eliminarTareaModal" data-id="" <i class="fa-solid fa-trash"></i> Eliminar </a>
                                <a href="#" class="btn btn-primary" target="_blank"><i class="fa-solid fa-eye"></i> Editar</a>
                            </td>
                        </tr>

                    </tbody>
                </table>

                <script src="ruta/a/tu/jquery.min.js"></script>
                <script src="ruta/a/tu/bootstrap.bundle.min.js"></script>
                <script>
                // Script para activar el modal al hacer clic en el botón "Editar PQRS" sin jQuery
                document.addEventListener('DOMContentLoaded', function() {
                    var editarPQRSButton = document.querySelector('.btn-editar-pqrs');
                    editarPQRSButton.addEventListener('click', function() {
                        var modal = document.getElementById('exampleModal');
                        var modalInstance = new bootstrap.Modal(modal);
                        modalInstance.show();
                    });
                });
                </script>


            </html>
