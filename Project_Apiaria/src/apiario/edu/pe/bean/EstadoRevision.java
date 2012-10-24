package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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

	//bi-directional many-to-one association to DetalleEstRevisionEquiTrab
	@OneToMany(mappedBy="estadoRevision")
	private Set<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="estadoRevision")
	private Set<PlanillaRevision> planillaRevisions;

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

	public Set<DetalleEstRevisionEquiTrab> getDetalleEstRevisionEquiTrabs() {
		return this.detalleEstRevisionEquiTrabs;
	}

	public void setDetalleEstRevisionEquiTrabs(Set<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs) {
		this.detalleEstRevisionEquiTrabs = detalleEstRevisionEquiTrabs;
	}
	
	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
}