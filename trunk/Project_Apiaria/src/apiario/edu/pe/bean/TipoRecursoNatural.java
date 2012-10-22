package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_recurso_natural database table.
 * 
 */
@Entity
@Table(name="tipo_recurso_natural")
public class TipoRecursoNatural implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_recurso_natural")
	private int idtipoRecursoNatural;

	private String descripcion;

	//bi-directional many-to-one association to RecursoNatural
	@OneToMany(mappedBy="tipoRecursoNatural")
	private List<RecursoNatural> recursoNaturals;

    public TipoRecursoNatural() {
    }

	public int getIdtipoRecursoNatural() {
		return this.idtipoRecursoNatural;
	}

	public void setIdtipoRecursoNatural(int idtipoRecursoNatural) {
		this.idtipoRecursoNatural = idtipoRecursoNatural;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<RecursoNatural> getRecursoNaturals() {
		return this.recursoNaturals;
	}

	public void setRecursoNaturals(List<RecursoNatural> recursoNaturals) {
		this.recursoNaturals = recursoNaturals;
	}
	
}