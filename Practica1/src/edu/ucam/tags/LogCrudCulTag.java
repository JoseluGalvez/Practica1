package edu.ucam.tags;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import edu.ucam.beans.Cultivo;

public class LogCrudCulTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		//Declaro la lista de cultivos con su "casting" correspondiente.
		Hashtable <String, Cultivo> cultivos = (Hashtable <String, Cultivo>)this.pageContext.getServletContext().getAttribute("ATR_CULTIVOS");
		if (cultivos != null) {
			try {
				this.pageContext.getOut().println("Añadidos: "+this.pageContext.getSession().getAttribute("CUL_ADD")
						+"<br>Eliminados: "+this.pageContext.getSession().getAttribute("CUL_DEL")
						+"<br>Total de cultivos: "+ cultivos.size());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.EVAL_PAGE;
	}

}
