package apiario.edu.pe.modulo.seleccion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "jMBVerificarApiario")
@SessionScoped
public class MBVerificarApiario {

	
	public void init(){
		
		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		
	}

}
