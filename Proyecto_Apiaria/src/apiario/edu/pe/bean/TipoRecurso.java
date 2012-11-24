package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_recurso database table.
 * 
 */
@Entity
@Table(name="tipo_recurso")
public class TipoRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_recurso")
	private int idTipoRecurso;

	@Column(name="descripcion_tipo_recurso")
	private String descripcionTipoRecurso;

	//bi-directional many-to-one association to RecursoNatural
	@OneToMany(mappedBy="tipoRecurso")
	private Set<RecursoNatural> recursoNaturals;

    public TipoRecurso() {
    }

	public int getIdTipoRecurso() {
		return this.idTipoRecurso;
	}

	public void setIdTipoRecurso(int idTipoRecurso) {
		this.idTipoRecurso = idTipoRecurso;
	}

	public String getDescripcionTipoRecurso() {
		return this.descripcionTipoRecurso;
	}

	public void setDescripcionTipoRecurso(String descripcionTipoRecurso) {
		this.descripcionTipoRecurso = descripcionTipoRecurso;
	}

	public Set<RecursoNatural> getRecursoNaturals() {
		return this.recursoNaturals;
	}

	public void setRecursoNaturals(Set<RecursoNatural> recursoNaturals) {
		this.recursoNaturals = recursoNaturals;
	}
	
}