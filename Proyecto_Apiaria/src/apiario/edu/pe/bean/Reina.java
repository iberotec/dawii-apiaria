package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Set;


/**
 * The persistent class for the reina database table.
 * 
 */
@Entity
@Table(name="reina")
public class Reina extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reina")
	private Integer idReina;

	@Column(name="caracteristica_reina")
	private String caracteristicaReina;

	@Column(name="activo_reina")
	private Boolean activoReina;
	
	@Column(name="descripcion_reina")
	private String descripcionReina;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="reina")
	private Set<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="id_colmena")
	private Colmena colmena;

    public Reina() {
    }

	public Integer getIdReina() {
		return this.idReina;
	}

	public void setIdReina(Integer idReina) {
		this.idReina = idReina;
	}

	public String getCaracteristicaReina() {
		return this.caracteristicaReina;
	}

	public void setCaracteristicaReina(String caracteristicaReina) {
		this.caracteristicaReina = caracteristicaReina;
	}

	public String getDescripcionReina() {
		return this.descripcionReina;
	}

	public void setDescripcionReina(String descripcionReina) {
		this.descripcionReina = descripcionReina;
	}

	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}

	public Boolean getActivoReina() {
		return activoReina;
	}

	public void setActivoReina(Boolean activoReina) {
		this.activoReina = activoReina;
	}
	
}