package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the planilla_seguimiento database table.
 * 
 */
@Embeddable
public class PlanillaSeguimientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idzona;

	private int idapiario;

    public PlanillaSeguimientoPK() {
    }
	public int getIdzona() {
		return this.idzona;
	}
	public void setIdzona(int idzona) {
		this.idzona = idzona;
	}
	public int getIdapiario() {
		return this.idapiario;
	}
	public void setIdapiario(int idapiario) {
		this.idapiario = idapiario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlanillaSeguimientoPK)) {
			return false;
		}
		PlanillaSeguimientoPK castOther = (PlanillaSeguimientoPK)other;
		return 
			(this.idzona == castOther.idzona)
			&& (this.idapiario == castOther.idapiario);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idzona;
		hash = hash * prime + this.idapiario;
		
		return hash;
    }
}