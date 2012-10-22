package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_revision database table.
 * 
 */
@Entity
@Table(name="estado_revision")
public class EstadoRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idestado_revision")
	private int idestadoRevision;

	private String descripcion;

	//bi-directional many-to-many association to EquipamientoTrabajo
	@ManyToMany(mappedBy="estadoRevisions")
	private List<EquipamientoTrabajo> equipamientoTrabajos;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="estadoRevision")
	private List<PlanillaRevision> planillaRevisions;

    public EstadoRevision() {
    }

	public int getIdestadoRevision() {
		return this.idestadoRevision;
	}

	public void setIdestadoRevision(int idestadoRevision) {
		this.idestadoRevision = idestadoRevision;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EquipamientoTrabajo> getEquipamientoTrabajos() {
		return this.equipamientoTrabajos;
	}

	public void setEquipamientoTrabajos(List<EquipamientoTrabajo> equipamientoTrabajos) {
		this.equipamientoTrabajos = equipamientoTrabajos;
	}
	
	public List<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(List<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
}