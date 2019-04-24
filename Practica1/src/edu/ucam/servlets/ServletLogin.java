package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Usuario;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Recuperamos parámetros para hacer login
		String name = (request.getParameter("nombre")==null)?"":(request.getParameter("nombre"));
		String pass = (request.getParameter("pass")==null)?"":(request.getParameter("pass"));
		
		String jsp = "/index.jsp"; //jsp de respuesta
		
		if("admin".equals(name) && "admin".equals(pass)) {
			
			Usuario user = new Usuario (name, pass);
			request.getSession().setAttribute("USUARIO", user);
			jsp= "/list.jsp";
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
