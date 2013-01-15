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
 * The persistent class for the envase database table.
 * 
 */
@Entity
@Table(name="envase")
public class Envase extends BaseEntidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_envase")
	private Integer idEnvase;
	
    @ManyToOne
	@JoinColumn(name="id_tipo_envase")
	private TipoEnvase tipoEnvase;
	
	public Envase() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEnvase() {
		return idEnvase;
	}

	public void setIdEnvase(Integer idEnvase) {
		this.idEnvase = idEnvase;
	}

	public TipoEnvase getTipoEnvase() {
		return tipoEnvase;
	}

	public void setTipoEnvase(TipoEnvase tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}
	
	
}
