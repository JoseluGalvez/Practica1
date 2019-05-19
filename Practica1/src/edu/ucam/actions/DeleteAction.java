package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Usuario;

public class DeleteAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/secured/list.jsp";
		System.out.println("Entro en DeleteAction...");
		
		String idUsu = request.getParameter("nombre");
				
		//Recupero la lista de usuarios con su "casting" correspondiente.
		Hashtable <String, Usuario> usuarios = (Hashtable <String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS");
		
		if (usuarios != null) {
			
			// Comprobamos si existe ese ID
		    if(usuarios.containsKey(idUsu)) {
		    	usuarios.remove(idUsu);
				request.setAttribute("MSG", "Usuario ["+idUsu+"] eliminado");
		    }else {
			request.setAttribute("MSG", "Usuario ["+idUsu+"] no encontrado");
		    }
		}
		return jsp;
	}

}
