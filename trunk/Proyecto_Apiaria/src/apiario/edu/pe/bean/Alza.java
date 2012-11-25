package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the alza database table.
 * 
 */
@Entity
@Table(name="alza")
public class Alza extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alza")
	private Integer idAlza;

	//bi-directional many-to-one association to Piso
    @ManyToOne
	@JoinColumn(name="id_piso")
	private Piso piso;

	//bi-directional many-to-one association to TipoAlza
    @ManyToOne
	@JoinColumn(name="id_tipo_alza")
	private TipoAlza tipoAlza;

	//bi-directional many-to-one association to PlanillaRevisionAlza
	@OneToMany(mappedBy="alza")
	private Set<PlanillaRevisionAlza> planillaRevisionAlzas;

    public Alza() {
    }

	public Integer getIdAlza() {
		return this.idAlza;
	}

	public void setIdAlza(Integer idAlza) {
		this.idAlza = idAlza;
	}

	public Piso getPiso() {
		return this.piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}
	
	public TipoAlza getTipoAlza() {
		return this.tipoAlza;
	}

	public void setTipoAlza(TipoAlza tipoAlza) {
		this.tipoAlza = tipoAlza;
	}
	
	public Set<PlanillaRevisionAlza> getPlanillaRevisionAlzas() {
		return this.planillaRevisionAlzas;
	}

	public void setPlanillaRevisionAlzas(Set<PlanillaRevisionAlza> planillaRevisionAlzas) {
		this.planillaRevisionAlzas = planillaRevisionAlzas;
	}
	
}