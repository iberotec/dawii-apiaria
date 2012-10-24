package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_est_revision_equi_trab database table.
 * 
 */
@Entity
@Table(name="detalle_est_revision_equi_trab")
public class DetalleEstRevisionEquiTrab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idestado_revision_equipamiento_trabajo")
	private int idestadoRevisionEquipamientoTrabajo;

	//bi-directional many-to-one association to EstadoRevision
    @ManyToOne
	@JoinColumn(name="idestado_revision")
	private EstadoRevision estadoRevision;

	//bi-directional many-to-one association to EquipamientoTrabajo
    @ManyToOne
	@JoinColumn(name="equipamiento_trabajo_idequipamiento_trabajo")
	private EquipamientoTrabajo equipamientoTrabajo;

    public DetalleEstRevisionEquiTrab() {
    }

	public int getIdestadoRevisionEquipamientoTrabajo() {
		return this.idestadoRevisionEquipamientoTrabajo;
	}

	public void setIdestadoRevisionEquipamientoTrabajo(int idestadoRevisionEquipamientoTrabajo) {
		this.idestadoRevisionEquipamientoTrabajo = idestadoRevisionEquipamientoTrabajo;
	}

	public EstadoRevision getEstadoRevision() {
		return this.estadoRevision;
	}

	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	
	public EquipamientoTrabajo getEquipamientoTrabajo() {
		return this.equipamientoTrabajo;
	}

	public void setEquipamientoTrabajo(EquipamientoTrabajo equipamientoTrabajo) {
		this.equipamientoTrabajo = equipamientoTrabajo;
	}
	
}