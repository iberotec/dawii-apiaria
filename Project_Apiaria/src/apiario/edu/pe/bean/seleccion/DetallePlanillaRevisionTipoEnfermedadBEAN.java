package apiario.edu.pe.bean.seleccion;

public class DetallePlanillaRevisionTipoEnfermedadBEAN {

	private PlanillaRevisionBEAN beanPlanillaRevision;
	private TipoEnfermedadBEAN beanTipoEnfermedad;
	private String miembroEnfermo;
	
	public DetallePlanillaRevisionTipoEnfermedadBEAN(
			PlanillaRevisionBEAN beanPlanillaRevision,
			TipoEnfermedadBEAN beanTipoEnfermedad, String miembroEnfermo) {
		super();
		this.beanPlanillaRevision = beanPlanillaRevision;
		this.beanTipoEnfermedad = beanTipoEnfermedad;
		this.miembroEnfermo = miembroEnfermo;
	}
	public PlanillaRevisionBEAN getBeanPlanillaRevision() {
		return beanPlanillaRevision;
	}
	public void setBeanPlanillaRevision(PlanillaRevisionBEAN beanPlanillaRevision) {
		this.beanPlanillaRevision = beanPlanillaRevision;
	}
	public TipoEnfermedadBEAN getBeanTipoEnfermedad() {
		return beanTipoEnfermedad;
	}
	public void setBeanTipoEnfermedad(TipoEnfermedadBEAN beanTipoEnfermedad) {
		this.beanTipoEnfermedad = beanTipoEnfermedad;
	}
	public String getMiembroEnfermo() {
		return miembroEnfermo;
	}
	public void setMiembroEnfermo(String miembroEnfermo) {
		this.miembroEnfermo = miembroEnfermo;
	}
	
	
}
