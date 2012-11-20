package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.service.SeleccionService;

@ManagedBean(name = "MBApiarioAsignado")
@SessionScoped
public class MBApiarioAsignado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Apiario> oList2 = new ArrayList<Apiario>();
	private SeleccionService serviceSeleccion = new SeleccionService();
	private IApiarioDAO daoApiario;
	
	
	public void listarApiarios(){
		
	}
	
	
	public void init(ActionEvent event) throws Exception {

		oList2 = serviceSeleccion.listarTodosApiarios();
	}

	public List<Apiario> getoList2() {
		return oList2;
	}

	public void setoList2(List<Apiario> oList2) {
		this.oList2 = oList2;
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
