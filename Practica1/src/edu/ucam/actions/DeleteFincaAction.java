package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Finca;

public class DeleteFincaAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/listFinca.jsp";
		System.out.println("Entro en DeleteFincaAction...");
		
		String idFin = request.getParameter("idFin");
				
		//Recupero la lista de fincas con su "casting" correspondiente.
		Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");
		
		if (fincas != null) {
			
			// Comprobamos si existe ese ID
		    if(fincas.containsKey(idFin)) {
		    	fincas.remove(idFin);
				request.setAttribute("MSG", "Finca eliminada");
		    }else {
			request.setAttribute("MSG", "Finca no encontrada");
		    }
		}
		return jsp;
	}

}
