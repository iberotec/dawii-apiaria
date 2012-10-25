package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;
import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "MBVerificarApiario")
@SessionScoped
public class MBVerificarApiario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{MBApiarioAsignado}")
	private MBApiarioAsignado oaa;
	@ManagedProperty("#{MBControlCalidadApiario}")
	private MBControlCalidadApiario occ;
	List<Apiario> oList=new ArrayList<Apiario>();
	List<String> oCheck;
	
	SeleccionService serviceSeleccion = new SeleccionService();
	
	List<String> oList2=new ArrayList<String>();;
	
	
	
	public void init(ActionEvent event)throws Exception{
		oList=serviceSeleccion.ListarTodos();
for (Apiario aux : oList) {
	System.out.println(""+aux.getIdapiario());
}
		oaa.init(event);
		
		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		
	}
	public List<String> getoCheck() {
		return oCheck;
	}

	public void setoCheck(List<String> oCheck) {
		this.oCheck = oCheck;
	}

	


	public List<Apiario> getoList() {
		return oList;
	}
	public void setoList(List<Apiario> oList) {
		this.oList = oList;
	}
	public SeleccionService getServiceSeleccion() {
		return serviceSeleccion;
	}
	public void setServiceSeleccion(SeleccionService serviceSeleccion) {
		this.serviceSeleccion = serviceSeleccion;
	}
	public List<String> getoList2() {
		return oList2;
	}
	public void setoList2(List<String> oList2) {
		this.oList2 = oList2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MBApiarioAsignado getOaa() {
		return oaa;
	}
	public void setOaa(MBApiarioAsignado oaa) {
		this.oaa = oaa;
	}
	public MBControlCalidadApiario getOcc() {
		return occ;
	}
	public void setOcc(MBControlCalidadApiario occ) {
		this.occ = occ;
	}
	

}
