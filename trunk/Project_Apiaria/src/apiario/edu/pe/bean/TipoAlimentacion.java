package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_alimentacion database table.
 * 
 */
@Entity
@Table(name="tipo_alimentacion")
public class TipoAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_alimentacion")
	private int idtipoAlimentacion;

	private String descripcion;

	//bi-directional many-to-many association to PlanillaRevision
	@ManyToMany(mappedBy="tipoAlimentacions")
	private List<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-many association to Insumo
	@ManyToMany(mappedBy="tipoAlimentacions")
	private List<Insumo> insumos;

    public TipoAlimentacion() {
    }

	public int getIdtipoAlimentacion() {
		return this.idtipoAlimentacion;
	}

	public void setIdtipoAlimentacion(int idtipoAlimentacion) {
		this.idtipoAlimentacion = idtipoAlimentacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(List<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public List<Insumo> getInsumos() {
		return this.insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}
	
}