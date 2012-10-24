package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_alza database table.
 * 
 */
@Entity
@Table(name="tipo_alza")
public class TipoAlza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_alza")
	private int idtipoAlza;

	private String descripcion;

	//bi-directional many-to-one association to Alza
	@OneToMany(mappedBy="tipoAlza")
	private Set<Alza> alzas;

    public TipoAlza() {
    }

	public int getIdtipoAlza() {
		return this.idtipoAlza;
	}

	public void setIdtipoAlza(int idtipoAlza) {
		this.idtipoAlza = idtipoAlza;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Alza> getAlzas() {
		return this.alzas;
	}

	public void setAlzas(Set<Alza> alzas) {
		this.alzas = alzas;
	}
	
}