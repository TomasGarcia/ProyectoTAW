<%-- 
    Document   : newpost
    Created on : 01-abr-2019, 9:42:31
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Nuevo Post</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="display-4" align="center">Nueva Publicación</h1>
        <div class="mx-auto" style="width: 400px;">
            <form method="post" action="newpostServlet" name="newpostServlet" accept-charset="utf-8">
                <div class="mx-auto d-block">
                    <label>Título</label>
                    <input class="form-control" name="titulo">
                </div>
                <div class="mx-auto d-block">
                    <label>Contenido</label>
                    <textarea name="texto" rows="10" cols="50">Escribe aquí </textarea>
                </div> 
                <div class="mx-auto d-block">
                    <label>Adjuntar Imagen</label>
                    <input type="url" name="imagen">
                </div>
                
                <div class="mx-auto d-block">
                    <label>Adjuntar Video</label>
                    <input type="url" name="video">
                </div>
                
                <%--
                A ver si aclaramos que coño va a destinario y como lo vamos a poner
                --%>              
                <div class="mx-auto d-block">
                    <label>Elegir Destinatario</label>
                    <input name="destinatario">
                </div>
                
                 
                
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='muro.jsp'">Publicar</button>
                
            </form>
            <div>
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='muro.jsp'">Volver</button>
            </div
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
