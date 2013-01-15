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
 * The persistent class for the planilla_envasado database table.
 * 
 */
@Entity
@Table(name="planilla_envasado")
public class PlanillaEnvasado extends BaseEntidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_planilla_envasado")
	private Integer idPlanillaEnvasado;
	
	@ManyToOne
	@JoinColumn(name="id_orden_pedido")
	private OrdenPedido ordenPedido;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
    @Temporal( TemporalType.DATE)
    @Column(name="fecha_envasado")
	private Date fechaEnvasado;
    
	@ManyToOne
	@JoinColumn(name="id_balde")
	private Balde balde;
	
	public PlanillaEnvasado() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPlanillaEnvasado() {
		return idPlanillaEnvasado;
	}

	public void setIdPlanillaEnvasado(Integer idPlanillaEnvasado) {
		this.idPlanillaEnvasado = idPlanillaEnvasado;
	}

	public OrdenPedido getOrdenPedido() {
		return ordenPedido;
	}

	public void setOrdenPedido(OrdenPedido ordenPedido) {
		this.ordenPedido = ordenPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(Date fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public Balde getBalde() {
		return balde;
	}

	public void setBalde(Balde balde) {
		this.balde = balde;
	}
	
}
