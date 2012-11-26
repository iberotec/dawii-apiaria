package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the apiario database table.
 * 
 */
@Entity
@Table(name="apiario")
public class Apiario extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idapiario")
	private Integer idApiario;

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

	public Integer getIdApiario() {
		return this.idApiario;
	}

	public void setIdApiario(Integer idApiario) {
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