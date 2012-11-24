package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zona_recuso_natural database table.
 * 
 */
@Entity
@Table(name="zona_recuso_natural")
public class ZonaRecusoNatural implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_zona_recurso_natural")
	private int idZonaRecursoNatural;

	//bi-directional many-to-one association to RecursoNatural
    @ManyToOne
	@JoinColumn(name="id_recurso_natural")
	private RecursoNatural recursoNatural;

	//bi-directional many-to-one association to Zona
    @ManyToOne
	private Zona zona;

    public ZonaRecusoNatural() {
    }

	public int getIdZonaRecursoNatural() {
		return this.idZonaRecursoNatural;
	}

	public void setIdZonaRecursoNatural(int idZonaRecursoNatural) {
		this.idZonaRecursoNatural = idZonaRecursoNatural;
	}

	public RecursoNatural getRecursoNatural() {
		return this.recursoNatural;
	}

	public void setRecursoNatural(RecursoNatural recursoNatural) {
		this.recursoNatural = recursoNatural;
	}
	
	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
}