package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DualListModel;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaExtraccionAlza;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;
@SuppressWarnings("serial")
public class MBUsuarioApiarioExtraccion implements Serializable{
	private List<UsuarioApiario> listaUsuarioApiarioExtraccion=new ArrayList<UsuarioApiario>();
	private UsuarioApiario usuarioApiarioExtraccionSeleccionado;
	private SeleccionService service = new SeleccionService();
	private UsuarioApiario usuarioApiarioExtraccion;
	private List<EstadoRevisionEquipamientoTrabajo> listaEretExtraccion=new ArrayList<EstadoRevisionEquipamientoTrabajo>();
	private List<PlanillaRevision> listaPRCosechable= new ArrayList<PlanillaRevision>();
	private PlanillaRevision planillaRevisioCosechableSeleccionada;
	private PlanillaRevision planillaRevisionCosechable;
	private PlanillaExtraccionAlza planillaExtraccionAlza;
	private DualListModel<PlanillaRevisionAlza> dListaPrA = new DualListModel<PlanillaRevisionAlza>();
	private DualListModel<Alza> dListaA = new DualListModel<Alza>();
	
	private String nivelPeligroExtraccion;
	private int nivelPeligroIdExtraccion;
	private String ubicacionApiarioExtraccion;
	private boolean mostrarEquipoSeguridadExtraccion;
	private String tipoAlimentacion;
	private String tipoEnfermedad;
	private boolean mostrarTipoAlimentacion;
	private boolean mostrarTipoEnfermedad;
	private boolean exitenciaReina;
	
	
	
	public DualListModel<Alza> getdListaA() {
		return dListaA;
	}

	public void setdListaA(DualListModel<Alza> dListaA) {
		this.dListaA = dListaA;
	}

	public DualListModel<PlanillaRevisionAlza> getdListaPrA() {
		return dListaPrA;
	}

	public void setdListaPrA(DualListModel<PlanillaRevisionAlza> dListaPrA) {
		this.dListaPrA = dListaPrA;
	}

	public boolean isExitenciaReina() {
		return exitenciaReina;
	}

	public void setExitenciaReina(boolean exitenciaReina) {
		this.exitenciaReina = exitenciaReina;
	}

	public boolean isMostrarTipoAlimentacion() {
		return mostrarTipoAlimentacion;
	}

	public void setMostrarTipoAlimentacion(boolean mostrarTipoAlimentacion) {
		this.mostrarTipoAlimentacion = mostrarTipoAlimentacion;
	}

	public boolean isMostrarTipoEnfermedad() {
		return mostrarTipoEnfermedad;
	}

	public void setMostrarTipoEnfermedad(boolean mostrarTipoEnfermedad) {
		this.mostrarTipoEnfermedad = mostrarTipoEnfermedad;
	}

	public String getTipoAlimentacion() {
		return tipoAlimentacion;
	}

	public void setTipoAlimentacion(String tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}

	public String getTipoEnfermedad() {
		return tipoEnfermedad;
	}

	public void setTipoEnfermedad(String tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}

	public PlanillaRevision getPlanillaRevisionCosechable() {
		return planillaRevisionCosechable;
	}

	public void setPlanillaRevisionCosechable(
			PlanillaRevision planillaRevisionCosechable) {
		this.planillaRevisionCosechable = planillaRevisionCosechable;
	}

	public PlanillaExtraccionAlza getPlanillaExtraccionAlza() {
		return planillaExtraccionAlza;
	}

	public void setPlanillaExtraccionAlza(
			PlanillaExtraccionAlza planillaExtraccionAlza) {
		this.planillaExtraccionAlza = planillaExtraccionAlza;
	}

	public PlanillaRevision getPlanillaRevisioCosechableSeleccionada() {
		return planillaRevisioCosechableSeleccionada;
	}

	public void setPlanillaRevisioCosechableSeleccionada(
			PlanillaRevision planillaRevisioCosechableSeleccionada) {
		this.planillaRevisioCosechableSeleccionada = planillaRevisioCosechableSeleccionada;
	}

	public List<PlanillaRevision> getListaPRCosechable() {
		return listaPRCosechable;
	}

	public void setListaPRCosechable(List<PlanillaRevision> listaPRCosechable) {
		this.listaPRCosechable = listaPRCosechable;
	}

	public boolean isMostrarEquipoSeguridadExtraccion() {
		return mostrarEquipoSeguridadExtraccion;
	}

	public void setMostrarEquipoSeguridadExtraccion(
			boolean mostrarEquipoSeguridadExtraccion) {
		this.mostrarEquipoSeguridadExtraccion = mostrarEquipoSeguridadExtraccion;
	}

	public List<EstadoRevisionEquipamientoTrabajo> getListaEretExtraccion() {
		return listaEretExtraccion;
	}

	public void setListaEretExtraccion(
			List<EstadoRevisionEquipamientoTrabajo> listaEretExtraccion) {
		this.listaEretExtraccion = listaEretExtraccion;
	}

	public String getUbicacionApiarioExtraccion() {
		return ubicacionApiarioExtraccion;
	}

	public void setUbicacionApiarioExtraccion(String ubicacionApiarioExtraccion) {
		this.ubicacionApiarioExtraccion = ubicacionApiarioExtraccion;
	}

	public String getNivelPeligroExtraccion() {
		return nivelPeligroExtraccion;
	}

	public void setNivelPeligroExtraccion(String nivelPeligroExtraccion) {
		this.nivelPeligroExtraccion = nivelPeligroExtraccion;
	}

	public int getNivelPeligroIdExtraccion() {
		return nivelPeligroIdExtraccion;
	}

	public void setNivelPeligroIdExtraccion(int nivelPeligroIdExtraccion) {
		this.nivelPeligroIdExtraccion = nivelPeligroIdExtraccion;
	}

	public UsuarioApiario getUsuarioApiarioExtraccion() {
		return usuarioApiarioExtraccion;
	}

	public void setUsuarioApiarioExtraccion(UsuarioApiario usuarioApiarioExtraccion) {
		this.usuarioApiarioExtraccion = usuarioApiarioExtraccion;
	}

	public UsuarioApiario getUsuarioApiarioExtraccionSeleccionado() {
		return usuarioApiarioExtraccionSeleccionado;
	}

	public void setUsuarioApiarioExtraccionSeleccionado(
			UsuarioApiario usuarioApiarioExtraccionSeleccionado) {
		this.usuarioApiarioExtraccionSeleccionado = usuarioApiarioExtraccionSeleccionado;
	}

	public List<UsuarioApiario> getListaUsuarioApiarioExtraccion() {
		return listaUsuarioApiarioExtraccion;
	}

	public void setListaUsuarioApiarioExtraccion(
			List<UsuarioApiario> listaUsuarioApiarioExtraccion) {
		this.listaUsuarioApiarioExtraccion = listaUsuarioApiarioExtraccion;
	}

	public MBUsuarioApiarioExtraccion() {
		// TODO Auto-generated constructor stub
	}
	
	public String abrirMantenimientoUsuarioApiarioExtraccion(){
		return "successMantenimientoUsuarioApiarioExtraccion";
	}
	public void listarTodosUsuarioApiarioExtraccion() throws Exception{
		Usuario objU=new Usuario();
		objU=(Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario");
		
		UsuarioApiario obj = new UsuarioApiario();
		obj.setTemporada(new Temporada());
		obj.setUsuario(new Usuario());
		obj.getTemporada().setEtapaTemporada("extraccion");
		obj.getTemporada().setEstadoTemporada(true);
		obj.getUsuario().setIdUsuario(objU.getIdUsuario());
		
		listaUsuarioApiarioExtraccion=service.buscarUsuarioApiario(obj);
		
		
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
	
	public void abrirModificarUsuarioApiarioExtraccion(int id) throws Exception{
		
		
		System.out.println("abrirModificarUsuarioApiario");
		System.out.println("id "+id);
		UsuarioApiario objUA = new UsuarioApiario();
		objUA= service.obtenerPorIdUsuarioApiario(id);
		usuarioApiarioExtraccion =objUA;
		PlanillaSeguimiento objPS = new PlanillaSeguimiento();
		objPS.setEstado(1);
		objPS.setApiario(new Apiario());
		objPS.getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
		List<PlanillaSeguimiento> listaPS = new ArrayList<PlanillaSeguimiento>();
		listaPS=service.buscarPlanillaSeguimiento(objPS);
		System.out.println("listaPS.size() "+listaPS.size());
		ubicacionApiarioExtraccion=listaPS.get(0).getZona().getUbigeo().getDistrito();
		obtenerNivelPeligroEquipoTrabajoExtraccion();

		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext
        .getCurrentInstance().getApplication()
        .getNavigationHandler();
		handler.performNavigation("successNuevoUsuarioApiarioExtraccion");
	}
	public void limpiarUsuarioApiarioExtraccion(){
		System.out.println("limpiarNuevaAsignacionExtraccion");
		usuarioApiarioExtraccion= new UsuarioApiario();
		usuarioApiarioExtraccionSeleccionado= new UsuarioApiario();
		usuarioApiarioExtraccion.setApiario(new Apiario());
		usuarioApiarioExtraccion.setUsuario(new Usuario());
		usuarioApiarioExtraccion.setTemporada(new Temporada());
		listaEretExtraccion = new ArrayList<EstadoRevisionEquipamientoTrabajo>();
		ubicacionApiarioExtraccion="";
		nivelPeligroExtraccion="";
		mostrarEquipoSeguridadExtraccion=false;
	}
	public String abrirRegistrarUsuarioApiarioExtraccion(){
		limpiarUsuarioApiarioExtraccion();
		return "successNuevoUsuarioApiarioExtraccion";
	}
	public void localizarApiarioParaExtraccion() throws Exception{
		listaEretExtraccion= new ArrayList<EstadoRevisionEquipamientoTrabajo>();
		System.out.println("entrega ubicacion");
		PlanillaSeguimiento obj= new PlanillaSeguimiento();
		obj.setApiario(new Apiario());
		System.out.println("entra el parametro "+usuarioApiarioExtraccion.getApiario().getIdApiario());
		if(usuarioApiarioExtraccion.getApiario()!=null){
			if(usuarioApiarioExtraccion.getApiario().getIdApiario()!=null && usuarioApiarioExtraccion.getApiario().getIdApiario().intValue()>0){
				obj.getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
				
				System.out.println("dato encapsulado "+obj.getApiario().getIdApiario());
				List<PlanillaSeguimiento> listaPlanillaSeguimiento = new ArrayList<PlanillaSeguimiento>();
				listaPlanillaSeguimiento=service.buscarPlanillaSeguimiento(obj);
				System.out.println("la lista se lleno "+listaPlanillaSeguimiento.size());
				if(listaPlanillaSeguimiento.size()>0){
				for (int i = 0; i < listaPlanillaSeguimiento.size(); i++) {
					
					obj=listaPlanillaSeguimiento.get(i);
				}
				System.out.println("del for salio el obj "+obj.getZona().getUbigeo().getDistrito());
				ubicacionApiarioExtraccion=obj.getZona().getUbigeo().getDistrito();
				System.out.println("el valor de ubicacionApiario es "+ubicacionApiarioExtraccion);
				}else{
					ubicacionApiarioExtraccion="";
				}

				
				System.out.println("entraga el estado mayor de peligro");
				 PlanillaRevision objRevision = new PlanillaRevision();
				 objRevision.setUsuarioApiario(new UsuarioApiario());
				 objRevision.getUsuarioApiario().setApiario(new Apiario());
				 objRevision.getUsuarioApiario().getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
				 
				 List<PlanillaRevision> listaPlanillaRevision = new ArrayList<PlanillaRevision>();
				 System.out.println("tamaño lista planilla de revision antes "+listaPlanillaRevision.size());
				 listaPlanillaRevision=service.buscarPlanillaRevision(objRevision);
				System.out.println("tamaño lista planilla de revision "+ listaPlanillaRevision.size());
				nivelPeligroIdExtraccion=0;
				 if(listaPlanillaRevision.size()>0){
					 System.out.println("entro al if");
					 for (int i = 0; i < listaPlanillaRevision.size(); i++) {
						 System.out.println("entro al for");
						if(listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue()==1){
							System.out.println("es 1");
							nivelPeligroExtraccion=listaPlanillaRevision.get(i).getEstadoRevision().getDescripcionEstadoRevision();
							nivelPeligroIdExtraccion=listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue();
						}
						if(listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue()==2){
							System.out.println("es 2");
							nivelPeligroExtraccion=listaPlanillaRevision.get(i).getEstadoRevision().getDescripcionEstadoRevision();
							nivelPeligroIdExtraccion=listaPlanillaRevision.get(i).getEstadoRevision().getIdEstadoRevision().intValue();
						}
					}
				 }else{
					 nivelPeligroExtraccion="No precisa";
				 }
			}else{
				nivelPeligroExtraccion="";
				nivelPeligroIdExtraccion=0;
				ubicacionApiarioExtraccion="";
			}
			

		}else{
			nivelPeligroExtraccion="";
			nivelPeligroIdExtraccion=0;
			ubicacionApiarioExtraccion="";
		}
	}
	
	public boolean validarUsuarioApiarioUnico(UsuarioApiario obj) throws Exception{
		boolean resultado=true;
		boolean validar=false;
		if(obj!=null){
			if(obj.getIdUsuarioApiario()!=null && obj.getIdUsuarioApiario().intValue()>0){
				UsuarioApiario objGenerico = new UsuarioApiario();
				objGenerico = service.obtenerPorIdUsuarioApiario(obj.getIdUsuarioApiario());
				if(objGenerico.getApiario().getIdApiario()!=obj.getApiario().getIdApiario()){
					System.out.println("validar que no haya repetido al modificar");
					validar=true;
					
					
				}else{
					System.out.println("no es necesaria la validacion");
					resultado=true;
				}
			}else{
				System.out.println("validar que no haya repetido en nuevo registro");
				validar=true;
				
			}
			
			if(validar){
				if(obj.getApiario()!= null && obj.getTemporada()!=null){
					System.out.println("entro al if no es null obj apiario ni temporada");
					if(obj.getApiario().getIdApiario()!=null && obj.getApiario().getIdApiario().intValue()>0 &&
							obj.getTemporada().getIdTemporada()!=null && obj.getTemporada().getIdTemporada().intValue()>0){
						System.out.println("entro al if los ids existen");
						List<UsuarioApiario> lista = new ArrayList<UsuarioApiario>();
						lista=service.listarTodosUsuarioApiario();
						if(lista.size()>0){
							System.out.println("entro al if la lista es mayor a 0");
							for (int i = 0; i < lista.size(); i++) {
								System.out.println("recorriendo el for");
								System.out.println("id apiario "+obj.getApiario().getIdApiario()+" - "+"lista "+lista.get(i).getApiario().getIdApiario());
								System.out.println("id temporada "+obj.getTemporada().getIdTemporada()+" - "+"lista "+lista.get(i).getTemporada().getIdTemporada());
								if(obj.getApiario().getIdApiario().intValue()==lista.get(i).getApiario().getIdApiario().intValue() && obj.getTemporada().getIdTemporada().intValue()==lista.get(i).getTemporada().getIdTemporada().intValue()){
									System.out.println("se encontraron repetidos");
									resultado=false;
								}
							}
						}else{
							System.out.println("no hay registros en la tabla");
							resultado=true;
						}
						
						if(!resultado){
							System.out.println("entro aqui a botar el mensaje");
							 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "El Apiario "+usuarioApiarioExtraccion.getApiario().getIdApiario()+" ya fue asignado")); 
						}
					}else{
						resultado=false;
					}
				}else{
					resultado=false;
				}
				
				
			}
			
			
		}
		
		System.out.println("resultado "+resultado);
		return resultado;
	}
	public boolean validarIdApiarioConValor(UsuarioApiario obj){
		boolean resultado=false;
		if(obj.getApiario()!=null){
			if(obj.getApiario().getIdApiario()!=null && obj.getApiario().getIdApiario().intValue()>0){
				resultado=true;
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona un Apiario")); 
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona un Apiario")); 
		}
		return resultado;
	}
	public void guardarUsuarioApiarioExtraccion() throws Exception{
		boolean validacion=false;
		usuarioApiarioExtraccion.setUsuario((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		System.out.println("aver???? "+usuarioApiarioExtraccion.getUsuario().getNombreUsuario());
		usuarioApiarioExtraccion.setEstadoAsignacion("asignado");
		usuarioApiarioExtraccion.setFechaAsignacion(new Date());
		

		List<Temporada> listaTemporada = new ArrayList<Temporada>();
		listaTemporada = service.listarTodosTemporada();
		System.out.println("tamaño lista temporada "+listaTemporada.size());
		Date fechaActual= new Date();
		for (int i = 0; i < listaTemporada.size(); i++) {
			System.out.println("etapa "+listaTemporada.get(i).getEtapaTemporada()+" "+"Fecha Final "+listaTemporada.get(i).getPeriodoFinal());
			System.out.println("fecha actual "+fechaActual);
			if(listaTemporada.get(i).getEtapaTemporada().equals("extraccion") && listaTemporada.get(i).getPeriodoFinal().getTime()>=fechaActual.getTime() && listaTemporada.get(i).getEstadoTemporada()){
				System.out.println("entro al if");
				System.out.println("id temporada "+listaTemporada.get(i).getIdTemporada());
				usuarioApiarioExtraccion.getTemporada().setIdTemporada(listaTemporada.get(i).getIdTemporada());
			}

		}

		UsuarioApiario confirm = null;
		try {
			validacion=validarIdApiarioConValor(usuarioApiarioExtraccion);
			validacion=validarUsuarioApiarioUnico(usuarioApiarioExtraccion);
			if(validacion){
				confirm = service.guardarUsuarioApiario(usuarioApiarioExtraccion);
				
				List<Integer> listaIdUsuarioApiario = new ArrayList<Integer>();
				listaIdUsuarioApiario=service.obtenerMaximoIdUsuarioApiario();
				System.out.println("tamaño listaUsuApi "+listaIdUsuarioApiario.size());
				if(listaIdUsuarioApiario.size()>0){
					for (int i = 0; i < listaIdUsuarioApiario.size(); i++) {
						System.out.println("id?? "+listaIdUsuarioApiario.get(i));
						usuarioApiarioExtraccion=service.obtenerPorIdUsuarioApiario(listaIdUsuarioApiario.get(i));
						usuarioApiarioExtraccionSeleccionado=service.obtenerPorIdUsuarioApiario(listaIdUsuarioApiario.get(i));
					}
				}
				System.out.println("usarioApiario id "+usuarioApiarioExtraccion.getIdUsuarioApiario());
				if(confirm.isSuccess()){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una nueva asignacion"));  
					System.out.println("grabo");
				}else{
					  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la asignacion")); 
					System.out.println("error al grabar");
				}
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}
	}
	public void obtenerEquipoSeguridadExtraccion() throws Exception{
		System.out.println("obtenerEquipoSeguridad");
		if(nivelPeligroIdExtraccion!=0){
			EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
			objERET.setEstadoRevision(new EstadoRevision());
			objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroIdExtraccion);
			
			mostrarEquipoSeguridadExtraccion=true;
			listaEretExtraccion=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
			System.out.println("tamaño de lista obtenerEquipoSeguridad "+listaEretExtraccion.size());
		}else{
			mostrarEquipoSeguridadExtraccion=false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No precisa Nivel de Peligro consulte a su Superior para saber que equipo llevar o utilize su criterio")); 
			System.out.println("error al grabar");
		}
	}
	public void obtenerNivelPeligroEquipoTrabajoExtraccion() throws Exception{
		PlanillaRevision objPR = new PlanillaRevision();
		objPR.setUsuarioApiario(new UsuarioApiario());
		objPR.getUsuarioApiario().setApiario(new Apiario());
		objPR.getUsuarioApiario().getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
		objPR.getUsuarioApiario().setTemporada(new Temporada());
		if(usuarioApiarioExtraccion.getTemporada().getOrdenTemporada()!=null){
			objPR.getUsuarioApiario().getTemporada().setOrdenTemporada(usuarioApiarioExtraccion.getTemporada().getOrdenTemporada().intValue()-1);
			objPR.getUsuarioApiario().getTemporada().setEtapaTemporada(usuarioApiarioExtraccion.getTemporada().getEtapaTemporada());
			List<PlanillaRevision> listaPR = new ArrayList<PlanillaRevision>();
			listaPR = service.buscarPlanillaRevision(objPR);
			System.out.println("listaPR.size() "+listaPR.size());
			int cont=0;
			if(listaPR.size()>0){
				for (int i = 0; i < listaPR.size(); i++) {
					if(listaPR.get(i).getEstadoRevision().getDescripcionEstadoRevision().equals("Peligro")){
						cont++;
					}
				}
			if(cont>0){
				nivelPeligroExtraccion ="Peligro";
				EstadoRevision objBuscarER= new EstadoRevision();
				objBuscarER.setDescripcionEstadoRevision(nivelPeligroExtraccion);
				List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
				listaBuscarER=service.buscarEstadoRevision(objBuscarER);
				if(listaBuscarER.size()>0){
					nivelPeligroIdExtraccion= listaBuscarER.get(0).getIdEstadoRevision();
				}
				
				
			}else{
				nivelPeligroExtraccion="Normal";
				EstadoRevision objBuscarER= new EstadoRevision();
				objBuscarER.setDescripcionEstadoRevision(nivelPeligroExtraccion);
				List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
				listaBuscarER=service.buscarEstadoRevision(objBuscarER);
				if(listaBuscarER.size()>0){
					nivelPeligroIdExtraccion= listaBuscarER.get(0).getIdEstadoRevision();
				}
			}

			}else{
				nivelPeligroIdExtraccion=0;
				nivelPeligroExtraccion="No precisa";
			}
		
			
			
			
			if(nivelPeligroIdExtraccion!=0){
				EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
				objERET.setEstadoRevision(new EstadoRevision());
				objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroIdExtraccion);
				
				listaEretExtraccion=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
				mostrarEquipoSeguridadExtraccion=true;
			}else{
				System.out.println("no se esta mostrnado el listado -.-!");
				listaEretExtraccion= new ArrayList<EstadoRevisionEquipamientoTrabajo>();
				mostrarEquipoSeguridadExtraccion=false;
			}
		}
	}
	public void listarColmenaCosechable() throws Exception{
		List<Integer> listaOrdenTemporada= new ArrayList<Integer>();
		Temporada objBusqueda= new Temporada();
		objBusqueda.setEtapaTemporada("seleccion");
		listaOrdenTemporada=service.obtenerUltimaTemporada(objBusqueda);
		
		if(listaOrdenTemporada.size()>0){
			Temporada objT= new Temporada();
			objT.setOrdenTemporada(listaOrdenTemporada.get(0));
			objT.setEtapaTemporada("seleccion");
			
			List<Temporada> listaT= new ArrayList<Temporada>();
			listaT= service.buscarTemporada(objT);
		
			if(listaT.size()>0){
				PlanillaRevision obj = new PlanillaRevision();
				obj.setUsuarioApiario(new UsuarioApiario());
				obj.getUsuarioApiario().setApiario(new Apiario());
				obj.getUsuarioApiario().setTemporada(new Temporada());
				obj.getUsuarioApiario().getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
				obj.setEstadoCosecha("cosechable");
				obj.getUsuarioApiario().getTemporada().setIdTemporada(listaT.get(0).getIdTemporada());
				
				listaPRCosechable = service.buscarPlanillaRevision(obj);
			}
			
			
		}
		
	}
	public void abrirRegistrarPlanillaCosecha(int id) throws Exception{
		if(id>0){
			planillaRevisionCosechable=service.obtenerPorIdPlanillaRevision(id);
			if(planillaRevisionCosechable!=null){
				if(planillaRevisionCosechable.getExistenciaReina()!=null){
					exitenciaReina=planillaRevisionCosechable.getExistenciaReina();
				}
				
				if(planillaRevisionCosechable.getIdPlanillaRevision()!=null && planillaRevisionCosechable.getIdPlanillaRevision().intValue()>0){
					PlanillaRevisionTipoAlimentacion objPRTA= new PlanillaRevisionTipoAlimentacion();
					objPRTA.setPlanillaRevision(new PlanillaRevision());
					objPRTA.getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
					
					List<PlanillaRevisionTipoAlimentacion> listaPRTA= new ArrayList<PlanillaRevisionTipoAlimentacion>();
					listaPRTA=service.buscarPlanillaRevisionTipoAlimentacion(objPRTA);
					if(listaPRTA.size()>0){
						mostrarTipoAlimentacion=true;
						tipoAlimentacion=listaPRTA.get(0).getTipoAlimentacion().getDescripcionTipoAlimentacion();
					}else{
						mostrarTipoAlimentacion=false;
					}
					
					
					PlanillaRevisionTipoEnfermedad objPRTE= new PlanillaRevisionTipoEnfermedad();
					objPRTE.setPlanillaRevision(new PlanillaRevision());
					objPRTE.getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
					
					List<PlanillaRevisionTipoEnfermedad> listaPRTE= new ArrayList<PlanillaRevisionTipoEnfermedad>();
					listaPRTE=service.buscarPlanillaRevisionTipoEnfermedad(objPRTE);
					if(listaPRTE.size()>0){
						mostrarTipoEnfermedad=true;
						tipoEnfermedad=listaPRTE.get(0).getTipoEnfermedad().getDescripcionTipoEnfermedad();
					}else{
						mostrarTipoEnfermedad=false;
					}
					
				}else{
					mostrarTipoEnfermedad=false;
					mostrarTipoAlimentacion=false;
				}
			}else{
				mostrarTipoEnfermedad=false;
				mostrarTipoAlimentacion=false;
			}
			
		}else{
			mostrarTipoEnfermedad=false;
			mostrarTipoAlimentacion=false;
		}
		List<PlanillaRevisionAlza> fuente= new ArrayList<PlanillaRevisionAlza>();
		List<PlanillaRevisionAlza> destino= new ArrayList<PlanillaRevisionAlza>();
		
		PlanillaRevisionAlza objFuentePrA= new PlanillaRevisionAlza();
		objFuentePrA.setPlanillaRevision(new PlanillaRevision());
		objFuentePrA.getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
		
		fuente=service.buscarPlanillaRevisionAlza(objFuentePrA);
		
		
		
		
		List<PlanillaExtraccionAlza> listaPEA= new ArrayList<PlanillaExtraccionAlza>();
		PlanillaExtraccionAlza objDestinoPEA= new PlanillaExtraccionAlza();
		objDestinoPEA.setPlanillaRevisionAlza(new PlanillaRevisionAlza());
		objDestinoPEA.getPlanillaRevisionAlza().setPlanillaRevision(new PlanillaRevision());
		objDestinoPEA.getPlanillaRevisionAlza().getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
		
		listaPEA=service.buscarPlanillaExtraccionAlza(objDestinoPEA);
		
		
		if(listaPEA.size()>0){
			PlanillaRevisionAlza obj= new PlanillaRevisionAlza();
			for (PlanillaExtraccionAlza planillasExtraccionAlza : listaPEA) {
				obj=planillasExtraccionAlza.getPlanillaRevisionAlza();
				
				for (int i = 0; i < fuente.size(); i++) {
					if(planillasExtraccionAlza.getPlanillaRevisionAlza().getIdPlanillaRevisionAlza()==fuente.get(i).getIdPlanillaRevisionAlza()){
						fuente.remove(i);
					}
				}
				
				
				
				destino.add(obj);
			}
			
			
			
		}
		
		
		
//		PlanillaRevisionAlza objDestinoPrA= new PlanillaRevisionAlza();
//		objDestinoPrA.setAlza(new Alza());
//		objDestinoPrA.getAlza().setEstadoAlza("en cosecha");
//		objDestinoPrA.setPlanillaRevision(new PlanillaRevision());
//		objDestinoPrA.getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
//		
//		destino=service.buscarPlanillaRevisionAlza(objDestinoPrA);
		
		dListaPrA= new DualListModel<PlanillaRevisionAlza>(fuente, destino);
		
		
		
		List<Alza> origen = new ArrayList<Alza>();
		Alza objOrigen = new Alza();
		objOrigen.setPiso(new Piso());
		objOrigen.getPiso().setColmena(new Colmena());
		objOrigen.getPiso().getColmena().setIdColmena(planillaRevisionCosechable.getColmena().getIdColmena());
		objOrigen.setEstadoAlza("en colmena");
		
		origen=service.buscarAlza(objOrigen);
		
		
		List<Alza> llegada = new ArrayList<Alza>();
		Alza objLlegada = new Alza();
		objLlegada.setPiso(new Piso());
		objLlegada.getPiso().setColmena(new Colmena());
		objLlegada.getPiso().getColmena().setIdColmena(planillaRevisionCosechable.getColmena().getIdColmena());
		objLlegada.setEstadoAlza("en almacen");
		
		llegada=service.buscarAlza(objLlegada);
		
		dListaA= new DualListModel<Alza>(origen, llegada);
		
	}
	public void guardarDistribucionAlza() throws Exception{
		Alza confirm=new Alza();
		int contCapacidad=0;
		if(dListaA.getSource().size()>0){
			Alza objA= new Alza();
			for (int i = 0; i < dListaA.getSource().size(); i++) {
				objA=dListaA.getSource().get(i);
				objA.setEstadoAlza("en colmena");
				System.out.println("id alza "+objA.getIdAlza());
				contCapacidad++;
				System.out.println("capacidad "+contCapacidad);
				System.out.println("capacidad obj "+objA.getPiso().getCapacidad());
				if(objA.getPiso().getCapacidad().intValue()>=contCapacidad){
					confirm=service.guardarAlza(objA);
				}else{
					System.out.println("piso lleno");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atencion", "El piso "+objA.getPiso().getIdPiso()+" Solo tiene una capacidad de "+objA.getPiso().getCapacidad()));
				}
			}
			if(confirm.isSuccess()){
				System.out.println("guardo distribucion colmena");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Distribucion de Alzas"));
			}else{
				System.out.println("no guardo distribucion colmena");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Distribucion de Alzas"));
			}
		}
		if(dListaA.getTarget().size()>0){
			Alza objA= new Alza();
			for (int i = 0; i < dListaA.getTarget().size(); i++) {
				objA=dListaA.getTarget().get(i);
				objA.setEstadoAlza("en almacen");
				System.out.println("id alza "+objA.getIdAlza());
				confirm=service.guardarAlza(objA);
				
			}
			if(confirm.isSuccess()){
				System.out.println("guardo distribucion almacen");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Distribucion de Alzas"));
			}else{
				System.out.println("no guardo distribucion almacen");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Distribucion de Alzas"));
			}
		}
		validarTerminoAsignacion();
	}
	
	
	public void validarDatosRepetidosPlanillaExtraccionAlza(List<PlanillaRevisionAlza> listaTarget,List<PlanillaExtraccionAlza> listaTabla,PlanillaExtraccionAlza obj) throws Exception{
		PlanillaExtraccionAlza confirm= new PlanillaExtraccionAlza();
		List<String> listaIds= new ArrayList<String>();
		if(listaTarget.size()>0){
			for (int i = 0; i < listaTarget.size(); i++) {
				listaIds.add(listaTarget.get(i).getIdPlanillaRevisionAlza().toString());
			}
		}
		String id="";
		
		
		if(listaTabla.size()>0){
			//validar la actualizacion e una tabla llena
			if(dListaPrA.getTarget().size()>0){
				for (int i = 0; i < dListaPrA.getTarget().size(); i++) {
					for (int j = 0; j < listaTabla.size(); j++) {
						System.out.println("lista "+listaTabla.get(j).getPlanillaRevisionAlza().getIdPlanillaRevisionAlza()+
								" == "+"target "+dListaPrA.getTarget().get(i).getIdPlanillaRevisionAlza());
						if(listaTabla.get(j).getPlanillaRevisionAlza().getIdPlanillaRevisionAlza().intValue()==
							dListaPrA.getTarget().get(i).getIdPlanillaRevisionAlza().intValue()){
							System.out.println("entra if");
							id=dListaPrA.getTarget().get(i).getIdPlanillaRevisionAlza().toString();
							System.out.println("id a remover "+id);
							listaIds.remove(id);
							
						}else{
							System.out.println("entra else");
						
						}
					}
					
			
				}
			}
			if(listaIds.size()>0){
				for (int i = 0; i < listaIds.size(); i++) {
					System.out.println("ids "+listaIds.get(i));
					obj.getPlanillaRevisionAlza().setIdPlanillaRevisionAlza(Integer.parseInt(listaIds.get(i)));
					confirm=service.guardarPlanillaExtraccionAlza(obj);
					/////////////////////
					PlanillaRevisionAlza objPRA=null;
					objPRA=service.obtenerPorIdPlanillaRevisionAlza(obj.getPlanillaRevisionAlza().getIdPlanillaRevisionAlza());
					
					Alza confirmar=null;
					Alza objAlza= new Alza();
					objAlza=objPRA.getAlza();
					objAlza.setEstadoAlza("en cosecha");
					confirmar=service.guardarAlza(objAlza);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objAlza.getIdAlza()+"en tabla llena");
					}else{
						System.out.println("error en tabla llena");
					}
					///////////////////////
				}
				if(confirm.isSuccess()){
					System.out.println("ms1");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Extraccion"));  
				}else{
					System.out.println("ms2");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Extraccion")); 
				}
			}else{
				System.out.println("lista id vacia");
			}
			
			
		}else{
			//validar la actualizacion e una tabla vacia
			if(dListaPrA.getTarget().size()>0){
				for (int i = 0; i < dListaPrA.getTarget().size(); i++) {
					obj.getPlanillaRevisionAlza().setIdPlanillaRevisionAlza(dListaPrA.getTarget().get(i).getIdPlanillaRevisionAlza());
					confirm=service.guardarPlanillaExtraccionAlza(obj);	
					
					/////////////////////
					PlanillaRevisionAlza objPRA=null;
					objPRA=service.obtenerPorIdPlanillaRevisionAlza(obj.getPlanillaRevisionAlza().getIdPlanillaRevisionAlza());
					
					Alza confirmar=null;
					Alza objAlza= new Alza();
					objAlza=objPRA.getAlza();
					objAlza.setEstadoAlza("en cosecha");
					confirmar=service.guardarAlza(objAlza);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objAlza.getIdAlza()+"en tabla vacia");
					}else{
						System.out.println("error en tabla vacia");
					}
					///////////////////////
					
				}
				if(confirm.isSuccess()){
					System.out.println("ms3");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Extraccion"));  
				}else{
					System.out.println("ms4");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Extraccion")); 
				}
			}
		}
		
	}
	public void validarEliminacionPlanillaRevision(List<PlanillaExtraccionAlza> listaTabla,List<PlanillaRevisionAlza> listaSource) throws Exception{
		List<Integer> listaI= new ArrayList<Integer>();
		if(listaTabla.size()>0){
			for (int i = 0; i < listaTabla.size(); i++) {
				if(listaSource.size()>0){
					for (int j = 0; j < listaSource.size(); j++) {
						if(listaTabla.get(i).getPlanillaRevisionAlza().getIdPlanillaRevisionAlza()==listaSource.get(j).getIdPlanillaRevisionAlza()){
							listaI.add(listaTabla.get(i).getIdPlanillaExtraccionAlza());
						}
					}
				}
			
			}
		}
		
		System.out.println("tamaño listaI "+listaI.size());
		if(listaI.size()>0){
		PlanillaExtraccionAlza eliminar= new PlanillaExtraccionAlza();
		eliminar.setListaEliminar(listaI);
		PlanillaExtraccionAlza confirmEliminar=null;
		/////////////////////
		for (int i = 0; i < listaI.size(); i++) {
			PlanillaExtraccionAlza objPEA =null;
			objPEA=service.obtenerPorIdPlanillaExtraccionAlza(listaI.get(i));
			/////////////////////
			
			
			Alza confirmar=null;
			Alza objAlza= new Alza();
			objAlza=objPEA.getPlanillaRevisionAlza().getAlza();
			objAlza.setEstadoAlza("en seleccion");
			confirmar=service.guardarAlza(objAlza);
			
			if(confirmar.isSuccess()){
				System.out.println("guardo "+objAlza.getIdAlza()+"en eliminacion");
			}else{
				System.out.println("error en eliminacion");
			}
			///////////////////////
		}
		//////////////////////////////
		confirmEliminar=service.eliminarPlanillaExtraccionAlza(eliminar);
		
			if(confirmEliminar.isSuccess()){
				System.out.println("ms5");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Extraccion"));  
			}else{
				System.out.println("ms6");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Extraccion")); 
			}
		}
	}
	public void guardarPlanillaExtraccionAlza() throws Exception{
		Date fechaActualExtraccion = new Date();
		PlanillaExtraccionAlza guardar= new PlanillaExtraccionAlza();
		guardar.setUsuarioApiario(new UsuarioApiario());
		guardar.getUsuarioApiario().setIdUsuarioApiario(usuarioApiarioExtraccion.getIdUsuarioApiario());
		guardar.setPlanillaRevisionAlza(new PlanillaRevisionAlza());
		guardar.setFechaExtraccionAlza(fechaActualExtraccion);
		
		List<PlanillaExtraccionAlza> listaPEA= new ArrayList<PlanillaExtraccionAlza>();
		PlanillaExtraccionAlza obj= new PlanillaExtraccionAlza();
		obj.setPlanillaRevisionAlza(new PlanillaRevisionAlza());
		obj.getPlanillaRevisionAlza().setPlanillaRevision(new PlanillaRevision());
		obj.getPlanillaRevisionAlza().getPlanillaRevision().setIdPlanillaRevision(planillaRevisionCosechable.getIdPlanillaRevision());
		
		listaPEA=service.buscarPlanillaExtraccionAlza(obj);
	
		validarDatosRepetidosPlanillaExtraccionAlza(dListaPrA.getTarget(), listaPEA, guardar);

		validarEliminacionPlanillaRevision(listaPEA, dListaPrA.getSource());

		validarTerminoAsignacion();
	}
	public void validarTerminoAsignacion() throws Exception{
		List<Alza> listaAlzaSeleccionada = new ArrayList<Alza>();
		Alza objSeleccionado = new Alza();
		objSeleccionado.setEstadoAlza("en seleccion");
		objSeleccionado.setPiso(new Piso());
		objSeleccionado.getPiso().setColmena(new Colmena());
		objSeleccionado.getPiso().getColmena().setApiario(new Apiario());
		objSeleccionado.getPiso().getColmena().getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
		
		boolean todasAlzasExtraidas=false;
		listaAlzaSeleccionada = service.buscarAlza(objSeleccionado);
		if(listaAlzaSeleccionada.size()>0){
			System.out.println("aun hay alzas en seleccion no se puede acabar la asignacion");
		}else{
			System.out.println("todas las alzas en seleccion fueron extraidas");
			todasAlzasExtraidas=true;
		}
		
		
		
		
//		Piso objBuscaPiso = new Piso();
//		objBuscaPiso.setColmena(new Colmena());
//		objBuscaPiso.getColmena().setApiario(new Apiario());
//		objBuscaPiso.getColmena().getApiario().setIdApiario(usuarioApiarioExtraccion.getApiario().getIdApiario());
		List<Piso> listaBuscaPisos= new ArrayList<Piso>();
	
		
		for (PlanillaRevision planillasRevision : listaPRCosechable) {
			for (Piso pisos : planillasRevision.getColmena().getPisos()) {
				System.out.println("piso "+pisos.getIdPiso());
				listaBuscaPisos.add(pisos);
			}
		}
//		listaBuscaPisos=service.buscarPiso(objBuscaPiso);
		
		Alza objBuscaAlzaFor = new Alza();
		objBuscaAlzaFor.setEstadoAlza("en colmena");
		objBuscaAlzaFor.setPiso(new Piso());
		List<Alza> listaAlzaBuscaFor = new ArrayList<Alza>();
		boolean todasAlzasColocadas=true;
		int cont=0;
		if(listaBuscaPisos.size()>0){
			for (int i = 0; i < listaBuscaPisos.size(); i++) {
				objBuscaAlzaFor.getPiso().setIdPiso(listaBuscaPisos.get(i).getIdPiso());
				listaAlzaBuscaFor=service.buscarAlza(objBuscaAlzaFor);
				if(listaAlzaBuscaFor.size()>0){
					for (int j = 0; j < listaAlzaBuscaFor.size(); j++) {
						cont++;
						System.out.println("alza "+listaAlzaBuscaFor.get(j).getIdAlza());
						System.out.println("hay "+cont+" alzas colocadas en el piso "+listaBuscaPisos.get(i).getIdPiso());
					}
				}
				
				if(cont!=listaBuscaPisos.get(i).getCapacidad().intValue()){
					System.out.println("espacios vacion aun en el piso "+listaBuscaPisos.get(i).getIdPiso());
					cont=0;
					todasAlzasColocadas=false;
					
				}else{
					System.out.println("todas los "+listaBuscaPisos.get(i).getCapacidad()+" espacios del piso "+listaBuscaPisos.get(i).getIdPiso()+" estan llenos");
					cont=0;
				}
				
			}
		}
		if(todasAlzasColocadas && todasAlzasExtraidas){
			System.out.println("cambia el estado de asignacion a completado");
			UsuarioApiario objUsuApi = new UsuarioApiario();
			UsuarioApiario confirm = new UsuarioApiario();
			objUsuApi=service.obtenerPorIdUsuarioApiario(usuarioApiarioExtraccion.getIdUsuarioApiario());
			objUsuApi.setEstadoAsignacion("revisado");
			objUsuApi.setFechaRevision(new Date());
			confirm=service.guardarUsuarioApiario(objUsuApi);
			if(confirm.isSuccess()){
				System.out.println("se modifico el estado a revisado");
			}else{
				System.out.println("erro en cambio de esstado");
			}
			
		}else{
			System.out.println("aun no se ah acabado");
			System.out.println("cambia el estado de asignacion a asignado");
			UsuarioApiario objUsuApi = new UsuarioApiario();
			UsuarioApiario confirm = new UsuarioApiario();
			objUsuApi=service.obtenerPorIdUsuarioApiario(usuarioApiarioExtraccion.getIdUsuarioApiario());
			objUsuApi.setEstadoAsignacion("asignado");
			objUsuApi.setFechaRevision(null);
			confirm=service.guardarUsuarioApiario(objUsuApi);
			if(confirm.isSuccess()){
				System.out.println("se modifico el estado a asignado");
			}else{
				System.out.println("erro en cambio de asignado");
			}
		}

		
	}
}
