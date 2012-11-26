package apiario.edu.pe.managedBeans;

import java.io.Serializable;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadApiario;
import apiario.edu.pe.service.SeleccionService;

public class MBNormaSeguridadApiario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NormaSeguridadApiario normaSeguridadApiario;
	private SeleccionService service=new SeleccionService();
	
	public MBNormaSeguridadApiario() {
		limpiarNormaSeguridadApiario();
	}
	
	public void limpiarNormaSeguridadApiario(){
		normaSeguridadApiario=new NormaSeguridadApiario();
		normaSeguridadApiario.setApiario(new Apiario());
		normaSeguridadApiario.setNormaSeguridad(new NormaSeguridad());
	}
	
	public void guardarNormaSeguridadApiario(){
		System.out.println("entro al metodo guardarNormaSeguridadApiario");
		try {
			service.guardarNormaSeguridadApiario(normaSeguridadApiario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public NormaSeguridadApiario getNormaSeguridadApiario() {
		return normaSeguridadApiario;
	}
	public void setNormaSeguridadApiario(NormaSeguridadApiario normaSeguridadApiario) {
		this.normaSeguridadApiario = normaSeguridadApiario;
	}
	public SeleccionService getService() {
		return service;
	}
	public void setService(SeleccionService service) {
		this.service = service;
	}
	
}
