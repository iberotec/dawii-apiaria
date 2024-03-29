package apiario.edu.pe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import apiario.edu.pe.bean.base.BaseEntidades;

@Entity
@Table(name="decantadora")
public class Decantadora extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_decantadora")
	private Integer idDecantadora;
	
	@Column(name="disponibilidad_decantadora")
	private Boolean disponibilidadDecantadora;
	
	public Decantadora() {
		
	}
	
	public Integer getIdDecantadora() {
		return idDecantadora;
	}
	public void setIdDecantadora(Integer idDecantadora) {
		this.idDecantadora = idDecantadora;
	}

	public Boolean getDisponibilidadDecantadora() {
		return disponibilidadDecantadora;
	}

	public void setDisponibilidadDecantadora(Boolean disponibilidadDecantadora) {
		this.disponibilidadDecantadora = disponibilidadDecantadora;
	}

}
