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
	private int idinsumo;

	private String descripcion;

	//bi-directional many-to-one association to DetalleTipoAlimentacionInsumo
	@OneToMany(mappedBy="insumo")
	private Set<DetalleTipoAlimentacionInsumo> detalleTipoAlimentacionInsumos;

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

	public Set<DetalleTipoAlimentacionInsumo> getDetalleTipoAlimentacionInsumos() {
		return this.detalleTipoAlimentacionInsumos;
	}

	public void setDetalleTipoAlimentacionInsumos(Set<DetalleTipoAlimentacionInsumo> detalleTipoAlimentacionInsumos) {
		this.detalleTipoAlimentacionInsumos = detalleTipoAlimentacionInsumos;
	}
	
}