<%-- 
    Document   : paginagrupo
    Created on : 01-may-2019, 19:46:46
    Author     : Hp
--%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
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
    List<Post> PostsList = (List<Post>)request.getAttribute("PostListGrupo");
    
%>    
<html>
    
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Pagina del grupo <%=grupo.getNombre() %></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    </head>
    <body>
        <h1 class="display-4" align="center">Datos del grupo</h1>
        <div class="mx-auto" style="width: 400px;">
         <div class="mx-auto d-block">
            <label>Nombre</label>
            <input class="form-control" name="nombre" value = "<%=grupo.getNombre()%>" readonly>
        </div>   
        <div class="mx-auto d-block">
            <label>Descripcion</label>
            <input class="form-control" name="descripcion" value = "<%=grupo.getDescripcion()%>" readonly>
        </div>
        <div class="mx-auto d-block">
            <label>Administrador</label>
            <input class="form-control" name="descripcion" value = "<%=grupo.getUsuarioId().getUsername()%>" readonly>
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
                 <th>
                    IMAGEN
                 </th>
                 <th>
                    VIDEO
                 </th>
                 <th>
                    DESTINATARIO
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
             <td>
                 <%= g.getImagen()%>
             </td>
             <td>
                 <%= g.getVideo()%>
             </td>
             <td>
                 <%= g.getDestinatario()%>
             </td>
             
         </tr>
             <% } %>
         </table>
         <form action="newpostgrupoServlet"
         <h4 align="center">Nueva Publicacion en este Grupo</h4>
        
         </form>
         
        <div>
            
            <p align="center">
            <button class="btn btn-primary" role="link" onclick="window.location='newpostgrupo.jsp'">Crear nueva publicacion</button>
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
        
    </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    </body>
</html>
