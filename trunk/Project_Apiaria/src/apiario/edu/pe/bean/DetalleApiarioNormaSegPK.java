package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_apiario_norma_seg database table.
 * 
 */
@Embeddable
public class DetalleApiarioNormaSegPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idapiario;

	@Column(name="idnorma_seguridad")
	private int idnormaSeguridad;

	@Column(name="iddetalle_apiario_norma_seguridad")
	private int iddetalleApiarioNormaSeguridad;

    public DetalleApiarioNormaSegPK() {
    }
	public int getIdapiario() {
		return this.idapiario;
	}
	public void setIdapiario(int idapiario) {
		this.idapiario = idapiario;
	}
	public int getIdnormaSeguridad() {
		return this.idnormaSeguridad;
	}
	public void setIdnormaSeguridad(int idnormaSeguridad) {
		this.idnormaSeguridad = idnormaSeguridad;
	}
	public int getIddetalleApiarioNormaSeguridad() {
		return this.iddetalleApiarioNormaSeguridad;
	}
	public void setIddetalleApiarioNormaSeguridad(int iddetalleApiarioNormaSeguridad) {
		this.iddetalleApiarioNormaSeguridad = iddetalleApiarioNormaSeguridad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleApiarioNormaSegPK)) {
			return false;
		}
		DetalleApiarioNormaSegPK castOther = (DetalleApiarioNormaSegPK)other;
		return 
			(this.idapiario == castOther.idapiario)
			&& (this.idnormaSeguridad == castOther.idnormaSeguridad)
			&& (this.iddetalleApiarioNormaSeguridad == castOther.iddetalleApiarioNormaSeguridad);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idapiario;
		hash = hash * prime + this.idnormaSeguridad;
		hash = hash * prime + this.iddetalleApiarioNormaSeguridad;
		
		return hash;
    }
}