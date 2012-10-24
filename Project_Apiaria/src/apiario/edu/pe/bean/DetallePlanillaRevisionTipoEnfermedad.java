package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_planilla_revision_tipo_enfermedad database table.
 * 
 */
@Entity
@Table(name="detalle_planilla_revision_tipo_enfermedad")
public class DetallePlanillaRevisionTipoEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_revision_tipo_enfermedad")
	private int idplanillaRevisionTipoEnfermedad;

	@Column(name="mienbro_enfermo")
	private String mienbroEnfermo;

	//bi-directional many-to-one association to TipoEnfermedad
    @ManyToOne
	@JoinColumn(name="idtipo_enfermedad")
	private TipoEnfermedad tipoEnfermedad;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="idplanilla_revision")
	private PlanillaRevision planillaRevision;

    public DetallePlanillaRevisionTipoEnfermedad() {
    }

	public int getIdplanillaRevisionTipoEnfermedad() {
		return this.idplanillaRevisionTipoEnfermedad;
	}

	public void setIdplanillaRevisionTipoEnfermedad(int idplanillaRevisionTipoEnfermedad) {
		this.idplanillaRevisionTipoEnfermedad = idplanillaRevisionTipoEnfermedad;
	}

	public String getMienbroEnfermo() {
		return this.mienbroEnfermo;
	}

	public void setMienbroEnfermo(String mienbroEnfermo) {
		this.mienbroEnfermo = mienbroEnfermo;
	}

	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoEnfermedad;
	}

	public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}
	
	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
}