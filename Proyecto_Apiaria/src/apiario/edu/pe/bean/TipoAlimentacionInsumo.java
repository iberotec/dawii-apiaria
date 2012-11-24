package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_alimentacion_insumo database table.
 * 
 */
@Entity
@Table(name="tipo_alimentacion_insumo")
public class TipoAlimentacionInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_alimentacion_insumo")
	private int idTipoAlimentacionInsumo;

	//bi-directional many-to-one association to Insumo
    @ManyToOne
	@JoinColumn(name="id_insumo")
	private Insumo insumo;

	//bi-directional many-to-one association to TipoAlimentacion
    @ManyToOne
	@JoinColumn(name="id_tipo_alimentacion")
	private TipoAlimentacion tipoAlimentacion;

    public TipoAlimentacionInsumo() {
    }

	public int getIdTipoAlimentacionInsumo() {
		return this.idTipoAlimentacionInsumo;
	}

	public void setIdTipoAlimentacionInsumo(int idTipoAlimentacionInsumo) {
		this.idTipoAlimentacionInsumo = idTipoAlimentacionInsumo;
	}

	public Insumo getInsumo() {
		return this.insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	public TipoAlimentacion getTipoAlimentacion() {
		return this.tipoAlimentacion;
	}

	public void setTipoAlimentacion(TipoAlimentacion tipoAlimentacion) {
		this.tipoAlimentacion = tipoAlimentacion;
	}
	
}