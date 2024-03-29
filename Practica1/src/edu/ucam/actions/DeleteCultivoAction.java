package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Cultivo;

public class DeleteCultivoAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/secured/listCultivo.jsp";
		System.out.println("Entro en DeleteCultivoAction...");
		
		String idCul = request.getParameter("idCul");
				
		//Recupero la lista de cultivos con su "casting" correspondiente.
		Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");
		
		if (cultivos != null) {
			
			// Comprobamos si existe ese ID
		    if(cultivos.containsKey(idCul)) {
		    	cultivos.remove(idCul);
		    	
				//Incremento cantidad de cultivos eliminados por usuario actual en esta sesion
				int contDelCul = (int)request.getSession().getAttribute("CUL_DEL");
				request.getSession().setAttribute("CUL_DEL", ++contDelCul);
		    	
				request.setAttribute("MSG", "Cultivo ["+idCul+"] eliminado");
		    }else {
			request.setAttribute("MSG", "Cultivo ["+idCul+"] no encontrado");
		    }
		}
		return jsp;
	}

}
