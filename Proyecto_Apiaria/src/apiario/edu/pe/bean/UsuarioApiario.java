package apiario.edu.pe.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import apiario.edu.pe.bean.base.BaseEntidades;
/**
 * The persistent class for the usuario_apiario database table.
 * 
 */
@Entity
@Table(name="usuario_apiario")
public class UsuarioApiario extends BaseEntidades implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_usuario_apiario")
	private Integer idUsuarioApiario;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="id_apiario")
	private Apiario apiario;
	
	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
    
	//bi-directional many-to-one association to Temporada
    @ManyToOne
    @JoinColumn(name="id_temporada")
	private Temporada temporada;
    
    @Column(name="estado_asignacion")
	private String estadoAsignacion;
	
    @Temporal( TemporalType.DATE)
    @Column(name="fecha_asignacion")
    private Date fechaAsignacion;
	
    @Temporal( TemporalType.DATE)
    @Column(name="fecha_revision")
    private Date fechaRevision;
	
  //bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="usuarioApiario")
	private Set<PlanillaRevision> planillaRevisions;
	
	public UsuarioApiario() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<PlanillaRevision> getPlanillaRevisions() {
		return planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}

	public Apiario getApiario() {
		return apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public Integer getIdUsuarioApiario() {
		return idUsuarioApiario;
	}

	public void setIdUsuarioApiario(Integer idUsuarioApiario) {
		this.idUsuarioApiario = idUsuarioApiario;
	}

	public String getEstadoAsignacion() {
		return estadoAsignacion;
	}

	public void setEstadoAsignacion(String estadoAsignacion) {
		this.estadoAsignacion = estadoAsignacion;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}
	
}
