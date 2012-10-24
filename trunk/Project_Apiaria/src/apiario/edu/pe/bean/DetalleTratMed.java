package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_trat_med database table.
 * 
 */
@Entity
@Table(name="detalle_trat_med")
public class DetalleTratMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtratamiento_medicina")
	private int idtratamientoMedicina;

	//bi-directional many-to-one association to Tratamiento
    @ManyToOne
	private Tratamiento tratamiento;

	//bi-directional many-to-one association to Medicamento
    @ManyToOne
	private Medicamento medicamento;

    public DetalleTratMed() {
    }

	public int getIdtratamientoMedicina() {
		return this.idtratamientoMedicina;
	}

	public void setIdtratamientoMedicina(int idtratamientoMedicina) {
		this.idtratamientoMedicina = idtratamientoMedicina;
	}

	public Tratamiento getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
}