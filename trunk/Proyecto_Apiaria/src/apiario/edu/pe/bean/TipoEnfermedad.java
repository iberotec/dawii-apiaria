package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_enfermedad database table.
 * 
 */
@Entity
@Table(name="tipo_enfermedad")
public class TipoEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_enfermedad")
	private int idTipoEnfermedad;

	@Column(name="descripcion_tipo_enfermedad")
	private String descripcionTipoEnfermedad;

	//bi-directional many-to-one association to PlanillaRevisionTipoEnfermedad
	@OneToMany(mappedBy="tipoEnfermedad")
	private Set<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads;

	//bi-directional many-to-one association to TipoEnfermedadTratamiento
	@OneToMany(mappedBy="tipoEnfermedad")
	private Set<TipoEnfermedadTratamiento> tipoEnfermedadTratamientos;

    public TipoEnfermedad() {
    }

	public int getIdTipoEnfermedad() {
		return this.idTipoEnfermedad;
	}

	public void setIdTipoEnfermedad(int idTipoEnfermedad) {
		this.idTipoEnfermedad = idTipoEnfermedad;
	}

	public String getDescripcionTipoEnfermedad() {
		return this.descripcionTipoEnfermedad;
	}

	public void setDescripcionTipoEnfermedad(String descripcionTipoEnfermedad) {
		this.descripcionTipoEnfermedad = descripcionTipoEnfermedad;
	}

	public Set<PlanillaRevisionTipoEnfermedad> getPlanillaRevisionTipoEnfermedads() {
		return this.planillaRevisionTipoEnfermedads;
	}

	public void setPlanillaRevisionTipoEnfermedads(Set<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads) {
		this.planillaRevisionTipoEnfermedads = planillaRevisionTipoEnfermedads;
	}
	
	public Set<TipoEnfermedadTratamiento> getTipoEnfermedadTratamientos() {
		return this.tipoEnfermedadTratamientos;
	}

	public void setTipoEnfermedadTratamientos(Set<TipoEnfermedadTratamiento> tipoEnfermedadTratamientos) {
		this.tipoEnfermedadTratamientos = tipoEnfermedadTratamientos;
	}
	
}