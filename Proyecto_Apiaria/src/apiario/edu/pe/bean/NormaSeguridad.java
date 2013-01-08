package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the norma_seguridad database table.
 * 
 */
@Entity
@Table(name="norma_seguridad")
public class NormaSeguridad extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_norma_seguridad")
	private Integer idNormaSeguridad;

	@Column(name="descripcion_norma_seguridad")
	private String descripcionNormaSeguridad;

	private Boolean activo;
	
	//bi-directional many-to-one association to NormaSeguridadUsuarioApiario
	@OneToMany(mappedBy="normaSeguridad")
	private Set<NormaSeguridadUsuarioApiario> normaSeguridadUsuarioApiarios;

    public NormaSeguridad() {
    }

	public Integer getIdNormaSeguridad() {
		return this.idNormaSeguridad;
	}

	public void setIdNormaSeguridad(Integer idNormaSeguridad) {
		this.idNormaSeguridad = idNormaSeguridad;
	}

	public String getDescripcionNormaSeguridad() {
		return this.descripcionNormaSeguridad;
	}

	public void setDescripcionNormaSeguridad(String descripcionNormaSeguridad) {
		this.descripcionNormaSeguridad = descripcionNormaSeguridad;
	}

	public Set<NormaSeguridadUsuarioApiario> getNormaSeguridadUsuarioApiarios() {
		return normaSeguridadUsuarioApiarios;
	}

	public void setNormaSeguridadUsuarioApiarios(
			Set<NormaSeguridadUsuarioApiario> normaSeguridadUsuarioApiarios) {
		this.normaSeguridadUsuarioApiarios = normaSeguridadUsuarioApiarios;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}