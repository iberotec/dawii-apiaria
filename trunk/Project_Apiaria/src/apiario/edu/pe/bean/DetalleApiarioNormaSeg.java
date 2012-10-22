package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_apiario_norma_seg database table.
 * 
 */
@Entity
@Table(name="detalle_apiario_norma_seg")
public class DetalleApiarioNormaSeg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleApiarioNormaSegPK id;

	@Column(name="estado_conformidad")
	private String estadoConformidad;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="idapiario")
	private Apiario apiario;

	//bi-directional many-to-one association to NormaSeguridad
    @ManyToOne
	@JoinColumn(name="idnorma_seguridad")
	private NormaSeguridad normaSeguridad;

    public DetalleApiarioNormaSeg() {
    }

	public DetalleApiarioNormaSegPK getId() {
		return this.id;
	}

	public void setId(DetalleApiarioNormaSegPK id) {
		this.id = id;
	}
	
	public String getEstadoConformidad() {
		return this.estadoConformidad;
	}

	public void setEstadoConformidad(String estadoConformidad) {
		this.estadoConformidad = estadoConformidad;
	}

	public Apiario getApiario() {
		return this.apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
	public NormaSeguridad getNormaSeguridad() {
		return this.normaSeguridad;
	}

	public void setNormaSeguridad(NormaSeguridad normaSeguridad) {
		this.normaSeguridad = normaSeguridad;
	}
	
}