<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

	
<form action="ServletLogin" method="POST">
	<fieldset style="background:#e1eff2;">
	<legend>LOGIN</legend>
	<p>
	<label for="nombre">Nombre</label><br>
	<input type="text" name="nombre" id="nombre" value="admin"/>
	</p>
	<p>
	<label for="contrasena">Contrase�a</label><br>
	<input type="password" name="pass" id="pass" value="admin"/>
	</p>
	</fieldset>	
	<input type="submit" value="ACCEDER">
</form>


</body>
</html>