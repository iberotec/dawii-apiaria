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
	@Column(name="idtipo_enfermedad")
	private int idtipoEnfermedad;

	private String descripcion;

	//bi-directional many-to-one association to DetallePlanillaRevisionTipoEnfermedad
	@OneToMany(mappedBy="tipoEnfermedad")
	private Set<DetallePlanillaRevisionTipoEnfermedad> detallePlanillaRevisionTipoEnfermedads;

	//bi-directional many-to-one association to DetalleTipoEnfeTratamiento
	@OneToMany(mappedBy="tipoEnfermedad")
	private Set<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos;

    public TipoEnfermedad() {
    }

	public int getIdtipoEnfermedad() {
		return this.idtipoEnfermedad;
	}

	public void setIdtipoEnfermedad(int idtipoEnfermedad) {
		this.idtipoEnfermedad = idtipoEnfermedad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DetallePlanillaRevisionTipoEnfermedad> getDetallePlanillaRevisionTipoEnfermedads() {
		return this.detallePlanillaRevisionTipoEnfermedads;
	}

	public void setDetallePlanillaRevisionTipoEnfermedads(Set<DetallePlanillaRevisionTipoEnfermedad> detallePlanillaRevisionTipoEnfermedads) {
		this.detallePlanillaRevisionTipoEnfermedads = detallePlanillaRevisionTipoEnfermedads;
	}
	
	public Set<DetalleTipoEnfeTratamiento> getDetalleTipoEnfeTratamientos() {
		return this.detalleTipoEnfeTratamientos;
	}

	public void setDetalleTipoEnfeTratamientos(Set<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos) {
		this.detalleTipoEnfeTratamientos = detalleTipoEnfeTratamientos;
	}
	
}