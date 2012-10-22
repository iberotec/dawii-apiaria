package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planilla_envasado database table.
 * 
 */
@Entity
@Table(name="planilla_envasado")
public class PlanillaEnvasado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_envasado")
	private int idplanillaEnvasado;

	private String cantidad;

	@Column(name="fecha_envasado")
	private String fechaEnvasado;

	//bi-directional many-to-one association to Envasadora
    @ManyToOne
	@JoinColumn(name="idEnvasadora")
	private Envasadora envasadora;

	//bi-directional many-to-one association to Envase
    @ManyToOne
	@JoinColumn(name="idenvase")
	private Envase envase;

	//bi-directional many-to-one association to Producto
    @ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;

    public PlanillaEnvasado() {
    }

	public int getIdplanillaEnvasado() {
		return this.idplanillaEnvasado;
	}

	public void setIdplanillaEnvasado(int idplanillaEnvasado) {
		this.idplanillaEnvasado = idplanillaEnvasado;
	}

	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaEnvasado() {
		return this.fechaEnvasado;
	}

	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public Envasadora getEnvasadora() {
		return this.envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}
	
	public Envase getEnvase() {
		return this.envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}
	
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}