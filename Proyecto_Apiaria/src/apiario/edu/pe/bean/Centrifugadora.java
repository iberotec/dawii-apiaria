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
	
	@Column(name="disponibilidad_centrifugadora")
	private Boolean disponibilidadCentrifugadora;
	
	public Centrifugadora() {
		
	}
	public Integer getIdCentrifugadora() {
		return idCentrifugadora;
	}
	public void setIdCentrifugadora(Integer idCentrifugadora) {
		this.idCentrifugadora = idCentrifugadora;
	}
	public Boolean getDisponibilidadCentrifugadora() {
		return disponibilidadCentrifugadora;
	}
	public void setDisponibilidadCentrifugadora(Boolean disponibilidadCentrifugadora) {
		this.disponibilidadCentrifugadora = disponibilidadCentrifugadora;
	}

	

}
