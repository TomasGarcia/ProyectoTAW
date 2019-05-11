<%-- 
    Document   : profile
    Created on : 14-abr-2019, 9:40:53
    Author     : Alejandro Calvo
--%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import = "Entities.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario usuario = (Usuario)request.getAttribute("usuario");
    if(usuario == null){
        usuario = (Usuario)session.getAttribute("usuario");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi perfil</title>
    </head>
    <body>
        <h1 class="display-4" align="center">Mis datos personales</h1>
        <div class="mx-auto" style="width: 400px;">
                <div class="mx-auto d-block">
                    <label>ID</label>
                    <input class="form-control" name="id" value = "<%=usuario.getId()%>" readonly>
                </div> 
                <div class="mx-auto d-block">
                    <label>Nombre de Usuario</label>
                    <input class="form-control" name="username" value = "<%=usuario.getUsername()%>" readonly>
                </div>   
                <div class="mx-auto d-block">
                    <label>Email</label>
                    <input class="form-control" name="email" value = "<%=usuario.getEmail()%>" readonly>
                </div>  
                <div class="mx-auto d-block">
                    <label>Contraseña</label>
                    <input class="form-control" name="password" value = "<%=usuario.getPassword()%>" readonly>
                </div>  
                <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre"value = "<%=usuario.getNombre()%>" readonly>
                </div>  
                <div class="mx-auto d-block">
                    <label>Apellido</label>
                    <input class="form-control" name="apellido"value = "<%=usuario.getApellido()%>" readonly>
                </div>  
                <div class="mx-auto d-block">
                    <label>Fecha de Nacimiento</label>
                    <%
                        String pattern = "dd/MM/yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        String fecha = simpleDateFormat.format(usuario.getFechaNacimiento());
                      %>
                    <input class="form-control" type="text" name="fecha_nacimiento" value = "<%=fecha%>" readonly>
                </div>  
                <div class="mx-auto d-block">
                    <label>Pais</label>
                    <input class="form-control" name="pais" value = "<%=usuario.getPais()%>" readonly>
                </div> 
                <br>
                <p align="center">
                    <button class="btn btn-primary" onclick="window.location='editprofile.jsp'">Editar Perfil</button>
                </p>
    
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
</html>
