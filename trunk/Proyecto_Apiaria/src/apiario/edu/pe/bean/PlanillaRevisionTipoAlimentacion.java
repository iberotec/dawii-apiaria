package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planilla_revision_tipo_alimentacion database table.
 * 
 */
@Entity
@Table(name="planilla_revision_tipo_alimentacion")
public class PlanillaRevisionTipoAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_revision_tipo_alimentacion")
	private int idPlanillaRevisionTipoAlimentacion;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="id_planilla_revision")
	private PlanillaRevision planillaRevision;

	//bi-directional many-to-one association to TipoAlimentacion
    @ManyToOne
	@JoinColumn(name="id_tipo_alimentacion")
	private TipoAlimentacion tipoAlimentacion;

    public PlanillaRevisionTipoAlimentacion() {
    }

	public int getIdPlanillaRevisionTipoAlimentacion() {
		return this.idPlanillaRevisionTipoAlimentacion;
	}

	public void setIdPlanillaRevisionTipoAlimentacion(int idPlanillaRevisionTipoAlimentacion) {
		this.idPlanillaRevisionTipoAlimentacion = idPlanillaRevisionTipoAlimentacion;
	}

	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
	public TipoAlimentacion getTipoAlimentacion() {
		return this.tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}
	
}