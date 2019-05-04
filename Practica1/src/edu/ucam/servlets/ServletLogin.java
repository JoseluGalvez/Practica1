package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ucam.beans.Usuario;

//import edu.ucam.actions.Action;
//import edu.ucam.actions.AddAction;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
	//Creamos el primer usuario Administrador para poder acceder
		String idUsu = "admin";

		Usuario admin = new Usuario (idUsu, "Admin", "Istrator", "admin");
		Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
		
			// Lista de usuarios iniciales
	usuarios.put(idUsu, admin);
			// La agrego al contexto para tenerla accesible por todos
	getServletContext().setAttribute("ATR_USUARIOS", usuarios);		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Recuperamos parámetros que contienen las credenciales para hacer login
		String idUsu = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
		String pass = (request.getParameter("pass")==null)?"":(request.getParameter("pass"));
		
		String jsp = "/index.jsp"; //jsp de respuesta
		
		// Si no ha introducido credenciales
		if (idUsu=="" || pass=="") {
			request.setAttribute("MSG", "Complete los campos [Usuario] y [Contraseña]");
		}else {
			// Recupero usuarios.
		    Hashtable<String, Usuario> usuarios= (Hashtable<String, Usuario>) getServletContext().getAttribute("ATR_USUARIOS");
			// Comprobamos que existe ese ID
		    if(usuarios.containsKey(idUsu)) {
		    	if(usuarios.get(idUsu).getPass().equals(pass)) {
		    		// Usuario y pass correctos
		    		Usuario user = usuarios.get(idUsu);
		    		request.getSession().setAttribute("USUARIO_LOGED", user);
		    		jsp = "/list.jsp"; //jsp de respuesta Logueado
		    	}else {
					request.setAttribute("MSG", "Contraseña incorrecta");
		    	}
		    }else {
				request.setAttribute("MSG", "Usuario no encontrado. Si sigue sin poder entrar comuníquelo a un administrador.");
		    }
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
