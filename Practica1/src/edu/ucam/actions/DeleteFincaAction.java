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
		String jsp ="/secured/listFinca.jsp";
		System.out.println("Entro en DeleteFincaAction...");
		
		String idFin = request.getParameter("idFin");
				
		//Recupero la lista de fincas con su "casting" correspondiente.
		Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");
		
		if (fincas != null) {
			
			// Comprobamos si existe ese ID
		    if(fincas.containsKey(idFin)) {
		    	fincas.remove(idFin);
		    	
				//Incremento cantidad de fincas eliminadas por usuario actual en esta sesion
				int contDelFin = (int)request.getSession().getAttribute("FIN_DEL");
				request.getSession().setAttribute("FIN_DEL", ++contDelFin);
		    	
				request.setAttribute("MSG", "Finca ["+idFin+"] eliminada");
		    }else {
			request.setAttribute("MSG", "Finca ["+idFin+"] no encontrada");
		    }
		}
		return jsp;
	}

}
