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
	private int idtratamiento;

	private String descripcion;

	//bi-directional many-to-one association to DetalleTipoEnfeTratamiento
	@OneToMany(mappedBy="tratamiento")
	private Set<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos;

	//bi-directional many-to-one association to DetalleTratMed
	@OneToMany(mappedBy="tratamiento")
	private Set<DetalleTratMed> detalleTratMeds;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

    public Tratamiento() {
    }

	public int getIdtratamiento() {
		return this.idtratamiento;
	}

	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DetalleTipoEnfeTratamiento> getDetalleTipoEnfeTratamientos() {
		return this.detalleTipoEnfeTratamientos;
	}

	public void setDetalleTipoEnfeTratamientos(Set<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos) {
		this.detalleTipoEnfeTratamientos = detalleTipoEnfeTratamientos;
	}
	
	public Set<DetalleTratMed> getDetalleTratMeds() {
		return this.detalleTratMeds;
	}

	public void setDetalleTratMeds(Set<DetalleTratMed> detalleTratMeds) {
		this.detalleTratMeds = detalleTratMeds;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}