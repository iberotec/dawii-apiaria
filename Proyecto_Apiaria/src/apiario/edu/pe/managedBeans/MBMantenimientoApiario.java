package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Ubigeo;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.service.SeleccionService;

public class MBMantenimientoApiario implements Serializable{

	private SeleccionService service=new SeleccionService();
	private List<Apiario> listaApiario=new ArrayList<Apiario>();
	private Apiario objApiario=new Apiario();
	private Ubigeo objUbigeo=new Ubigeo();
	
	public String abrirMantenimientoApiario(){
		return "successMantenimientoApiario";
	}
	public String abrirNuevoApiario() throws Exception{
		obtenerUltimo();
		return "successNuevoApiario";
	}
	public void listarTodos() throws Exception{
		listaApiario=service.listarTodosApiarios();
	}
	public void limpiar(){
		objApiario=new Apiario();
		objUbigeo=new Ubigeo();
	}
	public void obtenerUltimo() throws Exception{
		List<Integer> listEntero=new ArrayList<Integer>();
		int apiario=0;
		listEntero=service.obtenerMaximoIdApiario();
		apiario=listEntero.get(0);
		apiario=apiario+1;
		objApiario.setIdApiario(apiario);
	}
//	public void abrirEliminar(){
//		limpiarMessage();
//		int cont=0;
//			for(int i=0;i<lista.size();i++){
//	    		if(lista.get(i).isSel()){
//	    			cont++;   			
//	    		}
//	    	}
//		if (cont>0){
//			setSeleccionados(cont);
//			setOncomplete("Richfaces.showModalPanel('mpEliminar')");
//		}else{
//			setOncomplete("alert('Seleccionar un registro')");
//		}
//	}	
	public void eliminar(){
		Apiario confirmacion;
		List<Integer> lista2=new ArrayList<Integer>();
		try {
			int cont=0;
			for (int i = 0; i < listaApiario.size(); i++) {
				if(listaApiario.get(i).isSel()){
					lista2.add(listaApiario.get(i).getIdApiario());
					cont++;
				}
				if(cont>0){
					confirmacion=service.eliminarApiario(objApiario);
					listarTodos();
					if(confirmacion.isSuccess()){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro(s) elmininado(s) satisfactoriamente", ""));
					}else{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se pudieron eliminar los registros", ""));
					}
				}
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error Fatal", ""));
		}
	}
	public void guardar() throws Exception{
		Apiario confirmacion;
		confirmacion=service.guardarApiario(objApiario);
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
	public List<Apiario> getListaApiario() {
		return listaApiario;
	}
	public void setListaApiario(List<Apiario> listaApiario) {
		this.listaApiario = listaApiario;
	}
	public Apiario getObjApiario() {
		return objApiario;
	}
	public void setObjApiario(Apiario objApiario) {
		this.objApiario = objApiario;
	}
	public Ubigeo getObjUbigeo() {
		return objUbigeo;
	}
	public void setObjUbigeo(Ubigeo objUbigeo) {
		this.objUbigeo = objUbigeo;
	}
}
