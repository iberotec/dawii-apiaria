package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_alimentacion database table.
 * 
 */
@Entity
@Table(name="tipo_alimentacion")
public class TipoAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_alimentacion")
	private int idtipoAlimentacion;

	private String descripcion;

	//bi-directional many-to-one association to DetallePlanillaRevTipoAlim
	@OneToMany(mappedBy="tipoAlimentacion")
	private Set<DetallePlanillaRevTipoAlim> detallePlanillaRevTipoAlims;

	//bi-directional many-to-one association to DetalleTipoAlimentacionInsumo
	@OneToMany(mappedBy="tipoAlimentacion")
	private Set<DetalleTipoAlimentacionInsumo> detalleTipoAlimentacionInsumos;

    public TipoAlimentacion() {
    }

	public int getIdtipoAlimentacion() {
		return this.idtipoAlimentacion;
	}

	public void setIdtipoAlimentacion(int idtipoAlimentacion) {
		this.idtipoAlimentacion = idtipoAlimentacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DetallePlanillaRevTipoAlim> getDetallePlanillaRevTipoAlims() {
		return this.detallePlanillaRevTipoAlims;
	}

	public void setDetallePlanillaRevTipoAlims(Set<DetallePlanillaRevTipoAlim> detallePlanillaRevTipoAlims) {
		this.detallePlanillaRevTipoAlims = detallePlanillaRevTipoAlims;
	}
	
	public Set<DetalleTipoAlimentacionInsumo> getDetalleTipoAlimentacionInsumos() {
		return this.detalleTipoAlimentacionInsumos;
	}

	public void setDetalleTipoAlimentacionInsumos(Set<DetalleTipoAlimentacionInsumo> detalleTipoAlimentacionInsumos) {
		this.detalleTipoAlimentacionInsumos = detalleTipoAlimentacionInsumos;
	}
	
}