package apiario.edu.pe.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import apiario.edu.pe.bean.base.BaseEntidades;

/**
 * The persistent class for the planilla_extraccion_alza database table.
 * 
 */
@Entity
@Table(name="planilla_extraccion_alza")
public class PlanillaExtraccionAlza extends BaseEntidades implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_planilla_extraccion_alza")
	private Integer idPlanillaExtraccionAlza;
	
	@ManyToOne
	@JoinColumn(name="id_planilla_revision_alza")
	private PlanillaRevisionAlza planillaRevisionAlza;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_apiario")
	private UsuarioApiario usuarioApiario;
	
	@Temporal( TemporalType.DATE)
    @Column(name="fecha_extraccion_alza")
	private Date fechaExtraccionAlza;


	
	public PlanillaExtraccionAlza() {
		
	}

	public Integer getIdPlanillaExtraccionAlza() {
		return idPlanillaExtraccionAlza;
	}

	public void setIdPlanillaExtraccionAlza(Integer idPlanillaExtraccionAlza) {
		this.idPlanillaExtraccionAlza = idPlanillaExtraccionAlza;
	}

	public PlanillaRevisionAlza getPlanillaRevisionAlza() {
		return planillaRevisionAlza;
	}

	public void setPlanillaRevisionAlza(PlanillaRevisionAlza planillaRevisionAlza) {
		this.planillaRevisionAlza = planillaRevisionAlza;
	}

	public UsuarioApiario getUsuarioApiario() {
		return usuarioApiario;
	}

	public void setUsuarioApiario(UsuarioApiario usuarioApiario) {
		this.usuarioApiario = usuarioApiario;
	}

	public Date getFechaExtraccionAlza() {
		return fechaExtraccionAlza;
	}

	public void setFechaExtraccionAlza(Date fechaExtraccionAlza) {
		this.fechaExtraccionAlza = fechaExtraccionAlza;
	}
	
	
	
}
