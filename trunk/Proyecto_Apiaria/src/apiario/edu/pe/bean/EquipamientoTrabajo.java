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
	@Column(name="id_equipamiento_trabajo")
	private int idEquipamientoTrabajo;

	@Column(name="descripcion_equipo_trabajo")
	private String descripcionEquipoTrabajo;

	//bi-directional many-to-one association to EstadoRevisionEquipamientoTrabajo
	@OneToMany(mappedBy="equipamientoTrabajo")
	private Set<EstadoRevisionEquipamientoTrabajo> estadoRevisionEquipamientoTrabajos;

    public EquipamientoTrabajo() {
    }

	public int getIdEquipamientoTrabajo() {
		return this.idEquipamientoTrabajo;
	}

	public void setIdEquipamientoTrabajo(int idEquipamientoTrabajo) {
		this.idEquipamientoTrabajo = idEquipamientoTrabajo;
	}

	public String getDescripcionEquipoTrabajo() {
		return this.descripcionEquipoTrabajo;
	}

	public void setDescripcionEquipoTrabajo(String descripcionEquipoTrabajo) {
		this.descripcionEquipoTrabajo = descripcionEquipoTrabajo;
	}

	public Set<EstadoRevisionEquipamientoTrabajo> getEstadoRevisionEquipamientoTrabajos() {
		return this.estadoRevisionEquipamientoTrabajos;
	}

	public void setEstadoRevisionEquipamientoTrabajos(Set<EstadoRevisionEquipamientoTrabajo> estadoRevisionEquipamientoTrabajos) {
		this.estadoRevisionEquipamientoTrabajos = estadoRevisionEquipamientoTrabajos;
	}
	
}