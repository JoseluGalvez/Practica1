package edu.ucam.servlets;

import java.io.IOException;
import java.util.Enumeration;
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
@WebServlet("/ServletLogin2")
public class ServletLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin2() {
        super();
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	//Creamos el primer usuario Administrador para poder acceder
		String idUsu = "ADM00";
		int idUsuInt = 00; //int idUsuInt = Integer.parseInt(idUsu);

		Usuario admin = new Usuario (idUsu, "admin", "istrator", "admin");
		Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
		
			//Lista de usuarios iniciales
	usuarios.put(idUsu, admin);
			// La agrego al contexto para tenerla accesible por todos
	getServletContext().setAttribute("ATR_USUARIOS", usuarios);
			//Creamos en el contexto un contador que definirá la ID de usuario
	getServletContext().setAttribute("ATR_IDUSU", idUsuInt);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Recuperamos parámetros para hacer login
		String name = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
		String pass = (request.getParameter("pass")==null)?"":(request.getParameter("pass"));
		
		String jsp = "/index.jsp"; //jsp de respuesta

		//Buscamos el usuario por su nombre en la tabla de usuarios.
		//tendremos que recorrerlo entero porque el nombre no es la clave
		
	    Hashtable<String, Usuario> usuarios= (Hashtable<String, Usuario>) getServletContext().getAttribute("ATR_USUARIOS");
		Enumeration<String> llaves = usuarios.keys();
		Usuario user = ((Hashtable<String, Usuario>)request.getServletContext().getAttribute("ATR_USUARIOS")).get(name);
		boolean existe = false;
		boolean correcto = false;
	    while (llaves.hasMoreElements()) {
	     // System.out.println(""+"hashtable llaves: " + llaves.nextElement() + "Nombre: " + usuarios.get(llaves).getName());
	      if (usuarios.get(llaves).getName().equals(name)){ //nombre correcto
	    	  existe = true;
	    	  if (usuarios.get(llaves).getPass().equals(pass)){	//pass correcta		
					request.getSession().setAttribute("USUARIO_LOGED", user);
					jsp= "/list.jsp";
					correcto = true;
				}else{	//Si no es correcta y no ha sido encontrada anteriormente
					if (correcto == false)	{ //Pueden haber varios usuarios con mismo nombre
						//informamos al usuario mediante un mensaje en la JSP.
						request.setAttribute("MSG", "Pass usuario incorrecta");
						}					
				}
	      }
	    } //FIN de búsqueda
	    if (existe == false) {
			request.setAttribute("MSG", "Usuario no encontrado");
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
