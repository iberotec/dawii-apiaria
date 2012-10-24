package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_planilla_revision_alza database table.
 * 
 */
@Entity
@Table(name="detalle_planilla_revision_alza")
public class DetallePlanillaRevisionAlza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_revision_alza")
	private int idplanillaRevisionAlza;

	@Column(name="estado_alza")
	private String estadoAlza;

	@Column(name="estado_deterioro_alza")
	private String estadoDeterioroAlza;

	@Column(name="porcentaje_miel")
	private BigDecimal porcentajeMiel;

	@Column(name="porcentaje_polen")
	private BigDecimal porcentajePolen;

	//bi-directional many-to-one association to Alza
    @ManyToOne
	@JoinColumn(name="idalza")
	private Alza alza;

	//bi-directional many-to-one association to PlanillaRevision
    @ManyToOne
	@JoinColumn(name="idplanilla_revision")
	private PlanillaRevision planillaRevision;

    public DetallePlanillaRevisionAlza() {
    }

	public int getIdplanillaRevisionAlza() {
		return this.idplanillaRevisionAlza;
	}

	public void setIdplanillaRevisionAlza(int idplanillaRevisionAlza) {
		this.idplanillaRevisionAlza = idplanillaRevisionAlza;
	}

	public String getEstadoAlza() {
		return this.estadoAlza;
	}

	public void setEstadoAlza(String estadoAlza) {
		this.estadoAlza = estadoAlza;
	}

	public String getEstadoDeterioroAlza() {
		return this.estadoDeterioroAlza;
	}

	public void setEstadoDeterioroAlza(String estadoDeterioroAlza) {
		this.estadoDeterioroAlza = estadoDeterioroAlza;
	}

	public BigDecimal getPorcentajeMiel() {
		return this.porcentajeMiel;
	}

	public void setPorcentajeMiel(BigDecimal porcentajeMiel) {
		this.porcentajeMiel = porcentajeMiel;
	}

	public BigDecimal getPorcentajePolen() {
		return this.porcentajePolen;
	}

	public void setPorcentajePolen(BigDecimal porcentajePolen) {
		this.porcentajePolen = porcentajePolen;
	}

	public Alza getAlza() {
		return this.alza;
	}

	public void setAlza(Alza alza) {
		this.alza = alza;
	}
	
	public PlanillaRevision getPlanillaRevision() {
		return this.planillaRevision;
	}

	public void setPlanillaRevision(PlanillaRevision planillaRevision) {
		this.planillaRevision = planillaRevision;
	}
	
}