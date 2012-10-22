package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_planilla_rev_tipo_alim database table.
 * 
 */
@Entity
@Table(name="detalle_planilla_rev_tipo_alim")
public class DetallePlanillaRevTipoAlim implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallePlanillaRevTipoAlimPK id;

	//bi-directional many-to-one association to TipoAlimentacion
    @ManyToOne
	@JoinColumn(name="idtipo_alimentacion")
	private TipoAlimentacion tipoAlimentacion;

    public DetallePlanillaRevTipoAlim() {
    }

	public DetallePlanillaRevTipoAlimPK getId() {
		return this.id;
	}

	public void setId(DetallePlanillaRevTipoAlimPK id) {
		this.id = id;
	}
	
	public TipoAlimentacion getTipoAlimentacion() {
		return this.tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}
	
}