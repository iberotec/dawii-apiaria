package apiario.edu.pe.modulo.seleccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "jMBApiarioAsignado")
@SessionScoped
public class MBApiarioAsignado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> oList2=new ArrayList<String>();
	
	public MBApiarioAsignado(){
		load();
	}
public void load(){
	
	
	oList2.add("Tarma");
	oList2.add("Tambo");
	oList2.add("La merced");
}
public void init(ActionEvent event)throws Exception{
	load();
	
	
}
public List<String> getoList2() {
	return oList2;
}
public void setoList2(List<String> oList2) {
	this.oList2 = oList2;
}




}
