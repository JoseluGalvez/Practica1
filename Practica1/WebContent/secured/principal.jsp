<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="edu.ucam.beans.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
  .botonUsu{
    text-decoration: none;
    padding: 8px;
    font-weight: 600;
    font-size: 15px;
    color: #ffffff;
    background-color: #41b5f0;  
    border-radius: 5px;
    border: 2px solid #0016b0;
  }
    .botonFin{
    text-decoration: none;
    padding: 8px;
    font-weight: 600;
    font-size: 15px;
    color: #ffffff;
    background-color: #f0a641;  
    border-radius: 5px;
    border: 2px solid #0016b0;
  }
    .botonCul{
    text-decoration: none;
    padding: 8px;
    font-weight: 600;
    font-size: 15px;
    color: #ffffff;
    background-color: #8ef041;  
    border-radius: 5px;
    border: 2px solid #0016b0;
  }
  .botonUsu:hover{
    color: #1883ba;
    font-size: 18px;
    background-color: #ffffff;
  }
    .botonFin:hover{
    color: #fc5c00;
    font-size: 18px;
    background-color: #ffffff;
  }
    .botonCul:hover{
    color: #18a002;
    font-size: 18px;
    background-color: #ffffff;
  }
  
</style>

<title>FINCAS Y CULTIVOS</title>
</head>
<body>
<%@ include file="cabecera.jsp"%>
Bienvenido, <%= user.getIdUsu() %>!<br><br>

<% if (user.isAdmin()){ %>
Gestionar <a class="botonUsu" href="<%=request.getContextPath()%>/secured/list.jsp">  USUARIOS</a><br><br>
<%} %>
Gestionar <a class="botonFin" href="<%=request.getContextPath()%>/secured/listFinca.jsp">  FINCAS</a><br><br>
Gestionar <a class="botonCul" href="<%=request.getContextPath()%>/secured/listCultivo.jsp">  CULTIVOS</a><br><br>
		
</body>
</html>