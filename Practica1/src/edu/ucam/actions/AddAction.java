package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ucam.beans.Usuario;

public class AddAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/list.jsp";
		System.out.println("Entro en AddAction...");
		
		String idUsu = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
		String name = (request.getParameter("name")==null)?"":(request.getParameter("name"));
		String surname = (request.getParameter("surname")==null)?"":(request.getParameter("surname"));
		String pass = (request.getParameter("pass")==null)?"":(request.getParameter("pass"));
		
		Usuario usuario = new Usuario(idUsu, name, surname, pass);
		
		//Declaro la lista de usuarios con su "casting" correspondiente.
		Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");
		
		//Si no tengo la lista de usuarios la creo y la guardo en el contexto
		if (usuarios == null) {
			usuarios = new Hashtable<String, Usuario>();
			request.getServletContext().setAttribute("ATR_USUARIOS", usuarios);
		}
		
		// Comprobamos si existe ese ID
	    if(usuarios.containsKey(idUsu)) {
			request.setAttribute("MSG", "Nick en uso, escriba otro diferente.");
	    }else {
			// Añado a la lista el usuario creado con los parámetros recibidos (atributos)
			usuarios.put(idUsu, usuario);
	    }
		return jsp;
	}

}
