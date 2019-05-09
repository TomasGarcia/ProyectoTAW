<%-- 
    Document   : newpostgrupo
    Created on : 09-may-2019, 18:02:02
    Author     : Jose
--%>

<%@page import="Entities.Usuario"%>
<%@page import="Entities.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    Grupo grupo = (Grupo)request.getAttribute("grupo");
    if(grupo == null){
        grupo = (Grupo)session.getAttribute("grupo");
    }
    Usuario loggedUser = (Usuario) session.getAttribute("usuario");


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post en Grupo</title>
    </head>
    <body>
        <h1 class="display-4" align="center">Nueva Publicación</h1>
        <div class="mx-auto" style="width: 400px;">
            <form method="post" action="newpostgrupoServlet" name="newpostgrupoServlet" accept-charset="utf-8">
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
                    <input type="text" name="imagen">
                </div>
                
                <div class="mx-auto d-block">
                    <label>Adjuntar Video</label>
                    <input type="text" name="video">
                </div>
                
                              
                <div class="mx-auto d-block">
                    <label>Destinatario</label>
                    <select name="destinatario">
                        <option name="destinatario" value="1" >
                            Publico
                          
                        
                    </select>
                </div>
                
                 
                
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='paginagrupo.jsp'">Publicar</button>
                </form>
               <p>                 
                    <button onclick="goBack()">Volver</button>
                </p>

                    <script>
                    function goBack() {
                      window.history.back();
                    }
                    </script>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
