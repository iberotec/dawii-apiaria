package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pais")
	private int idPais;

	@Column(name="nombre_pais")
	private String nombrePais;

	//bi-directional many-to-one association to Ubigeo
	@OneToMany(mappedBy="pai")
	private Set<Ubigeo> ubigeos;

    public Pai() {
    }

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Set<Ubigeo> getUbigeos() {
		return this.ubigeos;
	}

	public void setUbigeos(Set<Ubigeo> ubigeos) {
		this.ubigeos = ubigeos;
	}
	
}