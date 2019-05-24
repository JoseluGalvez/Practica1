package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ucam.beans.Finca;

public class AddFincaAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/secured/listFinca.jsp";
		System.out.println("Entro en AddFincaAction...");
		
		String name = (request.getParameter("name")==null)?"":(request.getParameter("name"));
		
		//Llamo a método que comprueba si hectareas es número
		if (isNumeric(request.getParameter("hectareas"))==true) { 
			int hectareas = (request.getParameter("hectareas")==null)?0:Integer.parseInt(request.getParameter("hectareas"));
			
			//Genero el id de la finca
				int atrContFin = (int)request.getServletContext().getAttribute("ATR_CONTFIN");
				String idFin = "FIN"+ atrContFin;
			//Incremento el atributo contador de Fincas
				request.getServletContext().setAttribute("ATR_CONTFIN", ++atrContFin);

				Finca finca = new Finca(idFin, hectareas, name);
				
				//Declaro la lista de fincas con su "casting" correspondiente.
				
				Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");
				
				//Si no tengo la lista de fincas la creo y la guardo en el contexto
				if (fincas == null) {
					fincas = new Hashtable<String, Finca>();
					request.getServletContext().setAttribute("ATR_FINCAS", fincas);
				}
				
				// Comprobamos si existe ese ID
			    if(fincas.containsKey(idFin)) {
					request.setAttribute("MSG", "Finca en la lista.");
			    }else {
					// Añado a la lista la finca creada con los parámetros recibidos (atributos)
					fincas.put(idFin, finca);
					//Incremento cantidad de cultivos añadidos por usuario actual en esta sesion
					int contAddCul = (int)request.getSession().getAttribute("FIN_ADD");
					request.getSession().setAttribute("FIN_ADD", ++contAddCul);
					request.setAttribute("MSG", "Finca ["+idFin+"] añadida.");
			    }
				return jsp;	
		}else{
            System.out.println("No es un numero");
            request.setAttribute("MSG", "Introduzca hectáreas en número");
        }
		return jsp;	
		
	}
	// Método que comprueba si es número
	public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
