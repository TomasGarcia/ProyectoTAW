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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset=UTF-8">
        <title>Mi perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
        </div>     
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
        
    </body>
</html>
