package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;
/**
 * The persistent class for the tipo_etiqueta database table.
 * 
 */
@Entity
@Table(name="tipo_etiqueta")
public class TipoEtiqueta extends BaseEntidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_tipo_etiqueta")
	private Integer idTipoEtiqueta;
	
	@Column(name="descripcion_tipo_etiqueta")
	private String descripcionTipoEtiqueta;
	
	public TipoEtiqueta() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoEtiqueta() {
		return idTipoEtiqueta;
	}

	public void setIdTipoEtiqueta(Integer idTipoEtiqueta) {
		this.idTipoEtiqueta = idTipoEtiqueta;
	}

	public String getDescripcionTipoEtiqueta() {
		return descripcionTipoEtiqueta;
	}

	public void setDescripcionTipoEtiqueta(String descripcionTipoEtiqueta) {
		this.descripcionTipoEtiqueta = descripcionTipoEtiqueta;
	}
	
}
