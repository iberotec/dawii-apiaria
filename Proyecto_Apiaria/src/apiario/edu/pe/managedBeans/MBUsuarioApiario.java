package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
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
	private String nivelPeligro;
	
//	SeleccionService service = new SeleccionService();
	private Colmena colmena;
	private List<Colmena> listaColmenas=new ArrayList<Colmena>();
	private PlanillaRevision objplanillaRevision;
	private Colmena objColmena;
	
	
	public void limpiar(){
//		objColmena=new Colmena();

		setColmena(new Colmena());
		objplanillaRevision=new PlanillaRevision();
		objColmena=new Colmena();
		
	}
	
	public void listColmenas(){
		System.out.println("Entro Colmenas");
		listaColmenas.clear();
		try {
			System.out.println();
			objColmena.setApiario(new Apiario());
			System.out.println(usuarioApiario.getApiario().getIdApiario());
			objColmena.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
			listaColmenas=service.buscarColmena(objColmena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarPlanillaRevision(){
		System.out.println("Llego al metodo de guardarPlanillaRevision");
		
		try {
			for (int i = 0; i < listaColmenas.size(); i++) {
				if(listaColmenas.get(i).isSel()){
					System.out.println("Colmena->"+listaColmenas.get(i).getIdColmena());
					objplanillaRevision.setColmena(new Colmena());
					objplanillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
				}
			}
			service.guardarPlanillaRevision(objplanillaRevision);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public String getNivelPeligro() {
		return nivelPeligro;
	}
	public void setNivelPeligro(String nivelPeligro) {
		this.nivelPeligro = nivelPeligro;
	}
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

	public SeleccionService getService() {
		return service;
	}

	public void setService(SeleccionService service) {
		this.service = service;
	}

	public Colmena getColmena() {
		return colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public List<Colmena> getListaColmenas() {
		return listaColmenas;
	}

	public void setListaColmenas(List<Colmena> listaColmenas) {
		this.listaColmenas = listaColmenas;
	}

	public PlanillaRevision getObjplanillaRevision() {
		return objplanillaRevision;
	}

	public void setObjplanillaRevision(PlanillaRevision objplanillaRevision) {
		this.objplanillaRevision = objplanillaRevision;
	}

	public Colmena getObjColmena() {
		return objColmena;
	}

	public void setObjColmena(Colmena objColmena) {
		this.objColmena = objColmena;
	}

	public MBUsuarioApiario() {
		limpiar();
		
	}
	
	public void limpiarNuevaAsignacion(){
		System.out.println("limpiarNuevaAsignacion");
		usuarioApiario= new UsuarioApiario();
		usuarioApiario.setApiario(new Apiario());
		ubicacionApiario="";
		nivelPeligro="";
	}
	public String abrirNuevaAsignacion(){
		System.out.println("abriendo nueva asignacion");
		limpiarNuevaAsignacion();
		return "successNuevaAsignacion";
	}
	public void listarTodosUsuarioApiario() throws Exception{
		System.out.println("entro a listartodos");
		listaUsarioApiario = service.listarTodosUsuarioApiario();
		System.out.println("tamaño de la lista en listarTodos"+listaUsarioApiario.size());
	}
	public String obtenerNivelPeligro(Set<PlanillaRevision> set){
		String retorno="";
		System.out.println("tamaño lista nivel peligro "+set.size());
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
		System.out.println("tamaño planilla seguimiento provincia"+set.size());
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
		System.out.println("tamaño planilla seguimiento departamento"+set.size());
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
			
			obj=listaPlanillaSeguimiento.get(i);
		}
		System.out.println("del for salio el obj "+obj.getZona().getUbigeo().getDistrito());
		ubicacionApiario=obj.getZona().getUbigeo().getDistrito();
		System.out.println("el valor de ubicacionApiario es "+ubicacionApiario);
		}else{
			ubicacionApiario="";
		}

		
		System.out.println("entraga el estado mayor de peligro");
		 PlanillaRevision objRevision = new PlanillaRevision();
		 objRevision.setUsuarioApiario(new UsuarioApiario());
		 objRevision.getUsuarioApiario().setApiario(new Apiario());
		 objRevision.getUsuarioApiario().getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		 
		 List<PlanillaRevision> listaPlanillaRevision = new ArrayList<PlanillaRevision>();
		 System.out.println("tamaño lista planilla de revision antes "+listaPlanillaRevision.size());
		 listaPlanillaRevision=service.buscarPlanillaRevision(objRevision);
		System.out.println("tamaño lista planilla de revision "+ listaPlanillaRevision.size());
		 if(listaPlanillaRevision.size()>0){
			 System.out.println("entro al if");
			 for (int i = 0; i < listaPlanillaRevision.size(); i++) {
				 System.out.println("entro al for");
				if(listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue()==1){
					System.out.println("es 1");
					nivelPeligro=listaPlanillaRevision.get(i).getEstadoRevision().getDescripcionEstadoRevision();
				}
				if(listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue()==2){
					System.out.println("es 2");
					nivelPeligro=listaPlanillaRevision.get(i).getEstadoRevision().getDescripcionEstadoRevision();
				}
			}
		 }else{
			 nivelPeligro="";
		 }

		listColmenas();

	}
}
