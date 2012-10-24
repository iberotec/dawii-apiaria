package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the zona database table.
 * 
 */
@Entity
@Table(name="zona")
public class Zona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idzona;

	private String descripcion;

	//bi-directional many-to-one association to DetalleRecNatZona
	@OneToMany(mappedBy="zona")
	private Set<DetalleRecNatZona> detalleRecNatZonas;

	//bi-directional many-to-one association to PlanillaSeguimiento
	@OneToMany(mappedBy="zona")
	private Set<PlanillaSeguimiento> planillaSeguimientos;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	@JoinColumn(name="idubigeo")
	private Ubigeo ubigeo;

    public Zona() {
    }

	public int getIdzona() {
		return this.idzona;
	}

	public void setIdzona(int idzona) {
		this.idzona = idzona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DetalleRecNatZona> getDetalleRecNatZonas() {
		return this.detalleRecNatZonas;
	}

	public void setDetalleRecNatZonas(Set<DetalleRecNatZona> detalleRecNatZonas) {
		this.detalleRecNatZonas = detalleRecNatZonas;
	}
	
	public Set<PlanillaSeguimiento> getPlanillaSeguimientos() {
		return this.planillaSeguimientos;
	}

	public void setPlanillaSeguimientos(Set<PlanillaSeguimiento> planillaSeguimientos) {
		this.planillaSeguimientos = planillaSeguimientos;
	}
	
	public Ubigeo getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
	
}