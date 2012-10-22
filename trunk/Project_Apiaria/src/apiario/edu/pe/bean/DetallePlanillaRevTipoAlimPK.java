package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_planilla_rev_tipo_alim database table.
 * 
 */
@Embeddable
public class DetallePlanillaRevTipoAlimPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idusuario;

	private int idcolmena;

	@Column(name="idtipo_alimentacion")
	private int idtipoAlimentacion;

    public DetallePlanillaRevTipoAlimPK() {
    }
	public int getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIdcolmena() {
		return this.idcolmena;
	}
	public void setIdcolmena(int idcolmena) {
		this.idcolmena = idcolmena;
	}
	public int getIdtipoAlimentacion() {
		return this.idtipoAlimentacion;
	}
	public void setIdtipoAlimentacion(int idtipoAlimentacion) {
		this.idtipoAlimentacion = idtipoAlimentacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePlanillaRevTipoAlimPK)) {
			return false;
		}
		DetallePlanillaRevTipoAlimPK castOther = (DetallePlanillaRevTipoAlimPK)other;
		return 
			(this.idusuario == castOther.idusuario)
			&& (this.idcolmena == castOther.idcolmena)
			&& (this.idtipoAlimentacion == castOther.idtipoAlimentacion);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario;
		hash = hash * prime + this.idcolmena;
		hash = hash * prime + this.idtipoAlimentacion;
		
		return hash;
    }
}