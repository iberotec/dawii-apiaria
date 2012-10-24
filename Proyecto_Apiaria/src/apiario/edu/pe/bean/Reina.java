package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reina database table.
 * 
 */
@Entity
@Table(name="reina")
public class Reina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idreina;

	private String descripcion;

	private String genetica;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="reina")
	private List<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="idcolmena")
	private Colmena colmena;

    public Reina() {
    }

	public int getIdreina() {
		return this.idreina;
	}

	public void setIdreina(int idreina) {
		this.idreina = idreina;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGenetica() {
		return this.genetica;
	}

	public void setGenetica(String genetica) {
		this.genetica = genetica;
	}

	public List<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(List<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
}