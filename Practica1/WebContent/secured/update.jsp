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
<%@ include file="cabecera.jsp"%>
<%
//Recuperamos del contexto la lista de los usuarios
	Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");
//recupero el usuario a modificar
	Usuario usuario = usuarios.get(request.getParameter("idUsu"));
%>
	<form action="<%=request.getContextPath()%>/Control" method="post">
<!-- hidden para que no se vea el campo que contiene la acci�n -->
	<input type="hidden" name="ACTION_ID" value="UPDATE"/>
	<input type="hidden" name="nombre" value="<%= usuario.getIdUsu() %>"/>
	<fieldset style="background:#ffe1e1;">
	<legend> MODIFICAR <%= usuario.getIdUsu() %> </legend>
	<p>
	<label for="name">Nombre a modificar:</label><br>
	<input type="text" name="name" id="name" value="<%= usuario.getName() %>"/>
	</p>
	<p>
	<label for="surname">Apellidos a modificar:</label><br>
	<input type="text" name="surname" id="surname" value="<%= usuario.getSurname() %>"/>
	</p>
	<p>
	<label for="contrasena">Contrase�a a modificar:</label><br>
	<input type="text" name="pass" id="pass" value="<%= usuario.getPass() %>"/>
	</p>
	<p>
    <input type="radio" name="tipo" value="normal"
		    <% if (usuario.isAdmin()){
		    	out.println("");
		    }else {
		    	out.println("checked");
		    	}
		    %>
	    > Normal    
    
    <input type="radio" name="tipo" value="administrador"
    		<% if (usuario.isAdmin()){
		    	out.println("checked");
		    }else {
		    	out.println("");
		    	}
		    %>
    > Administrador
  	</p>
	</fieldset>	
	<p>
	<input type="submit" value="MODIFICAR">
	</p>
	</form><br><br>



</body>
</html>