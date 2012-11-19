package apiario.edu.pe.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

/**
 * @author Henry
 * 
 */
public class MBVerficaApiaria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SeleccionService se = new SeleccionService();
	private Apiario apiaria=new Apiario();
	private List<Apiario> listaapi = new ArrayList<Apiario>();
	List<Apiario> lista = new ArrayList<Apiario>();

	public MBVerficaApiaria() {
		
	}

	public List<Apiario> listar() throws Exception {

		List<Apiario> lista = se.listarTodosApiarios();
		return lista;
	}

	public void setApiaria(Apiario apiaria) {
		this.apiaria = apiaria;
	}

	public Apiario getApiaria() {
		return apiaria;
	}

	public List<Apiario> getListaapi() {
		return listaapi;
	}

	public void setListaapi(List<Apiario> listaapi) {
		this.listaapi = listaapi;
	}

	public List<Apiario> getLista() {
		return lista;
	}

	public void setLista(List<Apiario> lista) {
		this.lista = lista;
	}

}
