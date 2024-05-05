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
                        <li class="nav-item"><a class="nav-link" href="Login.jsp">Enviar PQRS</a></li>
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

                        <!-- to get an API token!-->
                        <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- Name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="name" type="text" placeholder="Enter your name..." data-sb-validations="required" />
                                <label for="name">Nombre Completo</label>
                                <div class="invalid-feedback" data-sb-feedback="name:required">Complete este espacio.</div>
                            </div>
                            <div class="form-floating mb-3">
                                <select class="form-select" id="opcion" data-sb-validations="required">
                                    <option value="">Selecciona una opción</option>
                                    <option value="opcion1">Opción 1</option>
                                    <option value="opcion2">Opción 2</option>
                                    <option value="opcion3">Opción 3</option>

                                </select>

                                <div class="invalid-feedback" data-sb-feedback="opcion:required">Debes seleccionar una opción.</div>
                            </div>
                            <!-- Email address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                <label for="email">Correo Electronico</label>
                                <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                            </div>
                            <!-- Phone number input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="phone" type="tel" placeholder="(123) 456-7890" data-sb-validations="required" />
                                <label for="phone">Estado</label>
                                <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                            </div>
                            <!-- Message input-->
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="message" type="text" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                <label for="message">Descripcion</label>
                                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                            </div>
                    </div>
                </div>
            </div>
            
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Realiza tu PQRS</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <!-- Aquí va tu tabla -->
                            <table class="table">
                                <!-- Contenido de tu tabla aquí -->
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            <!-- Agrega aquí tu botón de envío de formulario dentro del modal si es necesario -->
                        </div>
                    </div>
                </div>
            </div>

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
