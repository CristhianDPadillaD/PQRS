<%-- 
    Document   : Formulario
    Created on : 1/05/2024, 8:48:09 p. m.
    Author     : ADMIN
--%>
<%@include file= "templates/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <% 
    // Obtener el nombre de usuario y el rol de la sesión
    String nombreUsuario = (String) session.getAttribute("usuario");
    String correo = (String) session.getAttribute("correo");
    String cedula = (String) session.getAttribute("cedula");
    %>
    
<!DOCTYPE html>
<html lang="en">
    <link rel="stylesheet" href="templates/Style2.css">
    <body id="page-top">

        <!-- Navigation-->
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
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Creative - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/" />
        <!-- Bootstrap Icons-->
        <link href="https://www.google.com/url?sa=i&url=https%3A%2F%2Fbookstore.cl%2Fblog%2Fpost%2Fcaracteristicas-principales-de-una-oficina-moderna-cual-te-hace-falta&psig=AOvVaw3NqiBEDtpGSHkKShteXkN9&ust=1714950963456000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPiUuNKP9YUDFQAAAAAdAAAAABAE" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/"css />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="templates/Style2.css" rel="stylesheet" />
    </head>
    
    <body id="page-top">

        <!-- Masthead-->
        
        <header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <h1 class="text-white font-weight-bold">Sistema de PQRS</h1>
                        <hr class="divider" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        
                        <p class="text-white-75 mb-5">Aquí puedes enviar tus Peticiones, Quejas, Reclamos y Sugerencias de forma rápida, obtener respuestas y soluciones eficientes, y ayudarnos a mejorar con tu feedback.</p>
                        <p class="text-white-75 mb-5">Tu opinión es importante. ¡Gracias por comunicarte con nosotros!</p>
                    </div>
                </div>
            </div>
        </header>

        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 col-xl-6 text-center">
                        <h2 class="mt-0">Realiza tu PQRS</h2>
                        <hr class="divider" />
                        <p class="text-muted mb-5">Enviar tus Peticiones, Quejas, Reclamos y Sugerencias de forma rápida.</p>
                        <p class="text-muted mb-5">Obtener respuestas y soluciones eficientes.</p>
                       
                    </div>
                </div>
                <div class="row gx-4 gx-lg-5 justify-content-center mb-5">
                    <div class="col-lg-6">
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- * * SB Forms Contact Form * *-->
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- This form is pre-integrated with SB Forms.-->
                        <!-- To make this form functional, sign up at-->
                        <!-- https://startbootstrap.com/solution/contact-forms-->
                        <!-- to get an API token!-->
                        <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- Name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="name" type="text" placeholder="Enter your name..." data-sb-validations="required" value=" <%= nombreUsuario%>" />
                                <label for="name">Nombre Completo</label>
                                <div class="invalid-feedback" data-sb-feedback="name:required">Complete este espacio.</div>
                            </div>
                            <div class="form-floating mb-3">
                                <select class="form-select" id="opcion" data-sb-validations="required">
                                    <option value="" hidden>Selecciona una opción</option>
                                    <option value="Pregunta">Pregunta</option>
                                    <option value="Queja">Queja</option>
                                    <option value="Reclamo">Reclamo</option>
                                      <option value="Sugerencias">Sugerencias</option>
                                   
                                </select>
                               
                                <div class="invalid-feedback" data-sb-feedback="opcion:required">Debes seleccionar una opción.</div>
                            </div>
                            <!-- Email address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" value="<%=correo%>" />
                                <label for="email">Correo Electronico</label>
                                <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                            </div>
                            <!-- Phone number input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="phone" type="tel" placeholder="(123) 456-7890" data-sb-validations="required"  value=" <%=cedula%>"/>
                                <label for="phone">Cedula</label>
                                <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                            </div>
                            <!-- Message input-->
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="message" type="text" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                <label for="message">Descripcion</label>
                                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                            </div>
                            <div>
                                <label for="formFileLg" class="form-label">Subir un archivo PDF</label>
                                <input class="form-control form-control-lg" id="formFileLg" type="file" accept=".pdf">
                            </div>
                            <br>
                           <div class="d-grid"> <form action="SvAgregarUsuario" method="Get">
                                    <input type ="submit" value =" Enviar">
                                    </form></div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="bg-light py-5">
            <div class="container px-4 px-lg-5"><div class="small text-center text-muted">Copyright &copy; 2023 - Company Name</div></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- SimpleLightbox plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
        
        <script>
            document.getElementById('contactForm').addEventListener('submit', function(event) {
    var message = document.getElementById('message').value;
    var fileInput = document.getElementById('formFileLg');

    // Verificar si al menos uno de los campos tiene valor
    if (!message && !fileInput.files.length) {
        alert('Debes proporcionar al menos la descripción o el archivo PDF.');
        event.preventDefault(); // Evitar el envío del formulario si no se proporciona ninguno
    }
});

        </script>
        
    </body>
    
    
</html>
