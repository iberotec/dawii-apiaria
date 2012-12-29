package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.service.SeleccionService;

public class MBMantenimientoPiso implements Serializable{

	private SeleccionService service=new SeleccionService();
	private List<Piso> listaPiso=new ArrayList<Piso>();
	private Piso objPiso=new Piso();
	
	
	public String abrirMantenimientoPiso(){
		return "successMantenimientoPiso";
	}
	public String abrirNuevoPiso() throws Exception{
		limpiar();
		obtenerUltimo();
		return "successNuevoPiso";
	}
	public void listarTodos() throws Exception{
		listaPiso=service.listarTodosPisos();
	}
	public void limpiar(){
		objPiso=new Piso();
		objPiso.setColmena(new Colmena());
		objPiso.getColmena().setApiario(new Apiario());
	}
	public void obtenerUltimo() throws Exception{
		List<Integer> listEntero=new ArrayList<Integer>();
		int piso=0;
		listEntero=service.obtenerMaximoIdPiso();
		piso=listEntero.get(0);
		piso=piso+1;
		objPiso.setIdPiso(piso);
	}
	public void eliminar(){
		
	}
	public void guardar() throws Exception{
		Piso confirmacion;
		confirmacion=service.guardarPiso(objPiso);
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
	public List<Piso> getListaPiso() {
		return listaPiso;
	}
	public void setListaPiso(List<Piso> listaPiso) {
		this.listaPiso = listaPiso;
	}
	public Piso getObjPiso() {
		return objPiso;
	}
	public void setObjPiso(Piso objPiso) {
		this.objPiso = objPiso;
	}
	
}
