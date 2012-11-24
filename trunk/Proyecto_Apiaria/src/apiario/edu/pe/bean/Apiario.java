package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the apiario database table.
 * 
 */
@Entity
@Table(name="apiario")
public class Apiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_apiario")
	private int idApiario;

	//bi-directional many-to-one association to Colmena
	@OneToMany(mappedBy="apiario")
	private Set<Colmena> colmenas;

	//bi-directional many-to-one association to NormaSeguridadApiario
	@OneToMany(mappedBy="apiario")
	private Set<NormaSeguridadApiario> normaSeguridadApiarios;

	//bi-directional many-to-one association to PlanillaSeguimiento
	@OneToMany(mappedBy="apiario")
	private Set<PlanillaSeguimiento> planillaSeguimientos;

    public Apiario() {
    }

	public int getIdApiario() {
		return this.idApiario;
	}

	public void setIdApiario(int idApiario) {
		this.idApiario = idApiario;
	}

	public Set<Colmena> getColmenas() {
		return this.colmenas;
	}

	public void setColmenas(Set<Colmena> colmenas) {
		this.colmenas = colmenas;
	}
	
	public Set<NormaSeguridadApiario> getNormaSeguridadApiarios() {
		return this.normaSeguridadApiarios;
	}

	public void setNormaSeguridadApiarios(Set<NormaSeguridadApiario> normaSeguridadApiarios) {
		this.normaSeguridadApiarios = normaSeguridadApiarios;
	}
	
	public Set<PlanillaSeguimiento> getPlanillaSeguimientos() {
		return this.planillaSeguimientos;
	}

	public void setPlanillaSeguimientos(Set<PlanillaSeguimiento> planillaSeguimientos) {
		this.planillaSeguimientos = planillaSeguimientos;
	}
	
}