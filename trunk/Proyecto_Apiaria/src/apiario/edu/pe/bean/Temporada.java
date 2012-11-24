package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the temporada database table.
 * 
 */
@Entity
@Table(name="temporada")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_temporada")
	private int idTemporada;

	@Column(name="estado_etapa")
	private String estadoEtapa;

    @Temporal( TemporalType.DATE)
	@Column(name="periodo_final")
	private Date periodoFinal;

    @Temporal( TemporalType.DATE)
	@Column(name="periodo_inicial")
	private Date periodoInicial;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="temporada")
	private Set<PlanillaRevision> planillaRevisions;

    public Temporada() {
    }

	public int getIdTemporada() {
		return this.idTemporada;
	}

	public void setIdTemporada(int idTemporada) {
		this.idTemporada = idTemporada;
	}

	public String getEstadoEtapa() {
		return this.estadoEtapa;
	}

	public void setEstadoEtapa(String estadoEtapa) {
		this.estadoEtapa = estadoEtapa;
	}

	public Date getPeriodoFinal() {
		return this.periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public Date getPeriodoInicial() {
		return this.periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
}