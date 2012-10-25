package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

@ManagedBean(name = "MBControlCalidadApiario")
@SessionScoped
public class MBControlCalidadApiario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> oList1 = new ArrayList<String>();
	SeleccionService serviceSeleccion = new SeleccionService();

	public MBControlCalidadApiario() {
		load();
	}

	public List<String> load() {

		oList1.add("distancia entre apiarios");
		oList1.add("flora melifera adecuada");
		oList1.add("Fuente natural de agua o bebederos adecuados");
		oList1.add("Aguas contaminadas o residuales  a 2km de distancia");
		oList1.add("Zona adecuada (no humeda,no caluros)");
		oList1.add("Distancia entre via publica 200m");
		oList1.add("posicionamiento adecuado de piqueras");
		
		return oList1;
	}

	public void grabarCC(String[] arr){
		
	}

	public List<String> getoList1() {
		return oList1;
	}

	public void setoList1(List<String> oList1) {
		this.oList1 = oList1;
	}

	public SeleccionService getServiceSeleccion() {
		return serviceSeleccion;
	}

	public void setServiceSeleccion(SeleccionService serviceSeleccion) {
		this.serviceSeleccion = serviceSeleccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
