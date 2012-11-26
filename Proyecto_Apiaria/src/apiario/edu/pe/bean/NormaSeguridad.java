package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the norma_seguridad database table.
 * 
 */
@Entity
@Table(name="norma_seguridad")
public class NormaSeguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idnorma_seguridad")
	private int idNormaSeguridad;

	@Column(name="descripcion")
	private String descripcionNormaSeguridad;

	//bi-directional many-to-one association to NormaSeguridadApiario
	@OneToMany(mappedBy="normaSeguridad")
	private Set<NormaSeguridadApiario> normaSeguridadApiarios;

    public NormaSeguridad() {
    }

	public int getIdNormaSeguridad() {
		return this.idNormaSeguridad;
	}

	public void setIdNormaSeguridad(int idNormaSeguridad) {
		this.idNormaSeguridad = idNormaSeguridad;
	}

	public String getDescripcionNormaSeguridad() {
		return this.descripcionNormaSeguridad;
	}

	public void setDescripcionNormaSeguridad(String descripcionNormaSeguridad) {
		this.descripcionNormaSeguridad = descripcionNormaSeguridad;
	}

	public Set<NormaSeguridadApiario> getNormaSeguridadApiarios() {
		return this.normaSeguridadApiarios;
	}

	public void setNormaSeguridadApiarios(Set<NormaSeguridadApiario> normaSeguridadApiarios) {
		this.normaSeguridadApiarios = normaSeguridadApiarios;
	}
	
}