<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@page import="edu.ucam.beans.Finca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FINCAS</title>
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
	<input type="hidden" name="ACTION_ID" value="ADDFI"/>
	<fieldset style="background:#feffe1;">
		<legend>NUEVA FINCA</legend>
		<p>
		<label for="name">Nombre: </label>
		<input type="text" name="name" id="name" required/>
		</p>
		<p>
		<label for="hectareas">Hectáreas: </label>
		<input type="number" name="hectareas" id="hectareas" value=""/>
		</p>
		</fieldset>
		<p>
		<input type="submit" value="AÑADIR">
		</p>
	</form>
	<br><br>

<%
//Recuperamos del contexto todas las fincas
	Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");

	if (fincas != null && fincas.size() > 0){
		
		Finca finca;
		for(Enumeration e = fincas.elements(); e.hasMoreElements();){
			finca = (Finca)e.nextElement();
			
			out.println("<input type=\"button\" value=\"x\" onclick=\"window.location('Control?ACTION_ID=DELETEFI&idFin="+ finca.getId()+"')\" />"+"  ["+ finca.getId()
				+"], Nombre: "+finca.getName()+", Hectáreas: "+finca.getHectareas()
				+"<a href=\"updateFinca.jsp?nombre="+finca.getName()+"&idFin="+finca.getId()+"\">  Modificar</a><br>");

		}
	}else{
		out.println("   - = No hay fincas. = -");
	}
%>

</body>
</html>