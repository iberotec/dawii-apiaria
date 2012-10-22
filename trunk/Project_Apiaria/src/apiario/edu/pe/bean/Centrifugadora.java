package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centrifugadora database table.
 * 
 */
@Entity
@Table(name="centrifugadora")
public class Centrifugadora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcentrifugadora;

	@Column(name="nombre_centrifugadora")
	private String nombreCentrifugadora;

	//bi-directional many-to-many association to PlanillaCosecha
	@ManyToMany(mappedBy="centrifugadoras")
	private List<PlanillaCosecha> planillaCosechas;

    public Centrifugadora() {
    }

	public int getIdcentrifugadora() {
		return this.idcentrifugadora;
	}

	public void setIdcentrifugadora(int idcentrifugadora) {
		this.idcentrifugadora = idcentrifugadora;
	}

	public String getNombreCentrifugadora() {
		return this.nombreCentrifugadora;
	}

	public void setNombreCentrifugadora(String nombreCentrifugadora) {
		this.nombreCentrifugadora = nombreCentrifugadora;
	}

	public List<PlanillaCosecha> getPlanillaCosechas() {
		return this.planillaCosechas;
	}

	public void setPlanillaCosechas(List<PlanillaCosecha> planillaCosechas) {
		this.planillaCosechas = planillaCosechas;
	}
	
}