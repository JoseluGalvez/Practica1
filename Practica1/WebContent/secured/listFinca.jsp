<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@page import="edu.ucam.beans.Finca"%>
<%@ taglib uri="tagspractica" prefix="logcont" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FINCAS</title>
</head>
<body bgcolor="#fff9f2">
<%@ include file="cabecera.jsp"%>
	<form action="<%=request.getContextPath()%>/Control" method="POST">
<!-- hidden para que no se vea el campo que contiene la acci�n -->
	<input type="hidden" name="ACTION_ID" value="ADDFI"/>
	<fieldset style="background:#feffe1;">
		<legend> NUEVA FINCA </legend>
		<p>
		<label for="name">Nombre: </label>
		<input type="text" name="name" id="name" required/>
		</p>
		<p>
		<label for="hectareas">Hect�reas: </label>
		<input type="number" name="hectareas" id="hectareas" value=""/>
		</p>
		</fieldset>
		<p>
		<input type="submit" value="+ A�ADIR">
		</p>
	</form>
	<br><br>

<%
//Recuperamos del contexto todas las fincas
	Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");

	if (fincas != null && fincas.size() > 0){
		Finca finca;
		out.println("<table><tr>"
				+"<th>[Eliminar]</th>"
				+"<th>[ ID ]</th>"
				+"<th>[ Nombre ]</th>"
				+"<th>[ Hect�reas ]</th>"
				+"<th>[Modificar]</th></tr>");

		for(Enumeration e = fincas.elements(); e.hasMoreElements();){
			finca = (Finca)e.nextElement();
			
			out.println("<tr>"
			+"<td align=\"CENTER\"><a href=\""+request.getContextPath()+"/Control?ACTION_ID=DELETEFI&idFin="+ finca.getId()+"\">X </a></td>"
			+"<td align=\"CENTER\"> "+finca.getId()+" </td>"
			+"<td align=\"CENTER\"> "+finca.getName()+" </td>"
			+"<td align=\"CENTER\"> "+finca.getHectareas()+" </td>"
			+"<td align=\"CENTER\"><a href=\""+request.getContextPath()+"/secured/updateFinca.jsp?nombre="+finca.getName()+"&idFin="+finca.getId()+"\"> >> </a></td>"
			+"</tr>");			
		}
		out.println("</table>");
	}else{
		out.println("   - = No hay fincas. = -");
	}
%>
<br>
		<!-- ETIQUETA que contabiliza las inserciones y eliminaci�n de fincas en esta sesion -->
<logcont:LogFin/>
<br>
<% //BOTON VOLVER
out.println("<a href=\"" +request.getContextPath()+ "/secured/principal.jsp \"><button>< VOLVER</button></a>");
%>
</body>
</html>