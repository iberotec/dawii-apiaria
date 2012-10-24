package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the envasadora database table.
 * 
 */
@Entity
@Table(name="envasadora")
public class Envasadora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEnvasadora;

	//bi-directional many-to-one association to DetalleUsuarioEnva
	@OneToMany(mappedBy="envasadora")
	private Set<DetalleUsuarioEnva> detalleUsuarioEnvas;

	//bi-directional many-to-one association to PlanillaEnvasado
	@OneToMany(mappedBy="envasadora")
	private Set<PlanillaEnvasado> planillaEnvasados;

    public Envasadora() {
    }

	public int getIdEnvasadora() {
		return this.idEnvasadora;
	}

	public void setIdEnvasadora(int idEnvasadora) {
		this.idEnvasadora = idEnvasadora;
	}

	public Set<DetalleUsuarioEnva> getDetalleUsuarioEnvas() {
		return this.detalleUsuarioEnvas;
	}

	public void setDetalleUsuarioEnvas(Set<DetalleUsuarioEnva> detalleUsuarioEnvas) {
		this.detalleUsuarioEnvas = detalleUsuarioEnvas;
	}
	
	public Set<PlanillaEnvasado> getPlanillaEnvasados() {
		return this.planillaEnvasados;
	}

	public void setPlanillaEnvasados(Set<PlanillaEnvasado> planillaEnvasados) {
		this.planillaEnvasados = planillaEnvasados;
	}
	
}