package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Date;


/**
 * The persistent class for the norma_seguridad_apiario database table.
 * 
 */
@Entity
@Table(name="norma_seguridad_apiario")
public class NormaSeguridadApiario extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_norma_seguridad_apiario")
	private Integer idNormaSeguridadApiario;

	private Boolean estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to NormaSeguridad
    @ManyToOne
	@JoinColumn(name="id_norma_seguridad")
	private NormaSeguridad normaSeguridad;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="id_apiario")
	private Apiario apiario;

    public NormaSeguridadApiario() {
    }

	public Integer getIdNormaSeguridadApiario() {
		return this.idNormaSeguridadApiario;
	}

	public void setIdNormaSeguridadApiario(Integer idNormaSeguridadApiario) {
		this.idNormaSeguridadApiario = idNormaSeguridadApiario;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public NormaSeguridad getNormaSeguridad() {
		return this.normaSeguridad;
	}

	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}
	
	public Apiario getApiario() {
		return this.apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
}