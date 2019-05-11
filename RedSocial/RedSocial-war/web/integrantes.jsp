<%-- 
    Document   : addparticipante
    Created on : 03-may-2019, 18:41:41
    Author     : Jose
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="Entities.Usuario"%>
<%@page import="Entities.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario loggedUser = (Usuario)session.getAttribute("usuario");
    Grupo grupo = (Grupo)request.getAttribute("grupo");
    if(grupo == null){
        grupo = (Grupo)session.getAttribute("grupo");
    }
    List<Usuario> usuarios=(List<Usuario>)request.getAttribute("Participantes");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Integrantes del grupo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="mx-auto" style="width: 400px;">
        <%
          if(loggedUser.getId() == grupo.getUsuarioId().getId()){
        %>
        <form action="addIntegrante">
            <p>Añadir Integrante <input name="user" placeholder="Introduce Username"><input type="submit" value="Enviar"></p>
        </form>
        <% } %>
        <table border ="1">
             <tr>
                 <th>
                     username
                 </th>
                 
                 <th>
                     email
                 </th>
             </tr>

             <% for(Usuario u: usuarios){ %>
         <tr>
             <td>
                 <%= u.getUsername() %>
             </td>
             
             <td>
                 <%= u.getEmail() %>
             </td>
        <%
          if(loggedUser.getId() == grupo.getUsuarioId().getId()){
        %>             
            <td>
                 <a href="EliminarIntegranteServlet?idUser=<%= u.getId() %>">Eliminar</a>
            </td>
        <% } %>
         </tr>
             <% } %>
             
        </table>
             
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
