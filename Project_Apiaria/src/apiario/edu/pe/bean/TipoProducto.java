package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_producto database table.
 * 
 */
@Entity
@Table(name="tipo_producto")
public class TipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_producto")
	private int idtipoProducto;

	private String descripcion;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tipoProducto")
	private List<Producto> productos;

    public TipoProducto() {
    }

	public int getIdtipoProducto() {
		return this.idtipoProducto;
	}

	public void setIdtipoProducto(int idtipoProducto) {
		this.idtipoProducto = idtipoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}