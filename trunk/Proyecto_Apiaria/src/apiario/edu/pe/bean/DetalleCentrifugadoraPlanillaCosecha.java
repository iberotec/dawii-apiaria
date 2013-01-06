package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

@Entity
@Table(name="detalle_centrifugadora_planilla_cosecha")
public class DetalleCentrifugadoraPlanillaCosecha extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_detalle_centrifugadora_planilla_cosecha")
	private Integer idDetalleCentrifugadoraPlanillaCosecha;
	
	//bi-directional many-to-one association to Planilla Cosecha
    @ManyToOne
	@JoinColumn(name="id_planilla_cosecha")
	private PlanillaCosecha planillaCosecha;
    
  //bi-directional many-to-one association to Centrifugadora
    @ManyToOne
	@JoinColumn(name="id_centrifugadora")
	private Centrifugadora centrifugadora;

    public DetalleCentrifugadoraPlanillaCosecha() {
	}
    
	public Integer getIdDetalleCentrifugadoraPlanillaCosecha() {
		return idDetalleCentrifugadoraPlanillaCosecha;
	}

	public void setIdDetalleCentrifugadoraPlanillaCosecha(
			Integer idDetalleCentrifugadoraPlanillaCosecha) {
		this.idDetalleCentrifugadoraPlanillaCosecha = idDetalleCentrifugadoraPlanillaCosecha;
	}

	public PlanillaCosecha getPlanillaCosecha() {
		return planillaCosecha;
	}

	public void setPlanillaCosecha(PlanillaCosecha planillaCosecha) {
		this.planillaCosecha = planillaCosecha;
	}

	public Centrifugadora getCentrifugadora() {
		return centrifugadora;
	}

	public void setCentrifugadora(Centrifugadora centrifugadora) {
		this.centrifugadora = centrifugadora;
	}
	
}
