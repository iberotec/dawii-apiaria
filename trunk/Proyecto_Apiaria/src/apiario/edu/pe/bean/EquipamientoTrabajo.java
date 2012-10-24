package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private List<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs;

    public EquipamientoTrabajo() {
    }

	public int getIdequipamientoTrabajo() {
		return this.idequipamientoTrabajo;
	}

	public void setIdequipamientoTrabajo(int idequipamientoTrabajo) {
		this.idequipamientoTrabajo = idequipamientoTrabajo;
	}

	public List<DetalleEstRevisionEquiTrab> getDetalleEstRevisionEquiTrabs() {
		return this.detalleEstRevisionEquiTrabs;
	}

	public void setDetalleEstRevisionEquiTrabs(List<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs) {
		this.detalleEstRevisionEquiTrabs = detalleEstRevisionEquiTrabs;
	}
	
}