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
<%
	//Intentamos recuperar el usuario que ha iniciado sesión.
	Usuario user = (Usuario) session.getAttribute("USUARIO");

%>
Bienvenido, <%= user.getName() %>!<br>
	<form action="Control" method="POST">
<!-- hidden para que no se vea el campo que contiene la acción -->
	<input type="hidden" name="ACTION_ID" value="ADD"/>
	<fieldset style="background:#feffe1;">
		<legend>USUARIO</legend>
		<p>
		<label for="nombre">Nombre usuario nuevo: </label>
		<input type="text" name="nombre" id="nombre" />
		</p>
		<p>
		<label for="contrasena">Contraseña usuario nuevo: </label>
		<input type="text" name="pass" id="pass" />
		</p>
		</fieldset>
		<p>
		<input type="submit" value="AÑADIR">
		</p>
	</form><br><br>

<%
//Recuperamos del contexto todos los usuarios
	Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");

	if (usuarios != null && usuarios.size() > 0){
		
		Usuario usuario;
		for(Enumeration e = usuarios.elements(); e.hasMoreElements();){
			usuario = (Usuario)e.nextElement();
			
			out.println("<input type=\"button\" value=\"x\" onclick=\"window.location('Control?ACTION_ID=DELETE&nombre="+usuario.getName()+"')\" />"+"  "+ usuario.getName()
				+", contraseña: "+ usuario.getPass()+" "
				+"<a href=\"update.jsp?nombre="+usuario.getName()+"&pass="+ usuario.getPass()+"\">  Modificar</a><br>");
		}
	}else{
		out.println("   - = No hay usuarios. = -");
	}
%>

</body>
</html>