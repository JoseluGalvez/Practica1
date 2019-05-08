package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Cultivo;

public class UpdateCultivoAction extends Action {

@Override
public String execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
String jsp = "/listCultivo.jsp";
	
	System.out.println("Entro en UpdateCultivoAction...");
	
	String idCul = (request.getParameter("idCul")==null)?"":(request.getParameter("idCul"));
	String name = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));

			Cultivo cultivo = new Cultivo(idCul, name);
			
			//Declaro la lista de cultivos con su "casting" correspondiente.
			Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOSS");
			
			//Si no tengo la lista de cultivos la creo y la guardo en el contexto
			if(cultivos == null) {
				cultivos = new Hashtable<String,Cultivo>();		
				request.getServletContext().setAttribute("ATR_CULTIVOS", cultivos);
			}
			
			// Añado a la lista el cultivo modificada con los datos incorporados y sobreescribo
			// los datos de ese cultivo en la lista de cultivos
			cultivos.put(idCul, cultivo);
			request.setAttribute("MSG", "Cultivo modificado.");
			return jsp;

		}
}
