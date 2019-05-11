<%-- 
    Document   : newjspgrupos
    Created on : 01-abr-2019, 9:43:26
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Nuevo Grupo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="display-4" align="center">Nuevo Grupo</h1>
        <div class="mx-auto" style="width: 400px;">
            <form method="post" action="newgrupoServlet" name="newgrupoServlet" accept-charset="utf-8">
                <div class="mx-auto d-block">
                    <label>Nombre del Grupo</label>
                    <input class="form-control" name="nombre">
                </div>    
                <div class="mx-auto d-block">
                    <label>Descripcion</label>
                    <textarea name="descripcion" rows="10" cols="50"></textarea>
                </div>  
                
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='muro.jsp'">Crear</button>
                
            </form>
            <p align ="center">                 
                    <%-- <button onclick="${pageContext.request.contextPath}/">Volver</button>--%>
                    <a class="...." href="${pageContext.request.contextPath}/indexServlet">VOLVER</a>
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
