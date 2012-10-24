package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the envase database table.
 * 
 */
@Entity
@Table(name="envase")
public class Envase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idenvase;

	@Column(name="unidad_medida")
	private String unidadMedida;

	//bi-directional many-to-one association to TipoEnvase
    @ManyToOne
	@JoinColumn(name="idtipo_envase")
	private TipoEnvase tipoEnvase;

	//bi-directional many-to-one association to PlanillaEnvasado
	@OneToMany(mappedBy="envase")
	private Set<PlanillaEnvasado> planillaEnvasados;

    public Envase() {
    }

	public int getIdenvase() {
		return this.idenvase;
	}

	public void setIdenvase(int idenvase) {
		this.idenvase = idenvase;
	}

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public TipoEnvase getTipoEnvase() {
		return this.tipoEnvase;
	}

	public void setTipoEnvase(TipoEnvase tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}
	
	public Set<PlanillaEnvasado> getPlanillaEnvasados() {
		return this.planillaEnvasados;
	}

	public void setPlanillaEnvasados(Set<PlanillaEnvasado> planillaEnvasados) {
		this.planillaEnvasados = planillaEnvasados;
	}
	
}