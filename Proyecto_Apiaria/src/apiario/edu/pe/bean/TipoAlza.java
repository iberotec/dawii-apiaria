package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the tipo_alza database table.
 * 
 */
@Entity
@Table(name="tipo_alza")
public class TipoAlza extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_alza")
	private int idTipoAlza;

	@Column(name="descripcion_tipo_alza")
	private String descripcionTipoAlza;

	//bi-directional many-to-one association to Alza
	@OneToMany(mappedBy="tipoAlza")
	private Set<Alza> alzas;

    public TipoAlza() {
    }

	public int getIdTipoAlza() {
		return this.idTipoAlza;
	}

	public void setIdTipoAlza(int idTipoAlza) {
		this.idTipoAlza = idTipoAlza;
	}

	public String getDescripcionTipoAlza() {
		return this.descripcionTipoAlza;
	}

	public void setDescripcionTipoAlza(String descripcionTipoAlza) {
		this.descripcionTipoAlza = descripcionTipoAlza;
	}

	public Set<Alza> getAlzas() {
		return this.alzas;
	}

	public void setAlzas(Set<Alza> alzas) {
		this.alzas = alzas;
	}
	
}