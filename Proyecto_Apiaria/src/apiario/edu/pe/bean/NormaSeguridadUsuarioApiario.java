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
@Table(name="norma_seguridad_usuario_apiario")
public class NormaSeguridadUsuarioApiario extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_norma_seguridad_usuario_apiario")
	private Integer idNormaSeguridadUsuarioApiario;

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
	@JoinColumn(name="id_usuario_apiario")
	private UsuarioApiario usuarioApiario;

    public NormaSeguridadUsuarioApiario() {
    }

	public Integer getIdNormaSeguridadUsuarioApiario() {
		return idNormaSeguridadUsuarioApiario;
	}

	public void setIdNormaSeguridadUsuarioApiario(
			Integer idNormaSeguridadUsuarioApiario) {
		this.idNormaSeguridadUsuarioApiario = idNormaSeguridadUsuarioApiario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public NormaSeguridad getNormaSeguridad() {
		return normaSeguridad;
	}

	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}

	public UsuarioApiario getUsuarioApiario() {
		return usuarioApiario;
	}

	public void setUsuarioApiario(UsuarioApiario usuarioApiario) {
		this.usuarioApiario = usuarioApiario;
	}

		
}