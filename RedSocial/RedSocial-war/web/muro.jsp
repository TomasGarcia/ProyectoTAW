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
    
    List<Post> PostsList = (List<Post>)request.getAttribute("PostList");
    List<Grupo> GruposList = (List<Grupo>)request.getAttribute("GrupoList");
    Usuario loggedUser = (Usuario) session.getAttribute("usuario");
    
%>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        
    </head>
    <body>
        Bienvenido a nuestra Red Social @<%= loggedUser.getUsername() %>
        <br>
        <!--Perfil con datos personales-->
        <img src=https://www.soporte.ipn.mx/assets/images/cau-profile-default.png alt="usuario" style="width:100px;height:100px;"> 
        <br>
        <button class="btn btn-primary" role="link" onclick="window.location='profile.jsp'">Mi perfil</button>
        <br>
        <form action="cerrarSesion">
            <button class="btn btn-danger" role="link" >Desconectar</button>
        </form> 
        
        <h4 align="left">Grupos</h4>
         <table border ="1">
             <tr>
                 <th>
                     NOMBRE
                 </th>
                 <th>
                    DESCRIPCION
                 </th>
                 <th>
                    ADMINISTRADOR
                 </th>
                 
             </tr>

             <% for(Grupo p: GruposList){ 
                    if(p.getUsuarioId().getId()== loggedUser.getId() || p.getUsuarioCollection().contains(loggedUser) ){
             
             %>     
         <tr>
             <td>
                 <%= p.getNombre() %>
             </td>
             <td>
                 <%= p.getDescripcion()%>
             </td>
             <td>
                 <%= p.getUsuarioId().getEmail()%>
             </td>
             <td>
                 <% 
                     if(p.getUsuarioId().getId() == loggedUser.getId() ){
                        
                 %>
               <a href="editargrupoServlet?id=<%= p.getId()%>">Editar</a>
               <% } %>
             </td>
             <td>
               <a href="paginaGrupoServlet?id=<%= p.getId()%>">Pagina</a>
             </td>
             <td>
               <a href="integrantesServlet?id=<%= p.getId()%>">Integrantes</a>
             </td>
         </tr>
       <%     }
                
                } %>
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
                 <th>
                    IMAGEN
                 </th>
                 <th>
                    VIDEO
                 </th>
                 <th>
                    DESTINATARIO
                 </th>
                 <th>
                     ENVIADO POR
                 </th>
             </tr>

             <% for(Post g: PostsList){ 
                    if(g.getUsuarioId().getId()== loggedUser.getId() || g.getUsuarioId1().getId()== loggedUser.getId() || g.getDestinatario() == 1){
             
             %>
         <tr>
             <td>
                 <%= g.getTitulo()%>
             </td>
             <td>
                 <%= g.getTexto()%>
             </td>
             
             <td>
                 <img src="<%= g.getImagen()%>" alt="Sin Imagen" width="200" height="100">
             </td>
             <td>
                <iframe width="200" height="100" src="<%=g.getVideo()%>">
                </iframe>
             </td>
             <td>
                 <% 
                     String dest = g.getUsuarioId1().getUsername();
                     if(g.getUsuarioId1().getId() == 1){
                         dest = "Publico";
                     }
                 %>
                 <%= dest %>
             </td>
            <td>
                <%= g.getUsuarioId().getUsername() %>
            </td> 
            <td>
                <%
                    boolean eliminar = false;
                    Usuario userPost = g.getUsuarioId();
                    if(userPost.getId() == loggedUser.getId()){
                        eliminar = true;
                    }
                %>
                <button onclick="window.location.href='eliminarPost?id=<%= g.getId() %>'" 
                <% if(!eliminar){ %>
                        disabled
                <%}%>>Eliminar</button>
            </td>
         </tr>
             <%     }
                
                } %>
         </table>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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