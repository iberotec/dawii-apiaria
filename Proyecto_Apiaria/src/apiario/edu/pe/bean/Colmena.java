package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.List;


/**
 * The persistent class for the colmena database table.
 * 
 */
@Entity
@Table(name="colmena")
public class Colmena extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcolmena;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="idapiario")
	private Apiario apiario;

	//bi-directional many-to-one association to Piso
	@OneToMany(mappedBy="colmena")
	private List<Piso> pisos;

	//bi-directional many-to-one association to PlanillaCosecha
	@OneToMany(mappedBy="colmena")
	private List<PlanillaCosecha> planillaCosechas;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="colmena")
	private List<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Reina
	@OneToMany(mappedBy="colmena")
	private List<Reina> reinas;

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
	
	public List<Piso> getPisos() {
		return this.pisos;
	}

	public void setPisos(List<Piso> pisos) {
		this.pisos = pisos;
	}
	
	public List<PlanillaCosecha> getPlanillaCosechas() {
		return this.planillaCosechas;
	}

	public void setPlanillaCosechas(List<PlanillaCosecha> planillaCosechas) {
		this.planillaCosechas = planillaCosechas;
	}
	
	public List<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(List<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public List<Reina> getReinas() {
		return this.reinas;
	}

	public void setReinas(List<Reina> reinas) {
		this.reinas = reinas;
	}
	
}