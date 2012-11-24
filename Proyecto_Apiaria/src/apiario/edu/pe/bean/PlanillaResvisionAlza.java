package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planilla_resvision_alza database table.
 * 
 */
@Entity
@Table(name="planilla_resvision_alza")
public class PlanillaResvisionAlza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_resvision_alza")
	private int idPlanillaResvisionAlza;

	@Column(name="estado_alza")
	private String estadoAlza;

	@Column(name="estado_deterioro_alza")
	private String estadoDeterioroAlza;

	@Column(name="porcentaje_miel")
	private double porcentajeMiel;

	//bi-directional many-to-one association to Alza
    @ManyToOne
	@JoinColumn(name="iid_alza")
	private Alza alza;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="id_planilla_revision")
	private PlanillaRevision planillaRevision;

    public PlanillaResvisionAlza() {
    }

	public int getIdPlanillaResvisionAlza() {
		return this.idPlanillaResvisionAlza;
	}

	public void setIdPlanillaResvisionAlza(int idPlanillaResvisionAlza) {
		this.idPlanillaResvisionAlza = idPlanillaResvisionAlza;
	}

	public String getEstadoAlza() {
		return this.estadoAlza;
	}

	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}

	public String getEstadoDeterioroAlza() {
		return this.estadoDeterioroAlza;
	}

	public void setEstadoDeterioroAlza(String estadoDeterioroAlza) {
		this.estadoDeterioroAlza = estadoDeterioroAlza;
	}

	public double getPorcentajeMiel() {
		return this.porcentajeMiel;
	}

	public void setPorcentajeMiel(double porcentajeMiel) {
		this.porcentajeMiel = porcentajeMiel;
	}

	public Alza getAlza() {
		return this.alza;
	}

	public void setAlza(Alza alza) {
		this.alza = alza;
	}
	
	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
}