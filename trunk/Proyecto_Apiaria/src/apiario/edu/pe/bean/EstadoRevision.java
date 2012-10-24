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

	//bi-directional many-to-one association to DetalleEstRevisionEquiTrab
	@OneToMany(mappedBy="estadoRevision")
	private List<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs;

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

	public List<DetalleEstRevisionEquiTrab> getDetalleEstRevisionEquiTrabs() {
		return this.detalleEstRevisionEquiTrabs;
	}

	public void setDetalleEstRevisionEquiTrabs(List<DetalleEstRevisionEquiTrab> detalleEstRevisionEquiTrabs) {
		this.detalleEstRevisionEquiTrabs = detalleEstRevisionEquiTrabs;
	}
	
	public List<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(List<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
}