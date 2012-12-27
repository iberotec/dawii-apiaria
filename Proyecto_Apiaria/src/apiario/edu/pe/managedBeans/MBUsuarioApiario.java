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

//import com.sun.org.apache.bcel.internal.generic.NEW;


import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadApiario;
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
	private boolean mostrarEquipoSeguridad;
	private List<PlanillaRevision> listaPR = new ArrayList<PlanillaRevision>();
	private PlanillaRevision planillaRevision;
	private Boolean muestraExistenciaReina;
	//prueba
//	private Integer muestraIexistenciaReina;
	//prueba
	private String muestraEstadoCosecha;
	private boolean muestraNecesidadAlimentacion;
	private boolean muestraNecesidadCuracion;
	private boolean muestraFaltaEspacioCamara;
	private boolean muestraFaltaAlza;
	private String muestraComportamiento;
	private Integer muestraEstadoRevision;
	private boolean muestraListaColmenas;
	private List<NormaSeguridad> listaNS = new ArrayList<NormaSeguridad>();
	private NormaSeguridad normaSeguridad;
	private NormaSeguridadApiario normaSeguridadApiario;
	private List<NormaSeguridadApiario> listaNSA = new ArrayList<NormaSeguridadApiario>();
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
	private String muestraEstadoAlza;
	private boolean muestraEstadoDeterioroAlza;
	private boolean muestraCajaIdAlza;
	private double muestraPorcentajeMiel;
	private boolean activaTabAlza;
	private boolean activaListadoAlza;
	private Integer muestraIdAlza;
//	public void limpiar(){
////		objColmena=new Colmena();
//
//		setColmena(new Colmena());
//		objplanillaRevision=new PlanillaRevision();
//		objplanillaRevision.setEstadoRevision(new EstadoRevision());
//		objColmena=new Colmena();
//		objEstadoRevision=new EstadoRevision();
//	}
	
//	public void listColmenas(){
//		System.out.println("Entro Colmenas");
//		System.out.println("-->"+usuarioApiario.getApiario().getIdApiario());
//		listaColmenas.clear();
//		int apiarioId=0;
//		try {
//			System.out.println();
//			apiarioId=usuarioApiario.getApiario().getIdApiario();
//			objColmena.setApiario(new Apiario());
//			System.out.println("IdUsuarioApiario->"+usuarioApiario.getApiario().getIdApiario());
//			System.out.println(">-->"+apiarioId);
////			usuarioApiario.getApiario().getIdApiario()
//			objColmena.getApiario().setIdApiario(apiarioId);
//			listaColmenas=service.buscarColmena(objColmena);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void guardarPlanillaRevision(){
//		System.out.println("Llego al metodo de guardarPlanillaRevision");
//		listColmenas();
//		Reina objReina=new Reina();
//		List<Reina> listaReina=new ArrayList<Reina>();
//		int idReina=0;
//		List arregloEnfermedad;
//		List arregloAlimentacion;
//		try {
//			System.out.println("Entro al try catch");
//			for (int i = 0; i < listaColmenas.size(); i++) {
//				System.out.println("IDUsuarioApiario->"+usuarioApiario.getIdUsuarioApiario());
//				objplanillaRevision.setUsuarioApiario(new UsuarioApiario());
////				usuarioApiario.getIdUsuarioApiario()
//				objplanillaRevision.getUsuarioApiario().setIdUsuarioApiario(1);
//				System.out.println("ListaSize->"+listaColmenas.size());
//				System.out.println("->"+listaColmenas.get(i).isSel());
//				System.out.println("->"+listaColmenas.get(i).getIdColmena());
//				if(listaColmenas.get(i).isSel()==false){
//					System.out.println("Entro a los seleccionados???");
//					System.out.println("Colmena->"+listaColmenas.get(i).getIdColmena());
//					objplanillaRevision.setColmena(new Colmena());
//					objplanillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
//					System.out.println("DespuesColmena->"+listaColmenas.get(i).getIdColmena());
////					objplanillaRevision.getColmena().setIdColmena(1);
//				}
//					
//				System.out.println("ColemnaID para la Reina->"+listaColmenas.get(i).getIdColmena());
//				objReina.setColmena(new Colmena());
//				objReina.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
//				listaReina=service.buscarReina(objReina);
//					
//				for (int j = 0; j < listaReina.size(); j++) {
////					listaColmenas.get(i).getIdColmena()
//					objReina=service.obtenerPorIdReina(listaColmenas.get(i).getIdColmena());
////					listaReina.get(j).getIdReina()
//					objplanillaRevision.setReina(new Reina());
//					objplanillaRevision.getReina().setIdReina(objReina.getIdReina());
//				}
//				
//				objplanillaRevision.setEstadoRevision(new EstadoRevision());
//				objplanillaRevision.getEstadoRevision().setIdEstadoRevision(objEstadoRevision.getIdEstadoRevision());
//				
//				
////				objplanillaRevision.setReina(new Reina());
////				objplanillaRevision.getReina().setIdReina(idReina);
//				
//				
//				System.out.println("IdColmena->"+objplanillaRevision.getColmena().getIdColmena());
//				System.out.println("ExistenciaReina->"+objplanillaRevision.getExistenciaReina());
//				System.out.println("IdReina->"+objplanillaRevision.getReina().getIdReina());
//				System.out.println("EstadoCosecha->"+objplanillaRevision.getEstadoCosecha());
//				System.out.println("NecesidadAlimentacion->"+objplanillaRevision.getNecesidadAlimentacion());
//				System.out.println("NecesidadCuracion->"+objplanillaRevision.getNecesidadCuracion());
//				System.out.println("IdEstadoRevision->"+objplanillaRevision.getEstadoRevision().getIdEstadoRevision());
//				System.out.println("FaltaEspacioCamara->"+objplanillaRevision.getFaltaEspacioCamara());
//				System.out.println("FaltaAlza->"+objplanillaRevision.getFaltaAlza());
//				System.out.println("Comportamiento->"+objplanillaRevision.getComportamiento());
//				System.out.println("IdUsuarioApiario->"+objplanillaRevision.getUsuarioApiario().getIdUsuarioApiario());
//
//				System.out.println("TipoAlimentacion->"+objplanillaRevision.getPlanillaRevisionTipoAlimentacions());
//				System.out.println("TipoEnfermedad->"+objplanillaRevision.getPlanillaRevisionTipoEnfermedads());
//				
//				
//				arregloAlimentacion=objplanillaRevision.getPlanillaRevisionTipoAlimentacions();
//				arregloEnfermedad=objplanillaRevision.getPlanillaRevisionTipoEnfermedads();
//				
////				.get(i).getIdPlanillaRevisionTipoAlimentacion()
////				.get(i).getIdPlanillaRevisionTipoEnfermedad()
//				
//				
//				service.guardarPlanillaRevision(objplanillaRevision);
//				System.out.println("------------------------------------guardar satisfactoriamente");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public void guardarControldeCalidad(){
//		try {
//			
//		} catch (Exception e) {
//			System.out.println("Error al guardar el control de calidad");
//		}
//	}
	
	


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
	
	public List<NormaSeguridad> getListaNS() {
		return listaNS;
	}

	public void setListaNS(List<NormaSeguridad> listaNS) {
		this.listaNS = listaNS;
	}
	
	public NormaSeguridad getNormaSeguridad() {
		return normaSeguridad;
	}

	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}

	public NormaSeguridadApiario getNormaSeguridadApiario() {
		return normaSeguridadApiario;
	}

	public void setNormaSeguridadApiario(NormaSeguridadApiario normaSeguridadApiario) {
		this.normaSeguridadApiario = normaSeguridadApiario;
	}

	public List<NormaSeguridadApiario> getListaNSA() {
		return listaNSA;
	}

	public void setListaNSA(List<NormaSeguridadApiario> listaNSA) {
		this.listaNSA = listaNSA;
	}

	public List<String> getListaString() {
		return listaString;
	}

	public void setListaString(List<String> listaString) {
		this.listaString = listaString;
	}
	
//	public Integer getMuestraIexistenciaReina() {
//		return muestraIexistenciaReina;
//	}
//
//	public void setMuestraIexistenciaReina(Integer muestraIexistenciaReina) {
//		this.muestraIexistenciaReina = muestraIexistenciaReina;
//	}

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
	
	public String getMuestraEstadoAlza() {
		return muestraEstadoAlza;
	}

	public void setMuestraEstadoAlza(String muestraEstadoAlza) {
		this.muestraEstadoAlza = muestraEstadoAlza;
	}

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

	public MBUsuarioApiario() {
//		limpiar();

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
		 System.out.println("tama�o lista planilla de revision antes "+listaPlanillaRevision.size());
		 listaPlanillaRevision=service.buscarPlanillaRevision(objRevision);
		System.out.println("tama�o lista planilla de revision "+ listaPlanillaRevision.size());
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

//		listColmenas();

	}
	public void obtenerEquipoSeguridad() throws Exception{
		System.out.println("obtenerEquipoSeguridad");
		EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
		objERET.setEstadoRevision(new EstadoRevision());
		objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
		
		mostrarEquipoSeguridad=true;
		listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
		System.out.println("tama�o de lista obtenerEquipoSeguridad "+listaERET.size());
		
		
		
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
			
			List<Integer> listaIdApiario = new ArrayList<Integer>();
			listaIdApiario=service.obtenerMaximoIdUsuarioApiario();
			System.out.println("tama�o listaUsuApi "+listaIdApiario.size());
			if(listaIdApiario.size()>0){
				for (int i = 0; i < listaIdApiario.size(); i++) {
					System.out.println("id?? "+listaIdApiario.get(i));
					usuarioApiario.setIdUsuarioApiario(listaIdApiario.get(i));
				}
			}
			System.out.println("usarioApiario id "+usuarioApiario.getIdUsuarioApiario());
			if(confirm.isSuccess()){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una nueva asignacion"));  
				System.out.println("grabo");
			}else{
				  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la asignacion")); 
				System.out.println("error al grabar");
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
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
		ubicacionApiario=listaPS.get(0).getZona().getUbigeo().getDistrito();
		
		PlanillaRevision objPR = new PlanillaRevision();
		objPR.setUsuarioApiario(new UsuarioApiario());
		objPR.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
		List<PlanillaRevision> listaPR = new ArrayList<PlanillaRevision>();
		listaPR = service.buscarPlanillaRevision(objPR);
		nivelPeligro = listaPR.get(0).getEstadoRevision().getDescripcionEstadoRevision();
		nivelPeligroId= listaPR.get(0).getEstadoRevision().getIdEstadoRevision();
		
		
		EstadoRevisionEquipamientoTrabajo objERET = new EstadoRevisionEquipamientoTrabajo();
		objERET.setEstadoRevision(new EstadoRevision());
		objERET.getEstadoRevision().setIdEstadoRevision(nivelPeligroId);
		
		
		System.out.println("ubicacionApiario "+ubicacionApiario);
		System.out.println("nivelPeligro "+nivelPeligro);
		System.out.println("nivelPeligroId "+nivelPeligroId);
		listaERET=service.buscarEstadoRevisionEquipamientoTrabajo(objERET);
		
		NormaSeguridadApiario objNSA= new NormaSeguridadApiario();
		objNSA.setApiario(new Apiario());
		objNSA.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
		
		listaNSA = service.buscarNormaSeguridadApiario(objNSA);
		System.out.println("tama�o listaNSA "+listaNSA.size());
		if(listaNSA.size()>0){
			for (int i = 0; i < listaNSA.size(); i++) {
				String idNormaSeguridad=listaNSA.get(i).getNormaSeguridad().getIdNormaSeguridad().toString();
				System.out.println("id NormaSeguridad "+idNormaSeguridad);
				System.out.println("listaString antes "+listaString.size());
				listaString.add(idNormaSeguridad);
				System.out.println("listaString despues "+listaString.size());
			}
		}
		
		mostrarEquipoSeguridad=true;
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
		
//		muestraIexistenciaReina=planillaRevision.getExistenciaReina();
		
		System.out.println("cosechable? "+planillaRevision.getEstadoCosecha());
		muestraEstadoCosecha=planillaRevision.getEstadoCosecha();
		System.out.println("muestraEstadoCosecha "+muestraEstadoCosecha);
		
		System.out.println("planillaRevision.getNecesidadAlimentacion() "+planillaRevision.getNecesidadAlimentacion());
		muestraNecesidadAlimentacion=planillaRevision.getNecesidadAlimentacion();
		System.out.println("muestraNecesidadAlimentacion "+muestraNecesidadAlimentacion);
		
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
			muestraTipoAlimentacion=lista.get(0).getIdPlanillaRevisionTipoAlimentacion();

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
			muestraTipoEnfermedad=lista.get(0).getIdPlanillaRevisionTipoEnfermedad();
			
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
		System.out.println("id planilla revision al abrir registrar"+planillaRevision.getIdPlanillaRevision());

	}
	public void guardarPlanillaRevision() throws Exception{
		PlanillaRevision confirm=null;
//		double porcentajeMiel;
		try {
			if(listaColmenas.size()>0){
				System.out.println("tam�ao lista "+listaColmenas.size());
				for (int i = 0; i < listaColmenas.size(); i++) {
					if(listaColmenas.get(i).isSel()){
//						System.out.println("id de planilla de revision al guardar "+planillaRevision.getIdPlanillaRevision());
						System.out.println("activo? "+listaColmenas.get(i).isSel());
						System.out.println("id colmena "+listaColmenas.get(i).getIdColmena());
						
						planillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
						planillaRevision.setExistenciaReina(muestraExistenciaReina);
						
						Reina objR= new Reina();
						objR = service.obtenerPorIdReina(listaColmenas.get(i).getIdColmena());
						planillaRevision.getReina().setIdReina(objR.getIdReina());
						planillaRevision.setEstadoCosecha(muestraEstadoCosecha);
						planillaRevision.setNecesidadAlimentacion(muestraNecesidadAlimentacion);
						planillaRevision.setNecesidadCuracion(muestraNecesidadCuracion);
						planillaRevision.setFaltaEspacioCamara(muestraFaltaEspacioCamara);
						planillaRevision.setFaltaAlza(muestraFaltaAlza);
						planillaRevision.setComportamiento(muestraComportamiento);
						planillaRevision.getUsuarioApiario().setIdUsuarioApiario(usuarioApiario.getIdUsuarioApiario());
						planillaRevision.getEstadoRevision().setIdEstadoRevision(muestraEstadoRevision);
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
//						if(listaAlza.size()>0){
//							System.out.println("primer if la lista es mayor a 0");
//							PlanillaRevisionAlza confirmPRA =null;
//							for (int j = 0; j < listaAlza.size(); j++) {
//								System.out.println("recorriendo for");
//								if(listaAlza.get(j).isSel()){
//									System.out.println("segundo if se encontro seleccionados");
//									System.out.println("id de alaza "+listaAlza.get(j).getIdAlza());
//									PlanillaRevisionAlza obj = new PlanillaRevisionAlza();
//									obj.setPlanillaRevision(new PlanillaRevision());
//									obj.setAlza(new Alza());
//									obj.getPlanillaRevision().setIdPlanillaRevision(listaIdPlanillaRevision.get(0));
//									obj.getAlza().setIdAlza(listaAlza.get(j).getIdAlza());
//									if(listaAlza.get(i).getMsgResult()!=null && listaAlza.get(i).getMsgResult().length()>0){
//										System.out.println("entro al if");
//										porcentajeMiel= Double.parseDouble(listaAlza.get(i).getMsgResult());
//										System.out.println("porcentaje miel "+porcentajeMiel);
//										obj.setPorcentajeMiel(porcentajeMiel);
//									}
//									confirmPRA = service.guardarPlanillaRevisionAlza(obj);
//									if(confirmPRA.isSuccess()){
//										System.out.println("grabo planilla revision-alza");
//									}else{
//										System.out.println("error no grabo planilla revision-alza");
//									}
//								}
//								
//							}
//							
//							
//						}
						
						
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
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}	
	}
	
	public void guardarControlCalidad(){
		System.out.println("guardarControlCalidad");
		System.out.println("tama�o lista NS "+listaNS.size());
		System.out.println("tama�o listaString "+listaString.size());
		NormaSeguridadApiario obj = new NormaSeguridadApiario();
		NormaSeguridadApiario confirm =null;
		try {
			if(listaString.size()>0){
				for (int i = 0; i < listaString.size(); i++) {
					System.out.println("listaString.get(i) "+listaString.get(i));
					obj.setNormaSeguridad(new NormaSeguridad());
					obj.setApiario(new Apiario());
					obj.getNormaSeguridad().setIdNormaSeguridad(Integer.parseInt(listaString.get(i)));
					obj.getApiario().setIdApiario(usuarioApiario.getApiario().getIdApiario());
					confirm = service.guardarNormaSeguridadApiario(obj);
					
				}
				if(confirm.isSuccess()){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una la Planilla de Normas de Seguridad"));  
					System.out.println("grabo");
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Planilla de Normas de Seguridad")); 
					System.out.println("error al grabar");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}
		
		
//		if(listaNS.size()>0){
//			for (int i = 0; i < listaNS.size(); i++) {
//				System.out.println("id norma "+listaNS.get(i).getDescripcionNormaSeguridad());
//				System.out.println("sel ?"+listaNS.get(i).isSel());
//			}
//		}
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
//	public void obtenerAlzasxColmena(int id) throws Exception{
//		Alza obj = new Alza();
//		obj.setPiso(new Piso());
//		obj.getPiso().setColmena(new Colmena());
//		obj.getPiso().getColmena().setIdColmena(id);
//		if(obj.getPiso().getColmena().getIdColmena()!=null && obj.getPiso().getColmena().getIdColmena().intValue()>0){
//			listaAlza = service.buscarAlza(obj);
//		}
//	}
	public void limpiarPlanillaRevisionAlza(){
		System.out.println("limpiarPlanillaRevisionAlza");
		planillaRevisionAlzaSeleccionada = new PlanillaRevisionAlza();
		planillaRevisionAlza = new PlanillaRevisionAlza();
		planillaRevisionAlza.setAlza(new Alza());
		planillaRevisionAlza.setPlanillaRevision(new PlanillaRevision());
		listaAlza= new ArrayList<Alza>();
		muestraEstadoAlza="";
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
		muestraEstadoAlza=planillaRevisionAlza.getEstadoAlza();
		muestraEstadoDeterioroAlza=planillaRevisionAlza.getEstadoDeterioroAlza();
		muestraPorcentajeMiel= planillaRevisionAlza.getPorcentajeMiel();
		
	}
	public void abrirRegistrarPlanillaRevisionAlza() throws Exception{
		System.out.println("abrirRegistrarRevisionAlza");
		System.out.println("porcent miel "+muestraPorcentajeMiel);
		limpiarPlanillaRevisionAlza();
		System.out.println("id colmena "+planillaRevision.getColmena().getIdColmena());
		Alza obj = new Alza();
		obj.setPiso(new Piso());
		obj.getPiso().setColmena(new Colmena());
		obj.getPiso().getColmena().setIdColmena(planillaRevision.getColmena().getIdColmena());
		System.out.println("obj id colmena "+obj.getPiso().getColmena().getIdColmena());
		listaAlza = service.buscarAlza(obj);
		System.out.println("tama�o lista alza "+listaAlza.size());
		
	}
	public void guardarPlanillaRevisionAlza(){
		System.out.println("guardarPlanillaRevisionAlza");
		PlanillaRevisionAlza confirm=null;
		try {
			if(listaAlza.size()>0){
				for (int i = 0; i < listaAlza.size(); i++) {
					if(listaAlza.get(i).isSel()){
						planillaRevisionAlza.getPlanillaRevision().setIdPlanillaRevision(planillaRevision.getIdPlanillaRevision());
						planillaRevisionAlza.getAlza().setIdAlza(listaAlza.get(i).getIdAlza());
						planillaRevisionAlza.setEstadoAlza(muestraEstadoAlza);
						planillaRevisionAlza.setEstadoDeterioroAlza(muestraEstadoDeterioroAlza);
						planillaRevisionAlza.setPorcentajeMiel(muestraPorcentajeMiel);
						
						confirm=service.guardarPlanillaRevisionAlza(planillaRevisionAlza);
						
					}
				}
				if(confirm.isSuccess()){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro una revision de alza"));  
					System.out.println("grabo");
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la revision de alza")); 
					System.out.println("error al grabar");
				}
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", "Fatal"));
			e.printStackTrace();
		}
	
		
	}
}
