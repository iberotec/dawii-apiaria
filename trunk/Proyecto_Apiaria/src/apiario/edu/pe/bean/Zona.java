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
	@Column(name="id_zona")
	private int idZona;

	@Column(name="descripcion_zona")
	private String descripcionZona;

	//bi-directional many-to-one association to PlanillaSeguimiento
	@OneToMany(mappedBy="zona")
	private Set<PlanillaSeguimiento> planillaSeguimientos;

	//bi-directional many-to-one association to Ubigeo
    @ManyToOne
	@JoinColumn(name="id_ubigeo")
	private Ubigeo ubigeo;

	//bi-directional many-to-one association to ZonaRecusoNatural
	@OneToMany(mappedBy="zona")
	private Set<ZonaRecusoNatural> zonaRecusoNaturals;

    public Zona() {
    }

	public int getIdZona() {
		return this.idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getDescripcionZona() {
		return this.descripcionZona;
	}

	public void setDescripcionZona(String descripcionZona) {
		this.descripcionZona = descripcionZona;
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
	
	public Set<ZonaRecusoNatural> getZonaRecusoNaturals() {
		return this.zonaRecusoNaturals;
	}

	public void setZonaRecusoNaturals(Set<ZonaRecusoNatural> zonaRecusoNaturals) {
		this.zonaRecusoNaturals = zonaRecusoNaturals;
	}
	
}