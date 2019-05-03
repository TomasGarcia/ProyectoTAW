<%-- 
    Document   : paginagrupo
    Created on : 01-may-2019, 19:46:46
    Author     : Hp
--%>
<%@page import="java.util.List"%>
<%@page import="Entities.Post"%>
<%@page import="Entities.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Grupo grupo = (Grupo)request.getAttribute("grupo");
    if(grupo == null){
        grupo = (Grupo)session.getAttribute("grupo");
    }
    List<Post> PostsList = (List<Post>)request.getAttribute("PostList");
%>    
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina del grupo <%=grupo.getNombre() %></title>
    </head>
    <body>
        <h1>Datos del grupo</h1>
         <div class="mx-auto d-block">
            <label>Nombre</label>
            <input class="form-control" name="nombre" value = "<%=grupo.getNombre()%>" readonly>
        </div>   
        <div class="mx-auto d-block">
            <label>Descripcion</label>
            <input class="form-control" name="descripcion" value = "<%=grupo.getDescripcion()%>" readonly>
        </div>
        
        
        
        </table>      
         <h4 align="left">Posts</h4>
         <table border ="1" >
             <tr>
                 <th>
                     TITULO
                 </th>
                 <th>
                    TEXTO
                 </th>
             </tr>

             <% for(Post g: PostsList){ %>
         <tr>
             <td>
                 <%= g.getTitulo()%>
             </td>
             <td>
                 <%= g.getTexto()%>
             </td>
             
         </tr>
             <% } %>
         </table>
         <form action="newpostServlet"
         <h4 align="center">Nueva Publicacion en este Grupo</h4>
        <p align="center">
            <button class="btn btn-primary" role="link" onclick="window.location='newpost.jsp'">Crear nueva publicacion</button>
        </p>
         </form>
         
        <div>
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='muro.jsp'">Volver</button>
        </div>
    </body>
</html>
