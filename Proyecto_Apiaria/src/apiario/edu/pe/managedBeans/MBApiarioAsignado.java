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
import apiario.edu.pe.bean.PlanillaRevision;
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
//	private Colmena objColmena;
	
	private DataModel<Colmena> listaColmena;
	
	private List<Colmena> listaColmenta=new ArrayList<Colmena>();
	
	SeleccionService service = new SeleccionService();
	private Colmena colmena;
	private List<Colmena> listaColmenas=new ArrayList<Colmena>();
	private PlanillaRevision objplanillaRevision;
	private Colmena objColmena;
	
	public MBApiarioAsignado() {
		limpiar();
		listColmenas();
	}
	
	public void limpiar(){
//		objColmena=new Colmena();

		setColmena(new Colmena());
		objplanillaRevision=new PlanillaRevision();
		objColmena=new Colmena();
		
	}
	
	public void listColmenas(){
		System.out.println("Entro Colmenas");
		try {
			objColmena.setApiario(new Apiario());
			objColmena.getApiario().setIdApiario(1);
			listaColmenas=service.buscarColmena(objColmena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarPlanillaRevision(){
		System.out.println("Llego al metodo de guardarPlanillaRevision");
		
		try {
			for (int i = 0; i < listaColmenas.size(); i++) {
				if(listaColmenas.get(i).isSel()){
					System.out.println("Colmena->"+listaColmenas.get(i).getIdColmena());
					objplanillaRevision.setColmena(new Colmena());
					objplanillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
				}
			}
			service.guardarPlanillaRevision(objplanillaRevision);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public List<Colmena> getListaColmenas() {
		return listaColmenas;
	}

	public void setListaColmenas(List<Colmena> listaColmenas) {
		this.listaColmenas = listaColmenas;
	}

	public PlanillaRevision getObjplanillaRevision() {
		return objplanillaRevision;
	}

	public void setObjplanillaRevision(PlanillaRevision objplanillaRevision) {
		this.objplanillaRevision = objplanillaRevision;
	}

	public Colmena getObjColmena() {
		return objColmena;
	}

	public void setObjColmena(Colmena objColmena) {
		this.objColmena = objColmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public Colmena getColmena() {
		return colmena;
	}

	public SeleccionService getService() {
		return service;
	}

	public void setService(SeleccionService service) {
		this.service = service;
	}


}
