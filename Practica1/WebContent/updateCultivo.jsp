<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Cultivo"%>
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
//Recuperamos del contexto la lista de los cultivos
	Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");
//recupero el cultivo a modificar
	Cultivo cultivo = cultivos.get(request.getParameter("idCul"));
%>
<br>
	<form action="Control" method="post">
<!-- hidden para que no se vea el campo que contiene la acción -->
	<input type="hidden" name="ACTION_ID" value="UPDATECUL"/>
	<input type="hidden" name="nombre" value="<%= cultivo.getId() %>"/>
	<fieldset style="background:#ffe1e1;">
	<legend>MODIFICAR <%= cultivo.getId() %></legend>
	<p>
	<label for="name">Descripción a modificar:</label><br>
	<textarea id="name"/><%= cultivo.getDescription() %></textarea>
	</p>
	</fieldset>	
	<p>
	<input type="submit" value="MODIFICAR">
	</p>
	</form><br><br>



</body>
</html>