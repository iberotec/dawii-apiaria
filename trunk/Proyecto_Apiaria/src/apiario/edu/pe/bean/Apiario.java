package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


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
	
	@Column(name="descripcion_apiario")
	private String descripcion;
	
	//bi-directional many-to-one association to Colmena
	@OneToMany(mappedBy="apiario")
	private List<Colmena> colmenas;

	//bi-directional many-to-one association to DetalleApiarioNormaSeg
	@OneToMany(mappedBy="apiario")
	private List<DetalleApiarioNormaSeg> detalleApiarioNormaSegs;

	//bi-directional many-to-one association to PlanillaSeguimiento
	@OneToMany(mappedBy="apiario")
	private List<PlanillaSeguimiento> planillaSeguimientos;

    public Apiario() {
    }

	public int getIdapiario() {
		return this.idapiario;
	}

	public void setIdapiario(int idapiario) {
		this.idapiario = idapiario;
	}

	public List<Colmena> getColmenas() {
		return this.colmenas;
	}

	public void setColmenas(List<Colmena> colmenas) {
		this.colmenas = colmenas;
	}
	
	public List<DetalleApiarioNormaSeg> getDetalleApiarioNormaSegs() {
		return this.detalleApiarioNormaSegs;
	}

	public void setDetalleApiarioNormaSegs(List<DetalleApiarioNormaSeg> detalleApiarioNormaSegs) {
		this.detalleApiarioNormaSegs = detalleApiarioNormaSegs;
	}
	
	public List<PlanillaSeguimiento> getPlanillaSeguimientos() {
		return this.planillaSeguimientos;
	}

	public void setPlanillaSeguimientos(List<PlanillaSeguimiento> planillaSeguimientos) {
		this.planillaSeguimientos = planillaSeguimientos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}