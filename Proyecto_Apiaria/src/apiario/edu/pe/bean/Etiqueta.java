package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;
/**
 * The persistent class for the etiqueta database table.
 * 
 */
@Entity
@Table(name="etiqueta")
public class Etiqueta extends BaseEntidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id_etiqueta")
	private Integer idEtiqueta;
	
	
    @ManyToOne
	@JoinColumn(name="id_tipo_etiqueta")
	private TipoEtiqueta tipoEtiqueta;
	
	public Etiqueta() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Integer idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public TipoEtiqueta getTipoEtiqueta() {
		return tipoEtiqueta;
	}

	public void setTipoEtiqueta(TipoEtiqueta tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}
	
}
