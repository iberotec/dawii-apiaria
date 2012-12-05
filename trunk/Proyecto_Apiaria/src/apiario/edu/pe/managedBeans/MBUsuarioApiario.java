package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBUsuarioApiario implements Serializable{
	private UsuarioApiario usuarioApiario;
	private List<UsuarioApiario> listaUsarioApiario = new ArrayList<UsuarioApiario>();
	private SeleccionService service = new SeleccionService();
	private String ubicacionApiario;
	
	
	public String getUbicacionApiario() {
		return ubicacionApiario;
	}
	public void setUbicacionApiario(String ubicacionApiario) {
		this.ubicacionApiario = ubicacionApiario;
	}
	public UsuarioApiario getUsuarioApiario() {
		return usuarioApiario;
	}
	public void setUsuarioApiario(UsuarioApiario usuarioApiario) {
		this.usuarioApiario = usuarioApiario;
	}
	public List<UsuarioApiario> getListaUsarioApiario() {
		return listaUsarioApiario;
	}
	public void setListaUsarioApiario(List<UsuarioApiario> listaUsarioApiario) {
		this.listaUsarioApiario = listaUsarioApiario;
	}

	public MBUsuarioApiario() {
		// TODO Auto-generated constructor stub
	}
	
	public void limpiarNuevaAsignacion(){
		System.out.println("limpiarNuevaAsignacion");
		usuarioApiario= new UsuarioApiario();
		usuarioApiario.setApiario(new Apiario());
		ubicacionApiario="";
	}
	public String abrirNuevaAsignacion(){
		System.out.println("abriendo nueva asignacion");
		limpiarNuevaAsignacion();
		return "successNuevaAsignacion";
	}
	public void listarTodosUsuarioApiario() throws Exception{
		System.out.println("entro a listartodos");
		listaUsarioApiario = service.listarTodosUsuarioApiario();
		System.out.println("tama�o de la lista en listarTodos"+listaUsarioApiario.size());
	}
	public String obtenerNivelPeligro(Set<PlanillaRevision> set){
		String retorno="";
		System.out.println("tama�o lista nivel peligro "+set.size());
		if(set.size()>0){
			System.out.println("paso primer if");
			for (PlanillaRevision planillaRevision : set) {
				System.out.println("entro al for");
				if(planillaRevision!=null){
					System.out.println("entro al segundo if");
					System.out.println("id "+planillaRevision.getIdPlanillaRevision());
					System.out.println("id reina "+planillaRevision.getReina().getIdReina());
					if(planillaRevision.getEstadoRevision()!=null){
						System.out.println("entro al tercer if");
						if(planillaRevision.getEstadoRevision().getDescripcionEstadoRevision()!=null &&
								planillaRevision.getEstadoRevision().getDescripcionEstadoRevision().length()>0){
							System.out.println("entro al cuerto if");
							retorno= planillaRevision.getEstadoRevision().getDescripcionEstadoRevision();
							System.out.println("retorno "+retorno);
						}
					}
				}
				
			}
		}
		
		return retorno;
	}
	public String obtenerProvincia(Set<PlanillaSeguimiento> set){
		String retorno="";
		System.out.println("tama�o planilla seguimiento provincia"+set.size());
		if(set.size()>0){
			System.out.println("entro al primer if");
			for (PlanillaSeguimiento planillaSeguimiento : set) {
				System.out.println("entro al for");
				if(planillaSeguimiento!=null){
					System.out.println("entro al segundo if");
					if(planillaSeguimiento.getZona()!=null){
						System.out.println("entro al tercer if");
						if(planillaSeguimiento.getZona().getUbigeo()!=null){
							System.out.println("entro al cuarto if");
							if(planillaSeguimiento.getZona().getUbigeo().getProvincia()!=null &&
									planillaSeguimiento.getZona().getUbigeo().getProvincia().length()>0){
								System.out.println("entro al quinto if");
								retorno=planillaSeguimiento.getZona().getUbigeo().getProvincia();
								System.out.println("retorno "+retorno);
							}
						}
					}
				}
				
			}
		}
		
		
		return retorno;
	}
	public String obtenerDepartamento(Set<PlanillaSeguimiento> set){
		String retorno="";
		System.out.println("tama�o planilla seguimiento departamento"+set.size());
		if(set.size()>0){
			System.out.println("entro al primer if");
			for (PlanillaSeguimiento planillaSeguimiento : set) {
				System.out.println("entro al for");
				if(planillaSeguimiento!=null){
					System.out.println("entro al segundo if");
					if(planillaSeguimiento.getZona()!=null){
						System.out.println("entro al tercer if");
						if(planillaSeguimiento.getZona().getUbigeo()!=null){
							System.out.println("entro al cuarto if");
							if(planillaSeguimiento.getZona().getUbigeo().getProvincia()!=null &&
									planillaSeguimiento.getZona().getUbigeo().getDepartamento().length()>0){
								System.out.println("entro al quinto if");
								retorno=planillaSeguimiento.getZona().getUbigeo().getDepartamento();
								System.out.println("retorno "+retorno);
							}
						}
					}
				}
				
			}
		}
		
		
		return retorno;
	}
	
	public void localizarApiario() throws Exception{
		System.out.println("entrega ubicacion");
		PlanillaSeguimiento obj= new PlanillaSeguimiento();
		obj.setApiario(new Apiario());
		System.out.println("entra el parametro "+usuarioApiario.getApiario().getIdApiario());
		
		obj.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		
		System.out.println("dato encapsulado "+obj.getApiario().getIdApiario());
		List<PlanillaSeguimiento> listaPlanillaSeguimiento = new ArrayList<PlanillaSeguimiento>();
		listaPlanillaSeguimiento=service.buscarPlanillaSeguimiento(obj);
		System.out.println("la lista se lleno "+listaPlanillaSeguimiento.size());
		if(listaPlanillaSeguimiento.size()>0){
		for (int i = 0; i < listaPlanillaSeguimiento.size(); i++) {
			obj=listaPlanillaSeguimiento.get(0);
		}
		System.out.println("del for salio el obj "+obj.getZona().getUbigeo().getDistrito());
		ubicacionApiario=obj.getZona().getUbigeo().getDistrito();
		System.out.println("el valor de ubicacionApiario es "+ubicacionApiario);
		}else{
			ubicacionApiario="";
		}
	}
}
