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
	private int idapiario;

	//bi-directional many-to-one association to Colmena
	@OneToMany(mappedBy="apiario")
	private Set<Colmena> colmenas;

	//bi-directional many-to-one association to DetalleApiarioNormaSeg
	@OneToMany(mappedBy="apiario")
	private Set<DetalleApiarioNormaSeg> detalleApiarioNormaSegs;

	//bi-directional many-to-one association to PlanillaSeguimiento
	@OneToMany(mappedBy="apiario")
	private Set<PlanillaSeguimiento> planillaSeguimientos;

    public Apiario() {
    }

	public int getIdapiario() {
		return this.idapiario;
	}

	public void setIdapiario(int idapiario) {
		this.idapiario = idapiario;
	}

	public Set<Colmena> getColmenas() {
		return this.colmenas;
	}

	public void setColmenas(Set<Colmena> colmenas) {
		this.colmenas = colmenas;
	}
	
	public Set<DetalleApiarioNormaSeg> getDetalleApiarioNormaSegs() {
		return this.detalleApiarioNormaSegs;
	}

	public void setDetalleApiarioNormaSegs(Set<DetalleApiarioNormaSeg> detalleApiarioNormaSegs) {
		this.detalleApiarioNormaSegs = detalleApiarioNormaSegs;
	}
	
	public Set<PlanillaSeguimiento> getPlanillaSeguimientos() {
		return this.planillaSeguimientos;
	}

	public void setPlanillaSeguimientos(Set<PlanillaSeguimiento> planillaSeguimientos) {
		this.planillaSeguimientos = planillaSeguimientos;
	}
	
}