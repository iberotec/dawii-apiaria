package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

@Entity
@Table(name="centrifugadora")
public class Centrifugadora extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_centrifugadora")
	private Integer idCentrifugadora;
	
	@Column(name="descripcion_centrifugadora")
	private String descripcionCentrifugadora;

	
	public Integer getIdCentrifugadora() {
		return idCentrifugadora;
	}
	public void setIdCentrifugadora(Integer idCentrifugadora) {
		this.idCentrifugadora = idCentrifugadora;
	}
	public String getDescripcionCentrifugadora() {
		return descripcionCentrifugadora;
	}
	public void setDescripcionCentrifugadora(String descripcionCentrifugadora) {
		this.descripcionCentrifugadora = descripcionCentrifugadora;
	}
}
