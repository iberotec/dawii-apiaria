package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_planilla_rev_tipo_alim database table.
 * 
 */
@Entity
@Table(name="detalle_planilla_rev_tipo_alim")
public class DetallePlanillaRevTipoAlim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_revision_tipo_alimento")
	private int idplanillaRevisionTipoAlimento;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="idplanilla_revision")
	private PlanillaRevision planillaRevision;

	//bi-directional many-to-one association to TipoAlimentacion
    @ManyToOne
	@JoinColumn(name="idtipo_alimentacion")
	private TipoAlimentacion tipoAlimentacion;

    public DetallePlanillaRevTipoAlim() {
    }

	public int getIdplanillaRevisionTipoAlimento() {
		return this.idplanillaRevisionTipoAlimento;
	}

	public void setIdplanillaRevisionTipoAlimento(int idplanillaRevisionTipoAlimento) {
		this.idplanillaRevisionTipoAlimento = idplanillaRevisionTipoAlimento;
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