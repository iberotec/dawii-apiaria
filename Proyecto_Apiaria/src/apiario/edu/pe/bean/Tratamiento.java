package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tratamiento database table.
 * 
 */
@Entity
@Table(name="tratamiento")
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tratamiento")
	private int idTratamiento;

	@Column(name="descripcion_tratamiento")
	private String descripcionTratamiento;

	//bi-directional many-to-one association to TipoEnfermedadTratamiento
	@OneToMany(mappedBy="tratamiento")
	private Set<TipoEnfermedadTratamiento> tipoEnfermedadTratamientos;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to TratamientoMedicamento
	@OneToMany(mappedBy="tratamiento")
	private Set<TratamientoMedicamento> tratamientoMedicamentos;

    public Tratamiento() {
    }

	public int getIdTratamiento() {
		return this.idTratamiento;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getDescripcionTratamiento() {
		return this.descripcionTratamiento;
	}

	public void setDescripcionTratamiento(String descripcionTratamiento) {
		this.descripcionTratamiento = descripcionTratamiento;
	}

	public Set<TipoEnfermedadTratamiento> getTipoEnfermedadTratamientos() {
		return this.tipoEnfermedadTratamientos;
	}

	public void setTipoEnfermedadTratamientos(Set<TipoEnfermedadTratamiento> tipoEnfermedadTratamientos) {
		this.tipoEnfermedadTratamientos = tipoEnfermedadTratamientos;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<TratamientoMedicamento> getTratamientoMedicamentos() {
		return this.tratamientoMedicamentos;
	}

	public void setTratamientoMedicamentos(Set<TratamientoMedicamento> tratamientoMedicamentos) {
		this.tratamientoMedicamentos = tratamientoMedicamentos;
	}
	
}