package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the equipamiento_trabajo database table.
 * 
 */
@Entity
@Table(name="equipamiento_trabajo")
public class EquipamientoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idequipamiento_trabajo")
	private int idequipamientoTrabajo;

	//bi-directional many-to-one association to DetalleEstRevisionEquiTrab
	@OneToMany(mappedBy="equipamientoTrabajo")
	private Set<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs;

    public EquipamientoTrabajo() {
    }

	public int getIdequipamientoTrabajo() {
		return this.idequipamientoTrabajo;
	}

	public void setIdequipamientoTrabajo(int idequipamientoTrabajo) {
		this.idequipamientoTrabajo = idequipamientoTrabajo;
	}

	public Set<DetalleEstRevisionEquiTrab> getDetalleEstRevisionEquiTrabs() {
		return this.detalleEstRevisionEquiTrabs;
	}

	public void setDetalleEstRevisionEquiTrabs(Set<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs) {
		this.detalleEstRevisionEquiTrabs = detalleEstRevisionEquiTrabs;
	}
	
}