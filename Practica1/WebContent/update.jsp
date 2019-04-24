<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MODIFICAR</title>
</head>
<body>


<%
//Recuperamos del contexto la lista de los usuarios
	Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");
//recupero el usuario a modificar
	Usuario usuario = usuarios.get(request.getParameter("nombre"));
	
%>
<br>
	<form action="Control" method="post">
<!-- hidden para que no se vea el campo que contiene la acción -->
	<input type="hidden" name="ACTION_ID" value="UPDATE"/>
	<!-- disabled hace que no se modifique el campo pero envía NULL como valor -->
	<fieldset style="background:#ffe1e1;">
	<legend>MODIFICAR</legend>
	<p>
	<label for="nombre">Nombre usuario</label><br>
	<input type="text" name="nombre" id="nombre" value="<%= usuario.getName() %>" readonly="readonly"/>
	</p>
	<p>
	<label for="contrasena">Contraseña a modificar:</label><br>
	<input type="text" name="pass" id="pass" value="<%= usuario.getPass() %>"/>
	</p>
	</fieldset>	
	<p>
	<input type="submit" value="MODIFICAR">
	</p>
	</form><br><br>



</body>
</html>