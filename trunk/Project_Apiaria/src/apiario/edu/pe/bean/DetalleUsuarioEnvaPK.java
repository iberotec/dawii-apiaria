package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_usuario_enva database table.
 * 
 */
@Embeddable
public class DetalleUsuarioEnvaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idusuario;

	private int idEnvasadora;

    public DetalleUsuarioEnvaPK() {
    }
	public int getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIdEnvasadora() {
		return this.idEnvasadora;
	}
	public void setIdEnvasadora(int idEnvasadora) {
		this.idEnvasadora = idEnvasadora;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleUsuarioEnvaPK)) {
			return false;
		}
		DetalleUsuarioEnvaPK castOther = (DetalleUsuarioEnvaPK)other;
		return 
			(this.idusuario == castOther.idusuario)
			&& (this.idEnvasadora == castOther.idEnvasadora);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario;
		hash = hash * prime + this.idEnvasadora;
		
		return hash;
    }
}