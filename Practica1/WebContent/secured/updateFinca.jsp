<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Finca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MODIFICAR</title>
</head>
<body bgcolor="#fff9f2">
<%@ include file="cabecera.jsp"%>
<%
//Recuperamos del contexto la lista de las fincas
	Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");
//Compruebo si existe
	boolean exist=fincas.containsKey(request.getParameter("idFin"));
	if(exist == false){
		out.println("La finca que desea modificar no existe, puede que haya sido eliminada por otro usuario. <br><a href=\""+request.getContextPath()+"/secured/listFinca.jsp \">  Volver</a><br>");
	}else {
//recupero la finca a modificar
	Finca finca = fincas.get(request.getParameter("idFin"));
%>
	<form action="<%=request.getContextPath()%>/Control" method="post">
<!-- hidden para que no se vea el campo que contiene la acci�n -->
	<input type="hidden" name="ACTION_ID" value="UPDATEFI"/>
	<input type="hidden" name="nombre" value="<%= finca.getId() %>"/>
	<fieldset style="background:#ffe1e1;">
	<legend> MODIFICAR <%= finca.getId() %> </legend>
	<p>
	<label for="name">Nombre a modificar:</label><br>
	<input type="text" name="name" id="name" value="<%= finca.getName() %>"/>
	</p>
	<p>
	<label for="hectareas">Hect�reas a modificar:</label><br>
	<input type="number" name="hectareas" id="hectareas" value="<%= finca.getHectareas() %>"/>
	</p>
	</fieldset>	
	<p>
	<input type="submit" value="~ MODIFICAR">
	</p>
	</form><br><br>
<% //VOLVER
out.println("<a href=\"" +request.getContextPath()+ "/secured/listFinca.jsp \"><button>< VOLVER</button></a>");
}%>
</body>
</html>