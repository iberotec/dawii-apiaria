package apiario.edu.pe.manageBeans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBApiario implements Serializable{
	private Apiario apiario;
	private List<Apiario> lista = new ArrayList<Apiario>();
	private SeleccionService service= new SeleccionService();
	private String ubicacionApiario;
	public MBApiario() {
		// TODO Auto-generated constructor stub
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
	public String abrirVerificarApiaria(){
		System.out.println("entrando a verificar apiario");
		limpiar();
		return "successMainSeleccion";
	}
	
	public String abrirUbicacionApiario(){
		System.out.println("entrando a ubicacion apiario");
		limpiar();
		return "successUbicacion";
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
