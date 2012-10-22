package apiario.edu.pe.bean.seleccion;

public class DetallePlanillaRevisionAlzaBEAN {

	private PlanillaRevisionBEAN beanPlanillaRevision;
	private AlzaBEAN beanAlza;
	private String estadoDeterioroAlza;
	private double porcentajeMiel;
	private double porcentajePolen;
	private String estadoAlza;
	
	public DetallePlanillaRevisionAlzaBEAN(
			PlanillaRevisionBEAN beanPlanillaRevision, AlzaBEAN beanAlza,
			String estadoDeterioroAlza, double porcentajeMiel,
			double porcentajePolen, String estadoAlza) {
		super();
		this.beanPlanillaRevision = beanPlanillaRevision;
		this.beanAlza = beanAlza;
		this.estadoDeterioroAlza = estadoDeterioroAlza;
		this.porcentajeMiel = porcentajeMiel;
		this.porcentajePolen = porcentajePolen;
		this.estadoAlza = estadoAlza;
	}
	public PlanillaRevisionBEAN getBeanPlanillaRevision() {
		return beanPlanillaRevision;
	}
	public void setBeanPlanillaRevision(PlanillaRevisionBEAN beanPlanillaRevision) {
		this.beanPlanillaRevision = beanPlanillaRevision;
	}
	public AlzaBEAN getBeanAlza() {
		return beanAlza;
	}
	public void setBeanAlza(AlzaBEAN beanAlza) {
		this.beanAlza = beanAlza;
	}
	public String getEstadoDeterioroAlza() {
		return estadoDeterioroAlza;
	}
	public void setEstadoDeterioroAlza(String estadoDeterioroAlza) {
		this.estadoDeterioroAlza = estadoDeterioroAlza;
	}
	public double getPorcentajeMiel() {
		return porcentajeMiel;
	}
	public void setPorcentajeMiel(double porcentajeMiel) {
		this.porcentajeMiel = porcentajeMiel;
	}
	public double getPorcentajePolen() {
		return porcentajePolen;
	}
	public void setPorcentajePolen(double porcentajePolen) {
		this.porcentajePolen = porcentajePolen;
	}
	public String getEstadoAlza() {
		return estadoAlza;
	}
	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}
	
	
}
