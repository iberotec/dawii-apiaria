package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_planilla_revision_alza database table.
 * 
 */
@Embeddable
public class DetallePlanillaRevisionAlzaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idplanilla_revision")
	private int idplanillaRevision;

	private int idalza;

    public DetallePlanillaRevisionAlzaPK() {
    }
	public int getIdplanillaRevision() {
		return this.idplanillaRevision;
	}
	public void setIdplanillaRevision(int idplanillaRevision) {
		this.idplanillaRevision = idplanillaRevision;
	}
	public int getIdalza() {
		return this.idalza;
	}
	public void setIdalza(int idalza) {
		this.idalza = idalza;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePlanillaRevisionAlzaPK)) {
			return false;
		}
		DetallePlanillaRevisionAlzaPK castOther = (DetallePlanillaRevisionAlzaPK)other;
		return 
			(this.idplanillaRevision == castOther.idplanillaRevision)
			&& (this.idalza == castOther.idalza);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idplanillaRevision;
		hash = hash * prime + this.idalza;
		
		return hash;
    }
}