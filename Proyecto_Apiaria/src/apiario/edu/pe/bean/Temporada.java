package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import apiario.edu.pe.bean.base.BaseEntidades;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the temporada database table.
 * 
 */
@Entity
@Table(name="temporada")
public class Temporada extends BaseEntidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_temporada")
	private Integer idTemporada;

	@Column(name="etapa_temporada")
	private String etapaTemporada;

	@Column(name="estado_temporada")
	private Boolean estadoTemporada;
	
	@Column(name="orden_temporada")
	private Integer ordenTemporada;
	
    @Temporal( TemporalType.DATE)
	@Column(name="periodo_final")
	private Date periodoFinal;

    @Temporal( TemporalType.DATE)
	@Column(name="periodo_inicial")
	private Date periodoInicial;



    public Temporada() {
    }

	public Integer getIdTemporada() {
		return this.idTemporada;
	}

	public void setIdTemporada(Integer idTemporada) {
		this.idTemporada = idTemporada;
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

	public String getEtapaTemporada() {
		return etapaTemporada;
	}

	public void setEtapaTemporada(String etapaTemporada) {
		this.etapaTemporada = etapaTemporada;
	}

	public Boolean getEstadoTemporada() {
		return estadoTemporada;
	}

	public void setEstadoTemporada(Boolean estadoTemporada) {
		this.estadoTemporada = estadoTemporada;
	}

	public Integer getOrdenTemporada() {
		return ordenTemporada;
	}

	public void setOrdenTemporada(Integer ordenTemporada) {
		this.ordenTemporada = ordenTemporada;
	}


	
}