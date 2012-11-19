package apiario.edu.pe.util;

import java.io.File;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class JUtilities {

	public static String firstLetterUpper(String cadena) {
		String retorno = " ";
		System.out.println("cadena "+cadena);
		if (cadena!=null && !cadena.trim().equals("")) {
			retorno = cadena.substring(0, 1).toUpperCase();
			retorno = retorno.concat(cadena.substring(1, cadena.length()).toLowerCase());
		}
				System.out.println("retorno "+retorno);
		return retorno;
	}
	
	public static void redirect(String url){
		System.out.println("url "+url);
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e) {
			JMensajes.pinta("error al redireccionar");
		}
	}
	
	public static String upper(String cadena) {
		System.out.println("cadenaupper"+cadena);
		return cadena!=null ? cadena.toUpperCase() : cadena;
	}
	
	public static String lower(String cadena) {
		System.out.println("cadenalowe"+cadena);
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