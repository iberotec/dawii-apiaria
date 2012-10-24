package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_envase database table.
 * 
 */
@Entity
@Table(name="tipo_envase")
public class TipoEnvase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_envase")
	private int idtipoEnvase;

	private String descripcion;

	//bi-directional many-to-one association to Envase
	@OneToMany(mappedBy="tipoEnvase")
	private Set<Envase> envases;

    public TipoEnvase() {
    }

	public int getIdtipoEnvase() {
		return this.idtipoEnvase;
	}

	public void setIdtipoEnvase(int idtipoEnvase) {
		this.idtipoEnvase = idtipoEnvase;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Envase> getEnvases() {
		return this.envases;
	}

	public void setEnvases(Set<Envase> envases) {
		this.envases = envases;
	}
	
}