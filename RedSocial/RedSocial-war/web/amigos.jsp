<%-- 
    Document   : amigos
    Created on : 08-may-2019, 20:32:19
    Author     : Hp
--%>

<%@page import="Entities.Peticion"%>
<%@page import="Entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  List<Usuario> listaAmigos = (List)session.getAttribute("listaAmigos");
  List<Usuario> listaUsuarios = (List)request.getAttribute("listaUsuarios");
  List<Peticion> listaPeticiones = (List)request.getAttribute("listaPeticiones");
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Amigos</h1>
   
        <form action="enviarPeticionServlet">
    <div class="mx-auto d-block">
            <label>Usuarios</label>
            <select name="nuevoamigo">
                <option name="nuevoamigo">
                    Todos
                </option>  

                <% 
                    for(Usuario us : listaUsuarios){
                %>
                <option name="nuevoamigo" value="<%= us.getId() %>"> <%= us.getUsername()%> </option>
                <%     
                    }
                %>

            </select> 
        </div>
                <button type="submit">Enviar Peticion</button>
        </form>
                
        <h3>Mis Amigos</h3>
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
        
        <h3>Solicitudes de amistad </h3>
        <table>
            <tr>
                <th>
                    USUARIO
                </th>
                <th>
                    FECHA
                </th>
                <th>
                    
                </th>
            </tr>
            <%
                for(Peticion p : listaPeticiones){
                %>
            <tr>
                <td>
                    <%= p.getUsuario()%>
                </td>
                <td>
                    <%= p.getFecha()%>
                </td>
                <td>
                    
                </td>
            </tr>
            <%
                }
                %>
        </table>
        
        
    </body>
     <p align ="center">                 
                    <button onclick="goBack()">Volver</button>
                </p>

                    <script>
                    function goBack() {
                      window.history.back();
                    }
                    </script>
</html>
