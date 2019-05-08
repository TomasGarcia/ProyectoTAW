<%-- 
    Document   : amigos
    Created on : 08-may-2019, 20:32:19
    Author     : Hp
--%>

<%@page import="Entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  List<Usuario> listaAmigos = (List)request.getAttribute("listaAmigos");
  
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Amigos</h1>
        
        <table border ="1">
            <tr>
                <th>
                   ID 
                </th>
                <th>
                    USERNAME
                </th>
                <th>
                    EMAIL
                </th> 
                <th>
                    NOMBRE
                </th> 
                <th>
                    APELLIDO
                </th> 
                <th>
                    FECHA DE NACIMIENTO
                </th> 
            </tr>
            <%
              for(Usuario u : listaAmigos){ 
            %>
            <tr>
                <td>
                  <%= u.getId()%>
                </td>
                <td>
                    <%= u.getUsername() %>
                </td>
                <td>
                    <%= u.getEmail()%>
                </td>
                <td>
                    <%= u.getNombre()%>
                </td>
                <td>
                    <%= u.getApellido()%>
                </td>  
                <td>
                    <%= u.getFechaNacimiento() %>
                </td>
            </tr>
            <%
              }  
            %>
        </table>
    </body>
</html>
