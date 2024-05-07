<%-- 
    Document   : prueba
    Created on : 6/05/2024, 10:49:01 p. m.
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <form action="SvAgregarRegistro" method="POST"  enctype="multipart/form-data">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none;" id="errorAlert">
                                Debes proporcionar al menos la descripción o el archivo PDF.
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                            <!-- Name input-->
                           
                            <div class="form-floating mb-3">
                                <select class="form-select" id="opcion" name="opciones" required>
                                    <option hidden>Selecciona una opción</option>
                                    <option value="1">Pregunta</option>
                                    <option value="2">Queja</option>
                                    <option value="3">Reclamo</option>
                                    <option value="4">Sugerencias</option>
                                </select>
                                <div class="invalid-feedback" data-sb-feedback="opcion:required">Debes seleccionar una opción.</div>
                            </div>
                
                      
                       
                            <!-- Message input-->
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="message" name ="descripcion" type="text" placeholder="Enter your message here..." style="height: 10rem"></textarea>
                                <label for="message">Descripcion</label>
                                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                            </div>

                        
                            <div class="d-grid">
                                 <input type ="submit" value =" Enviar">
                               </form>  
                            </div>
    </body>
</html>
