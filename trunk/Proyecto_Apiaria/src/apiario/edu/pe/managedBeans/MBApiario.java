package apiario.edu.pe.managedBeans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBApiario implements Serializable{
	private Apiario apiario;
	private List<Apiario> lista = new ArrayList<Apiario>();
	private List<UsuarioApiario> listaUsuarioApiario = new ArrayList<UsuarioApiario>();
	private SeleccionService service= new SeleccionService();
	private String ubicacionApiario;
	private String onComplete;
	public MBApiario() {
		// TODO Auto-generated constructor stub
	}
	
	public List<UsuarioApiario> getListaUsuarioApiario() {
		return listaUsuarioApiario;
	}

	public void setListaUsuarioApiario(List<UsuarioApiario> listaUsuarioApiario) {
		this.listaUsuarioApiario = listaUsuarioApiario;
	}

	public String getOnComplete() {
		return onComplete;
	}

	public void setOnComplete(String onComplete) {
		this.onComplete = onComplete;
	}

	public String getUbicacionApiario() {
		return ubicacionApiario;
	}

	public void setUbicacionApiario(String ubicacionApiario) {
		this.ubicacionApiario = ubicacionApiario;
	}

	public Apiario getApiario() {
		return apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}

	public List<Apiario> getLista() {
		return lista;
	}

	public void setLista(List<Apiario> lista) {
		this.lista = lista;
	}
//	public void abrirNuevoRegistroAsignacionApiario() throws Exception{
////		System.out.println("entrando a asignar apiario");
////		String retorno="successMainSeleccion";
////		//Se esta verificando si en la temporada hay alguna etapa de seleccion
////		//y tambien se esta validando que el periodo final sea mayor a la fecha actual
////		//faltaria un campo mas  por que en esta tabla habria varios "seleccion" y tendria que diferenciarse
////		//el seleccion activo
//		List<Temporada> lista = new ArrayList<Temporada>();
//		lista = service.listarTodosTemporada();
//		Date fechaActual= new Date();
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println("periodo final" + lista.get(i).getPeriodoFinal()+" > "+fechaActual);
//			System.out.println("periodo final" + lista.get(i).getPeriodoFinal().getTime()+" > "+fechaActual.getTime());
//			if(lista.get(i).getEstadoEtapa().equals("seleccion") && lista.get(i).getPeriodoFinal().getTime()>fechaActual.getTime()){
//				System.out.println("correcto si esta en la etapa");
////				retorno="successMainSeleccion";
//			}else{
//				System.out.println("ya paso la etapa");
//				setOnComplete("dlg2.show();");
//				System.out.println("oncomplete "+getOnComplete());
//			}
////				setOnComplete("dlg2.show();");
////				System.out.println("ya paso la etapa");
//			}
////		}
//		
//	}
	public void abrirRegistroAsignacionApiario(){
		System.out.println("abrirRegistroAsignacionApiario");
		setOnComplete("dlg2.show();");
	}
	public void listarTodosUsuarioApiario(){
//		listaUsuarioApiario=service.listartodos
	}
	public String abrirAsignarApiario() throws Exception{
		limpiar();	
		return "successMainSeleccion";
	}
	
	public String abrirUbicacionApiario(){
		System.out.println("entrando a ubicacion apiario");
		limpiar();
		return "successUbicacion";
	}
	
	public String abrirMainCosecha(){
		System.out.println("Entrando a cosecha");
		limpiar();
		return "successMainCosecha";
	}
	
	public String abrirNuevaAsignacionCosecha(){
		System.out.println("Entro a nueva asignacion cosecha");
		limpiar();
		return "successNuevaAsignacionCosecha";
	}
	
	public void localizarApiario() throws Exception{
		System.out.println("entrega ubicacion");
		PlanillaSeguimiento obj= new PlanillaSeguimiento();
		obj.setApiario(new Apiario());
		obj.getApiario().setIdApiario(apiario.getIdApiario());
		List<PlanillaSeguimiento> listaPlanillaSeguimiento = new ArrayList<PlanillaSeguimiento>();
		listaPlanillaSeguimiento=service.buscarPlanillaSeguimiento(obj);
		
		for (int i = 0; i < listaPlanillaSeguimiento.size(); i++) {
			obj=listaPlanillaSeguimiento.get(0);
		}
		ubicacionApiario=obj.getZona().getUbigeo().getDistrito();
	}
	public void limpiar(){
		System.out.println("limpiando apiario");
		apiario= new Apiario();
	}
	
}