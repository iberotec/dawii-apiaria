package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Centrifugadora;
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBCosecha implements Serializable{
	/**
	 * 
	 */
	private UsuarioDecantadoraCentrifugadora oUsuarioDecantadoraCentrifugadora=new UsuarioDecantadoraCentrifugadora();
	SeleccionService sevice=new SeleccionService();
	private List<Alza> listaAlzas=new ArrayList<Alza>();
	private List<Centrifugadora> listaCentrifugadora=new ArrayList<Centrifugadora>();
//	private List<PlanillaCosecha> listaPlanillaCosecha=new ArrayList<PlanillaCosecha>();
//	private List<DetalleCentrifugadoraPlanillaCosecha> listaDetalleCentrifugadoraPlanillaCosecha=new ArrayList<DetalleCentrifugadoraPlanillaCosecha>();
	private DualListModel<PlanillaCosechaAlza> listaPCA=new DualListModel<PlanillaCosechaAlza>();
	public String abrirMainCosecha(){
		return "successMainCosechaa";
	}
	public String abrirNuevaAsignacionCosecha() throws Exception{
		return "successNuevaAsignacionCosechaa";
	}
	public void listarTodosCosechas() throws Exception{
		listarCentrifugadoras();
	}
	public void listarCentrifugadoras() throws Exception{
		listaCentrifugadora=sevice.listarTodosCentrifugadoras();
//		listaPlanillaCosecha=sevice.listarTodosPlanillaCosechas();
//		listaDetalleCentrifugadoraPlanillaCosecha=sevice.listarTodosDetalleCentrifugadoraPlanillaCosechas();
	}
	public void listarAlza() throws Exception{
		listaAlzas=sevice.listarTodosAlzas();
	}
	
	
	
	public List<Alza> getListaAlzas() {
		return listaAlzas;
	}
	public void setListaAlzas(List<Alza> listaAlzas) {
		this.listaAlzas = listaAlzas;
	}
	public SeleccionService getSevice() {
		return sevice;
	}
	public void setSevice(SeleccionService sevice) {
		this.sevice = sevice;
	}
	public List<Centrifugadora> getListaCentrifugadora() {
		return listaCentrifugadora;
	}
	public void setListaCentrifugadora(List<Centrifugadora> listaCentrifugadora) {
		this.listaCentrifugadora = listaCentrifugadora;
	}
	public UsuarioDecantadoraCentrifugadora getoUsuarioDecantadoraCentrifugadora() {
		return oUsuarioDecantadoraCentrifugadora;
	}
	public void setoUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora oUsuarioDecantadoraCentrifugadora) {
		this.oUsuarioDecantadoraCentrifugadora = oUsuarioDecantadoraCentrifugadora;
	}
	public void setListaPCA(DualListModel<PlanillaCosechaAlza> listaPCA) {
		this.listaPCA = listaPCA;
	}
	@SuppressWarnings("unchecked")
	public DualListModel<PlanillaCosechaAlza> getListaPCA() throws Exception {
		listaPCA=(DualListModel<PlanillaCosechaAlza>) sevice.listarTodosAlzas();
		return listaPCA;
	}
	

	
}
