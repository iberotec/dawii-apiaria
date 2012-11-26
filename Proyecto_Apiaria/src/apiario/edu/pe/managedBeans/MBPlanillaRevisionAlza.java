package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.service.SeleccionService;
import org.primefaces.model.SelectableDataModel;  

public class MBPlanillaRevisionAlza implements Serializable,SelectableDataModel<Alza> {

	private static final long serialVersionUID = 1L;

	private int idPlanillaRevisionAlza;

	private String estadoAlza;

	private byte estadoDeterioroAlza;

	private double porcentajeMiel;

	private PlanillaRevision planillaRevision;
	
	private Integer cod_planillaRevision;

	private Alza alza;
	
	private Integer idAlza;
	
	SeleccionService service = new SeleccionService();
	
	private List<Alza> listaAlza;
	
	DataModel<Alza> listaalzamodel;
	
	private Piso piso;
	
	private Integer codpiso;
		
	
	public MBPlanillaRevisionAlza() {
		limpiar();
	}
	
	public void limpiar(){
		
		piso = new Piso();
		
	}
	
	public void listarAlzas(){
		
		listaAlza = service.listarAlzaporPiso(codpiso);
		
	}

	public String registrarPlanillaRevisionAlza(){
		int resultado=0;
		PlanillaRevisionAlza obj = new PlanillaRevisionAlza();
		planillaRevision = new PlanillaRevision();
		planillaRevision.setIdPlanillaRevision(getCod_planillaRevision());
		obj.setPlanillaRevision(planillaRevision);
		alza = new Alza();
		alza.setIdAlza(getIdAlza());
		obj.setAlza(alza);
		obj.setEstadoAlza(getEstadoAlza());
		obj.setPorcentajeMiel(getPorcentajeMiel());
		obj.setEstadoAlza(getEstadoAlza());
		
		service.registrarPlanillaRevisionAlza(obj);
		
		if(resultado==1){
			
			obj = new PlanillaRevisionAlza();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se registró correctamente","")); 
			return "successUbicacion"; 
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No se registró correctamente",""));
			return "successUbicacion";
		}
		
	}
	
	//getter and setter

	public int getIdPlanillaRevisionAlza() {
		return idPlanillaRevisionAlza;
	}

	public void setIdPlanillaRevisionAlza(int idPlanillaRevisionAlza) {
		this.idPlanillaRevisionAlza = idPlanillaRevisionAlza;
	}

	public String getEstadoAlza() {
		return estadoAlza;
	}

	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}

	public byte getEstadoDeterioroAlza() {
		return estadoDeterioroAlza;
	}

	public void setEstadoDeterioroAlza(byte estadoDeterioroAlza) {
		this.estadoDeterioroAlza = estadoDeterioroAlza;
	}

	public double getPorcentajeMiel() {
		return porcentajeMiel;
	}

	public void setPorcentajeMiel(double porcentajeMiel) {
		this.porcentajeMiel = porcentajeMiel;
	}

	public PlanillaRevision getPlanillaRevision() {
		return planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}

	public Alza getAlza() {
		return alza;
	}

	public void setAlza(Alza alza) {
		this.alza = alza;
	}


	public void setCod_planillaRevision(int cod_planillaRevision) {
		this.cod_planillaRevision = cod_planillaRevision;
	}


	public int getCod_planillaRevision() {
		return cod_planillaRevision;
	}

	public void setIdAlza(Integer idAlza) {
		this.idAlza = idAlza;
	}


	public Integer getIdAlza() {
		return idAlza;
	}
	
	public Integer getCodpiso() {
		return codpiso;
	}

	public void setCodpiso(Integer codpiso) {
		this.codpiso = codpiso;
	}

	public Piso getPiso() {
		return piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	public void setListaAlza(List<Alza> listaAlza) {
		this.listaAlza = listaAlza;
	}

	public List<Alza> getListaAlza() {
		return listaAlza;
	}

	public DataModel<Alza> getListaalzamodel() {
		
		listaalzamodel = new ListDataModel<Alza>(service.listarAlzaporPiso(codpiso));
		
		return listaalzamodel;
	}

	public void setListaalzamodel(DataModel<Alza> listaalzamodel) {
		this.listaalzamodel = listaalzamodel;
	}

	@Override
	public Alza getRowData(String rowkey) {
		
		for(Alza obj: listaAlza) {  
            if(listaAlza.get(0).getIdAlza().equals(rowkey));  
                return obj;  
        }  
		
		return null;
	}

	@Override
	public Object getRowKey(Alza alza) {
		
		 return alza.getIdAlza();  
	}
	
}
