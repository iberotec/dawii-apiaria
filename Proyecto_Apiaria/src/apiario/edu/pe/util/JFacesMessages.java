package apiario.edu.pe.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JFacesMessages implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String	SUCCESS = "SUCCESS";
	public static final String	ERROR = "ERROR";
	public static final String	WARNING = "WARNING";

	public static final void showFaceMessageInfo(String title, String message){
		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, message);		 
		 FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	public static final void showFaceMessageAlert(String title, String message){
		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, title, message);		 
		 FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	public static final void showFaceMessageError(String title, String message){
		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message);		 
		 FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	public static final void showFaceMessageFatal(String title, String message){
		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, title, message);		 
		 FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

}
