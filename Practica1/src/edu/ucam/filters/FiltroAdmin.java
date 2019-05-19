package edu.ucam.filters;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;

import edu.ucam.actions.Action;
import edu.ucam.beans.Usuario;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter(filterName = "FiltroAdmin", servletNames = {"Control"})
public class FiltroAdmin implements Filter {
	Hashtable<String, String> accionesAdmin =new Hashtable<String,String>();
	
    public FiltroAdmin() {

    	// Acciones de administrador
    	accionesAdmin.put("ADD", "Para acceder a AddAction");
    	accionesAdmin.put("DELETE", "Para acceder a DeleteAction");
    	accionesAdmin.put("UPDATE", "Para acceder a UpdateAction"); 
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Comprobamos si existe usuario "Logueado"
				Usuario usuario = (Usuario)((HttpServletRequest) request).getSession().getAttribute("USUARIO_LOGED");
				//Cogemos el parámetro que llega para identificar la acción a realizar
				String actionId = request.getParameter("ACTION_ID");
				if (usuario != null) {
					
					 if(accionesAdmin.containsKey(actionId)) {
						 if(usuario.isAdmin()) {
							 chain.doFilter(request, response);
						 }else {
							request.setAttribute("MSG", "Debe ser administrador");
							request.getRequestDispatcher("/index.jsp").forward(request, response);
						 }
					 }else { // No es acción de Administrador
						 chain.doFilter(request, response);
					 }					
				}else {
					request.setAttribute("MSG", "Haga LOGIN para acceder");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
