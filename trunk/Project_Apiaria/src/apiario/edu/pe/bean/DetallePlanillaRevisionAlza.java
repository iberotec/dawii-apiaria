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

	@EmbeddedId
	private DetallePlanillaRevisionAlzaPK id;

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

	public DetallePlanillaRevisionAlzaPK getId() {
		return this.id;
	}

	public void setId(DetallePlanillaRevisionAlzaPK id) {
		this.id = id;
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