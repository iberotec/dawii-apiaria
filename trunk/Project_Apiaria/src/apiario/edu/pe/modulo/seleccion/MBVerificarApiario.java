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
	List<String> oCheck;
	public MBVerificarApiario(){
		oList=new ArrayList<String>();
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
	
	public List<String> getoCheck() {
		return oCheck;
	}

	public void setoCheck(List<String> oCheck) {
		this.oCheck = oCheck;
	}

	public void init(){
		
//		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		 JUtilities.redirect("/seleccion/layouts/main.xhtml");
		
		 JUtilities.redirect("/functionality/modseleccion/fMain.xhtml");
		
	}


	public List<String> getoList() {
		return oList;
	}


	public void setoList(List<String> oList) {
		this.oList = oList;
	}

}
