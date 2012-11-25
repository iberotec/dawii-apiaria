package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the colmena database table.
 * 
 */
@Entity
@Table(name="colmena")
public class Colmena extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_colmena")
	private Integer idColmena;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="id_apiario")
	private Apiario apiario;

	//bi-directional many-to-one association to Piso
	@OneToMany(mappedBy="colmena")
	private Set<Piso> pisos;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="colmena")
	private Set<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Reina
	@OneToMany(mappedBy="colmena")
	private Set<Reina> reinas;

    public Colmena() {
    }

	public Integer getIdColmena() {
		return this.idColmena;
	}

	public void setIdColmena(Integer idColmena) {
		this.idColmena = idColmena;
	}

	public Apiario getApiario() {
		return this.apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
	public Set<Piso> getPisos() {
		return this.pisos;
	}

	public void setPisos(Set<Piso> pisos) {
		this.pisos = pisos;
	}
	
	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public Set<Reina> getReinas() {
		return this.reinas;
	}

	public void setReinas(Set<Reina> reinas) {
		this.reinas = reinas;
	}
	
}