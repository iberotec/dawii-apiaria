package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tratamiento_medicamento database table.
 * 
 */
@Entity
@Table(name="tratamiento_medicamento")
public class TratamientoMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tratamiento_medicamento")
	private int idTratamientoMedicamento;

	//bi-directional many-to-one association to Medicamento
    @ManyToOne
	@JoinColumn(name="id_medicamento")
	private Medicamento medicamento;

	//bi-directional many-to-one association to Tratamiento
    @ManyToOne
	@JoinColumn(name="id_tratamiento")
	private Tratamiento tratamiento;

    public TratamientoMedicamento() {
    }

	public int getIdTratamientoMedicamento() {
		return this.idTratamientoMedicamento;
	}

	public void setIdTratamientoMedicamento(int idTratamientoMedicamento) {
		this.idTratamientoMedicamento = idTratamientoMedicamento;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public Tratamiento getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
}