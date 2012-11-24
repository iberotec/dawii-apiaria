package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the recurso_natural database table.
 * 
 */
@Entity
@Table(name="recurso_natural")
public class RecursoNatural implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_recurso_natural")
	private int idRecursoNatural;

	@Column(name="descripcion_recurso_natural")
	private String descripcionRecursoNatural;

	//bi-directional many-to-one association to TipoRecurso
    @ManyToOne
	@JoinColumn(name="id_tipo_recurso")
	private TipoRecurso tipoRecurso;

	//bi-directional many-to-one association to ZonaRecusoNatural
	@OneToMany(mappedBy="recursoNatural")
	private Set<ZonaRecusoNatural> zonaRecusoNaturals;

    public RecursoNatural() {
    }

	public int getIdRecursoNatural() {
		return this.idRecursoNatural;
	}

	public void setIdRecursoNatural(int idRecursoNatural) {
		this.idRecursoNatural = idRecursoNatural;
	}

	public String getDescripcionRecursoNatural() {
		return this.descripcionRecursoNatural;
	}

	public void setDescripcionRecursoNatural(String descripcionRecursoNatural) {
		this.descripcionRecursoNatural = descripcionRecursoNatural;
	}

	public TipoRecurso getTipoRecurso() {
		return this.tipoRecurso;
	}

	public void setTipoRecurso(TipoRecurso tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	
	public Set<ZonaRecusoNatural> getZonaRecusoNaturals() {
		return this.zonaRecusoNaturals;
	}

	public void setZonaRecusoNaturals(Set<ZonaRecusoNatural> zonaRecusoNaturals) {
		this.zonaRecusoNaturals = zonaRecusoNaturals;
	}
	
}