package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.Action;
import edu.ucam.beans.Usuario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;


/**
 * Servlet implementation class Control
 */
@WebServlet(urlPatterns= {"/Control"}, name="Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ACTION_ID = "ACTION_ID";
	
		private Hashtable<String, Action> actions;
       
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
		
		//System.out.print("Inicializando...");
		
		//Obtenemos la ruta al fichero donde est�n definidas todas las acciones.
		String filePath = this.getServletContext().getRealPath("WEB-INF/acciones.properties");
		//System.out.println(filePath);
		
			try {
				Properties propiedades = new Properties();
				propiedades.load(new FileReader(filePath));
				
				String accionesStr = propiedades.getProperty("acciones");
				String acciones[] = accionesStr.split(" ");
				
				//Creamos un objeto de cada accion y lo guardamos en la tabla hash
				Action accion = null;
				this.actions = new Hashtable<String, Action>();
				for(int i = 0; i < acciones.length;i++){
					accion = (Action)Class.forName(propiedades.getProperty(acciones[i])).newInstance();
					this.actions.put(acciones[i], accion);
				}
				
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			} catch (ClassNotFoundException e) {
			}
			
			//System.out.println("[ok]");
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
			String actionId = request.getParameter(Control.ACTION_ID);
			Action accion = this.actions.get(actionId); 
			
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

		doGet(request, response);
	}



}
