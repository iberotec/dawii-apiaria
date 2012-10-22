package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_rec_nat_zona database table.
 * 
 */
@Entity
@Table(name="detalle_rec_nat_zona")
public class DetalleRecNatZona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleRecNatZonaPK id;

	@Column(name="porcentaje_recurso")
	private BigDecimal porcentajeRecurso;

	//bi-directional many-to-one association to RecursoNatural
    @ManyToOne
	@JoinColumn(name="idrecurso_natural")
	private RecursoNatural recursoNatural;

	//bi-directional many-to-one association to Zona
    @ManyToOne
	@JoinColumn(name="idzona")
	private Zona zona;

    public DetalleRecNatZona() {
    }

	public DetalleRecNatZonaPK getId() {
		return this.id;
	}

	public void setId(DetalleRecNatZonaPK id) {
		this.id = id;
	}
	
	public BigDecimal getPorcentajeRecurso() {
		return this.porcentajeRecurso;
	}

	public void setPorcentajeRecurso(BigDecimal porcentajeRecurso) {
		this.porcentajeRecurso = porcentajeRecurso;
	}

	public RecursoNatural getRecursoNatural() {
		return this.recursoNatural;
	}

	public void setRecursoNatural(RecursoNatural recursoNatural) {
		this.recursoNatural = recursoNatural;
	}
	
	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
}