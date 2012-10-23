package apiario.edu.pe.modulo.seleccion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "jMBVerificarApiario")
@SessionScoped
public class MBVerificarApiario {

	
	List<String> oList;
	public MBVerificarApiario(){
		oList=new ArrayList<String>();
		oList.add("Tarma");
		oList.add("Tambo");
		oList.add("La merced");
	}
	
	public void init(){
		
		
		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		
	}


	public List<String> getoList() {
		return oList;
	}


	public void setoList(List<String> oList) {
		this.oList = oList;
	}

}
