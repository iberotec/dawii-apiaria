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
	private int idnormaSeguridad;

	private String descripcion;

	//bi-directional many-to-one association to DetalleApiarioNormaSeg
	@OneToMany(mappedBy="normaSeguridad")
	private Set<DetalleApiarioNormaSeg> detalleApiarioNormaSegs;

    public NormaSeguridad() {
    }

	public int getIdnormaSeguridad() {
		return this.idnormaSeguridad;
	}

	public void setIdnormaSeguridad(int idnormaSeguridad) {
		this.idnormaSeguridad = idnormaSeguridad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DetalleApiarioNormaSeg> getDetalleApiarioNormaSegs() {
		return this.detalleApiarioNormaSegs;
	}

	public void setDetalleApiarioNormaSegs(Set<DetalleApiarioNormaSeg> detalleApiarioNormaSegs) {
		this.detalleApiarioNormaSegs = detalleApiarioNormaSegs;
	}
	
}