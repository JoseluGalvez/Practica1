<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA</title>
</head>
<body>
<%@ include file="cabecera.jsp"%>
	<form action="Control" method="POST">
<!-- hidden para que no se vea el campo que contiene la acción -->
	<input type="hidden" name="ACTION_ID" value="ADD"/>
	<fieldset style="background:#feffe1;">
		<legend> NUEVO USUARIO </legend>
		<p>
		<label for="nombre">*Nick usuario nuevo: </label>
		<input type="text" name="nombre" id="nombre" required/>
		</p>
		<p>
		<label for="contrasena">*Contraseña usuario nuevo: </label>
		<input type="text" name="pass" id="pass" required/>
		</p>
		<p>
		<label for="name">Nombre: </label>
		<input type="text" name="name" id="name" value=""/>
		</p>
		<p>
		<label for="surname">Apellidos: </label>
		<input type="text" name="surname" id="surname" value=""/>
		</p>
		<h6>Los campos marcados con * son obligatorios.</h6>
		</fieldset>
		<p>
		<input type="submit" value="AÑADIR">
		</p>
	</form>
	<br><br>

<%
//Recuperamos del contexto todos los usuarios
	Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");

	if (usuarios != null && usuarios.size() > 0){
		Usuario usuario;
		for(Enumeration e = usuarios.elements(); e.hasMoreElements();){
			usuario = (Usuario)e.nextElement();
			out.println("<a href=\"Control?ACTION_ID=DELETE&nombre="+usuario.getIdUsu()+"\">X Eliminar </a>["+usuario.getIdUsu()
				+"], Nombre: "+usuario.getName()+", Apellidos: "+usuario.getSurname()+" "
				+"<a href=\"update.jsp?nombre="+usuario.getName()+"&pass="+ usuario.getPass()+"&idUsu="+ usuario.getIdUsu()+"\">  Modificar</a><br>");
		}
	}else{
		out.println("   - = No hay usuarios. = -");
	}
%>

</body>
</html>