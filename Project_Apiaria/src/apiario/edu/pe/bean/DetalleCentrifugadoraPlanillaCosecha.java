package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_centrifugadora_planilla_cosecha database table.
 * 
 */
@Entity
@Table(name="detalle_centrifugadora_planilla_cosecha")
public class DetalleCentrifugadoraPlanillaCosecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_cosecha_centrifugadora")
	private int idplanillaCosechaCentrifugadora;

	//bi-directional many-to-one association to PlanillaCosecha
    @ManyToOne
	@JoinColumn(name="idplanilla_cosecha")
	private PlanillaCosecha planillaCosecha;

	//bi-directional many-to-one association to Centrifugadora
    @ManyToOne
	@JoinColumn(name="idcentrifugadora")
	private Centrifugadora centrifugadora;

    public DetalleCentrifugadoraPlanillaCosecha() {
    }

	public int getIdplanillaCosechaCentrifugadora() {
		return this.idplanillaCosechaCentrifugadora;
	}

	public void setIdplanillaCosechaCentrifugadora(int idplanillaCosechaCentrifugadora) {
		this.idplanillaCosechaCentrifugadora = idplanillaCosechaCentrifugadora;
	}

	public PlanillaCosecha getPlanillaCosecha() {
		return this.planillaCosecha;
	}

	public void setPlanillaCosecha(PlanillaCosecha planillaCosecha) {
		this.planillaCosecha = planillaCosecha;
	}
	
	public Centrifugadora getCentrifugadora() {
		return this.centrifugadora;
	}

	public void setCentrifugadora(Centrifugadora centrifugadora) {
		this.centrifugadora = centrifugadora;
	}
	
}