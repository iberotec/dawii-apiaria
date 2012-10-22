package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicamento database table.
 * 
 */
@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmedicamento;

	private String descripcion;

	//bi-directional many-to-one association to TipoMedicamento
    @ManyToOne
	@JoinColumn(name="idtipo_medicamento")
	private TipoMedicamento tipoMedicamento;

	//bi-directional many-to-many association to Tratamiento
    @ManyToMany
	@JoinTable(
		name="detalle_trat_med"
		, joinColumns={
			@JoinColumn(name="idmedicamento")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idtratamiento")
			}
		)
	private List<Tratamiento> tratamientos;

    public Medicamento() {
    }

	public int getIdmedicamento() {
		return this.idmedicamento;
	}

	public void setIdmedicamento(int idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoMedicamento getTipoMedicamento() {
		return this.tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	public List<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
}