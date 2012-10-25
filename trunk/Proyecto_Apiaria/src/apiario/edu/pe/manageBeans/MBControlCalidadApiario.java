package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

@ManagedBean(name = "MBControlCalidadApiario")
@SessionScoped
public class MBControlCalidadApiario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Apiario> oList1 = new ArrayList<Apiario>();
	SeleccionService serviceSeleccion = new SeleccionService();

	public MBControlCalidadApiario() {

	}

	public void init(ActionEvent event) throws Exception {

		oList1 = serviceSeleccion.ListarTodos();
	}

	public List<Apiario> getoList1() {
		return oList1;
	}

	public void setoList1(List<Apiario> oList1) {
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
