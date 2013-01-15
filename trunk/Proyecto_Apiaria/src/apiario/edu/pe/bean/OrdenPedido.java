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
 * The persistent class for the orden_pedido database table.
 * 
 */
@Entity
@Table(name="orden_pedido")
public class OrdenPedido extends BaseEntidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_orden_pedido")
	private Integer idOrdenPedido;
	
	@Column(name="producto_orden_pedido")
	private String productoOrdenPedido;
	
	@ManyToOne
	@JoinColumn(name="id_envase")
	private Envase envase;
	
	@Column(name="cantidad_orden_pedido")
	private Integer cantidadOrdenPedido;
	
	@Column(name="insumos_orden_pedido")
	private String insumosOrdenPedido;
	
	@Column(name="estado_orden_pedido")
	private String estadoOrdenPedido;
	
	@ManyToOne
	@JoinColumn(name="id_etiqueta")
	private Etiqueta etiqueta;
	
	public OrdenPedido() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdOrdenPedido() {
		return idOrdenPedido;
	}

	public void setIdOrdenPedido(Integer idOrdenPedido) {
		this.idOrdenPedido = idOrdenPedido;
	}

	public String getProductoOrdenPedido() {
		return productoOrdenPedido;
	}

	public void setProductoOrdenPedido(String productoOrdenPedido) {
		this.productoOrdenPedido = productoOrdenPedido;
	}

	public Envase getEnvase() {
		return envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}

	public Integer getCantidadOrdenPedido() {
		return cantidadOrdenPedido;
	}

	public void setCantidadOrdenPedido(Integer cantidadOrdenPedido) {
		this.cantidadOrdenPedido = cantidadOrdenPedido;
	}

	public String getInsumosOrdenPedido() {
		return insumosOrdenPedido;
	}

	public void setInsumosOrdenPedido(String insumosOrdenPedido) {
		this.insumosOrdenPedido = insumosOrdenPedido;
	}

	public String getEstadoOrdenPedido() {
		return estadoOrdenPedido;
	}

	public void setEstadoOrdenPedido(String estadoOrdenPedido) {
		this.estadoOrdenPedido = estadoOrdenPedido;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}
	
}
