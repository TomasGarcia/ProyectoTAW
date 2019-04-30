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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Grupo</title>
    </head>
    <body>
        <h1>Modifique los datos del grupo</h1>
        <h5>Esto solo será posible si es el creador del grupo,abstenerse de intentarlos, hackers, o sereis destruidos</h5>
        
         <form method="get" action="saveGrupo" name="editar" accept-charset="utf-8">
                 <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre" value = "<%=grupo.getNombre()%>" 
                </div>   
                <div class="mx-auto d-block">
                    <label>Nombre de Usuario</label>
                    <input class="form-control" name="descripcion" value = "<%=grupo.getDescripcion()%>">
                </div>
                 <input type="submit" value="Editar" />
         </form>
              <p align ="center">                 
                    <button onclick="goBack()">Volver</button>
                </p>

                    <script>
                    function goBack() {
                      window.history.back();
                    }
                    </script>
    </body>
</html>
