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
	private int idpais;

	@Column(name="nom_pais")
	private String nomPais;

	//bi-directional many-to-one association to Ubigeo
	@OneToMany(mappedBy="pai")
	private Set<Ubigeo> ubigeos;

    public Pai() {
    }

	public int getIdpais() {
		return this.idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public Set<Ubigeo> getUbigeos() {
		return this.ubigeos;
	}

	public void setUbigeos(Set<Ubigeo> ubigeos) {
		this.ubigeos = ubigeos;
	}
	
}