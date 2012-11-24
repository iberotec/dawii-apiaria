package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the insumo database table.
 * 
 */
@Entity
@Table(name="insumo")
public class Insumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_insumo")
	private int idInsumo;

	@Column(name="descripcion_insumo")
	private String descripcionInsumo;

	//bi-directional many-to-one association to TipoAlimentacionInsumo
	@OneToMany(mappedBy="insumo")
	private Set<TipoAlimentacionInsumo> tipoAlimentacionInsumos;

    public Insumo() {
    }

	public int getIdInsumo() {
		return this.idInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getDescripcionInsumo() {
		return this.descripcionInsumo;
	}

	public void setDescripcionInsumo(String descripcionInsumo) {
		this.descripcionInsumo = descripcionInsumo;
	}

	public Set<TipoAlimentacionInsumo> getTipoAlimentacionInsumos() {
		return this.tipoAlimentacionInsumos;
	}

	public void setTipoAlimentacionInsumos(Set<TipoAlimentacionInsumo> tipoAlimentacionInsumos) {
		this.tipoAlimentacionInsumos = tipoAlimentacionInsumos;
	}
	
}