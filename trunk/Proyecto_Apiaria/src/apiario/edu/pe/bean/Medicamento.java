package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_medicamento")
	private int idMedicamento;

	@Column(name="descripcion_medicamento")
	private String descripcionMedicamento;

	//bi-directional many-to-one association to TipoMedicamento
    @ManyToOne
	@JoinColumn(name="id_tipo_medicamento")
	private TipoMedicamento tipoMedicamento;

	//bi-directional many-to-one association to TratamientoMedicamento
	@OneToMany(mappedBy="medicamento")
	private Set<TratamientoMedicamento> tratamientoMedicamentos;

    public Medicamento() {
    }

	public int getIdMedicamento() {
		return this.idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getDescripcionMedicamento() {
		return this.descripcionMedicamento;
	}

	public void setDescripcionMedicamento(String descripcionMedicamento) {
		this.descripcionMedicamento = descripcionMedicamento;
	}

	public TipoMedicamento getTipoMedicamento() {
		return this.tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	public Set<TratamientoMedicamento> getTratamientoMedicamentos() {
		return this.tratamientoMedicamentos;
	}

	public void setTratamientoMedicamentos(Set<TratamientoMedicamento> tratamientoMedicamentos) {
		this.tratamientoMedicamentos = tratamientoMedicamentos;
	}
	
}