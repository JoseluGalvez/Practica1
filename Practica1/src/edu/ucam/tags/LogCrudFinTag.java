package edu.ucam.tags;

import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import edu.ucam.beans.Finca;

public class LogCrudFinTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		//Declaro la lista de fincas con su "casting" correspondiente.
		Hashtable <String, Finca> fincas = (Hashtable <String, Finca>)this.pageContext.getServletContext().getAttribute("ATR_FINCAS");
		if (fincas != null) {
			try {
				this.pageContext.getOut().println("Añadidas: "+this.pageContext.getSession().getAttribute("FIN_ADD")
						+"<br>Eliminadas: "+this.pageContext.getSession().getAttribute("FIN_DEL")
						+"<br>Total de fincas: "+ fincas.size());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.EVAL_PAGE;
	}

}
