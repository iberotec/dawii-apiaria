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
	private int idmedicamento;

	private String descripcion;

	//bi-directional many-to-one association to DetalleTratMed
	@OneToMany(mappedBy="medicamento")
	private Set<DetalleTratMed> detalleTratMeds;

	//bi-directional many-to-one association to TipoMedicamento
    @ManyToOne
	@JoinColumn(name="idtipo_medicamento")
	private TipoMedicamento tipoMedicamento;

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

	public Set<DetalleTratMed> getDetalleTratMeds() {
		return this.detalleTratMeds;
	}

	public void setDetalleTratMeds(Set<DetalleTratMed> detalleTratMeds) {
		this.detalleTratMeds = detalleTratMeds;
	}
	
	public TipoMedicamento getTipoMedicamento() {
		return this.tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
}