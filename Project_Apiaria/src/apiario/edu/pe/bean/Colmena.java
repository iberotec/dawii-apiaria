package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the colmena database table.
 * 
 */
@Entity
@Table(name="colmena")
public class Colmena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcolmena;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="idapiario")
	private Apiario apiario;

	//bi-directional many-to-one association to Piso
	@OneToMany(mappedBy="colmena")
	private Set<Piso> pisos;

	//bi-directional many-to-one association to PlanillaCosecha
	@OneToMany(mappedBy="colmena")
	private Set<PlanillaCosecha> planillaCosechas;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="colmena")
	private Set<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Reina
	@OneToMany(mappedBy="colmena")
	private Set<Reina> reinas;

    public Colmena() {
    }

	public int getIdcolmena() {
		return this.idcolmena;
	}

	public void setIdcolmena(int idcolmena) {
		this.idcolmena = idcolmena;
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
	
	public Set<PlanillaCosecha> getPlanillaCosechas() {
		return this.planillaCosechas;
	}

	public void setPlanillaCosechas(Set<PlanillaCosecha> planillaCosechas) {
		this.planillaCosechas = planillaCosechas;
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