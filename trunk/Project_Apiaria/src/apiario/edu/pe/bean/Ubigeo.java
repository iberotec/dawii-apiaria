package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
@Table(name="ubigeo")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idubigeo;

	private String departamento;

	private String distrito;

	private String provincia;

	//bi-directional many-to-one association to Pai
    @ManyToOne
	@JoinColumn(name="pais_idpais")
	private Pai pai;

	//bi-directional many-to-one association to Zona
	@OneToMany(mappedBy="ubigeo")
	private List<Zona> zonas;

    public Ubigeo() {
    }

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}
	
	public List<Zona> getZonas() {
		return this.zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}
	
}