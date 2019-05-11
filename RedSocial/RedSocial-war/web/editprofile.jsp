<%-- 
    Document   : editprofile
    Created on : 01-abr-2019, 11:09:40
    Author     : 
--%>
<%@page import="Entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <title>Editar Datos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>    
        <h2 class="display-4" align="center">Modifique los datos que considere oportunos</h2>

        <form method="get" action="editProfileServlet" name="editar" accept-charset="utf-8">
            <div class="mx-auto" style="width: 400px;">     
            <div class="mx-auto d-block">
                    <label>ID</label>
                    <input class="form-control" name="id" value = "<%=usuario.getId()%>" readonly>
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
                    <input class="form-control" name="password" value = "<%=usuario.getPassword()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Nombre</label>
                    <input class="form-control" name="nombre"value = "<%=usuario.getNombre()%>">
                </div>  
                <div class="mx-auto d-block">
                    <label>Apellido</label>
                    <input class="form-control" name="apellido"value = "<%=usuario.getApellido()%>">
                </div>  
                
                    <label>Fecha de Nacimiento</label>
                    <%
                        String pattern = "dd/MM/yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        String fecha = simpleDateFormat.format(usuario.getFechaNacimiento());
                    %>
                    <input class="form-control" type="text" name="fecha_nacimiento" value = "<%=fecha%>">
                  
                <div class="mx-auto d-block">
                    <label>Pais</label>
                    <input class="form-control" name="pais" value = "<%=usuario.getPais()%>">
                </div> 
                <p align="center">
                    <input type="submit" value="Editar" />
                </p>
        
        </div>
        </form>        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
