package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_tipo_enfe_tratamiento database table.
 * 
 */
@Entity
@Table(name="detalle_tipo_enfe_tratamiento")
public class DetalleTipoEnfeTratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleTipoEnfeTratamientoPK id;

	private String dosis;

	//bi-directional many-to-one association to TipoEnfermedad
    @ManyToOne
	@JoinColumn(name="idtipo_enfermedad")
	private TipoEnfermedad tipoEnfermedad;

	//bi-directional many-to-one association to Tratamiento
    @ManyToOne
	@JoinColumn(name="idtratamiento")
	private Tratamiento tratamiento;

    public DetalleTipoEnfeTratamiento() {
    }

	public DetalleTipoEnfeTratamientoPK getId() {
		return this.id;
	}

	public void setId(DetalleTipoEnfeTratamientoPK id) {
		this.id = id;
	}
	
	public String getDosis() {
		return this.dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoEnfermedad;
	}

	public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}
	
	public Tratamiento getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
}