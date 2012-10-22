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

	//bi-directional many-to-many association to EstadoRevision
    @ManyToMany
	@JoinTable(
		name="detalle_est_revision_equi_trab"
		, joinColumns={
			@JoinColumn(name="idequipamiento_trabajo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idestado_revision")
			}
		)
	private List<EstadoRevision> estadoRevisions;

    public EquipamientoTrabajo() {
    }

	public int getIdequipamientoTrabajo() {
		return this.idequipamientoTrabajo;
	}

	public void setIdequipamientoTrabajo(int idequipamientoTrabajo) {
		this.idequipamientoTrabajo = idequipamientoTrabajo;
	}

	public List<EstadoRevision> getEstadoRevisions() {
		return this.estadoRevisions;
	}

	public void setEstadoRevisions(List<EstadoRevision> estadoRevisions) {
		this.estadoRevisions = estadoRevisions;
	}
	
}