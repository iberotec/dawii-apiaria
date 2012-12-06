package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;


/**
 * The persistent class for the planilla_revision_tipo_enfermedad database table.
 * 
 */
@Entity
@Table(name="planilla_revision_tipo_enfermedad")
public class PlanillaRevisionTipoEnfermedad extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_revision_tipo_enfermedad")
	private int idPlanillaRevisionTipoEnfermedad;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="id_planilla_revision")
	private PlanillaRevision planillaRevision;

	//bi-directional many-to-one association to TipoEnfermedad
    @ManyToOne
	@JoinColumn(name="id_tipo_enfermedad")
	private TipoEnfermedad tipoEnfermedad;

    public PlanillaRevisionTipoEnfermedad() {
    }

	public int getIdPlanillaRevisionTipoEnfermedad() {
		return this.idPlanillaRevisionTipoEnfermedad;
	}

	public void setIdPlanillaRevisionTipoEnfermedad(int idPlanillaRevisionTipoEnfermedad) {
		this.idPlanillaRevisionTipoEnfermedad = idPlanillaRevisionTipoEnfermedad;
	}

	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoEnfermedad;
	}

	public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}
	
}