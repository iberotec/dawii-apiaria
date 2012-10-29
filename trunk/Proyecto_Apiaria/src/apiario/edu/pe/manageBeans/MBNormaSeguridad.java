package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.service.SeleccionService;

public class MBNormaSeguridad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SeleccionService service=new SeleccionService();
	Apiario apiario=new Apiario();
	List<Apiario> lista = new ArrayList<Apiario>();
	NormaSeguridad norma_Seguridad=new NormaSeguridad();

    private NormaSeguridad normaSeguridad;
    private List<NormaSeguridad>  listaNormaSeguridad=new ArrayList<NormaSeguridad>();
    
    public List<NormaSeguridad> load(){
    	List<NormaSeguridad> lista=null;
    	lista=service.listaNormaSeguridad(); 
    	return lista;
    }
    public List<Apiario> listar() {

		List<Apiario> lista = service.ListarTodos();
		return lista;
	}

    public void grabarDetApiNormSeg(ActionEvent event){
    	System.out.println("grabar");
    	    	
    	/*if(event.getComponent().getAttributes().get("item") instanceof Apiario)
    	setApiario((Apiario)event.getComponent().getAttributes().get("item"));
    	if(event.getComponent().getAttributes().get("item") instanceof NormaSeguridad)
    	setNorma_Seguridad((NormaSeguridad)event.getComponent().getAttributes().get("item"));
    	System.out.println(""+apiario.getIdapiario());
    	System.out.println(""+norma_Seguridad.getDescripcion());*/
    	//service.insertarDetalleApiarioNormaSeguridad(apiario, norma_Seguridad);
    }
	public SeleccionService getService() {
		return service;
	}
	public void setService(SeleccionService service) {
		this.service = service;
	}
	public Apiario getApiario() {
		return apiario;
	}
	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	public NormaSeguridad getNorma_Seguridad() {
		return norma_Seguridad;
	}
	public void setNorma_Seguridad(NormaSeguridad norma_Seguridad) {
		this.norma_Seguridad = norma_Seguridad;
	}
	public NormaSeguridad getNormaSeguridad() {
		return normaSeguridad;
	}
	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}
	public List<NormaSeguridad> getListaNormaSeguridad() {
		return listaNormaSeguridad;
	}
	public void setListaNormaSeguridad(List<NormaSeguridad> listaNormaSeguridad) {
		this.listaNormaSeguridad = listaNormaSeguridad;
	}
    
}
