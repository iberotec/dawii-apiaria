package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IColmenaDAO;
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
	private Colmena objColmena;
	
	private DataModel<Colmena> listaColmena;
	
	private List<Colmena> listaColmenta=new ArrayList<Colmena>();
	
	public void limpiar(){
		objColmena=new Colmena();
		
		
	}
	
	public void buscarColmenaxComboApiario() throws Exception{
		listaColmenta=serviceSeleccion.buscarColmena(objColmena);
		
		System.out.println("entro al metodo???");
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


	public IApiarioDAO getDaoApiario() {
		return daoApiario;
	}


	public void setDaoApiario(IApiarioDAO daoApiario) {
		this.daoApiario = daoApiario;
	}

	public List<Colmena> getListaColmenta() {
		return listaColmenta;
	}


	public void setListaColmenta(List<Colmena> listaColmenta) {
		this.listaColmenta = listaColmenta;
	}

	public void setListaColmena(DataModel<Colmena> listaColmena) {
		this.listaColmena = listaColmena;
	}

	public DataModel<Colmena> getListaColmena() {
		return listaColmena;
	}


}
