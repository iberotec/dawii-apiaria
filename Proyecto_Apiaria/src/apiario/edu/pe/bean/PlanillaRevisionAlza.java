package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planilla_revision_alza database table.
 * 
 */
@Entity
@Table(name="planilla_revision_alza")
public class PlanillaRevisionAlza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_revision_alza")
	private int idPlanillaRevisionAlza;

	@Column(name="estado_alza")
	private String estadoAlza;

	@Column(name="estado_deterioro_alza")
	private byte estadoDeterioroAlza;

	@Column(name="porcentaje_miel")
	private double porcentajeMiel;

	//bi-directional many-to-one association to Alza
    @ManyToOne
	@JoinColumn(name="id_alza")
	private Alza alza;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="id_planilla_revision")
	private PlanillaRevision planillaRevision;

    public PlanillaRevisionAlza() {
    }

	public int getIdPlanillaRevisionAlza() {
		return this.idPlanillaRevisionAlza;
	}

	public void setIdPlanillaRevisionAlza(int idPlanillaRevisionAlza) {
		this.idPlanillaRevisionAlza = idPlanillaRevisionAlza;
	}

	public String getEstadoAlza() {
		return this.estadoAlza;
	}

	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}

	public byte getEstadoDeterioroAlza() {
		return this.estadoDeterioroAlza;
	}

	public void setEstadoDeterioroAlza(byte estadoDeterioroAlza) {
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