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

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;
import apiario.edu.pe.bean.PlanillaRevision;
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
	
	private String nivelPeligroExtraccion;
	private int nivelPeligroIdExtraccion;
	private String ubicacionApiarioExtraccion;
	private boolean mostrarEquipoSeguridadExtraccion;
	

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
}
