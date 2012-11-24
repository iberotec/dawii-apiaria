package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the norma_seguridad_apiario database table.
 * 
 */
@Entity
@Table(name="norma_seguridad_apiario")
public class NormaSeguridadApiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_norma_seguridad_apiario")
	private int idNormaSeguridadApiario;

	private byte estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to Apiario
    @ManyToOne
	@JoinColumn(name="id_apiario")
	private Apiario apiario;

	//bi-directional many-to-one association to NormaSeguridad
    @ManyToOne
	@JoinColumn(name="id_norma_seguridad")
	private NormaSeguridad normaSeguridad;

    public NormaSeguridadApiario() {
    }

	public int getIdNormaSeguridadApiario() {
		return this.idNormaSeguridadApiario;
	}

	public void setIdNormaSeguridadApiario(int idNormaSeguridadApiario) {
		this.idNormaSeguridadApiario = idNormaSeguridadApiario;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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