<%-- 
    Document   : editprofile
    Created on : 01-abr-2019, 11:09:40
    Author     : oscar
--%>
<%@page import="Entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario usuario = (Usuario)request.getAttribute("usuario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Datos</title>
    </head>
    <body>
        <h1>Modifique los datos que considere oportunos:</h1>
        <form action ="editProfileServlet" method="post">
                 <div class="mx-auto d-block">
                    <label>ID</label>
                    <input  type="hidden" class="form-control" name="id" value = "<%=usuario.getId()%>">
                </div>   
                <div class="mx-auto d-block">
                    <label>Nombre de Usuario</label>
                    <input class="form-control" name="username" value = "<%=usuario.getUsername()%>">
                </div>   
                <div class="mx-auto d-block">
                    <label>Email</label>
                    <input class="form-control" name="email" value = "<%=usuario.getEmail()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Contraseña</label>
                    <input class="form-control" name="password" value = "<%=usuario.getClave()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre"value = "<%=usuario.getNombre()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Apellido</label>
                    <input class="form-control" name="apellido"value = "<%=usuario.getApellido()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Fecha de Nacimiento</label>
                    <input class="form-control" type="datetime" name="fecha_nacimiento" value = "<%=usuario.getFechaNacimiento()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Pais</label>
                    <input class="form-control" name="pais" value = "<%=usuario.getPais()%>">
                </div> 
            <input type="submit" value="Editar" />
        </form>
    </body>
</html>
