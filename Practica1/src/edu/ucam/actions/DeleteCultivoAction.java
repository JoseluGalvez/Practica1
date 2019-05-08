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
		String jsp ="/listCultivo.jsp";
		System.out.println("Entro en DeleteCultivoAction...");
		
		String idCul = request.getParameter("idCul");
				
		//Recupero la lista de cultivos con su "casting" correspondiente.
		Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");
		
		if (cultivos != null) {
			
			// Comprobamos si existe ese ID
		    if(cultivos.containsKey(idCul)) {
		    	cultivos.remove(idCul);
				request.setAttribute("MSG", "Cultivo eliminado");
		    }else {
			request.setAttribute("MSG", "Cultivo no encontrado");
		    }
		}
		return jsp;
	}

}
