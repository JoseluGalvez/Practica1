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
Bienvenido, <%= user.getIdUsu() %>!<br>

<% if (user.isAdmin()){ %>
Gestionar <a href="<%=request.getContextPath()%>/secured/list.jsp">  USUARIOS</a><br><br>
<%} %>
Gestionar <a href="<%=request.getContextPath()%>/secured/listFinca.jsp">  FINCAS</a><br><br>
Gestionar <a href="<%=request.getContextPath()%>/secured/listCultivo.jsp">  CULTIVOS</a><br><br>
		
</body>
</html>