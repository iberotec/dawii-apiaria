package apiario.edu.pe.manageBeans.seleccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "jMBVerificarApiario")
@SessionScoped
public class MBVerificarApiario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{jMBApiarioAsignado}")
	private MBApiarioAsignado oaa;
	@ManagedProperty("#{jMBControlCalidadApiario}")
	private MBControlCalidadApiario occ;
	List<String> oList=new ArrayList<String>();
	List<String> oCheck;
	
	List<String> oList2=new ArrayList<String>();;
	
	public void load2(){
		
		
		oList2.add("Tarma");
		oList2.add("Tambo");
		oList2.add("La merced");
	}
	
	public void load()throws Exception{
		
		
		oList.add("Tarma");
		oList.add("Tambo");
		oList.add("La merced");
		
		oCheck=new ArrayList<String>();
		oCheck.add("Distancia entre apiarios(2 a 3 KM)");
		oCheck.add("Flora melifera adecuada");
		oCheck.add("Fuente natural de agua o bebederos adecuados");
		oCheck.add("Aguas contaminadas o residuales a 2km de distancia");
		oCheck.add("Zona apropiada no humedas, no calurosas");
		oCheck.add("Distancia entre vias publicas 200 km");
		oCheck.add("Posicionamiento adecuado de piqueras");
		
		
	}
	public void init(ActionEvent event)throws Exception{
		load2();
		occ.init(event);
		load();
		
		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		
	}
	public List<String> getoCheck() {
		return oCheck;
	}

	public void setoCheck(List<String> oCheck) {
		this.oCheck = oCheck;
	}

	


	public List<String> getoList() {
		return oList;
	}


	public void setoList(List<String> oList) {
		this.oList = oList;
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
