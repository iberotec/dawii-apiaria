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
 * The persistent class for the usuario_decantadora_centrifugadora_balde database table.
 * 
 */
@Entity
@Table(name="usuario_decantadora_centrifugadora_balde")
public class UsuarioDecantadoraCentrifugadoraBalde extends BaseEntidades implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_usuario_decantadora_centrifugadora_balde")
	private Integer idUsuarioDecantadoraCentrifugadoraBalde;
	
	@ManyToOne
	@JoinColumn(name="id_balde")
	private Balde balde;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_decantadora_centrifugadora")
	private UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora;
	
	private Integer kilos;
	
	public UsuarioDecantadoraCentrifugadoraBalde() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDecantadoraCentrifugadora getUsuarioDecantadoraCentrifugadora() {
		return usuarioDecantadoraCentrifugadora;
	}

	public void setUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora) {
		this.usuarioDecantadoraCentrifugadora = usuarioDecantadoraCentrifugadora;
	}

	public Integer getIdUsuarioDecantadoraCentrifugadoraBalde() {
		return idUsuarioDecantadoraCentrifugadoraBalde;
	}
	public void setIdUsuarioDecantadoraCentrifugadoraBalde(
			Integer idUsuarioDecantadoraCentrifugadoraBalde) {
		this.idUsuarioDecantadoraCentrifugadoraBalde = idUsuarioDecantadoraCentrifugadoraBalde;
	}
	public Balde getBalde() {
		return balde;
	}
	public void setBalde(Balde balde) {
		this.balde = balde;
	}
	public Integer getKilos() {
		return kilos;
	}
	public void setKilos(Integer kilos) {
		this.kilos = kilos;
	}
	
}
