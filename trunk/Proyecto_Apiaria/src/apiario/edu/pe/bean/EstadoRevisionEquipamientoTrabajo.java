package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_revision_equipamiento_trabajo database table.
 * 
 */
@Entity
@Table(name="estado_revision_equipamiento_trabajo")
public class EstadoRevisionEquipamientoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_revision_equipamiento_trabajo")
	private int idEstadoRevisionEquipamientoTrabajo;

	//bi-directional many-to-one association to EquipamientoTrabajo
    @ManyToOne
	@JoinColumn(name="id_equipamiento_trabajo")
	private EquipamientoTrabajo equipamientoTrabajo;

	//bi-directional many-to-one association to EstadoRevision
    @ManyToOne
	@JoinColumn(name="id_estado_revision")
	private EstadoRevision estadoRevision;
    
    @Column(name="cantidad")
    private Integer cantidad;

    public EstadoRevisionEquipamientoTrabajo() {
    }

	public int getIdEstadoRevisionEquipamientoTrabajo() {
		return this.idEstadoRevisionEquipamientoTrabajo;
	}

	public void setIdEstadoRevisionEquipamientoTrabajo(int idEstadoRevisionEquipamientoTrabajo) {
		this.idEstadoRevisionEquipamientoTrabajo = idEstadoRevisionEquipamientoTrabajo;
	}

	public EquipamientoTrabajo getEquipamientoTrabajo() {
		return this.equipamientoTrabajo;
	}

	public void setEquipamientoTrabajo(EquipamientoTrabajo equipamientoTrabajo) {
		this.equipamientoTrabajo = equipamientoTrabajo;
	}
	
	public EstadoRevision getEstadoRevision() {
		return this.estadoRevision;
	}

	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	
}