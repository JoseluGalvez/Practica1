<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@page import="edu.ucam.beans.Cultivo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CULTIVOS</title>
</head>
<body>
<%@ include file="cabecera.jsp"%>
<%
	//Intentamos recuperar el usuario que ha iniciado sesión.
	Usuario user = (Usuario) session.getAttribute("USUARIO_LOGED");
%>
<h5 align="RIGHT">Conectado como: <%= user.getIdUsu() %></h5><br>
	<form action="Control" method="POST">
<!-- hidden para que no se vea el campo que contiene la acción -->
	<input type="hidden" name="ACTION_ID" value="ADDCUL"/>
	<fieldset style="background:#feffe1;">
		<legend>NUEVO CULTIVO</legend>
		<p>
		<label for="name">Descripción: </label>
		<textarea id="name" required></textarea>
		</p>
		</fieldset>
		<p>
		<input type="submit" value="AÑADIR">
		</p>
	</form>
	<br><br>

<%
//Recuperamos del contexto todas los cultivos
	Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");

	if (cultivos != null && cultivos.size() > 0){
		
		Cultivo cultivo;
		for(Enumeration e = cultivos.elements(); e.hasMoreElements();){
			cultivo = (Cultivo)e.nextElement();
			
			out.println("<input type=\"button\" value=\"x\" onclick=\"window.location('Control?ACTION_ID=DELETECUL&idCul="+ cultivo.getId()+"')\" />"+"  ["+ cultivo.getId()
				+"], Descripción: "+ cultivo.getDescription()
				+"<a href=\"updateCultivo.jsp?nombre="+cultivo.getDescription()+"&idCul="+cultivo.getId()+"\">  Modificar</a><br>");

		}
	}else{
		out.println("   - = No hay cultivos. = -");
	}
%>

</body>
</html>