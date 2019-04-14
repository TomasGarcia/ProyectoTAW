<%-- 
    Document   : profile
    Created on : 14-abr-2019, 9:40:53
    Author     : Alejandro Calvo
--%>
<%@page import = "Entities.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario usuario = (Usuario)request.getAttribute("usuario");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi perfil</title>
    </head>
    <body>
        <h1 class="display-4" align="center">Mis datos personales</h1>
        <div class="mx-auto" style="width: 400px;">
            <form method="post" action="profileServlet" name="profile" accept-charset="utf-8">
                <div class="mx-auto d-block">
                    <label>Nombre de Usuario</label>
                    <input type = "hidden" class="form-control" name="username" value = "<%=usuario.getUsername()%>">
                </div>   
                <div class="mx-auto d-block">
                    <label>Email</label>
                    <input type = "hidden" class="form-control" name="email" value = "<%=usuario.getEmail()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Contraseña</label>
                    <input type = "hidden" class="form-control" name="password" value = "<%=usuario.getClave()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input type = "hidden" class="form-control" name="nombre"value = "<%=usuario.getNombre()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Apellido</label>
                    <input type = "hidden" class="form-control" name="apellido"value = "<%=usuario.getApellido()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Fecha de Nacimiento</label>
                    <input type = "hidden" class="form-control" type="datetime" name="fecha_nacimiento" value = "<%=usuario.getFechaNacimiento()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Pais</label>
                    <input type = "hidden" class="form-control" name="pais" value = "<%=usuario.getPais()%>">
                </div> 
                <br>
                <button class="btn btn-primary" role="link" onclick="window.location='muro.jsp'">Volver</button>
            </form>
    </body>
</html>
