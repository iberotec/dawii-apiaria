package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_enfermedad_tratamiento database table.
 * 
 */
@Entity
@Table(name="tipo_enfermedad_tratamiento")
public class TipoEnfermedadTratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_enfermedad_tratamiento")
	private int idTipoEnfermedadTratamiento;

	//bi-directional many-to-one association to TipoEnfermedad
    @ManyToOne
	@JoinColumn(name="id_tipo_enfermedad")
	private TipoEnfermedad tipoEnfermedad;

	//bi-directional many-to-one association to Tratamiento
    @ManyToOne
	@JoinColumn(name="id_tratamiento")
	private Tratamiento tratamiento;

    public TipoEnfermedadTratamiento() {
    }

	public int getIdTipoEnfermedadTratamiento() {
		return this.idTipoEnfermedadTratamiento;
	}

	public void setIdTipoEnfermedadTratamiento(int idTipoEnfermedadTratamiento) {
		this.idTipoEnfermedadTratamiento = idTipoEnfermedadTratamiento;
	}

	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoEnfermedad;
	}

	public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
		this.tipoEnfermedad = tipoEnfermedad;
	}
	
	public Tratamiento getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
}