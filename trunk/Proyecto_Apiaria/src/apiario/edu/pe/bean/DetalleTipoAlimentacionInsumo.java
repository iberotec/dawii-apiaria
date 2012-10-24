package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_tipo_alimentacion_insumo database table.
 * 
 */
@Entity
@Table(name="detalle_tipo_alimentacion_insumo")
public class DetalleTipoAlimentacionInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_alimentacion_insumo")
	private int idtipoAlimentacionInsumo;

	//bi-directional many-to-one association to TipoAlimentacion
    @ManyToOne
	@JoinColumn(name="idtipo_alimentacion")
	private TipoAlimentacion tipoAlimentacion;

	//bi-directional many-to-one association to Insumo
    @ManyToOne
	@JoinColumn(name="idinsumo")
	private Insumo insumo;

    public DetalleTipoAlimentacionInsumo() {
    }

	public int getIdtipoAlimentacionInsumo() {
		return this.idtipoAlimentacionInsumo;
	}

	public void setIdtipoAlimentacionInsumo(int idtipoAlimentacionInsumo) {
		this.idtipoAlimentacionInsumo = idtipoAlimentacionInsumo;
	}

	public TipoAlimentacion getTipoAlimentacion() {
		return this.tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}
	
	public Insumo getInsumo() {
		return this.insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
}