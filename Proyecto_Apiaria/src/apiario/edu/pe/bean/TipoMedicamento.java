package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_medicamento database table.
 * 
 */
@Entity
@Table(name="tipo_medicamento")
public class TipoMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_medicamento")
	private int idTipoMedicamento;

	@Column(name="descripcion_tipo_medicamento")
	private String descripcionTipoMedicamento;

	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="tipoMedicamento")
	private Set<Medicamento> medicamentos;

    public TipoMedicamento() {
    }

	public int getIdTipoMedicamento() {
		return this.idTipoMedicamento;
	}

	public void setIdTipoMedicamento(int idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}

	public String getDescripcionTipoMedicamento() {
		return this.descripcionTipoMedicamento;
	}

	public void setDescripcionTipoMedicamento(String descripcionTipoMedicamento) {
		this.descripcionTipoMedicamento = descripcionTipoMedicamento;
	}

	public Set<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
}