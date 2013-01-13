package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

/**
 * The persistent class for the planilla_cosecha_alza database table.
 * 
 */
@Entity
@Table(name="planilla_cosecha_alza")
public class PlanillaCosechaAlza extends BaseEntidades implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_cosecha_alza")
	private Integer idPlanillaCosechaAlza;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_decantadora_centrifugadora")
	private UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora;
	
	@ManyToOne
	@JoinColumn(name="id_planilla_extraccion_alza")
	private PlanillaExtraccionAlza planillaExtraccionAlza;
	
	public PlanillaCosechaAlza() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPlanillaCosechaAlza() {
		return idPlanillaCosechaAlza;
	}

	public void setIdPlanillaCosechaAlza(Integer idPlanillaCosechaAlza) {
		this.idPlanillaCosechaAlza = idPlanillaCosechaAlza;
	}

	public UsuarioDecantadoraCentrifugadora getUsuarioDecantadoraCentrifugadora() {
		return usuarioDecantadoraCentrifugadora;
	}

	public void setUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora) {
		this.usuarioDecantadoraCentrifugadora = usuarioDecantadoraCentrifugadora;
	}

	public PlanillaExtraccionAlza getPlanillaExtraccionAlza() {
		return planillaExtraccionAlza;
	}

	public void setPlanillaExtraccionAlza(
			PlanillaExtraccionAlza planillaExtraccionAlza) {
		this.planillaExtraccionAlza = planillaExtraccionAlza;
	}
	
}
