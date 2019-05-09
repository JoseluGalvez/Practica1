package edu.ucam.actions;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ucam.beans.Cultivo;

public class AddCultivoAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp ="/listCultivo.jsp";
		System.out.println("Entro en AddCultivoAction...");
		
		String name = (request.getParameter("name")==null)?"":(request.getParameter("name"));
			
			//Genero el id del cultivo
				int atrContCul = (int)request.getServletContext().getAttribute("ATR_CONTCUL");
				String idCul = "CUL"+ atrContCul;
			//Incremento el atributo contador de Cultivos
				request.getServletContext().setAttribute("ATR_CONTCUL", ++atrContCul);

				Cultivo cultivo = new Cultivo(idCul, name);
				
				//Declaro la lista de cultivos con su "casting" correspondiente.
				
				Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)request.getServletContext().getAttribute("ATR_CULTIVOS");
				
				//Si no tengo la lista de cultivos la creo y la guardo en el contexto
				if (cultivos == null) {
					cultivos = new Hashtable<String, Cultivo>();
					request.getServletContext().setAttribute("ATR_CULTIVOS", cultivos);
				}
				
				// Comprobamos si existe ese ID
			    if(cultivos.containsKey(idCul)) {
					request.setAttribute("MSG", "Cultivo en la lista.");
			    }else {
					// Añado a la lista el cultivo creado con los parámetros recibidos (atributos)
					cultivos.put(idCul, cultivo);
					request.setAttribute("MSG", "Cultivo ["+idCul+"] añadido.");
			    }
				return jsp;			
	}
}
