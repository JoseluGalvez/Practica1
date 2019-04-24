package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Usuario;

public class UpdateAction extends Action {

@Override
public String execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
String jsp = "/list.jsp";
	
	System.out.println("Entro en UpdateAction...");
	
	String name = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
	String pass = (request.getParameter("pass")==null)?"":(request.getParameter("pass"));
	
	//Declaro la lista de usuarios con su "casting" correspondiente.
	Usuario usuario = new Usuario(name, pass);
	
	Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");
	
	//Si no tengo la lista de usuarios la creo y la guardo en el contexto
	if(usuarios == null) {
		usuarios = new Hashtable<String,Usuario>();		
		
		request.getServletContext().setAttribute("ATR_USUARIOS", usuarios);
	}
	
	// Añado a la lista el usuario creado con los parámetros recibidos (atributos)
	usuarios.put(name, usuario);
	
	return jsp;
}

}
