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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Participantes</title>
    </head>
    <body>
        <%
          if(loggedUser.getId() == grupo.getUsuarioId().getId()){
        %>
        <form action="addIntegrante">
            <p>Add Integrante <input name="user" placeholder="Introduce Username"><input type="submit" value="Enviar"></p>
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
                    <button onclick="goBack()">Volver</button>
                </p>

                    <script>
                    function goBack() {
                      window.history.back();
                    }
                    </script>
    </body>
    
</html>
