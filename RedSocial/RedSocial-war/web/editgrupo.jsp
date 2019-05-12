<%-- 
    Document   : editgrupo
    Created on : 30-abr-2019, 17:53:05
    Author     : Hp
--%>

<%@page import="Entities.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Grupo grupo = (Grupo)request.getAttribute("grupo");
    if(grupo == null){
        grupo = (Grupo)session.getAttribute("grupo");
    }
%>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Editar grupo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
    </head>
    <body>
         <h1 class="display-4" align="center">Modifique los datos del grupo</h1>
        <div class="mx-auto" style="width: 400px;">
         <form method="get" action="saveGrupo" name="editar" accept-charset="utf-8">
                 <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre" value = "<%=grupo.getNombre()%>" >
                </div>   
                <div class="mx-auto d-block">
                    <label style="margin-top: 20px" >Descripcion</label>
                    <input class="form-control" name="descripcion" value = "<%=grupo.getDescripcion()%>">
                </div>
                <p align="center">
                    <input style="margin-top: 20px" class="btn btn-primary" type="submit" value="Editar" />
                </p>
         </form>
             <p  align ="center">                 
                    <%-- <button onclick="${pageContext.request.contextPath}/">Volver</button>--%>
                    <a class="...." href="${pageContext.request.contextPath}/indexServlet">VOLVER</a>
                </p>

                    <script>
                    function goBack() {
                      window.history.back();
                    }
                    </script>
    </body>
    </div>     
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</html>
