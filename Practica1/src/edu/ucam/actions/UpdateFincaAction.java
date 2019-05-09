package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Finca;

public class UpdateFincaAction extends Action {

@Override
public String execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
String jsp = "/listFinca.jsp";
	
	System.out.println("Entro en UpdateFincaAction...");
	
	String idFin = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
	String name = (request.getParameter("name")==null)?"":(request.getParameter("name"));
	
	//Llamo a método que comprueba si hectareas es número
		if (isNumeric(request.getParameter("hectareas"))==true) { 
			int hectareas = (request.getParameter("hectareas")==null)?0:Integer.parseInt(request.getParameter("hectareas"));

			Finca finca = new Finca(idFin, hectareas, name);
			
			//Declaro la lista de fincas con su "casting" correspondiente.
			Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)request.getServletContext().getAttribute("ATR_FINCAS");
			
			//Si no tengo la lista de fincas la creo y la guardo en el contexto
			if(fincas == null) {
				fincas = new Hashtable<String,Finca>();		
				request.getServletContext().setAttribute("ATR_FINCAS", fincas);
			}
			
			// Añado a la lista la finca modificada con los datos incorporados y sobreescribo
			// los datos de esa finca en la lista de fincas
			fincas.put(idFin, finca);
			request.setAttribute("MSG", "Finca ["+idFin+"] modificada.");
			return jsp;
		}else{ //Si hectáreas no es número
            System.out.println("No es un numero");
            request.setAttribute("MSG", "Introduzca hectáreas en número");
            // AL recargar updateFinca tengo que volver a pasar los parámetros necesarios
            jsp = "/updateFinca.jsp?nombre="+name+"&idFin="+idFin;
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
