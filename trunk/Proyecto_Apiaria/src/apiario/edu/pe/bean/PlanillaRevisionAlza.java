package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;


/**
 * The persistent class for the planilla_revision_alza database table.
 * 
 */
@Entity
@Table(name="planilla_revision_alza")
public class PlanillaRevisionAlza extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_revision_alza")
	private Integer idPlanillaRevisionAlza;

	@Column(name="estado_alza")
	private String estadoAlza;

	@Column(name="estado_deterioro_alza")
	private Boolean estadoDeterioroAlza;

	@Column(name="porcentaje_miel")
	private Double porcentajeMiel;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="id_planilla_revision")
	private PlanillaRevision planillaRevision;

	//bi-directional many-to-one association to Alza
    @ManyToOne
	@JoinColumn(name="id_alza")
	private Alza alza;

    public PlanillaRevisionAlza() {
    }

	public Integer getIdPlanillaRevisionAlza() {
		return this.idPlanillaRevisionAlza;
	}

	public void setIdPlanillaRevisionAlza(Integer idPlanillaRevisionAlza) {
		this.idPlanillaRevisionAlza = idPlanillaRevisionAlza;
	}

	public String getEstadoAlza() {
		return this.estadoAlza;
	}

	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}

	public Boolean getEstadoDeterioroAlza() {
		return this.estadoDeterioroAlza;
	}

	public void setEstadoDeterioroAlza(Boolean estadoDeterioroAlza) {
		this.estadoDeterioroAlza = estadoDeterioroAlza;
	}

	public Double getPorcentajeMiel() {
		return this.porcentajeMiel;
	}

	public void setPorcentajeMiel(Double porcentajeMiel) {
		this.porcentajeMiel = porcentajeMiel;
	}

	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
	public Alza getAlza() {
		return this.alza;
	}

	public void setAlza(Alza alza) {
		this.alza = alza;
	}
	
}