package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_medicamento database table.
 * 
 */
@Entity
@Table(name="tipo_medicamento")
public class TipoMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_medicamento")
	private int idtipoMedicamento;

	private String descripcion;

	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Medicamento> medicamentos;

    public TipoMedicamento() {
    }

	public int getIdtipoMedicamento() {
		return this.idtipoMedicamento;
	}

	public void setIdtipoMedicamento(int idtipoMedicamento) {
		this.idtipoMedicamento = idtipoMedicamento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
}