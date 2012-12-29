package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.service.SeleccionService;

public class MBMantenimientoColmena implements Serializable{

	private SeleccionService service=new SeleccionService();
	private List<Colmena> listaColmena=new ArrayList<Colmena>();
	private Colmena objColmena=new Colmena();
	
	public String abrirMantenimientoColmena(){
		return "successMantenimientoColmena";
	}
	public String abrirNuevoColmena() throws Exception{
		limpiar();
		obtenerUltimo();
		return "successNuevoColmena";
	}
	public void listarTodos() throws Exception{
		listaColmena=service.listarTodosColmenas();
	}
	public void limpiar(){
		objColmena=new Colmena();
		objColmena.setApiario(new Apiario());
	}
	public void obtenerUltimo() throws Exception{
		List<Integer> listEntero=new ArrayList<Integer>();
		int colmena=0;
		listEntero=service.obtenerMaximoIdColmena();
		colmena=listEntero.get(0);
		colmena=colmena+1;
		objColmena.setIdColmena(colmena);
	}
	public void eliminar(){
		
	}
	public void guardar() throws Exception{
		Colmena confirmacion;
		confirmacion=service.guardarColmena(objColmena);
		if(confirmacion.isSuccess()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se guardo correctamente", ""));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se registro", ""));
		}
	}
	public SeleccionService getService() {
		return service;
	}
	public void setService(SeleccionService service) {
		this.service = service;
	}
	public List<Colmena> getListaColmena() {
		return listaColmena;
	}
	public void setListaColmena(List<Colmena> listaColmena) {
		this.listaColmena = listaColmena;
	}
	public Colmena getObjColmena() {
		return objColmena;
	}
	public void setObjColmena(Colmena objColmena) {
		this.objColmena = objColmena;
	}
	
}
