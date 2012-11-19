package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;


/**
 * The persistent class for the planilla_seguimiento database table.
 * 
 */
@Entity
@Table(name="planilla_seguimiento")
public class PlanillaSeguimiento extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_seguimiento")
	private Integer idplanillaSeguimiento;

	@Column(name="motivo_ubicacion")
	private String motivoUbicacion;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="idapiario")
	private Apiario apiario;

	//bi-directional many-to-one association to Zona
    @ManyToOne
	@JoinColumn(name="idzona")
	private Zona zona;

    public PlanillaSeguimiento() {
    }

	public Integer getIdplanillaSeguimiento() {
		return this.idplanillaSeguimiento;
	}

	public void setIdplanillaSeguimiento(Integer idplanillaSeguimiento) {
		this.idplanillaSeguimiento = idplanillaSeguimiento;
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