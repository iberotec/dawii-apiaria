package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.TipoAlza;
import apiario.edu.pe.service.SeleccionService;

public class MBMantenimientoAlza implements Serializable{

	private SeleccionService service=new SeleccionService();
	private List<Alza> listaAlza=new ArrayList<Alza>();
	private Alza objAlza=new Alza();
	
	public String abrirMantenimientoAlza(){
		return "successMantenimientoAlza";
	}
	public String abrirNuevoAlza() throws Exception{
		limpiar();
		obtenerUltimo();
		return "successNuevoAlza";
	}
	public void listarTodos() throws Exception{
		listaAlza=service.listarTodosAlzas();
	}
	public void limpiar(){
		objAlza=new Alza();
		objAlza.setPiso(new Piso());
		objAlza.getPiso().setColmena(new Colmena());
		objAlza.getPiso().getColmena().setApiario(new Apiario());
		objAlza.setTipoAlza(new TipoAlza());
	}
	public void obtenerUltimo() throws Exception{
		List<Integer> listEntero=new ArrayList<Integer>();
		int alza=0;
		listEntero=service.obtenerMaximoIdAlza();
		alza=listEntero.get(0);
		alza=alza+1;
		objAlza.setIdAlza(alza);
	}
	public void eliminar(){
		
	}
	public void guardar() throws Exception{
		Alza confirmacion;
		confirmacion=service.guardarAlza(objAlza);
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
	public List<Alza> getListaAlza() {
		return listaAlza;
	}
	public void setListaAlza(List<Alza> listaAlza) {
		this.listaAlza = listaAlza;
	}
	public Alza getObjAlza() {
		return objAlza;
	}
	public void setObjAlza(Alza objAlza) {
		this.objAlza = objAlza;
	}
	
}
