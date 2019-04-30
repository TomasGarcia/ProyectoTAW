<%-- 
    Document   : home
    Created on : 01-abr-2019, 9:39:11
    Author     : Hp
--%>

<%@page import="ejb.GrupoFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Grupo"%>
<%@page import= "Entities.Usuario" %>
<%@page import= "Entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    
   // List<Post> PostsList = (List<Post>)request.getAttribute("PostList");
    List<Grupo> GruposList = (List<Grupo>)request.getAttribute("GrupoList");
    if(GruposList == null){
        System.out.println("LISTA NULL GILIPOLLAS");
        GruposList = (List)session.getAttribute("GrupoList");
        if(GruposList == null){
            GruposList = new ArrayList<Grupo>();
            System.out.println("LISTA NULL GILIPOLLAS OTRA VEZ");
        }
    }
%>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        
    </head>
    <body>
        Bienvenido a nuestra Red Social
        <!--Perfil con datos personales-->
        <button class="btn btn-primary" role="link" onclick="window.location='profile.jsp'">Mi perfil</button>
        <form action="newGrupoServlet">   
            <h4 align="left">Grupos</h4>
         <table border ="1">
             <tr>
                 <th>
                     NOMBRE
                 </th>
                 <th>
                    DESCRIPCION
                 </th>
             </tr>

             <% for(Grupo g: GruposList){ %>
         <tr>
             <td>
                 <%= g.getNombre() %>
             </td>
             <td>
                 <%= g.getDescripcion()%>
             </td>
             <td>
               <a href="editargrupoServlet?id=<%= g.getId()%>">Editar</a>
             </td>
         </tr>
             <% } %>
         </table>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </form> 
    </body>
    <h4 align="center">Nueva Publicacion</h4>
        <p align="center">
            <button class="btn btn-primary" role="link" onclick="window.location='newpost.jsp'">Crear nueva publicacion</button>
        </p>
    
    <h4 align="center">Crear grupo</h4>
    <p align="center">
        <button class="btn btn-primary" role="link" onclick="window.location='newgrupo.jsp'">Crear nuevo grupo</button>
    </p>
  
</html>