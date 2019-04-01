<%-- 
    Document   : index
    Created on : 01-abr-2019, 10:15:10
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RED SOCIAL</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <img class="mx-auto d-block" src="https://github.com/TomasGarcia/ProyectoTAW/blob/master/RedSocial/RedSocial-war/src/java/logo.png?raw=true"  border="0" alt="error" width="200" height="200">
	<div class="container">
        
    </head>
    <body>
         <div class="mx-auto" style="width: 400px;">
		<form th:action="@{/login}" method="post">
			<div class="mx-auto d-block">
				<label for="InputEmail1">Correo Electrónico</label>
                                <input type="email" class="form-control" id="Email1" placeholder="Escriba su correo">
			</div>
			<div class="mx-auto d-block">
				<label for="Password1">Contraseña</label>
                                <input type="text" class="form-control" id="Password1" placeholder="Escriba su contraseña">
			</div>
                    <br>
			<div class="text-center">
				<input class="btn btn-primary" type="submit" value="Sign In" />
			</div>
                </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
    </body>
</html>