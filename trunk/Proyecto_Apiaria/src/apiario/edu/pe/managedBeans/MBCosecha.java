package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Centrifugadora;
import apiario.edu.pe.service.SeleccionService;

public class MBCosecha implements Serializable{

	SeleccionService sevice=new SeleccionService();
	private List<Alza> listaAlzas=new ArrayList<Alza>();
	private List<Centrifugadora> listaCentrifugadora=new ArrayList<Centrifugadora>();
//	private List<PlanillaCosecha> listaPlanillaCosecha=new ArrayList<PlanillaCosecha>();
//	private List<DetalleCentrifugadoraPlanillaCosecha> listaDetalleCentrifugadoraPlanillaCosecha=new ArrayList<DetalleCentrifugadoraPlanillaCosecha>();
	
	public String abrirMainCosecha(){
		return "successMainCosechaa";
	}
	public String abrirNuevaAsignacionCosecha() throws Exception{
		listarAlza();
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

	
}
