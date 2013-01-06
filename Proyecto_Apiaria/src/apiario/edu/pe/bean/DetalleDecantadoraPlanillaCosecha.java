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
@Table(name="detalle_decantadora_planilla_cosecha")
public class DetalleDecantadoraPlanillaCosecha extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_detalle_decantadora_planilla_cosecha")
	private Integer idDetalleDecantadoraPlanillaCosecha;
	
	//bi-directional many-to-one association to Planilla Cosecha
    @ManyToOne
	@JoinColumn(name="id_planilla_cosecha")
	private PlanillaCosecha planillaCosecha;
    
  //bi-directional many-to-one association to Decantadora
    @ManyToOne
	@JoinColumn(name="id_decantadora")
	private Decantadora decantadora;

    public DetalleDecantadoraPlanillaCosecha() {
	}
    
	public Integer getIdDetalleDecantadoraPlanillaCosecha() {
		return idDetalleDecantadoraPlanillaCosecha;
	}

	public void setIdDetalleDecantadoraPlanillaCosecha(
			Integer idDetalleDecantadoraPlanillaCosecha) {
		this.idDetalleDecantadoraPlanillaCosecha = idDetalleDecantadoraPlanillaCosecha;
	}

	public PlanillaCosecha getPlanillaCosecha() {
		return planillaCosecha;
	}

	public void setPlanillaCosecha(PlanillaCosecha planillaCosecha) {
		this.planillaCosecha = planillaCosecha;
	}

	public Decantadora getDecantadora() {
		return decantadora;
	}

	public void setDecantadora(Decantadora decantadora) {
		this.decantadora = decantadora;
	}
}
