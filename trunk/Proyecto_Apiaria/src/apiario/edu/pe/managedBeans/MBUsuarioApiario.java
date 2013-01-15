package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;




import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Reina;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.TipoAlimentacion;
import apiario.edu.pe.bean.TipoEnfermedad;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBUsuarioApiario implements Serializable{
//	private boolean muestraModal;
	private UsuarioApiario usuarioApiario;
	private List<UsuarioApiario> listaUsarioApiario = new ArrayList<UsuarioApiario>();
	private SeleccionService service = new SeleccionService();
	private String ubicacionApiario;
	private String nivelPeligro;
	private int nivelPeligroId;
	private List<EstadoRevisionEquipamientoTrabajo> listaERET = new ArrayList<EstadoRevisionEquipamientoTrabajo>();
	private Colmena colmena;
	private List<Colmena> listaColmenas=new ArrayList<Colmena>();
	private PlanillaRevision objplanillaRevision;
	private Colmena objColmena;
	private EstadoRevision objEstadoRevision;
	private int p_indice_usuarioApiario;
	private boolean mostrarEquipoSeguridad;
	private List<PlanillaRevision> listaPR = new ArrayList<PlanillaRevision>();
	private PlanillaRevision planillaRevision;
	private Boolean muestraExistenciaReina;
	private String muestraEstadoCosecha;
	private boolean muestraNecesidadAlimentacion;
	private boolean muestraNecesidadCuracion;
	private boolean muestraFaltaEspacioCamara;
	private boolean muestraFaltaAlza;
	private String muestraComportamiento;
	private Integer muestraEstadoRevision;
	private boolean muestraListaColmenas;
	private DualListModel<NormaSeguridad> listaNS = new DualListModel<NormaSeguridad>();
	private NormaSeguridad normaSeguridad;
	private NormaSeguridadUsuarioApiario normaSeguridadUsuarioApiario;
	private List<NormaSeguridadUsuarioApiario> listaNSA = new ArrayList<NormaSeguridadUsuarioApiario>();
	private List<String> listaString = new ArrayList<String>();
	private boolean muestraCajaTexto;
	private PlanillaRevision planillaRevisionSeleccionada;
	private Integer muestraTipoEnfermedad;
	private Integer muestraTipoAlimentacion;
	private boolean activarTipoEnfermedad;
	private boolean activarTipoAlimentacion;
	private List<Alza> listaAlza = new ArrayList<Alza>();
	private Colmena colmenaSeleccionada;
	private List<PlanillaRevisionAlza> listaPlanillaRevisionAlza= new ArrayList<PlanillaRevisionAlza>();
	private PlanillaRevisionAlza planillaRevisionAlzaSeleccionada;
	private PlanillaRevisionAlza planillaRevisionAlza;
//	private String muestraEstadoAlza;
	private boolean muestraEstadoDeterioroAlza;
	private boolean muestraCajaIdAlza;
	private double muestraPorcentajeMiel;
	private boolean activaTabAlza;
	private boolean activaListadoAlza;
	private Integer muestraIdAlza;
	private boolean muestraEstadoDeterioroColmena;


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
	
	public boolean isMostrarEquipoSeguridad() {
		return mostrarEquipoSeguridad;
	}

	public void setMostrarEquipoSeguridad(boolean mostrarEquipoSeguridad) {
		this.mostrarEquipoSeguridad = mostrarEquipoSeguridad;
	}
	
	public List<PlanillaRevision> getListaPR() {
		return listaPR;
	}

	public void setListaPR(List<PlanillaRevision> listaPR) {
		this.listaPR = listaPR;
	}
	
	public PlanillaRevision getPlanillaRevision() {
		return planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}

	public Boolean getMuestraExistenciaReina() {
		return muestraExistenciaReina;
	}
	
	public String getMuestraEstadoCosecha() {
		return muestraEstadoCosecha;
	}

	public void setMuestraEstadoCosecha(String muestraEstadoCosecha) {
		this.muestraEstadoCosecha = muestraEstadoCosecha;
	}

	public void setMuestraExistenciaReina(Boolean muestraExistenciaReina) {
		this.muestraExistenciaReina = muestraExistenciaReina;
	}
	
	public boolean isMuestraNecesidadAlimentacion() {
		return muestraNecesidadAlimentacion;
	}

	public void setMuestraNecesidadAlimentacion(boolean muestraNecesidadAlimentacion) {
		this.muestraNecesidadAlimentacion = muestraNecesidadAlimentacion;
	}

	public boolean isMuestraNecesidadCuracion() {
		return muestraNecesidadCuracion;
	}

	public void setMuestraNecesidadCuracion(boolean muestraNecesidadCuracion) {
		this.muestraNecesidadCuracion = muestraNecesidadCuracion;
	}

	public boolean isMuestraFaltaEspacioCamara() {
		return muestraFaltaEspacioCamara;
	}

	public void setMuestraFaltaEspacioCamara(boolean muestraFaltaEspacioCamara) {
		this.muestraFaltaEspacioCamara = muestraFaltaEspacioCamara;
	}

	public boolean isMuestraFaltaAlza() {
		return muestraFaltaAlza;
	}

	public void setMuestraFaltaAlza(boolean muestraFaltaAlza) {
		this.muestraFaltaAlza = muestraFaltaAlza;
	}

	public String getMuestraComportamiento() {
		return muestraComportamiento;
	}

	public void setMuestraComportamiento(String muestraComportamiento) {
		this.muestraComportamiento = muestraComportamiento;
	}
	
	public boolean isMuestraListaColmenas() {
		return muestraListaColmenas;
	}

	public void setMuestraListaColmenas(boolean muestraListaColmenas) {
		this.muestraListaColmenas = muestraListaColmenas;
	}
	
	public DualListModel<NormaSeguridad> getListaNS() {
		return listaNS;
	}

	public void setListaNS(DualListModel<NormaSeguridad> listaNS) {
		this.listaNS = listaNS;
	}

	public NormaSeguridad getNormaSeguridad() {
		return normaSeguridad;
	}

	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}

	public NormaSeguridadUsuarioApiario getNormaSeguridadUsuarioApiario() {
		return normaSeguridadUsuarioApiario;
	}

	public void setNormaSeguridadUsuarioApiario(NormaSeguridadUsuarioApiario normaSeguridadUsuarioApiario) {
		this.normaSeguridadUsuarioApiario = normaSeguridadUsuarioApiario;
	}

	public List<NormaSeguridadUsuarioApiario> getListaNSA() {
		return listaNSA;
	}

	public void setListaNSA(List<NormaSeguridadUsuarioApiario> listaNSA) {
		this.listaNSA = listaNSA;
	}

	public List<String> getListaString() {
		return listaString;
	}

	public void setListaString(List<String> listaString) {
		this.listaString = listaString;
	}

	public boolean isMuestraCajaTexto() {
		return muestraCajaTexto;
	}

	public void setMuestraCajaTexto(boolean muestraCajaTexto) {
		this.muestraCajaTexto = muestraCajaTexto;
	}

	public Integer getMuestraEstadoRevision() {
		return muestraEstadoRevision;
	}

	public void setMuestraEstadoRevision(Integer muestraEstadoRevision) {
		this.muestraEstadoRevision = muestraEstadoRevision;
	}

	public PlanillaRevision getPlanillaRevisionSeleccionada() {
		return planillaRevisionSeleccionada;
	}

	public void setPlanillaRevisionSeleccionada(
			PlanillaRevision planillaRevisionSeleccionada) {
		this.planillaRevisionSeleccionada = planillaRevisionSeleccionada;
	}
	
	public Integer getMuestraTipoEnfermedad() {
		return muestraTipoEnfermedad;
	}

	public void setMuestraTipoEnfermedad(Integer muestraTipoEnfermedad) {
		this.muestraTipoEnfermedad = muestraTipoEnfermedad;
	}

	public Integer getMuestraTipoAlimentacion() {
		return muestraTipoAlimentacion;
	}

	public void setMuestraTipoAlimentacion(Integer muestraTipoAlimentacion) {
		this.muestraTipoAlimentacion = muestraTipoAlimentacion;
	}

	public boolean isActivarTipoEnfermedad() {
		return activarTipoEnfermedad;
	}

	public void setActivarTipoEnfermedad(boolean activarTipoEnfermedad) {
		this.activarTipoEnfermedad = activarTipoEnfermedad;
	}

	public boolean isActivarTipoAlimentacion() {
		return activarTipoAlimentacion;
	}

	public void setActivarTipoAlimentacion(boolean activarTipoAlimentacion) {
		this.activarTipoAlimentacion = activarTipoAlimentacion;
	}

	public List<Alza> getListaAlza() {
		return listaAlza;
	}

	public void setListaAlza(List<Alza> listaAlza) {
		this.listaAlza = listaAlza;
	}

	public Colmena getColmenaSeleccionada() {
		return colmenaSeleccionada;
	}

	public void setColmenaSeleccionada(Colmena colmenaSeleccionada) {
		this.colmenaSeleccionada = colmenaSeleccionada;
	}

	public List<PlanillaRevisionAlza> getListaPlanillaRevisionAlza() {
		return listaPlanillaRevisionAlza;
	}

	public void setListaPlanillaRevisionAlza(
			List<PlanillaRevisionAlza> listaPlanillaRevisionAlza) {
		this.listaPlanillaRevisionAlza = listaPlanillaRevisionAlza;
	}

	public PlanillaRevisionAlza getPlanillaRevisionAlzaSeleccionada() {
		return planillaRevisionAlzaSeleccionada;
	}

	public void setPlanillaRevisionAlzaSeleccionada(
			PlanillaRevisionAlza planillaRevisionAlzaSeleccionada) {
		this.planillaRevisionAlzaSeleccionada = planillaRevisionAlzaSeleccionada;
	}

	public PlanillaRevisionAlza getPlanillaRevisionAlza() {
		return planillaRevisionAlza;
	}

	public void setPlanillaRevisionAlza(PlanillaRevisionAlza planillaRevisionAlza) {
		this.planillaRevisionAlza = planillaRevisionAlza;
	}
	
//	public String getMuestraEstadoAlza() {
//		return muestraEstadoAlza;
//	}
//
//	public void setMuestraEstadoAlza(String muestraEstadoAlza) {
//		this.muestraEstadoAlza = muestraEstadoAlza;
//	}

	public boolean isMuestraEstadoDeterioroAlza() {
		return muestraEstadoDeterioroAlza;
	}

	public void setMuestraEstadoDeterioroAlza(boolean muestraEstadoDeterioroAlza) {
		this.muestraEstadoDeterioroAlza = muestraEstadoDeterioroAlza;
	}

	public boolean isMuestraCajaIdAlza() {
		return muestraCajaIdAlza;
	}

	public void setMuestraCajaIdAlza(boolean muestraCajaIdAlza) {
		this.muestraCajaIdAlza = muestraCajaIdAlza;
	}

	public double getMuestraPorcentajeMiel() {
		return muestraPorcentajeMiel;
	}

	public void setMuestraPorcentajeMiel(double muestraPorcentajeMiel) {
		this.muestraPorcentajeMiel = muestraPorcentajeMiel;
	}

	public boolean isActivaTabAlza() {
		return activaTabAlza;
	}

	public void setActivaTabAlza(boolean activaTabAlza) {
		this.activaTabAlza = activaTabAlza;
	}

	public boolean isActivaListadoAlza() {
		return activaListadoAlza;
	}

	public void setActivaListadoAlza(boolean activaListadoAlza) {
		this.activaListadoAlza = activaListadoAlza;
	}

	public Integer getMuestraIdAlza() {
		return muestraIdAlza;
	}

	public void setMuestraIdAlza(Integer muestraIdAlza) {
		this.muestraIdAlza = muestraIdAlza;
	}

//	public boolean isMuestraModal() {
//		return muestraModal;
//	}
//
//	public void setMuestraModal(boolean muestraModal) {
//		this.muestraModal = muestraModal;
//	}

	public boolean isMuestraEstadoDeterioroColmena() {
		return muestraEstadoDeterioroColmena;
	}

	public void setMuestraEstadoDeterioroColmena(
			boolean muestraEstadoDeterioroColmena) {
		this.muestraEstadoDeterioroColmena = muestraEstadoDeterioroColmena;
	}

	public MBUsuarioApiario() {


	}
	public String abrirMantenimientoUsuarioApiario() throws Exception{
		return "successMantenimientoUsuarioApiario";
	}
	public void limpiarNuevaAsignacion(){
		System.out.println("limpiarNuevaAsignacion");
		usuarioApiario= new UsuarioApiario();
		usuarioApiario.setApiario(new Apiario());
		usuarioApiario.setUsuario(new Usuario());
		usuarioApiario.setTemporada(new Temporada());
		listaERET = new ArrayList<EstadoRevisionEquipamientoTrabajo>();
		listaPR = new ArrayList<PlanillaRevision>();
		listaString= new ArrayList<String>();
		ubicacionApiario="";
		nivelPeligro="";
		mostrarEquipoSeguridad=false;
	}
	public String abrirNuevaAsignacion() throws Exception{
		System.out.println("abriendo nueva asignacion");
		limpiarNuevaAsignacion();
		
		return "successNuevaAsignacion";
	}
	public void listarTodosUsuarioApiario() throws Exception{
		System.out.println("entro a listartodos");
		Date fechaActual= new Date();
		Temporada objT = new Temporada();
		objT.setEtapaTemporada("seleccion");
		objT.setEstadoTemporada(true);
		List<Temporada> listaT = new ArrayList<Temporada>();
		listaT= service.buscarTemporada(objT);
		if(listaT.size()>0){
			System.out.println("entro al if 1");
			if(listaT.get(0).getPeriodoFinal().getTime()>=fechaActual.getTime()){
				System.out.println("entro al if 2");
				UsuarioApiario objUA =new UsuarioApiario();
				objUA.setUsuario(new Usuario());
				objUA.setTemporada(new Temporada());
				objUA.setUsuario((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
				objUA.getTemporada().setIdTemporada(listaT.get(0).getIdTemporada());
				listaUsarioApiario=service.buscarUsuarioApiario(objUA);
				System.out.println("tamaño de la lista en listarTodos"+listaUsarioApiario.size());
			}
		}
	
		
	}
//	public String obtenerNivelPeligro(Set<PlanillaRevision> set){
//		String retorno="No precisa";
//		System.out.println("tamaño lista nivel peligro "+set.size());
//		if(set.size()>0){
//			System.out.println("paso primer if");
//			for (PlanillaRevision planillaRevision : set) {
//				System.out.println("entro al for");
//				if(planillaRevision!=null){
//					System.out.println("entro al segundo if");
//					System.out.println("id "+planillaRevision.getIdPlanillaRevision());
//					System.out.println("id reina "+planillaRevision.getReina().getIdReina());
//					if(planillaRevision.getEstadoRevision()!=null){
//						System.out.println("entro al tercer if");
//						if(planillaRevision.getEstadoRevision().getDescripcionEstadoRevision()!=null &&
//								planillaRevision.getEstadoRevision().getDescripcionEstadoRevision().length()>0){
//							System.out.println("entro al cuerto if");
//							retorno= planillaRevision.getEstadoRevision().getDescripcionEstadoRevision();
//							System.out.println("retorno "+retorno);
//						}
//					}
//				}
//				
//			}
//		}
//		
//		return retorno;
//	}
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
		if(usuarioApiario.getApiario()!=null){
			if(usuarioApiario.getApiario().getIdApiario()!=null && usuarioApiario.getApiario().getIdApiario().intValue()>0){
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
				nivelPeligroId=0;
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
					 nivelPeligro="No precisa";
				 }
			}else{
				nivelPeligro="";
				nivelPeligroId=0;
				ubicacionApiario="";
			}
			

		}else{
			nivelPeligro="";
			nivelPeligroId=0;
			ubicacionApiario="";
		}
		


	}
	public void obtenerEquipoSeguridad() throws Exception{
		System.out.println("obtenerEquipoSeguridad");
		if(nivelPeligroId!=0){
			EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
			objERET.setEstadoRevision(new EstadoRevision());
			objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
			
			mostrarEquipoSeguridad=true;
			listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
			System.out.println("tamaño de lista obtenerEquipoSeguridad "+listaERET.size());
		}else{
			mostrarEquipoSeguridad=false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No precisa Nivel de Peligro consulte a su Superior para saber que equipo llevar o utilize su criterio")); 
			System.out.println("error al grabar");
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
							 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "El Apiario "+usuarioApiario.getApiario().getIdApiario()+" ya fue asignado")); 
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
	public void guardarUsuarioApiario() throws Exception{
		boolean validacion=false;
		usuarioApiario.setUsuario((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		System.out.println("aver???? "+usuarioApiario.getUsuario().getNombreUsuario());
		usuarioApiario.setEstadoAsignacion("asignado");
		usuarioApiario.setFechaAsignacion(new Date());
		

		List<Temporada> listaTemporada = new ArrayList<Temporada>();
		listaTemporada = service.listarTodosTemporada();
		System.out.println("tamaño lista temporada "+listaTemporada.size());
		Date fechaActual= new Date();
		for (int i = 0; i < listaTemporada.size(); i++) {
			System.out.println("etapa "+listaTemporada.get(i).getEtapaTemporada()+" "+"Fecha Final "+listaTemporada.get(i).getPeriodoFinal());
			System.out.println("fecha actual "+fechaActual);
			if(listaTemporada.get(i).getEtapaTemporada().equals("seleccion") && listaTemporada.get(i).getPeriodoFinal().getTime()>=fechaActual.getTime() && listaTemporada.get(i).getEstadoTemporada()){
				System.out.println("entro al if");
				System.out.println("id temporada "+listaTemporada.get(i).getIdTemporada());
				usuarioApiario.getTemporada().setIdTemporada(listaTemporada.get(i).getIdTemporada());
			}

		}

		UsuarioApiario confirm = null;
		try {
			validacion=validarIdApiarioConValor(usuarioApiario);
			validacion=validarUsuarioApiarioUnico(usuarioApiario);
			if(validacion){
				confirm = service.guardarUsuarioApiario(usuarioApiario);
				
				List<Integer> listaIdUsuarioApiario = new ArrayList<Integer>();
				listaIdUsuarioApiario=service.obtenerMaximoIdUsuarioApiario();
				System.out.println("tamaño listaUsuApi "+listaIdUsuarioApiario.size());
				if(listaIdUsuarioApiario.size()>0){
					for (int i = 0; i < listaIdUsuarioApiario.size(); i++) {
						System.out.println("id?? "+listaIdUsuarioApiario.get(i));
						usuarioApiario=service.obtenerPorIdUsuarioApiario(listaIdUsuarioApiario.get(i));
//						usuarioApiario.setIdUsuarioApiario(listaIdUsuarioApiario.get(i));
					}
				}
				System.out.println("usarioApiario id "+usuarioApiario.getIdUsuarioApiario());
				if(confirm.isSuccess()){
					
					List<NormaSeguridad> fuente= new ArrayList<NormaSeguridad>();
					NormaSeguridad objFuenteNS = new NormaSeguridad();
					objFuenteNS.setActivo(true);
					fuente=service.buscarNormaSeguridad(objFuenteNS);
					List<NormaSeguridad> destino= new ArrayList<NormaSeguridad>();
					listaNS = new DualListModel<NormaSeguridad>(fuente, destino);
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
	public void obtenerNivelPeligroEquipoTrabajo() throws Exception{
		PlanillaRevision objPR = new PlanillaRevision();
		objPR.setUsuarioApiario(new UsuarioApiario());
//		objPR.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		objPR.getUsuarioApiario().setApiario(new Apiario());
		objPR.getUsuarioApiario().getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		objPR.getUsuarioApiario().setTemporada(new Temporada());
		if(usuarioApiario.getTemporada().getOrdenTemporada()!=null){
			objPR.getUsuarioApiario().getTemporada().setOrdenTemporada(usuarioApiario.getTemporada().getOrdenTemporada().intValue()-1);
			objPR.getUsuarioApiario().getTemporada().setEtapaTemporada(usuarioApiario.getTemporada().getEtapaTemporada());
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
				nivelPeligro="Peligro";
				EstadoRevision objBuscarER= new EstadoRevision();
				objBuscarER.setDescripcionEstadoRevision(nivelPeligro);
				List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
				listaBuscarER=service.buscarEstadoRevision(objBuscarER);
				if(listaBuscarER.size()>0){
					nivelPeligroId= listaBuscarER.get(0).getIdEstadoRevision();
				}
				
				
			}else{
				nivelPeligro="Normal";
				EstadoRevision objBuscarER= new EstadoRevision();
				objBuscarER.setDescripcionEstadoRevision(nivelPeligro);
				List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
				listaBuscarER=service.buscarEstadoRevision(objBuscarER);
				if(listaBuscarER.size()>0){
					nivelPeligroId= listaBuscarER.get(0).getIdEstadoRevision();
				}
			}

			}else{
				nivelPeligroId=0;
				nivelPeligro="No precisa";
			}
		
			
			
			
			if(nivelPeligroId!=0){
				EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
				objERET.setEstadoRevision(new EstadoRevision());
				objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
				
				listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
				mostrarEquipoSeguridad=true;
			}else{
				System.out.println("no se esta mostrnado el listado -.-!");
				listaERET= new ArrayList<EstadoRevisionEquipamientoTrabajo>();
				mostrarEquipoSeguridad=false;
			}
		}
		
	}
	public void abrirModificarUsuarioApiario(int id) throws Exception{
		

		System.out.println("abrirModificarUsuarioApiario");
		System.out.println("id "+id);
		UsuarioApiario objUA = new UsuarioApiario();
		objUA= service.obtenerPorIdUsuarioApiario(id);
		usuarioApiario =objUA;
		PlanillaSeguimiento objPS = new PlanillaSeguimiento();
		objPS.setEstado(1);
		objPS.setApiario(new Apiario());
		objPS.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		List<PlanillaSeguimiento> listaPS = new ArrayList<PlanillaSeguimiento>();
		listaPS=service.buscarPlanillaSeguimiento(objPS);
		System.out.println("listaPS.size() "+listaPS.size());
		ubicacionApiario=listaPS.get(0).getZona().getUbigeo().getDistrito();
		obtenerNivelPeligroEquipoTrabajo();
//		PlanillaRevision objPR = new PlanillaRevision();
//		objPR.setUsuarioApiario(new UsuarioApiario());
//		objPR.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
//		List<PlanillaRevision> listaPR = new ArrayList<PlanillaRevision>();
//		listaPR = service.buscarPlanillaRevision(objPR);
//		int cont=0;
//		if(listaPR.size()>0){
//			for (int i = 0; i < listaPR.size(); i++) {
//				if(listaPR.get(i).getEstadoRevision().getDescripcionEstadoRevision().equals("Peligro")){
//					cont++;
//				}
//			}
//		if(cont>0){
//			nivelPeligro="Peligro";
//			EstadoRevision objBuscarER= new EstadoRevision();
//			objBuscarER.setDescripcionEstadoRevision(nivelPeligro);
//			List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
//			listaBuscarER=service.buscarEstadoRevision(objBuscarER);
//			if(listaBuscarER.size()>0){
//				nivelPeligroId= listaBuscarER.get(0).getIdEstadoRevision();
//			}
//			
//			
//		}else{
//			nivelPeligro="Normal";
//			EstadoRevision objBuscarER= new EstadoRevision();
//			objBuscarER.setDescripcionEstadoRevision(nivelPeligro);
//			List<EstadoRevision> listaBuscarER= new ArrayList<EstadoRevision>();
//			listaBuscarER=service.buscarEstadoRevision(objBuscarER);
//			if(listaBuscarER.size()>0){
//				nivelPeligroId= listaBuscarER.get(0).getIdEstadoRevision();
//			}
//		}
//
//		}else{
//			nivelPeligroId=0;
//			nivelPeligro="No precisa";
//		}
//	
//		
//		
//		
//		if(nivelPeligroId!=0){
//			EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
//			objERET.setEstadoRevision(new EstadoRevision());
//			objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
//			
//			listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
//			mostrarEquipoSeguridad=true;
//		}else{
//			System.out.println("no se esta mostrnado el listado -.-!");
//			listaERET= new ArrayList<EstadoRevisionEquipamientoTrabajo>();
//			mostrarEquipoSeguridad=false;
//		}


		///////////////////
		List<NormaSeguridad> fuente= new ArrayList<NormaSeguridad>();
		NormaSeguridad objFuenteNS = new NormaSeguridad();
		objFuenteNS.setActivo(true);
		fuente=service.buscarNormaSeguridad(objFuenteNS);
		List<NormaSeguridad> destino= new ArrayList<NormaSeguridad>();
		//para sacar el tamaño de la lista
		List<NormaSeguridad> listaTamaño= new ArrayList<NormaSeguridad>();
		NormaSeguridad objTamaño = new NormaSeguridad();
		objTamaño.setActivo(true);
		listaTamaño=service.buscarNormaSeguridad(objTamaño);
		//para sacar el tamaño de la lista
		NormaSeguridad objEstadoT= new NormaSeguridad();
		
		List<NormaSeguridadUsuarioApiario> listaCumple= new ArrayList<NormaSeguridadUsuarioApiario>();
		NormaSeguridadUsuarioApiario objCumple=new NormaSeguridadUsuarioApiario();
		objCumple.setUsuarioApiario(new UsuarioApiario());
		objCumple.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		objCumple.setEstado(true);
		listaCumple=service.buscarNormaSeguridadUsuarioApiario(objCumple);
		System.out.println("tamaño listaCumple "+listaCumple.size());
		int contV=0;
		if(listaCumple.size()>0){
			destino.clear();
			System.out.println("destino clear tamaño "+destino.size());
			for (int i = 0; i < listaCumple.size(); i++) {
				System.out.println("id norma seguridad cumple"+listaCumple.get(i).getNormaSeguridad().getIdNormaSeguridad());
				System.out.println("esstado cumple "+listaCumple.get(i).getEstado());
				objEstadoT=service.obtenerPorIdNormaSeguridad(listaCumple.get(i).getNormaSeguridad().getIdNormaSeguridad());
				destino.add(objEstadoT);
				System.out.println("destino add tamaño "+destino.size());
				contV++;
			}
			if(contV==listaTamaño.size()){
				fuente.clear();
			}
		}
		
		NormaSeguridad objEstadoF= new NormaSeguridad();
		
		List<NormaSeguridadUsuarioApiario> listaNoCumple= new ArrayList<NormaSeguridadUsuarioApiario>();
		NormaSeguridadUsuarioApiario objNoCumple = new NormaSeguridadUsuarioApiario();
		objNoCumple.setUsuarioApiario(new UsuarioApiario());
		objNoCumple.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		objNoCumple.setEstado(false);
		listaNoCumple=service.buscarNormaSeguridadUsuarioApiario(objNoCumple);
		System.out.println("tamaño listaNoCumple "+listaNoCumple.size());
		int contF=0;
		if(listaNoCumple.size()>0){
			fuente.clear();
			System.out.println("fuente clear tamaño "+fuente.size());
			for (int i = 0; i < listaNoCumple.size(); i++) {
				System.out.println("id norma seguridad No cumple"+listaNoCumple.get(i).getNormaSeguridad().getIdNormaSeguridad());
				System.out.println("estado no cumple "+listaNoCumple.get(i).getEstado());
				objEstadoF=service.obtenerPorIdNormaSeguridad(listaNoCumple.get(i).getNormaSeguridad().getIdNormaSeguridad());
				fuente.add(objEstadoF);
				System.out.println("fuente add tamaño "+fuente.size());
				contF++;
			}
			if(contF==listaTamaño.size()){
				destino.clear();
			}
		}
		
		
		listaNS = new DualListModel<NormaSeguridad>(fuente, destino);
		////////////////
		
		
		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext
        .getCurrentInstance().getApplication()
        .getNavigationHandler();
		handler.performNavigation("successNuevaAsignacion");

	}
	
	public void listarTodosPlanillaRevision() throws Exception{
		PlanillaRevision objPR= new PlanillaRevision();
		objPR.setUsuarioApiario(new UsuarioApiario());
		objPR.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		listaPR = service.buscarPlanillaRevision(objPR);
	}
	public void limpiarPLanillaRevision(){
		System.out.println("limpiarPLanillaRevision");
		planillaRevisionSeleccionada = new PlanillaRevision();
		planillaRevision = new PlanillaRevision();
		planillaRevision.setColmena(new Colmena());
		planillaRevision.setEstadoRevision(new EstadoRevision());
		planillaRevision.setUsuarioApiario(new UsuarioApiario());
		planillaRevision.setReina(new Reina());
		listaColmenas= new ArrayList<Colmena>();
		muestraExistenciaReina=false;
		muestraNecesidadAlimentacion=false;
		muestraNecesidadCuracion=false;
		muestraFaltaEspacioCamara=false;
		muestraFaltaAlza=false;
		muestraEstadoDeterioroColmena=false;
		muestraEstadoCosecha="";
		muestraComportamiento="";
		muestraListaColmenas=true;
		muestraCajaTexto=false;
		muestraEstadoRevision=0;
		muestraTipoAlimentacion=0;
		muestraTipoEnfermedad=0;
		activarTipoEnfermedad=false;
		activarTipoAlimentacion=false;
		activaTabAlza=false;

	}
	public void abrirModificarPlanillaRevision(int id) throws Exception{
		System.out.println("abrirModificarPlanillaRevision");
		listaPlanillaRevisionAlza= new ArrayList<PlanillaRevisionAlza>();
		muestraListaColmenas=false;
		muestraCajaTexto=true;
		activaTabAlza=true;
		System.out.println("id PR "+id);
		PlanillaRevision objPR = new PlanillaRevision();
		objPR = service.obtenerPorIdPlanillaRevision(id);
		planillaRevision=objPR;
		System.out.println("existencia reina "+planillaRevision.getExistenciaReina());
		muestraExistenciaReina=planillaRevision.getExistenciaReina();
		System.out.println("muestraExistenciaReina "+muestraExistenciaReina);
		
		System.out.println("cosechable? "+planillaRevision.getEstadoCosecha());
		muestraEstadoCosecha=planillaRevision.getEstadoCosecha();
		System.out.println("muestraEstadoCosecha "+muestraEstadoCosecha);
		
		System.out.println("planillaRevision.getNecesidadAlimentacion() "+planillaRevision.getNecesidadAlimentacion());
		muestraNecesidadAlimentacion=planillaRevision.getNecesidadAlimentacion();
		System.out.println("muestraNecesidadAlimentacion "+muestraNecesidadAlimentacion);
		
		muestraEstadoDeterioroColmena=planillaRevision.getEstadoDeterioroColmena();
		
		System.out.println("planillaRevision.getNecesidadCuracion() "+planillaRevision.getNecesidadCuracion());
		muestraNecesidadCuracion=planillaRevision.getNecesidadCuracion();
		System.out.println("muestraNecesidadCuracion "+muestraNecesidadCuracion);
		
		System.out.println("planillaRevision.getFaltaEspacioCamara() "+planillaRevision.getFaltaEspacioCamara());
		muestraFaltaEspacioCamara=planillaRevision.getFaltaEspacioCamara();
		System.out.println("muestraFaltaEspacioCamara "+muestraFaltaEspacioCamara);
		
		System.out.println("planillaRevision.getFaltaAlza() "+planillaRevision.getFaltaAlza());
		muestraFaltaAlza=planillaRevision.getFaltaAlza();
		System.out.println("muestraFaltaAlza "+muestraFaltaAlza);
		
		muestraEstadoRevision=planillaRevision.getEstadoRevision().getIdEstadoRevision();
		
		muestraComportamiento=planillaRevision.getComportamiento();
		
		if(muestraNecesidadAlimentacion){
			System.out.println("if");
			activarTipoAlimentacion=true;
			PlanillaRevisionTipoAlimentacion obj = new PlanillaRevisionTipoAlimentacion();
			obj.setPlanillaRevision(new PlanillaRevision());
			obj.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
			List<PlanillaRevisionTipoAlimentacion> lista = new ArrayList<PlanillaRevisionTipoAlimentacion>();
			lista = service.buscarPlanillaRevisionTipoAlimentacion(obj);
			muestraTipoAlimentacion=lista.get(0).getTipoAlimentacion().getIdTipoAlimentacion();

		}else{
			System.out.println("else");
			activarTipoAlimentacion=false;

		}
		if(muestraNecesidadCuracion){
			System.out.println("if");
			activarTipoEnfermedad=true;
			PlanillaRevisionTipoEnfermedad obj = new PlanillaRevisionTipoEnfermedad();
			obj.setPlanillaRevision(new PlanillaRevision());
			obj.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
			List<PlanillaRevisionTipoEnfermedad> lista = new ArrayList<PlanillaRevisionTipoEnfermedad>();
			lista = service.buscarPlanillaRevisionTipoEnfermedad(obj);
			muestraTipoEnfermedad=lista.get(0).getTipoEnfermedad().getIdTipoEnfermedad();
			
		}else{
			System.out.println("else");
			activarTipoEnfermedad=false;

		}
		
	}
	public void abrirRegistrarPlanillaRevision() throws Exception{
		limpiarPLanillaRevision();
		System.out.println("abrirRegistrarPlanillaRevision");
		Colmena objC = new Colmena();
		objC.setApiario(new Apiario());
		objC.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		listaColmenas = service.buscarColmena(objC);
		muestraEstadoCosecha="no cosechable";
		System.out.println("id planilla revision al abrir registrar"+planillaRevision.getIdPlanillaRevision());

	}
	public boolean validarPlanillaRevisionUnica(PlanillaRevision obj) throws Exception{
		boolean resultado=true;
		boolean validar=false;
		if(obj!=null){
			if(obj.getIdPlanillaRevision()!=null && obj.getIdPlanillaRevision().intValue()>0){
				PlanillaRevision objGenerico = new PlanillaRevision();
				objGenerico = service.obtenerPorIdPlanillaRevision(obj.getIdPlanillaRevision());
				if(objGenerico.getColmena().getIdColmena()!=obj.getColmena().getIdColmena()){
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
				if(obj.getUsuarioApiario()!= null && obj.getColmena()!=null){
					System.out.println("entro al if no es null obj usuarioApiario ni colmena");
					if(obj.getUsuarioApiario().getIdUsuarioApiario()!=null && obj.getUsuarioApiario().getIdUsuarioApiario().intValue()>0 &&
							obj.getColmena().getIdColmena()!=null && obj.getColmena().getIdColmena().intValue()>0){
						System.out.println("entro al if los ids existen");
						List<PlanillaRevision> lista = new ArrayList<PlanillaRevision>();
						lista=service.listarTodosPlanillaRevisions();
						if(lista.size()>0){
							System.out.println("entro al if la lista es mayor a 0");
							for (int i = 0; i < lista.size(); i++) {
								System.out.println("recorriendo el for");
								System.out.println("id usuarioApiario "+obj.getUsuarioApiario().getIdUsuarioApiario()+" - "+"lista "+lista.get(i).getUsuarioApiario().getIdUsuarioApiario());
								System.out.println("id colmena "+obj.getColmena().getIdColmena()+" - "+"lista "+lista.get(i).getColmena().getIdColmena());
								if(obj.getUsuarioApiario().getIdUsuarioApiario().intValue()==lista.get(i).getUsuarioApiario().getIdUsuarioApiario().intValue() && obj.getColmena().getIdColmena().intValue()==lista.get(i).getColmena().getIdColmena().intValue()){
									System.out.println("se encontraron repetidos");
									resultado=false;
								}
							}
						}else{
							System.out.println("no hay registros en la tabla");
							resultado=true;
						}
						
						if(!resultado){
							 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "La Colmena "+obj.getColmena().getIdColmena()+" ya fue revisada")); 
						}
					}else{
						resultado=false;
					}
				}else{
					resultado=false;
				}
			}
		}
		
		
		
		
		System.out.println("resultado validacion planillaRevision "+resultado);
		return resultado;
	}
	public boolean validarCamposVaciosPlanillaRevision(PlanillaRevision obj){
		boolean resultado=true;
		
		System.out.println("obj.getEstadoCosecha() "+obj.getEstadoCosecha());
		if(obj.getEstadoCosecha()==null || obj.getEstadoCosecha().equals("0")){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona un estado de cosecha")); 
		}
			
		
		System.out.println("obj.getEstadoRevision() "+obj.getEstadoRevision());
		System.out.println("obj.getEstadoRevision().getIdEstadoRevision() "+obj.getEstadoRevision().getIdEstadoRevision());
		if(obj.getEstadoRevision().getIdEstadoRevision()==null || obj.getEstadoRevision().getIdEstadoRevision().intValue()==0){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona un estado de revision")); 
		}

			
		
		System.out.println("obj.getReina() "+obj.getReina());
		System.out.println("obj.getReina().getIdReina() "+obj.getReina().getIdReina());
		if(obj.getReina().getIdReina()==null || obj.getReina().getIdReina().intValue()==0){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "La Colmena "+obj.getColmena().getIdColmena()+" no tiene reina")); 
		}
		if(obj.getNecesidadAlimentacion()){
			if(muestraTipoAlimentacion==0){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Seleccione un tipo de alimentacion")); 
			}
		}
		if(obj.getNecesidadCuracion()){
			if(muestraTipoEnfermedad==0){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Seleccione un tipo de enfermedad")); 
			}
		}
		
		System.out.println("resulado validacion campos vacios "+resultado);
		return resultado;
	}
	public void guardarPlanillaRevision() throws Exception{
		PlanillaRevision confirm=null;
		boolean validacion=false;
		int cont=0;
		boolean grabar=false;
		try {
			if(planillaRevision.getIdPlanillaRevision()==null){
				System.out.println("nuevo registro planilla revision");
				if(listaColmenas.size()>0){
					System.out.println("tamñao lista "+listaColmenas.size());
					for (int i = 0; i < listaColmenas.size(); i++) {
						if(listaColmenas.get(i).isSel()){
							cont++;
						}
					}
				}
				if(cont>0){
					grabar=true;
					System.out.println("puede grabar planilla de revison");
				}else{
					System.out.println("muestra mensaje de seleccionar una colmena");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona al menos una colmena")); 
				}
				
				if(grabar){
					if(listaColmenas.size()>0){
						System.out.println("tamñao lista "+listaColmenas.size());
						for (int i = 0; i < listaColmenas.size(); i++) {
							if(listaColmenas.get(i).isSel()){
								//////
								System.out.println("activo? "+listaColmenas.get(i).isSel());
								System.out.println("id colmena "+listaColmenas.get(i).getIdColmena());
								
								planillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
								planillaRevision.setExistenciaReina(muestraExistenciaReina);
								
								Reina objR= new Reina();
								objR.setColmena(new Colmena());
								objR.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
								List<Reina> listaReina = new ArrayList<Reina>();
								listaReina = service.buscarReina(objR);
								System.out.println("listaReina "+listaReina);
								System.out.println("tamaño lista Reina "+listaReina.size());
								planillaRevision.getReina().setIdReina(null);
								if(listaReina.size()>0){
									planillaRevision.getReina().setIdReina(listaReina.get(0).getIdReina());
								}
								
								
								planillaRevision.setEstadoCosecha(muestraEstadoCosecha);
								planillaRevision.setNecesidadAlimentacion(muestraNecesidadAlimentacion);
								planillaRevision.setNecesidadCuracion(muestraNecesidadCuracion);
								planillaRevision.setFaltaEspacioCamara(muestraFaltaEspacioCamara);
								planillaRevision.setFaltaAlza(muestraFaltaAlza);
								planillaRevision.setEstadoDeterioroColmena(muestraEstadoDeterioroColmena);
								planillaRevision.setComportamiento(muestraComportamiento);
								planillaRevision.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
								planillaRevision.getEstadoRevision().setIdEstadoRevision(muestraEstadoRevision);
								
								
								validacion=validarCamposVaciosPlanillaRevision(planillaRevision);
								if(validacion){
									validacion=validarPlanillaRevisionUnica(planillaRevision);
								}
								
								if(validacion){
									confirm=service.guardarPlanillaRevision(planillaRevision);
									
									List<Integer> listaIdPlanillaRevision= new ArrayList<Integer>();
									listaIdPlanillaRevision = service.obtenerMaximoIdPlanillaRevision();
									if(muestraTipoAlimentacion.intValue()>0){
										System.out.println("grabando PlanillaRevisionTipoAlimentacion");
										PlanillaRevisionTipoAlimentacion objPRTA= new PlanillaRevisionTipoAlimentacion();
										objPRTA.setPlanillaRevision(new PlanillaRevision());
										objPRTA.getPlanillaRevision().setIdPlanillaRevision(listaIdPlanillaRevision.get(0));
										objPRTA.setTipoAlimentacion(new TipoAlimentacion());
										objPRTA.getTipoAlimentacion().setIdTipoAlimentacion(muestraTipoAlimentacion);
										
										PlanillaRevisionTipoAlimentacion confirmPRTA= null;
										confirmPRTA=service.guardarPlanillaRevisionTipoAlimentacion(objPRTA);
										if(confirmPRTA.isSuccess()){
											System.out.println("grabo PRTA");
										}else{
											System.out.println("error PRTA");
										}
									}
									if(muestraTipoEnfermedad.intValue()>0){
										System.out.println("grabando PlanillaRevisionTipoEnfermedad");
										PlanillaRevisionTipoEnfermedad objPRTE= new PlanillaRevisionTipoEnfermedad();
										objPRTE.setPlanillaRevision(new PlanillaRevision());
										objPRTE.setTipoEnfermedad(new TipoEnfermedad());
										objPRTE.getPlanillaRevision().setIdPlanillaRevision(listaIdPlanillaRevision.get(0));
										objPRTE.getTipoEnfermedad().setIdTipoEnfermedad(muestraTipoEnfermedad);
										
										PlanillaRevisionTipoEnfermedad confirmPRTE= null;
										confirmPRTE=service.guardarPlanillaRevisionTipoEnfermedad(objPRTE);
										if(confirmPRTE.isSuccess()){
											System.out.println("grabo PRTE");
										}else{
											System.out.println("error PRTE");
										}
									}
								}
							//////	
							}
						}
						
						if(validacion){
							if(confirm.isSuccess()){
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una nueva planilla de revision"));  
								System.out.println("grabo");
							}else{
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la planilla de revision")); 
								System.out.println("error al grabar");
							}
						}
						
					}
				}
				
			}else{
				System.out.println("modificacion planilla revision");
				planillaRevision.setExistenciaReina(muestraExistenciaReina);
				planillaRevision.setEstadoCosecha(muestraEstadoCosecha);
				planillaRevision.setFaltaEspacioCamara(muestraFaltaEspacioCamara);
				planillaRevision.setFaltaAlza(muestraFaltaAlza);
				planillaRevision.setEstadoDeterioroColmena(muestraEstadoDeterioroColmena);
				planillaRevision.setComportamiento(muestraComportamiento);
				planillaRevision.getEstadoRevision().setIdEstadoRevision(muestraEstadoRevision);
				planillaRevision.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
				planillaRevision.setNecesidadAlimentacion(muestraNecesidadAlimentacion);
				planillaRevision.setNecesidadCuracion(muestraNecesidadCuracion);
				validacion=validarCamposVaciosPlanillaRevision(planillaRevision);
				if(validacion){
					validacion=validarPlanillaRevisionUnica(planillaRevision);
				}
				if(validacion){
					confirm=service.guardarPlanillaRevision(planillaRevision);
					List<Integer> listaIdPlanillaRevision= new ArrayList<Integer>();
					listaIdPlanillaRevision = service.obtenerMaximoIdPlanillaRevision();
					if(planillaRevision.getNecesidadAlimentacion()){
						if(muestraTipoAlimentacion.intValue()>0){
							
							PlanillaRevisionTipoAlimentacion objBuscaIdPRTA= new PlanillaRevisionTipoAlimentacion();
							objBuscaIdPRTA.setPlanillaRevision(new PlanillaRevision());
							objBuscaIdPRTA.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
							List<PlanillaRevisionTipoAlimentacion> listaBuscaIdPRTA= new ArrayList<PlanillaRevisionTipoAlimentacion>();
							listaBuscaIdPRTA=service.buscarPlanillaRevisionTipoAlimentacion(objBuscaIdPRTA);
							
							
							System.out.println("grabando PlanillaRevisionTipoAlimentacion");
							PlanillaRevisionTipoAlimentacion objPRTA= new PlanillaRevisionTipoAlimentacion();
							objPRTA.setPlanillaRevision(new PlanillaRevision());
							objPRTA.getPlanillaRevision().setIdPlanillaRevision(listaIdPlanillaRevision.get(0));
							objPRTA.setTipoAlimentacion(new TipoAlimentacion());
							objPRTA.getTipoAlimentacion().setIdTipoAlimentacion(muestraTipoAlimentacion);
							if(listaBuscaIdPRTA.size()>0){
								objPRTA.setIdPlanillaRevisionTipoAlimentacion(listaBuscaIdPRTA.get(0).getIdPlanillaRevisionTipoAlimentacion());
							}
							PlanillaRevisionTipoAlimentacion confirmPRTA= null;
							confirmPRTA=service.guardarPlanillaRevisionTipoAlimentacion(objPRTA);
							if(confirmPRTA.isSuccess()){
								System.out.println("grabo PRTA");
							}else{
								System.out.println("error PRTA");
							}
						}
					}else{
						PlanillaRevisionTipoAlimentacion objBuscarPRTA= new PlanillaRevisionTipoAlimentacion();
						objBuscarPRTA.setPlanillaRevision(new PlanillaRevision());
						objBuscarPRTA.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
						List<PlanillaRevisionTipoAlimentacion> listaBuscarPRTA= new ArrayList<PlanillaRevisionTipoAlimentacion>();
						listaBuscarPRTA= service.buscarPlanillaRevisionTipoAlimentacion(objBuscarPRTA);
						if(listaBuscarPRTA.size()>0){
							PlanillaRevisionTipoAlimentacion confirmacion= null;
							PlanillaRevisionTipoAlimentacion eliminar=new PlanillaRevisionTipoAlimentacion();
							List<Integer> listaIds= new ArrayList<Integer>();
							for (int i = 0; i < listaBuscarPRTA.size(); i++) {
								listaIds.add(listaBuscarPRTA.get(i).getIdPlanillaRevisionTipoAlimentacion());
							}
							eliminar.setListaEliminar(listaIds);
							confirmacion=service.eliminarPlanillaRevisionTipoAlimentacion(eliminar);
							if(confirmacion.isSuccess()){
								System.out.println("elimino correctamente PRTA");
							}else{
								System.out.println("error al eliminar PRTA");
							}
						}
					}
					if(planillaRevision.getNecesidadCuracion()){
						if(muestraTipoEnfermedad.intValue()>0){
							PlanillaRevisionTipoEnfermedad objBuscaIdPRTE= new PlanillaRevisionTipoEnfermedad();
							objBuscaIdPRTE.setPlanillaRevision(new PlanillaRevision());
							objBuscaIdPRTE.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
							List<PlanillaRevisionTipoEnfermedad> listaBuscaIdPRTE= new ArrayList<PlanillaRevisionTipoEnfermedad>();
							listaBuscaIdPRTE=service.buscarPlanillaRevisionTipoEnfermedad(objBuscaIdPRTE);
								
							System.out.println("grabando PlanillaRevisionTipoEnfermedad");
							PlanillaRevisionTipoEnfermedad objPRTE= new PlanillaRevisionTipoEnfermedad();
							objPRTE.setPlanillaRevision(new PlanillaRevision());
							objPRTE.setTipoEnfermedad(new TipoEnfermedad());
							objPRTE.getPlanillaRevision().setIdPlanillaRevision(listaIdPlanillaRevision.get(0));
							objPRTE.getTipoEnfermedad().setIdTipoEnfermedad(muestraTipoEnfermedad);
							if(listaBuscaIdPRTE.size()>0){
								objPRTE.setIdPlanillaRevisionTipoEnfermedad(listaBuscaIdPRTE.get(0).getIdPlanillaRevisionTipoEnfermedad());
							}
							PlanillaRevisionTipoEnfermedad confirmPRTE= null;
							confirmPRTE=service.guardarPlanillaRevisionTipoEnfermedad(objPRTE);
							if(confirmPRTE.isSuccess()){
								System.out.println("grabo PRTE");
							}else{
								System.out.println("error PRTE");
							}
						}
					}else{
						PlanillaRevisionTipoEnfermedad objBuscarPRTE= new PlanillaRevisionTipoEnfermedad();
						objBuscarPRTE.setPlanillaRevision(new PlanillaRevision());
						objBuscarPRTE.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
						List<PlanillaRevisionTipoEnfermedad> listaBuscarPRTE= new ArrayList<PlanillaRevisionTipoEnfermedad>();
						listaBuscarPRTE= service.buscarPlanillaRevisionTipoEnfermedad(objBuscarPRTE);
						if(listaBuscarPRTE.size()>0){
							PlanillaRevisionTipoEnfermedad confirmacion= null;
							PlanillaRevisionTipoEnfermedad eliminar=new PlanillaRevisionTipoEnfermedad();
							List<Integer> listaIds= new ArrayList<Integer>();
							for (int i = 0; i < listaBuscarPRTE.size(); i++) {
								listaIds.add(listaBuscarPRTE.get(i).getIdPlanillaRevisionTipoEnfermedad());
							}
							eliminar.setListaEliminar(listaIds);
							confirmacion=service.eliminarPlanillaRevisionTipoEnfermedad(eliminar);
							if(confirmacion.isSuccess()){
								System.out.println("elimino correctamente PRTE");
							}else{
								System.out.println("error al eliminar PRTE");
							}
						}
					}
					if(confirm.isSuccess()){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una nueva planilla de revision"));  
						System.out.println("grabo");
					}else{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la planilla de revision")); 
						System.out.println("error al grabar");
					}
				}	
			}
			obtenerNivelPeligroEquipoTrabajo();
			validarTerminoAsignacion();
			listarTodosPlanillaRevision();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}	
	}
	
	public void guardarControlCalidad() throws Exception{
		System.out.println("guardarControlCalidad");
		NormaSeguridadUsuarioApiario confirm= null;
		NormaSeguridadUsuarioApiario obj = new NormaSeguridadUsuarioApiario();
		obj.setNormaSeguridad(new NormaSeguridad());
		obj.setUsuarioApiario(new UsuarioApiario());
//		NormaSeguridadUsuarioApiario objNocumple= new NormaSeguridadUsuarioApiario();
		if(listaNS.getSource().size()>0){
			
			List<NormaSeguridadUsuarioApiario> listaBusqueda= new ArrayList<NormaSeguridadUsuarioApiario>();
			NormaSeguridadUsuarioApiario objBusqueda= new NormaSeguridadUsuarioApiario();
			objBusqueda.setNormaSeguridad(new NormaSeguridad());
			objBusqueda.setUsuarioApiario(new UsuarioApiario());
			
			for (int i = 0; i < listaNS.getSource().size(); i++) {
				//no cumple
				System.out.println("id source NS "+listaNS.getSource().get(i).getIdNormaSeguridad());
				System.out.println("desc source NS "+listaNS.getSource().get(i).getDescripcionNormaSeguridad());
				obj.setEstado(false);
				obj.setFechaRegistro(new Date());
				obj.getNormaSeguridad().setIdNormaSeguridad(listaNS.getSource().get(i).getIdNormaSeguridad());
				obj.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
				
				objBusqueda.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
				objBusqueda.getNormaSeguridad().setIdNormaSeguridad(obj.getNormaSeguridad().getIdNormaSeguridad());
				listaBusqueda=service.buscarNormaSeguridadUsuarioApiario(objBusqueda);
				if(listaBusqueda.size()>0){
					obj.setIdNormaSeguridadUsuarioApiario(listaBusqueda.get(0).getIdNormaSeguridadUsuarioApiario());
				}
				
				confirm = service.guardarNormaSeguridadUsuarioApiario(obj);
			}
		}
	
		
		if(listaNS.getTarget().size()>0){
			List<NormaSeguridadUsuarioApiario> listaBusqueda= new ArrayList<NormaSeguridadUsuarioApiario>();
			NormaSeguridadUsuarioApiario objBusqueda= new NormaSeguridadUsuarioApiario();
			objBusqueda.setNormaSeguridad(new NormaSeguridad());
			objBusqueda.setUsuarioApiario(new UsuarioApiario());
			
			for (int i = 0; i < listaNS.getTarget().size(); i++) {
				//cumple
				System.out.println("id targetNS "+listaNS.getTarget().get(i).getIdNormaSeguridad());
				System.out.println("desc target NS "+listaNS.getTarget().get(i).getDescripcionNormaSeguridad());
				obj.setEstado(true);
				obj.setFechaRegistro(new Date());
				obj.getNormaSeguridad().setIdNormaSeguridad(listaNS.getTarget().get(i).getIdNormaSeguridad());
				obj.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
				
				objBusqueda.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
				objBusqueda.getNormaSeguridad().setIdNormaSeguridad(obj.getNormaSeguridad().getIdNormaSeguridad());
				listaBusqueda=service.buscarNormaSeguridadUsuarioApiario(objBusqueda);
				if(listaBusqueda.size()>0){
					obj.setIdNormaSeguridadUsuarioApiario(listaBusqueda.get(0).getIdNormaSeguridadUsuarioApiario());
				}
				
				confirm = service.guardarNormaSeguridadUsuarioApiario(obj);
			}
		}
		validarTerminoAsignacion();
		if(confirm.isSuccess()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro el control de calidad"));  
			System.out.println("grabo");
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro el control de calidad")); 
			System.out.println("error al grabar");
		}
	}
	public void mostrarComboTipoEnfermedad(){
		System.out.println("mostrarComboTipoEnfermedad");
		if(muestraNecesidadCuracion){
			System.out.println("if");
			activarTipoEnfermedad=true;

		}else{
			System.out.println("else");
			activarTipoEnfermedad=false;

		}
	}
	public void mostrarComboTipoAlimentacion(){
		System.out.println("mostrarComboTipoAlimentacion");
		if(muestraNecesidadAlimentacion){
			System.out.println("if");
			activarTipoAlimentacion=true;

		}else{
			System.out.println("else");
			activarTipoAlimentacion=false;

		}
	}
	public void limpiarPlanillaRevisionAlza(){
		System.out.println("limpiarPlanillaRevisionAlza");
		planillaRevisionAlzaSeleccionada = new PlanillaRevisionAlza();
		planillaRevisionAlza = new PlanillaRevisionAlza();
		planillaRevisionAlza.setAlza(new Alza());
		planillaRevisionAlza.setPlanillaRevision(new PlanillaRevision());
		listaAlza= new ArrayList<Alza>();
//		muestraEstadoAlza="";
		muestraEstadoDeterioroAlza=false;
		muestraCajaIdAlza=false;
		muestraPorcentajeMiel=0;
		activaListadoAlza=true;
		muestraIdAlza=0;
		
	}
	public void listarTodosPlanillaRevisionAlza() throws Exception{
		System.out.println("listarTodosRevisionAlza");
		PlanillaRevisionAlza obj = new PlanillaRevisionAlza();
		obj.setAlza(new Alza());
		obj.getAlza().setPiso(new Piso());
		obj.getAlza().getPiso().setColmena(new Colmena());
		obj.getAlza().getPiso().getColmena().setIdColmena(planillaRevision.getColmena().getIdColmena());
		listaPlanillaRevisionAlza = service.buscarPlanillaRevisionAlza(obj);
	}
	public void abrirModificarPlanillaRevisionAlza(int id) throws Exception{
		System.out.println("abrirModificarPlanillaRevisionAlzaAAAAAAAAAAA");
		activaListadoAlza=false;
		System.out.println("id de planillarevisonalza "+id);
		muestraCajaIdAlza=true;
		PlanillaRevisionAlza obj = new PlanillaRevisionAlza();
		obj.setIdPlanillaRevisionAlza(id);
		planillaRevisionAlza=service.obtenerPorIdPlanillaRevisionAlza(obj.getIdPlanillaRevisionAlza());
		muestraIdAlza=planillaRevisionAlza.getAlza().getIdAlza();
//		muestraEstadoAlza=planillaRevisionAlza.getEstadoAlza();
		muestraEstadoDeterioroAlza=planillaRevisionAlza.getEstadoDeterioroAlza();
		muestraPorcentajeMiel= planillaRevisionAlza.getPorcentajeMiel();
		
	}
	public void abrirRegistrarPlanillaRevisionAlza() throws Exception{
		System.out.println("abrirRegistrarRevisionAlza");
		System.out.println("porcent miel "+muestraPorcentajeMiel);
		limpiarPlanillaRevisionAlza();
		System.out.println("id colmena "+planillaRevision.getColmena().getIdColmena());
		Alza obj = new Alza();
		obj.setEstadoAlza("en colmena");
		obj.setPiso(new Piso());
		obj.getPiso().setColmena(new Colmena());
		obj.getPiso().getColmena().setIdColmena(planillaRevision.getColmena().getIdColmena());
		System.out.println("obj id colmena "+obj.getPiso().getColmena().getIdColmena());
		listaAlza = service.buscarAlza(obj);
		System.out.println("tamaño lista alza "+listaAlza.size());
//		muestraEstadoAlza="en colmena";
		
	}
	public boolean validarPlanillaRevisionAlzaUnica(PlanillaRevisionAlza obj) throws Exception{
		boolean resultado=true;
		boolean validar=false;
		
		if(obj!=null){
			if(obj.getIdPlanillaRevisionAlza()!=null && obj.getIdPlanillaRevisionAlza().intValue()>0){
				PlanillaRevisionAlza objGenerico = new PlanillaRevisionAlza();
				objGenerico = service.obtenerPorIdPlanillaRevisionAlza(obj.getIdPlanillaRevisionAlza());
				if(objGenerico.getAlza().getIdAlza()!=obj.getAlza().getIdAlza()){
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
				if(obj.getPlanillaRevision()!= null && obj.getAlza()!=null){
					System.out.println("entro al if no es null obj PlanillaRevision ni Alza");
					if(obj.getPlanillaRevision().getIdPlanillaRevision()!=null && obj.getPlanillaRevision().getIdPlanillaRevision().intValue()>0 &&
							obj.getAlza().getIdAlza()!=null && obj.getAlza().getIdAlza().intValue()>0){
						System.out.println("entro al if los ids existen");
						List<PlanillaRevisionAlza> lista = new ArrayList<PlanillaRevisionAlza>();
						lista=service.listarTodosPlanillaRevisionAlza();
						if(lista.size()>0){
							System.out.println("entro al if la lista es mayor a 0");
							for (int i = 0; i < lista.size(); i++) {
								System.out.println("recorriendo el for");
								System.out.println("id usuarioApiario "+obj.getPlanillaRevision().getIdPlanillaRevision()+" - "+"lista "+lista.get(i).getPlanillaRevision().getIdPlanillaRevision());
								System.out.println("id colmena "+obj.getAlza().getIdAlza()+" - "+"lista "+lista.get(i).getAlza().getIdAlza());
								if(obj.getPlanillaRevision().getIdPlanillaRevision().intValue()==lista.get(i).getPlanillaRevision().getIdPlanillaRevision().intValue() && obj.getAlza().getIdAlza().intValue()==lista.get(i).getAlza().getIdAlza().intValue()){
									System.out.println("se encontraron repetidos");
									resultado=false;
								}
							}
						}else{
							System.out.println("no hay registros en la tabla");
							resultado=true;
						}
						
						if(!resultado){
							 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "El Alza "+obj.getAlza().getIdAlza()+" ya fue revisada")); 
						}
					}else{
						resultado=false;
					}
				}else{
					resultado=false;
				}
			}
		}
		
		
		System.out.println("resutaldo de planillaRevisionAlza "+resultado);
		return resultado;
	}
	public boolean validarCamposVaciosPlanillaRevisionAlza(PlanillaRevisionAlza obj){
		boolean resultado=true;
		
//		System.out.println("obj.getEstadoCosecha() "+obj.getEstadoAlza());
//		if(obj.getEstadoAlza()==null || obj.getEstadoAlza().equals("0")){
//				resultado=false;
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona un estado de alza")); 
//		}
//			
//		System.out.println("obj.getEstadoCosecha() "+obj.getEstadoAlza());
		if(obj.getPorcentajeMiel()==null || obj.getPorcentajeMiel().intValue()==0){
				resultado=false;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Ingrese el porcentaje de miel")); 
		}


		
		System.out.println("resulado validacion campos vacios "+resultado);
		return resultado;
	}
//	public void abrirEliminarPlanillaRevisionAlza(){
//		int cont=0;
//		for (int i = 0; i < listaPlanillaRevisionAlza.size(); i++) {
//			if(listaPlanillaRevisionAlza.get(i).isSel()){
//				cont++;
//			}
//		}
//		if(cont>0){
//			System.out.println("entro if "+cont);
//			muestraModal=true;
////			setOnComplete("dialogEliminarPra.show()");
////			System.out.println("oncomplete "+getOnComplete());
//		}else{
//			muestraModal=false;
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona al menos uno"));
//		}
//		
//	}
	public void eliminarPlanillaRevisionAlza() throws Exception{
		PlanillaRevisionAlza confirm=null;
		int cont=0;
		List<Integer> listaIds= new ArrayList<Integer>();
		for (int i = 0; i < listaPlanillaRevisionAlza.size(); i++) {
			if(listaPlanillaRevisionAlza.get(i).isSel()){
				listaIds.add(listaPlanillaRevisionAlza.get(i).getIdPlanillaRevisionAlza());
				cont++;
			}
		}
		if(cont>0){
			PlanillaRevisionAlza eliminar=new PlanillaRevisionAlza();
			eliminar.setListaEliminar(listaIds);
			
			PlanillaRevisionAlza obj = new PlanillaRevisionAlza();
			Alza objAlza= new Alza(); 
			Alza confirmacion= null;
			for (int i = 0; i < eliminar.getListaEliminar().size(); i++) {
				obj=service.obtenerPorIdPlanillaRevisionAlza(eliminar.getListaEliminar().get(i));
				objAlza=service.obtenerPorIdAlza(obj.getAlza().getIdAlza());
				objAlza.setEstadoAlza("en colmena");
				confirmacion=service.guardarAlza(objAlza);
				if(confirmacion.isSuccess()){
					System.out.println("se paso el estado de alza a en colmena por eliminacion");
				}else{
					System.out.println("error no se paso el estado de alza a en colmena por eliminacion");
				}
			}
			
			confirm=service.eliminarPlanillaRevisionAlza(eliminar);
			listarTodosPlanillaRevisionAlza();
			
			if(confirm.isSuccess()){
				validarTerminoAsignacion();
				validarCambioEstadoCosechaColmena();
				listarTodosPlanillaRevision();	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se elimino el registro satisfactoriamente"));  
				System.out.println("elimino");
			}else{
				System.out.println("mensaje de seleccione un alza");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error fatal", "No se pudo eliminar"));
				System.out.println("error");
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona al menos uno")); 
		}
	}
	public void validarCambioEstadoCosechaColmena() throws Exception{
		System.out.println("validarCambioEstadoCosechaColmena");
		PlanillaRevisionAlza objBusquedaPRA= new PlanillaRevisionAlza();
		objBusquedaPRA.setPlanillaRevision(new PlanillaRevision());
		objBusquedaPRA.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
		List<PlanillaRevisionAlza> listaBusquedaPRA= new ArrayList<PlanillaRevisionAlza>();
		listaBusquedaPRA=service.buscarPlanillaRevisionAlza(objBusquedaPRA);
		int cont=0;
		if(listaBusquedaPRA.size()>0){
			for (int i = 0; i < listaBusquedaPRA.size(); i++) {
				if(listaBusquedaPRA.get(i).getPorcentajeMiel().intValue()>=75){
					cont++;
				}
			}
			if(cont>0){
				System.out.println("cont>0");
				PlanillaRevision objObtenerPR= new PlanillaRevision();
				PlanillaRevision confirm= new PlanillaRevision();
				objObtenerPR= service.obtenerPorIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
				objObtenerPR.setEstadoCosecha("cosechable");
				confirm=service.guardarPlanillaRevision(objObtenerPR);
				if(confirm.isSuccess()){
					System.out.println("se modifico el estado de cosecha");
					muestraEstadoCosecha="cosechable";
				}else{
					System.out.println("error en modificacion de estado de cosecha");
				}
			}else{
				System.out.println("else");
				PlanillaRevision objElse= new PlanillaRevision();
				PlanillaRevision confirmElse= new PlanillaRevision();
				objElse= service.obtenerPorIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
				objElse.setEstadoCosecha("no cosechable");
				confirmElse=service.guardarPlanillaRevision(objElse);
				if(confirmElse.isSuccess()){
					System.out.println("se modifico el estado de cosecha");
					muestraEstadoCosecha="no cosechable";
				}else{
					System.out.println("error en modificacion de estado de cosecha");
				}
			}
		}else{
			System.out.println("else lista=0");
			PlanillaRevision objElseLista= new PlanillaRevision();
			PlanillaRevision confirmElseLista= new PlanillaRevision();
			objElseLista= service.obtenerPorIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
			objElseLista.setEstadoCosecha("no cosechable");
			confirmElseLista=service.guardarPlanillaRevision(objElseLista);
			if(confirmElseLista.isSuccess()){
				System.out.println("se modifico el estado else lista de cosecha");
				muestraEstadoCosecha="no cosechable";
			}else{
				System.out.println("error en modificacion de estado else lista de cosecha");
			}
		}
	}
	public void guardarPlanillaRevisionAlza(){
		System.out.println("guardarPlanillaRevisionAlza");
		PlanillaRevisionAlza confirm=null;
		boolean validar=false;
		boolean grabar=false;
		int cont=0;
		try {
			if(planillaRevisionAlza.getIdPlanillaRevisionAlza()==null){
				System.out.println("nuevo registro planillaRevisionAlza");
				
				
				
				if(listaAlza.size()>0){
					for (int i = 0; i < listaAlza.size(); i++) {
						if(listaAlza.get(i).isSel()){
							cont++;
						}
					}
				}
				if(cont>0){
					System.out.println("graba planillaRevisionAlza");
					grabar=true;
				}else{
					System.out.println("mensaje de seleccione un alza");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Selecciona al menos una alza")); 
				}
				
				
				if(grabar){
					
					if(listaAlza.size()>0){
						for (int i = 0; i < listaAlza.size(); i++) {
							if(listaAlza.get(i).isSel()){
								planillaRevisionAlza.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
								planillaRevisionAlza.getAlza().setIdAlza(listaAlza.get(i).getIdAlza());
//								planillaRevisionAlza.setEstadoAlza(muestraEstadoAlza);
								planillaRevisionAlza.setEstadoDeterioroAlza(muestraEstadoDeterioroAlza);
								planillaRevisionAlza.setPorcentajeMiel(muestraPorcentajeMiel);
								
								validar=validarCamposVaciosPlanillaRevisionAlza(planillaRevisionAlza);
								
								if(validar){
									validar=validarPlanillaRevisionAlzaUnica(planillaRevisionAlza);
								}
								
								
								if(validar){
									validarEstadoAlzaxPorcentajeMiel(planillaRevisionAlza);
									confirm=service.guardarPlanillaRevisionAlza(planillaRevisionAlza);
								}
								
								
							}
						}
						if(validar){
							if(confirm.isSuccess()){
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una revision de alza"));  
								System.out.println("grabo");
							}else{
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la revision de alza")); 
								System.out.println("error al grabar");
							}
						}
					
					}
				}
				
			}else{
				System.out.println("modificacion registro planillaRevisionAlza");
				planillaRevisionAlza.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
				planillaRevisionAlza.getAlza().setIdAlza(muestraIdAlza);
//				planillaRevisionAlza.setEstadoAlza(muestraEstadoAlza);
				planillaRevisionAlza.setEstadoDeterioroAlza(muestraEstadoDeterioroAlza);
				planillaRevisionAlza.setPorcentajeMiel(muestraPorcentajeMiel);
				
				validar=validarCamposVaciosPlanillaRevisionAlza(planillaRevisionAlza);
				
				if(validar){
					validar=validarPlanillaRevisionAlzaUnica(planillaRevisionAlza);
				}
				
				
				if(validar){
					validarEstadoAlzaxPorcentajeMiel(planillaRevisionAlza);
					confirm=service.guardarPlanillaRevisionAlza(planillaRevisionAlza);
					if(confirm.isSuccess()){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una revision de alza"));  
						System.out.println("grabo");
					}else{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la revision de alza")); 
						System.out.println("error al grabar");
					}
				}
			}
			validarTerminoAsignacion();
			validarCambioEstadoCosechaColmena();
			listarTodosPlanillaRevisionAlza();
			listarTodosPlanillaRevision();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}
	
		
	}
	public void validarTerminoAsignacion() throws Exception{
		System.out.println("empesando validacion para termino de asignacion");
		boolean todasColmenasRevisadas=false;
		boolean todasAlzasRevisadas=false;
		boolean ControlCalidadRevisado=false;
		UsuarioApiario confirm=null;
		//todas las colmenas revisadas
		
		
		List<PlanillaRevision> listaPRBusqueda = new ArrayList<PlanillaRevision>();
		PlanillaRevision objPR= new PlanillaRevision();
		objPR.setUsuarioApiario(new UsuarioApiario());
		objPR.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		listaPRBusqueda=service.buscarPlanillaRevision(objPR);
		
		List<Colmena> listaCBusqueda= new ArrayList<Colmena>();
		Colmena objC= new Colmena();
		objC.setApiario(new Apiario());
		objC.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		listaCBusqueda=service.buscarColmena(objC);
		System.out.println("listaPRBusqueda.size() "+listaPRBusqueda.size());
		System.out.println("listaCBusqueda.size() "+listaCBusqueda.size());
		if(listaPRBusqueda.size()==listaCBusqueda.size()){
			System.out.println("entro 1");
			todasColmenasRevisadas=true;
		}
		
		//todas las alzas revisadas
		
		//alzas generales
		List<Alza> listaA= new ArrayList<Alza>();
		
		for (Colmena colmenas : listaCBusqueda) {
			for (Piso pisos : colmenas.getPisos()) {
				for (Alza alzas : pisos.getAlzas()) {
					listaA.add(alzas);
				}
			}
		}
		//alzas generales
		
		//alzas revisadas
		List<PlanillaRevisionAlza> listaAcumulaPRA = new ArrayList<PlanillaRevisionAlza>();
		

		PlanillaRevisionAlza objBusquedaPRA= new PlanillaRevisionAlza();
		List<PlanillaRevisionAlza> listaaBusquedaPRA= new ArrayList<PlanillaRevisionAlza>();
		for (PlanillaRevision planillaRevisiones : listaPRBusqueda) {
			objBusquedaPRA.setPlanillaRevision(new PlanillaRevision());
			objBusquedaPRA.getPlanillaRevision().setIdPlanillaRevision(planillaRevisiones.getIdPlanillaRevision());
			listaaBusquedaPRA= service.buscarPlanillaRevisionAlza(objBusquedaPRA);
			
			for (PlanillaRevisionAlza acumulaPRA : listaaBusquedaPRA) {
				listaAcumulaPRA.add(acumulaPRA);
			}

		}
		

		//alzas revisadas
		System.out.println("listaA.size() "+listaA.size());
		System.out.println("listaAcumulaPRA.size() "+listaAcumulaPRA.size());
		if(listaA.size()==listaAcumulaPRA.size()){
			System.out.println("entro 2");
			todasAlzasRevisadas=true;
		}
		
		
		//este registrado el control de calidad
		List<NormaSeguridad> listaGeneralNS = new ArrayList<NormaSeguridad>();
		
		NormaSeguridad objGeneralNS= new NormaSeguridad();
		objGeneralNS.setActivo(true);
		listaGeneralNS=service.buscarNormaSeguridad(objGeneralNS);
		
		List<NormaSeguridadUsuarioApiario> listaBusquedaNSUA = new ArrayList<NormaSeguridadUsuarioApiario>();
		NormaSeguridadUsuarioApiario objBusquedaNSUA = new NormaSeguridadUsuarioApiario();
		objBusquedaNSUA.setUsuarioApiario(new UsuarioApiario());
		objBusquedaNSUA.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		listaBusquedaNSUA=service.buscarNormaSeguridadUsuarioApiario(objBusquedaNSUA);
		System.out.println("listaGeneralNS.size() "+listaGeneralNS.size());
		System.out.println("listaBusquedaNSUA.size() "+listaBusquedaNSUA.size());
		if(listaGeneralNS.size()==listaBusquedaNSUA.size()){
			System.out.println("entro 3");
			ControlCalidadRevisado=true;
		}
		
		if(ControlCalidadRevisado && todasAlzasRevisadas && todasColmenasRevisadas){
			System.out.println("entro 4");
			UsuarioApiario objUsuarioApiario = new UsuarioApiario();
			objUsuarioApiario= service.obtenerPorIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
			objUsuarioApiario.setEstadoAsignacion("revisado");
			objUsuarioApiario.setFechaRevision(new Date());
			confirm=service.guardarUsuarioApiario(objUsuarioApiario);
			if(confirm.isSuccess()){
				System.out.println("cambio estado revisado");
			}else{
				System.out.println("aun no esta todo revisado");
			}
		}else{
			System.out.println("entro 4 else");
			UsuarioApiario objUsuarioApiario = new UsuarioApiario();
			objUsuarioApiario= service.obtenerPorIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
			objUsuarioApiario.setEstadoAsignacion("asignado");
			objUsuarioApiario.setFechaRevision(null);
			confirm=service.guardarUsuarioApiario(objUsuarioApiario);
			if(confirm.isSuccess()){
				System.out.println("cambio estado asignado");
			}else{
				System.out.println("ya esta todo revisado");
			}
		}
		
	}
	public void validarEstadoAlzaxPorcentajeMiel(PlanillaRevisionAlza obj) throws Exception{
		if(obj.getPorcentajeMiel().intValue()>=75){
			System.out.println("entro al else de cambio de estado alza");
			Alza objAlza= new Alza();
			objAlza= service.obtenerPorIdAlza(obj.getAlza().getIdAlza());
			objAlza.setEstadoAlza("en seleccion");
			Alza confirm= null;
			confirm=service.guardarAlza(objAlza);
			if(confirm.isSuccess()){
				System.out.println("se modifico alza a en seleccion");
			}else{
				System.out.println("error en modificacion");
			}
//			obj.setEstadoAlza("extraido");
//			muestraEstadoAlza="extraido";
//			System.out.println("planillaRevisionAlza.getEstadoAlza() "+obj.getEstadoAlza());
		}else{
			Alza objAlza= new Alza();
			objAlza= service.obtenerPorIdAlza(obj.getAlza().getIdAlza());
			objAlza.setEstadoAlza("en colmena");
			Alza confirm= null;
			confirm=service.guardarAlza(objAlza);
			if(confirm.isSuccess()){
				System.out.println("se modifico alza a en colmena");
			}else{
				System.out.println("error en modificacion");
			}
//			obj.setEstadoAlza("en colmena");
//			muestraEstadoAlza="en colmena";
		}
	}
	
}
