package apiario.edu.pe.manageBeans;

import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

/**
 * @author Henry
 *
 */
public class MBAPIARIA {
	private 	Apiario apiaria;
	private List<Apiario> listaapi=new ArrayList<Apiario>();
	List<Apiario> lista=new ArrayList<Apiario>();	
		public MBAPIARIA(){
			listar();
		}
		public List<Apiario> listar(){
			SeleccionService se=new SeleccionService();
			List<Apiario> lista=se.ListarTodos();
			System.out.println(""+lista.size());
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
