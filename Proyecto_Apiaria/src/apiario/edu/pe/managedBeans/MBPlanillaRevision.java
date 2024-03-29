package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;
import apiario.edu.pe.bean.Reina;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.managedBeans.commons.MBSelectItems;
import apiario.edu.pe.service.SeleccionService;

import java.util.UUID;  

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext; 
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

public class MBPlanillaRevision implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idPlanillaRevision;

	private String comportamiento;

	private String estadoCosecha;

	private byte existenciaReina;

	private String faltaAlza;

	private byte faltaEspacioCamara;

	private byte necesidadAlimentacion;

	private byte necesidadCuracion;
	
	private Date fechaAsignacion;
	
	private Date fechaRevision;
	
	private String estadoPlanillaRevision;
	
	private Colmena colmena;
	
	private int idcolmena;

	private Usuario usuario;

	private Reina reina;

	private EstadoRevision estadoRevision;

	private Temporada temporada;

	private List<PlanillaRevisionAlza> planillaRevisionAlzas;

	private List<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions;

	private List<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads;
	
	private List<PlanillaRevision> planillarevision;
	
	private DataModel<PlanillaRevision> listaplanillarevisionmodel;
	
	SeleccionService service = new SeleccionService();
	
//	private List<Colmena> listaColmenas=new ArrayList<Colmena>();
//	private PlanillaRevision objplanillaRevision;
//	private Colmena objColmena;
//	
//	public void listColmenas(){
//		System.out.println("Entro Colmenas");
//		try {
//			objColmena.setApiario(new Apiario());
//			objColmena.getApiario().setIdApiario(1);
//			listaColmenas=service.buscarColmena(objColmena);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void guardarPlanillaRevision(){
//		System.out.println("Llego al metodo de guardarPlanillaRevision");
//		
//		try {
//			for (int i = 0; i < listaColmenas.size(); i++) {
//				if(listaColmenas.get(i).isSel()){
//					System.out.println("Colmena->"+listaColmenas.get(i).getIdColmena());
//					objplanillaRevision.setColmena(new Colmena());
//					objplanillaRevision.getColmena().setIdColmena(listaColmenas.get(i).getIdColmena());
//				}
//			}
//			service.guardarPlanillaRevision(objplanillaRevision);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
	public MBPlanillaRevision() {
		limpiar();
//		listColmenas();
	}
	
	public void limpiar(){
		colmena=new Colmena();
//		objplanillaRevision=new PlanillaRevision();
//		objColmena=new Colmena();
	}
	
	public void listarPlanillaRevision(){
		planillarevision = service.listaPlanillaRevision(idcolmena);
	}
	
	
	public void setListaplanillarevisionmodel(
			DataModel<PlanillaRevision> listaplanillarevisionmodel) {
		this.listaplanillarevisionmodel = listaplanillarevisionmodel;
	}

	public DataModel<PlanillaRevision> getListaplanillarevisionmodel() {
		
		listaplanillarevisionmodel = new ListDataModel<PlanillaRevision>(service.listaPlanillaRevision(idcolmena));
		
		return listaplanillarevisionmodel;
	}
		
	
	public void onEdit(RowEditEvent event) {  
    //    FacesMessage msg = new FacesMessage("Planilla Edited", ((PlanillaRevision) event.getObject()).getModel());  
		FacesMessage msg = new FacesMessage(event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
      
    public void onDelete(RowEditEvent event) {  
//        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());  
    	FacesMessage msg= new FacesMessage(event.getObject().toString());
    	FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	
	//Getter and Setter
	public int getIdPlanillaRevision() {
		return idPlanillaRevision;
	}

	public void setIdPlanillaRevision(int idPlanillaRevision) {
		this.idPlanillaRevision = idPlanillaRevision;
	}

	public String getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}

	public String getEstadoCosecha() {
		return estadoCosecha;
	}

	public void setEstadoCosecha(String estadoCosecha) {
		this.estadoCosecha = estadoCosecha;
	}

	public byte getExistenciaReina() {
		return existenciaReina;
	}

	public void setExistenciaReina(byte existenciaReina) {
		this.existenciaReina = existenciaReina;
	}

	public String getFaltaAlza() {
		return faltaAlza;
	}

	public void setFaltaAlza(String faltaAlza) {
		this.faltaAlza = faltaAlza;
	}

	public byte getFaltaEspacioCamara() {
		return faltaEspacioCamara;
	}

	public void setFaltaEspacioCamara(byte faltaEspacioCamara) {
		this.faltaEspacioCamara = faltaEspacioCamara;
	}

	public byte getNecesidadAlimentacion() {
		return necesidadAlimentacion;
	}

	public void setNecesidadAlimentacion(byte necesidadAlimentacion) {
		this.necesidadAlimentacion = necesidadAlimentacion;
	}

	public byte getNecesidadCuracion() {
		return necesidadCuracion;
	}

	public void setNecesidadCuracion(byte necesidadCuracion) {
		this.necesidadCuracion = necesidadCuracion;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getEstadoPlanillaRevision() {
		return estadoPlanillaRevision;
	}

	public void setEstadoPlanillaRevision(String estadoPlanillaRevision) {
		this.estadoPlanillaRevision = estadoPlanillaRevision;
	}

	public Colmena getColmena() {
		return colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reina getReina() {
		return reina;
	}

	public void setReina(Reina reina) {
		this.reina = reina;
	}

	public EstadoRevision getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public List<PlanillaRevisionAlza> getPlanillaRevisionAlzas() {
		return planillaRevisionAlzas;
	}

	public void setPlanillaRevisionAlzas(
			List<PlanillaRevisionAlza> planillaRevisionAlzas) {
		this.planillaRevisionAlzas = planillaRevisionAlzas;
	}

	public List<PlanillaRevisionTipoAlimentacion> getPlanillaRevisionTipoAlimentacions() {
		return planillaRevisionTipoAlimentacions;
	}

	public void setPlanillaRevisionTipoAlimentacions(
			List<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions) {
		this.planillaRevisionTipoAlimentacions = planillaRevisionTipoAlimentacions;
	}

	public List<PlanillaRevisionTipoEnfermedad> getPlanillaRevisionTipoEnfermedads() {
		return planillaRevisionTipoEnfermedads;
	}

	public void setPlanillaRevisionTipoEnfermedads(
			List<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads) {
		this.planillaRevisionTipoEnfermedads = planillaRevisionTipoEnfermedads;
	}

	public List<PlanillaRevision> getPlanillarevision() {
		return planillarevision;
	}

	public void setPlanillarevision(List<PlanillaRevision> planillarevision) {
		this.planillarevision = planillarevision;
	}

	public void setIdcolmena(int idcolmena) {
		this.idcolmena = idcolmena;
	}

	public int getIdcolmena() {
		return idcolmena;
	}


//	public List<Colmena> getListaColmenas() {
//		return listaColmenas;
//	}
//	public void setListaColmenas(List<Colmena> listaColmenas) {
//		this.listaColmenas = listaColmenas;
//	}
//
//
//	public void setObjplanillaRevision(PlanillaRevision objplanillaRevision) {
//		this.objplanillaRevision = objplanillaRevision;
//	}
//
//
//	public PlanillaRevision getObjplanillaRevision() {
//		return objplanillaRevision;
//	}
//
//	public Colmena getObjColmena() {
//		return objColmena;
//	}
//
//	public void setObjColmena(Colmena objColmena) {
//		this.objColmena = objColmena;
//	}




}
