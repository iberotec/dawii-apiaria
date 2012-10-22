package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_tipo_enfe_tratamiento database table.
 * 
 */
@Embeddable
public class DetalleTipoEnfeTratamientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idtipo_enfermedad")
	private int idtipoEnfermedad;

	private int idtratamiento;

    public DetalleTipoEnfeTratamientoPK() {
    }
	public int getIdtipoEnfermedad() {
		return this.idtipoEnfermedad;
	}
	public void setIdtipoEnfermedad(int idtipoEnfermedad) {
		this.idtipoEnfermedad = idtipoEnfermedad;
	}
	public int getIdtratamiento() {
		return this.idtratamiento;
	}
	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleTipoEnfeTratamientoPK)) {
			return false;
		}
		DetalleTipoEnfeTratamientoPK castOther = (DetalleTipoEnfeTratamientoPK)other;
		return 
			(this.idtipoEnfermedad == castOther.idtipoEnfermedad)
			&& (this.idtratamiento == castOther.idtratamiento);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idtipoEnfermedad;
		hash = hash * prime + this.idtratamiento;
		
		return hash;
    }
}