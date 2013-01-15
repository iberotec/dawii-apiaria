package apiario.edu.pe.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import apiario.edu.pe.bean.base.BaseEntidades;


/**
 * The persistent class for the usuario_decantadora_centrifugadora database table.
 * 
 */
@Entity
@Table(name="usuario_decantadora_centrifugadora")
public class UsuarioDecantadoraCentrifugadora extends BaseEntidades implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario_decantadora_centrifugadora")
	private Integer idUsuarioDecantadoraCentrifugadora;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_decantadora")
	private Decantadora decantadora=new Decantadora();
	
	@ManyToOne
	@JoinColumn(name="id_centrifugadora")
	private Centrifugadora centrifugadora=new Centrifugadora();
	
	@ManyToOne
	@JoinColumn(name="id_temporada")
	private Temporada temporada;
	
	@Temporal( TemporalType.DATE)
    @Column(name="fecha_asignacion")
	private Date fechaAsignacion;
	
	@Temporal( TemporalType.DATE)
    @Column(name="fecha_termino")
	private Date fechaTermino;
	
	
	
	public UsuarioDecantadoraCentrifugadora() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdUsuarioDecantadoraCentrifugadora() {
		return idUsuarioDecantadoraCentrifugadora;
	}
	public void setIdUsuarioDecantadoraCentrifugadora(
			Integer idUsuarioDecantadoraCentrifugadora) {
		this.idUsuarioDecantadoraCentrifugadora = idUsuarioDecantadoraCentrifugadora;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Decantadora getDecantadora() {
		return decantadora;
	}
	public void setDecantadora(Decantadora decantadora) {
		this.decantadora = decantadora;
	}
	public Centrifugadora getCentrifugadora() {
		return centrifugadora;
	}
	public void setCentrifugadora(Centrifugadora centrifugadora) {
		this.centrifugadora = centrifugadora;
	}
	public Temporada getTemporada() {
		return temporada;
	}
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	
}
