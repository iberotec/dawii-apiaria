package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

/**
 * The persistent class for the tipo_envase database table.
 * 
 */
@Entity
@Table(name="tipo_envase")
public class TipoEnvase extends BaseEntidades implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tipo_envase")
	private Integer idTipoEnvase;
	
	@Column(name="descripcion_tipo_envase")
	private String descripcionTipoEnvase;
	
	public TipoEnvase() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getIdTipoEnvase() {
		return idTipoEnvase;
	}
	public void setIdTipoEnvase(Integer idTipoEnvase) {
		this.idTipoEnvase = idTipoEnvase;
	}
	public String getDescripcionTipoEnvase() {
		return descripcionTipoEnvase;
	}
	public void setDescripcionTipoEnvase(String descripcionTipoEnvase) {
		this.descripcionTipoEnvase = descripcionTipoEnvase;
	}
	
	
}
