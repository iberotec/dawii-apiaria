package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_rec_nat_zona database table.
 * 
 */
@Embeddable
public class DetalleRecNatZonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idrecurso_natural")
	private int idrecursoNatural;

	private int idzona;

	@Column(name="iddetalle_recursonatura_zona")
	private int iddetalleRecursonaturaZona;

    public DetalleRecNatZonaPK() {
    }
	public int getIdrecursoNatural() {
		return this.idrecursoNatural;
	}
	public void setIdrecursoNatural(int idrecursoNatural) {
		this.idrecursoNatural = idrecursoNatural;
	}
	public int getIdzona() {
		return this.idzona;
	}
	public void setIdzona(int idzona) {
		this.idzona = idzona;
	}
	public int getIddetalleRecursonaturaZona() {
		return this.iddetalleRecursonaturaZona;
	}
	public void setIddetalleRecursonaturaZona(int iddetalleRecursonaturaZona) {
		this.iddetalleRecursonaturaZona = iddetalleRecursonaturaZona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleRecNatZonaPK)) {
			return false;
		}
		DetalleRecNatZonaPK castOther = (DetalleRecNatZonaPK)other;
		return 
			(this.idrecursoNatural == castOther.idrecursoNatural)
			&& (this.idzona == castOther.idzona)
			&& (this.iddetalleRecursonaturaZona == castOther.iddetalleRecursonaturaZona);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idrecursoNatural;
		hash = hash * prime + this.idzona;
		hash = hash * prime + this.iddetalleRecursonaturaZona;
		
		return hash;
    }
}