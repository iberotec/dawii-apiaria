package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproducto;

	private String descripcion;

	//bi-directional many-to-one association to PlanillaEnvasado
	@OneToMany(mappedBy="producto")
	private List<PlanillaEnvasado> planillaEnvasados;

	//bi-directional many-to-one association to TipoProducto
    @ManyToOne
	@JoinColumn(name="idtipo_producto")
	private TipoProducto tipoProducto;

    public Producto() {
    }

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PlanillaEnvasado> getPlanillaEnvasados() {
		return this.planillaEnvasados;
	}

	public void setPlanillaEnvasados(List<PlanillaEnvasado> planillaEnvasados) {
		this.planillaEnvasados = planillaEnvasados;
	}
	
	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
}