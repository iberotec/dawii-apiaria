package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planilla_seguimiento database table.
 * 
 */
@Entity
@Table(name="planilla_seguimiento")
public class PlanillaSeguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlanillaSeguimientoPK id;

	@Column(name="motivo_ubicacion")
	private String motivoUbicacion;

	//bi-directional many-to-one association to Zona
    @ManyToOne
	@JoinColumn(name="idzona")
	private Zona zona;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="idapiario")
	private Apiario apiario;

    public PlanillaSeguimiento() {
    }

	public PlanillaSeguimientoPK getId() {
		return this.id;
	}

	public void setId(PlanillaSeguimientoPK id) {
		this.id = id;
	}
	
	public String getMotivoUbicacion() {
		return this.motivoUbicacion;
	}

	public void setMotivoUbicacion(String motivoUbicacion) {
		this.motivoUbicacion = motivoUbicacion;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	public Apiario getApiario() {
		return this.apiario;
	}

	public void setApiario(Apiario apiario) {
		this.apiario = apiario;
	}
	
}