package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Date;


/**
 * The persistent class for the planilla_seguimiento database table.
 * 
 */
@Entity
@Table(name="planilla_seguimiento")
public class PlanillaSeguimiento extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_seguimiento")
	private Integer idPlanillaSeguimiento;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="motivo_ubicacion")
	private String motivoUbicacion;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="id_apiario")
	private Apiario apiario;

	//bi-directional many-to-one association to Zona
    @ManyToOne
	@JoinColumn(name="id_zona")
	private Zona zona;

    public PlanillaSeguimiento() {
    }

	public Integer getIdPlanillaSeguimiento() {
		return this.idPlanillaSeguimiento;
	}

	public void setIdPlanillaSeguimiento(Integer idPlanillaSeguimiento) {
		this.idPlanillaSeguimiento = idPlanillaSeguimiento;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getMotivoUbicacion() {
		return this.motivoUbicacion;
	}

	public void setMotivoUbicacion(String motivoUbicacion) {
		this.motivoUbicacion = motivoUbicacion;
	}

	public Apiario getApiario() {
		return this.apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
}