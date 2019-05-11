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
  Usuario loggedUser = (Usuario)session.getAttribute("usuario");
%>


<html>
    <head>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Mis amigos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
    </head>
    <body>
        <h1 class="display-4" align="center">Amigos</h1>
        <div class="mx-auto" style="width: 400px;">
   
        <form action="enviarPeticionServlet">
    <div class="mx-auto d-block">
            <label>Usuarios</label>
            <select name="nuevoamigo">
                <% 
                    String disabled = "disabled";
                    for(Usuario us : listaUsuarios){
                        if(us.getId() != 1 && us.getId() != loggedUser.getId() && !listaAmigos.contains(us)){
                            disabled = "";
                %>
                <option name="nuevoamigo" value="<%= us.getId() %>"> <%= us.getUsername()%> </option>
                <%     
                    }}
                %>

            </select> 
        </div>
                <button type="submit" <%= disabled %>>Enviar Peticion</button>
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
                <th>
                    
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
                <td>
                    <a href="EliminarAmigoServlet?id=<%= u.getId() %>">Eliminar</a>
                </td>
            </tr>
            <%
              }  
            %>
        </table>
        
        <h3>Solicitudes de amistad </h3>
        <table border="1">
            <tr>
                <th>
                    USUARIO
                </th>
                <th>
                    FECHA
                </th>
                <th>
                    
                </th>
                <th>
                    
                </th>
            </tr>
            <%
                for(Peticion p : listaPeticiones){
                    if(!p.getConfirmada()){
                %>
            
                <tr>
               
                <td>
                    <%= p.getUsuario().getUsername() %>
                </td>
                <td>
                    <%= p.getFecha()%>
                </td>
                <td>
                    <a href="AceptarSolicitudServlet?id=<%= p.getUsuario().getId() %>&id1=<%= p.getUsuario1().getId() %>">Aceptar</a>
                </td>
                <td>
                    <a href="RechazarSolicitudServlet?id=<%= p.getUsuario().getId() %>&id1=<%= p.getUsuario1().getId() %>">Rechazar</a>
                </td>
            </tr>
            <%
                }}
                %>
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
    </body>
     </div>     
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</html>
