<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.Usuario"%>
<%@page import="edu.ucam.beans.Cultivo"%>
<%@ taglib uri="tagspractica" prefix="logcont" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CULTIVOS</title>
</head>
<body bgcolor="#f7fff1">
<%@ include file="cabecera.jsp"%>
	<form action="<%=request.getContextPath()%>/Control" method="POST">
<!-- hidden para que no se vea el campo que contiene la acci�n -->
	<input type="hidden" name="ACTION_ID" value="ADDCUL"/>
	<fieldset style="background:#feffe1;">
		<legend> NUEVO CULTIVO </legend>
		<p>
		<label for="name">Descripci�n: </label>
		<input type="text" name="name" id="name" required/>
		</p>
		</fieldset>
		<p>
		<input type="submit" value="+ A�ADIR">
		</p>
	</form>
	<br><br>

<%
//Recuperamos del contexto todas los cultivos
	Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");

	if (cultivos != null && cultivos.size() > 0){
		Cultivo cultivo;
		out.println("<table><tr>"
				+"<th>[Eliminar]</th>"
				+"<th>[  ID  ]</th>"
				+"<th>[ Descripci�n ]</th>"
				+"<th>[Modificar]</th></tr>");

		for(Enumeration e = cultivos.elements(); e.hasMoreElements();){
			cultivo = (Cultivo)e.nextElement();

			out.println("<tr>"
			+"<td align=\"CENTER\" ><a href=\""+request.getContextPath()+"/Control?ACTION_ID=DELETECUL&idCul="+ cultivo.getId()+"\">X </a></td>"
			+"<td align=\"CENTER\"> "+cultivo.getId()+" </td>"
			+"<td align=\"CENTER\"> "+cultivo.getDescription()+" </td>"
			+"<td align=\"CENTER\" ><a href=\""+request.getContextPath()+"/secured/updateCultivo.jsp?name="+cultivo.getDescription()+"&idCul="+cultivo.getId()+"\"> >> </a></td>"
			+"</tr>");	
		}
		out.println("</table>");
	}else{
		out.println("   - = No hay cultivos. = -");
	}
%>
<br>
		<!-- ETIQUETA que contabiliza las inserciones y eliminaci�n de cultivos en esta sesion -->
<logcont:LogCul/>
<br>
<%
out.println("<a href=\"" +request.getContextPath()+ "/secured/principal.jsp \"><button>< VOLVER</button></a>");
%>
</body>
</html>