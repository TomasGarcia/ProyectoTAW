<%-- 
    Document   : home
    Created on : 01-abr-2019, 9:39:11
    Author     : Hp
--%>
<%@page import="Entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    List<Post> posts = (List)request.getAttribute("listaPosts");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
        
    <button>Mi Perfil</button>
    </head>
    <body>
        <h1>Publicaciones</h1>
        
        <%
            for(Post post : posts){
        %>
        
        
        
        <%
               }
        %>
        
        
    </body>
    <button>New Post</button>
</html>
