package cibertec.edu.pe;

import java.io.File;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class JUtilities {

	public static String firstLetterUpper(String cadena) {
		String retorno = " ";
		
		if (cadena!=null && !cadena.trim().equals("")) {
			retorno = cadena.substring(0, 1).toUpperCase();
			retorno = retorno.concat(cadena.substring(1, cadena.length()).toLowerCase());
		}
				
		return retorno;
	}
	
	public static void redirect(String url){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e) {
			JMensajes.pinta("error al redireccionar");
		}
	}
	
	public static String upper(String cadena) {
		return cadena!=null ? cadena.toUpperCase() : cadena;
	}
	
	public static String lower(String cadena) {
		return cadena!=null ? cadena.toLowerCase() : cadena;
	}
	
	
	 
	public static String getAbsolutePath(String imageName) {
	    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	    StringBuilder logo = new StringBuilder().append(servletContext.getRealPath(""));
	    logo.append(File.separator).append("/resources/images/");
	    logo.append(File.separator).append(imageName);
	    return logo.toString();
	}
	
}