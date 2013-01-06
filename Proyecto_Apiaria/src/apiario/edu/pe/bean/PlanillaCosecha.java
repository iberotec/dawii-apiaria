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

@Entity
@Table(name="planilla_cosecha")
public class PlanillaCosecha extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_planilla_cosecha")
	private Integer idPlanillaCosecha;
	
	@Temporal( TemporalType.DATE)
	@Column(name="fecha_cosecha")
	private Date fechaCosecha;
	
	@Column(name="kilos")
	private Double kilos;
	
	//bi-directional many-to-one association to Colmena
	@ManyToOne
	@JoinColumn(name="id_colmena")
	private Colmena colmena;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public PlanillaCosecha() {
	}

	public Integer getIdPlanillaCosecha() {
		return idPlanillaCosecha;
	}

	public void setIdPlanillaCosecha(Integer idPlanillaCosecha) {
		this.idPlanillaCosecha = idPlanillaCosecha;
	}

	public Date getFechaCosecha() {
		return fechaCosecha;
	}

	public void setFechaCosecha(Date fechaCosecha) {
		this.fechaCosecha = fechaCosecha;
	}

	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

	public Colmena getColmena() {
		return colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
