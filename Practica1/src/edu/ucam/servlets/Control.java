package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.Action;
import edu.ucam.actions.AddAction;
import edu.ucam.actions.AddCultivoAction;
import edu.ucam.actions.DeleteAction;
import edu.ucam.actions.DeleteCultivoAction;
import edu.ucam.actions.UpdateAction;
import edu.ucam.actions.UpdateCultivoAction;
import edu.ucam.actions.AddFincaAction;
import edu.ucam.actions.DeleteFincaAction;
import edu.ucam.actions.UpdateFincaAction;
import edu.ucam.beans.Usuario;

/**
 * Servlet implementation class Control
 */
@WebServlet(urlPatterns= {"/Control"}, name="Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private Hashtable<String, Action> acciones;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init() throws ServletException {
		super.init();
		
		if (acciones == null) {
			
					//Lista de acciones
			acciones = new Hashtable<String, Action>();
			acciones.put("ADD", new AddAction());
			acciones.put("DELETE", new DeleteAction());
			acciones.put("UPDATE", new UpdateAction());
			acciones.put("ADDFI", new AddFincaAction());
			acciones.put("DELETEFI", new DeleteFincaAction());
			acciones.put("UPDATEFI", new UpdateFincaAction());
			acciones.put("ADDCUL", new AddCultivoAction());
			acciones.put("DELETECUL", new DeleteCultivoAction());
			acciones.put("UPDATECUL", new UpdateCultivoAction());
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/secured/principal.jsp"; //página de inicio tras loguearse
		//Comprobamos si existe usuario "Logueado"
		Usuario usuario = (Usuario)request.getSession().getAttribute("USUARIO_LOGED");
		
		if (usuario != null) {
			//Cogemos el parámetro que llega para identificar la acción a realizar
			String actionId = request.getParameter("ACTION_ID");
			Action accion = this.acciones.get(actionId); 
			
			//La jsp de respuesta dependerá de la acción que se ha realizado
			jsp = accion.execute(request, response);
									
		}else { //No se está "Logueado"
			jsp="/index.jsp";
			request.setAttribute("MSG", "Acceso restringido");
		}
		
		request.getRequestDispatcher(jsp).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
