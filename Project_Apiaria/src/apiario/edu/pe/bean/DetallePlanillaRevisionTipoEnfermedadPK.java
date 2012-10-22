package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_planilla_revision_tipo_enfermedad database table.
 * 
 */
@Embeddable
public class DetallePlanillaRevisionTipoEnfermedadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idplanilla_revision")
	private int idplanillaRevision;

	@Column(name="idtipo_enfermedad")
	private int idtipoEnfermedad;

    public DetallePlanillaRevisionTipoEnfermedadPK() {
    }
	public int getIdplanillaRevision() {
		return this.idplanillaRevision;
	}
	public void setIdplanillaRevision(int idplanillaRevision) {
		this.idplanillaRevision = idplanillaRevision;
	}
	public int getIdtipoEnfermedad() {
		return this.idtipoEnfermedad;
	}
	public void setIdtipoEnfermedad(int idtipoEnfermedad) {
		this.idtipoEnfermedad = idtipoEnfermedad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePlanillaRevisionTipoEnfermedadPK)) {
			return false;
		}
		DetallePlanillaRevisionTipoEnfermedadPK castOther = (DetallePlanillaRevisionTipoEnfermedadPK)other;
		return 
			(this.idplanillaRevision == castOther.idplanillaRevision)
			&& (this.idtipoEnfermedad == castOther.idtipoEnfermedad);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idplanillaRevision;
		hash = hash * prime + this.idtipoEnfermedad;
		
		return hash;
    }
}