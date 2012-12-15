package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Reina;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBUsuarioApiario implements Serializable{
	private UsuarioApiario usuarioApiario;
	private List<UsuarioApiario> listaUsarioApiario = new ArrayList<UsuarioApiario>();
	private SeleccionService service = new SeleccionService();
	private String ubicacionApiario;
	private String nivelPeligro;
	private int nivelPeligroId;
	private List<EstadoRevisionEquipamientoTrabajo> listaERET = new ArrayList<EstadoRevisionEquipamientoTrabajo>();
//	SeleccionService service = new SeleccionService();
	private Colmena colmena;
	private List<Colmena> listaColmenas=new ArrayList<Colmena>();
	private PlanillaRevision objplanillaRevision;
	private Colmena objColmena;
	private EstadoRevision objEstadoRevision;
	private int p_indice_usuarioApiario;
	
	public void limpiar(){
//		objColmena=new Colmena();

		setColmena(new Colmena());
		objplanillaRevision=new PlanillaRevision();
		objplanillaRevision.setEstadoRevision(new EstadoRevision());
		objColmena=new Colmena();
		objEstadoRevision=new EstadoRevision();
	}
	
	public void listColmenas(){
		System.out.println("Entro Colmenas");
		System.out.println("-->"+usuarioApiario.getApiario().getIdApiario());
		listaColmenas.clear();
		int apiarioId=0;
		try {
			System.out.println();
			apiarioId=usuarioApiario.getApiario().getIdApiario();
			objColmena.setApiario(new Apiario());
			System.out.println("IdUsuarioApiario->"+usuarioApiario.getApiario().getIdApiario());
			System.out.println(">-->"+apiarioId);
//			usuarioApiario.getApiario().getIdApiario()
			objColmena.getApiario().setIdApiario(apiarioId);
			listaColmenas=service.buscarColmena(objColmena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarPlanillaRevision(){
		System.out.println("Llego al metodo de guardarPlanillaRevision");
		listColmenas();
		Reina objReina=new Reina();
		List<Reina> listaReina=new ArrayList<Reina>();
		int idReina=0;
		List arregloEnfermedad;
		List arregloAlimentacion;
		try {
			System.out.println("Entro al try catch");
			for (int i = 0; i < listaColmenas.size(); i++) {
				System.out.println("IDUsuarioApiario->"+usuarioApiario.getIdUsuarioApiario());
				objplanillaRevision.setUsuarioApiario(new UsuarioApiario());
//				usuarioApiario.getIdUsuarioApiario()
				objplanillaRevision.getUsuarioApiario().setIdUsuarioApiario(1);
				System.out.println("ListaSize->"+listaColmenas.size());
				System.out.println("->"+listaColmenas.get(i).isSel());
				System.out.println("->"+listaColmenas.get(i).getIdColmena());
				if(listaColmenas.get(i).isSel()==false){
					System.out.println("Entro a los seleccionados???");
					System.out.println("Colmena->"+listaColmenas.get(i).getIdColmena());
					objplanillaRevision.setColmena(new Colmena());
					objplanillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
					System.out.println("DespuesColmena->"+listaColmenas.get(i).getIdColmena());
//					objplanillaRevision.getColmena().setIdColmena(1);
				}
					
				System.out.println("ColemnaID para la Reina->"+listaColmenas.get(i).getIdColmena());
				objReina.setColmena(new Colmena());
				objReina.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
				listaReina=service.buscarReina(objReina);
					
				for (int j = 0; j < listaReina.size(); j++) {
//					listaColmenas.get(i).getIdColmena()
					objReina=service.obtenerPorIdReina(listaColmenas.get(i).getIdColmena());
//					listaReina.get(j).getIdReina()
					objplanillaRevision.setReina(new Reina());
					objplanillaRevision.getReina().setIdReina(objReina.getIdReina());
				}
				
				objplanillaRevision.setEstadoRevision(new EstadoRevision());
				objplanillaRevision.getEstadoRevision().setIdEstadoRevision(objEstadoRevision.getIdEstadoRevision());
				
				
//				objplanillaRevision.setReina(new Reina());
//				objplanillaRevision.getReina().setIdReina(idReina);
				
				
				System.out.println("IdColmena->"+objplanillaRevision.getColmena().getIdColmena());
				System.out.println("ExistenciaReina->"+objplanillaRevision.getExistenciaReina());
				System.out.println("IdReina->"+objplanillaRevision.getReina().getIdReina());
				System.out.println("EstadoCosecha->"+objplanillaRevision.getEstadoCosecha());
				System.out.println("NecesidadAlimentacion->"+objplanillaRevision.getNecesidadAlimentacion());
				System.out.println("NecesidadCuracion->"+objplanillaRevision.getNecesidadCuracion());
				System.out.println("IdEstadoRevision->"+objplanillaRevision.getEstadoRevision().getIdEstadoRevision());
				System.out.println("FaltaEspacioCamara->"+objplanillaRevision.getFaltaEspacioCamara());
				System.out.println("FaltaAlza->"+objplanillaRevision.getFaltaAlza());
				System.out.println("Comportamiento->"+objplanillaRevision.getComportamiento());
				System.out.println("IdUsuarioApiario->"+objplanillaRevision.getUsuarioApiario().getIdUsuarioApiario());

				System.out.println("TipoAlimentacion->"+objplanillaRevision.getPlanillaRevisionTipoAlimentacions());
				System.out.println("TipoEnfermedad->"+objplanillaRevision.getPlanillaRevisionTipoEnfermedads());
				
				
				arregloAlimentacion=objplanillaRevision.getPlanillaRevisionTipoAlimentacions();
				arregloEnfermedad=objplanillaRevision.getPlanillaRevisionTipoEnfermedads();
				
//				.get(i).getIdPlanillaRevisionTipoAlimentacion()
//				.get(i).getIdPlanillaRevisionTipoEnfermedad()
				
				
				service.guardarPlanillaRevision(objplanillaRevision);
				System.out.println("------------------------------------guardar satisfactoriamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarControldeCalidad(){
		try {
			
		} catch (Exception e) {
			System.out.println("Error al guardar el control de calidad");
		}
	}
	
	


	public List<EstadoRevisionEquipamientoTrabajo> getListaERET() {
		return listaERET;
	}

	public void setListaERET(List<EstadoRevisionEquipamientoTrabajo> listaERET) {
		this.listaERET = listaERET;
	}

	public int getNivelPeligroId() {
		return nivelPeligroId;
	}
	public void setNivelPeligroId(int nivelPeligroId) {
		this.nivelPeligroId = nivelPeligroId;
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

//	public void setObjEstadoRevision(EstadoRevision objEstadoRevision) {
//		this.objEstadoRevision = objEstadoRevision;
//	}
//
//	public EstadoRevision getObjEstadoRevision() {
//		return objEstadoRevision;
//	}

	public void setObjEstadoRevision(EstadoRevision objEstadoRevision) {
		this.objEstadoRevision = objEstadoRevision;
	}

	public EstadoRevision getObjEstadoRevision() {
		return objEstadoRevision;
	}

	public int getP_indice_usuarioApiario() {
		return p_indice_usuarioApiario;
	}

	public void setP_indice_usuarioApiario(int p_indice_usuarioApiario) {
		this.p_indice_usuarioApiario = p_indice_usuarioApiario;
	}

	public MBUsuarioApiario() {
		limpiar();

	}
	
	public void limpiarNuevaAsignacion(){
		System.out.println("limpiarNuevaAsignacion");
		usuarioApiario= new UsuarioApiario();
		usuarioApiario.setApiario(new Apiario());
		usuarioApiario.setUsuario(new Usuario());
		usuarioApiario.setTemporada(new Temporada());
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
		listaERET= new ArrayList<EstadoRevisionEquipamientoTrabajo>();
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
					nivelPeligroId=listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue();
				}
				if(listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue()==2){
					System.out.println("es 2");
					nivelPeligro=listaPlanillaRevision.get(i).getEstadoRevision().getDescripcionEstadoRevision();
					nivelPeligroId=listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue();
				}
			}
		 }else{
			 nivelPeligro="";
		 }

		listColmenas();

	}
	public void obtenerEquipoSeguridad() throws Exception{
		System.out.println("obtenerEquipoSeguridad");
		EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
		objERET.setEstadoRevision(new EstadoRevision());
		objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
		
		
		listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
		System.out.println("tamaño de lista obtenerEquipoSeguridad "+listaERET.size());
		
	}
	public void guardarUsuarioApiario() throws Exception{
		usuarioApiario.setUsuario((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		System.out.println("aver???? "+usuarioApiario.getUsuario().getNombreUsuario());
		usuarioApiario.setEstadoAsignacion("asignado");
		usuarioApiario.setFechaAsignacion(new Date());
		

		List<Temporada> listaTemporada = new ArrayList<Temporada>();
		listaTemporada = service.listarTodosTemporada();
		Date fechaActual= new Date();
		for (int i = 0; i < listaTemporada.size(); i++) {
			if(listaTemporada.get(i).getEstadoEtapa().equals("seleccion") && listaTemporada.get(i).getPeriodoFinal().getTime()>fechaActual.getTime()){
			usuarioApiario.getTemporada().setIdTemporada(listaTemporada.get(i).getIdTemporada());
			}

		}

		UsuarioApiario confirm = null;
		try {
			confirm = service.guardarUsuarioApiario(usuarioApiario);
			if(confirm.isSuccess()){
				System.out.println("grabo");
			}else{
				System.out.println("error al grabar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void aver(int dato){
		System.out.println("entro oeoeoeoe");
		System.out.println("datos "+dato);
	}
	public void abrirModificarUsuarioApiario(int id){
		System.out.println("abrirModificarUsuarioApiario");
		System.out.println("indice "+p_indice_usuarioApiario);
		System.out.println("id "+id);
	}
//	public void onRowSelect(SelectEvent event) {  
//		System.out.println("1");
//	        FacesMessage msg = new FacesMessage("Car Selected", ((UsuarioApiario) event.getObject()).getEstadoAsignacion());  
//	  System.out.println("2");
//	       FacesContext.getCurrentInstance().addMessage(null, msg);  
//	System.out.println("3");
//	}  
}
