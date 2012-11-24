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
	@Column(name="id_tipo_alimentacion")
	private int idTipoAlimentacion;

	@Column(name="descripcion_tipo_alimentacion")
	private String descripcionTipoAlimentacion;

	//bi-directional many-to-one association to PlanillaRevisionTipoAlimentacion
	@OneToMany(mappedBy="tipoAlimentacion")
	private Set<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions;

	//bi-directional many-to-one association to TipoAlimentacionInsumo
	@OneToMany(mappedBy="tipoAlimentacion")
	private Set<TipoAlimentacionInsumo> tipoAlimentacionInsumos;

    public TipoAlimentacion() {
    }

	public int getIdTipoAlimentacion() {
		return this.idTipoAlimentacion;
	}

	public void setIdTipoAlimentacion(int idTipoAlimentacion) {
		this.idTipoAlimentacion = idTipoAlimentacion;
	}

	public String getDescripcionTipoAlimentacion() {
		return this.descripcionTipoAlimentacion;
	}

	public void setDescripcionTipoAlimentacion(String descripcionTipoAlimentacion) {
		this.descripcionTipoAlimentacion = descripcionTipoAlimentacion;
	}

	public Set<PlanillaRevisionTipoAlimentacion> getPlanillaRevisionTipoAlimentacions() {
		return this.planillaRevisionTipoAlimentacions;
	}

	public void setPlanillaRevisionTipoAlimentacions(Set<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions) {
		this.planillaRevisionTipoAlimentacions = planillaRevisionTipoAlimentacions;
	}
	
	public Set<TipoAlimentacionInsumo> getTipoAlimentacionInsumos() {
		return this.tipoAlimentacionInsumos;
	}

	public void setTipoAlimentacionInsumos(Set<TipoAlimentacionInsumo> tipoAlimentacionInsumos) {
		this.tipoAlimentacionInsumos = tipoAlimentacionInsumos;
	}
	
}