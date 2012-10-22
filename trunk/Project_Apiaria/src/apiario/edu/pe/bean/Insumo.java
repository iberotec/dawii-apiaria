package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the insumo database table.
 * 
 */
@Entity
@Table(name="insumo")
public class Insumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idinsumo;

	private String descripcion;

	//bi-directional many-to-many association to TipoAlimentacion
    @ManyToMany
	@JoinTable(
		name="detalle_tipo_alimentacion_insumo"
		, joinColumns={
			@JoinColumn(name="idinsumo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idtipo_alimentacion")
			}
		)
	private List<TipoAlimentacion> tipoAlimentacions;

    public Insumo() {
    }

	public int getIdinsumo() {
		return this.idinsumo;
	}

	public void setIdinsumo(int idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TipoAlimentacion> getTipoAlimentacions() {
		return this.tipoAlimentacions;
	}

	public void setTipoAlimentacions(List<TipoAlimentacion> tipoAlimentacions) {
		this.tipoAlimentacions = tipoAlimentacions;
	}
	
}