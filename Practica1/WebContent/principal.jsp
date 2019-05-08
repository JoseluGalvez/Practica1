<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="edu.ucam.beans.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FINCAS Y CULTIVOS</title>
</head>
<body>
<%@ include file="cabecera.jsp"%>
<%
	//Intentamos recuperar el usuario que ha iniciado sesión.
	Usuario user = (Usuario) session.getAttribute("USUARIO_LOGED");
%>
Bienvenido, <%= user.getIdUsu() %>!<br>

<a href="list.jsp">  USUARIOS</a><br>
<a href="listFinca.jsp">  FINCAS</a><br>
<a href="listCultivo.jsp">  CULTIVOS</a><br>
		
</body>
</html>