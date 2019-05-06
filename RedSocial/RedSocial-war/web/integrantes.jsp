<%-- 
    Document   : addparticipante
    Created on : 03-may-2019, 18:41:41
    Author     : Jose
--%>

<%@page import="java.util.Collection"%>
<%@page import="Entities.Usuario"%>
<%@page import="Entities.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Grupo grupo = (Grupo)request.getAttribute("grupo");
    if(grupo == null){
        grupo = (Grupo)session.getAttribute("grupo");
    }
    Collection<Usuario> usuarios=(Collection<Usuario>)request.getAttribute("Participantes");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Participantes</title>
    </head>
    <body>
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
         </tr>
             <% } %>
             
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
