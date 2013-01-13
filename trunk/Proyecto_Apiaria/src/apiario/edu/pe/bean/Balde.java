package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

/**
 * The persistent class for the balde database table.
 * 
 */
@Entity
@Table(name="balde")
public class Balde extends BaseEntidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idBalde")
	private Integer idBalde;
	
	@Column(name="capacidad_balde")
	private Integer capacidadBalde;
	
	@Column(name="diponibilidad_balde")
	private Boolean disponibilidadBalde;
	
	public Balde() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdBalde() {
		return idBalde;
	}

	public void setIdBalde(Integer idBalde) {
		this.idBalde = idBalde;
	}

	public Integer getCapacidadBalde() {
		return capacidadBalde;
	}

	public void setCapacidadBalde(Integer capacidadBalde) {
		this.capacidadBalde = capacidadBalde;
	}

	public Boolean getDisponibilidadBalde() {
		return disponibilidadBalde;
	}

	public void setDisponibilidadBalde(Boolean disponibilidadBalde) {
		this.disponibilidadBalde = disponibilidadBalde;
	}
	
}
