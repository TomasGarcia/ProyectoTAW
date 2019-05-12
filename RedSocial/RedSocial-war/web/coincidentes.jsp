<%-- 
    Document   : coincidentes
    Created on : 12-may-2019, 18:35:34
    Author     : tmgrm
--%>

<%@page import="Entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Usuario> amigos = (List) session.getAttribute("amigos");
    Usuario loggedUser = (Usuario) session.getAttribute("usuario");
    List<Usuario> coincidentes = (List) session.getAttribute("coincidentes");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coincidentes</title>
          <style type="text/css">
  body {
      padding-left: 11em;
    font-family: Georgia, "Times New Roman",
          Times, serif;
    font-weight: bold;
    color: black;
    background-color: white }
  h1 {
    font-family: Helvetica, Geneva, Arial,
          SunSans-Regular, sans-serif }
  
  th, td {
  padding: 15px;
  text-align: left;
  vertical-align: bottom;
   
}

a:link, a:visited {
  background-color: darkcyan;
  color: whitesmoke;
  padding: 15px 25px;
  text-align: center;
  text-decoration: blink;
  display: inline-block;
}


  
  </style>

    </head>
    <body>
        <h4>COINCIDENTES</h4>
        <table border="1">
            <tr>
                <th>
                    Usuario
                </th>
            </tr>
            <%
                for(Usuario u : coincidentes){
                    if(!amigos.contains(u) && loggedUser.getId() != u.getId() && u.getId() != 1){
             %>
             <tr>
                 <td>
                     <%= u.getUsername() %>
                 </td>
                 <td>
                     <a href="enviarPeticionServlet?nuevoamigo=<%= u.getId() %>">Agregar</a>
                 </td>
             </tr>
                 
             <%
                 }}
             %>
        </table>
    </body>
</html>
