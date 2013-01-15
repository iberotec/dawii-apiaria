package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;


/**
 * The persistent class for the tipo_balde database table.
 * 
 */
@Entity
@Table(name="tipo_balde")
public class TipoBalde extends BaseEntidades implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tipo_balde")
	private Integer idTipoBalde;
	
	@Column(name="descripcion_tipo_balde")
	private String descripcionTipoBalde;
	
	public TipoBalde() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoBalde() {
		return idTipoBalde;
	}

	public void setIdTipoBalde(Integer idTipoBalde) {
		this.idTipoBalde = idTipoBalde;
	}

	public String getDescripcionTipoBalde() {
		return descripcionTipoBalde;
	}

	public void setDescripcionTipoBalde(String descripcionTipoBalde) {
		this.descripcionTipoBalde = descripcionTipoBalde;
	}
	
}
