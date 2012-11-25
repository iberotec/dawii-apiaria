package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the estado_revision database table.
 * 
 */
@Entity
@Table(name="estado_revision")
public class EstadoRevision extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_revision")
	private int idEstadoRevision;

	@Column(name="descripcion_estado_revision")
	private String descripcionEstadoRevision;

	//bi-directional many-to-one association to EstadoRevisionEquipamientoTrabajo
	@OneToMany(mappedBy="estadoRevision")
	private Set<EstadoRevisionEquipamientoTrabajo> estadoRevisionEquipamientoTrabajos;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="estadoRevision")
	private Set<PlanillaRevision> planillaRevisions;

    public EstadoRevision() {
    }

	public int getIdEstadoRevision() {
		return this.idEstadoRevision;
	}

	public void setIdEstadoRevision(int idEstadoRevision) {
		this.idEstadoRevision = idEstadoRevision;
	}

	public String getDescripcionEstadoRevision() {
		return this.descripcionEstadoRevision;
	}

	public void setDescripcionEstadoRevision(String descripcionEstadoRevision) {
		this.descripcionEstadoRevision = descripcionEstadoRevision;
	}

	public Set<EstadoRevisionEquipamientoTrabajo> getEstadoRevisionEquipamientoTrabajos() {
		return this.estadoRevisionEquipamientoTrabajos;
	}

	public void setEstadoRevisionEquipamientoTrabajos(Set<EstadoRevisionEquipamientoTrabajo> estadoRevisionEquipamientoTrabajos) {
		this.estadoRevisionEquipamientoTrabajos = estadoRevisionEquipamientoTrabajos;
	}
	
	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
}