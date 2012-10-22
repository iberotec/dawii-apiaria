package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the planilla_revision_alza database table.
 * 
 */
@Embeddable
public class PlanillaRevisionAlzaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idusuario;

	private int idcolmena;

	@Column(name="alza_idalza")
	private int alzaIdalza;

    public PlanillaRevisionAlzaPK() {
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
	public int getAlzaIdalza() {
		return this.alzaIdalza;
	}
	public void setAlzaIdalza(int alzaIdalza) {
		this.alzaIdalza = alzaIdalza;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlanillaRevisionAlzaPK)) {
			return false;
		}
		PlanillaRevisionAlzaPK castOther = (PlanillaRevisionAlzaPK)other;
		return 
			(this.idusuario == castOther.idusuario)
			&& (this.idcolmena == castOther.idcolmena)
			&& (this.alzaIdalza == castOther.alzaIdalza);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario;
		hash = hash * prime + this.idcolmena;
		hash = hash * prime + this.alzaIdalza;
		
		return hash;
    }
}