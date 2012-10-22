package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recurso_natural database table.
 * 
 */
@Entity
@Table(name="recurso_natural")
public class RecursoNatural implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idrecurso_natural")
	private int idrecursoNatural;

	private String descripcion;

	//bi-directional many-to-one association to DetalleRecNatZona
	@OneToMany(mappedBy="recursoNatural")
	private List<DetalleRecNatZona> detalleRecNatZonas;

	//bi-directional many-to-one association to TipoRecursoNatural
    @ManyToOne
	@JoinColumn(name="idtipo_recurso_natural")
	private TipoRecursoNatural tipoRecursoNatural;

    public RecursoNatural() {
    }

	public int getIdrecursoNatural() {
		return this.idrecursoNatural;
	}

	public void setIdrecursoNatural(int idrecursoNatural) {
		this.idrecursoNatural = idrecursoNatural;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DetalleRecNatZona> getDetalleRecNatZonas() {
		return this.detalleRecNatZonas;
	}

	public void setDetalleRecNatZonas(List<DetalleRecNatZona> detalleRecNatZonas) {
		this.detalleRecNatZonas = detalleRecNatZonas;
	}
	
	public TipoRecursoNatural getTipoRecursoNatural() {
		return this.tipoRecursoNatural;
	}

	public void setTipoRecursoNatural(TipoRecursoNatural tipoRecursoNatural) {
		this.tipoRecursoNatural = tipoRecursoNatural;
	}
	
}