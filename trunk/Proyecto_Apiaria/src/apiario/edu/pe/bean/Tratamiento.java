package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private List<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos;

	//bi-directional many-to-one association to DetalleTratMed
	@OneToMany(mappedBy="tratamiento")
	private List<DetalleTratMed> detalleTratMeds;

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

	public List<DetalleTipoEnfeTratamiento> getDetalleTipoEnfeTratamientos() {
		return this.detalleTipoEnfeTratamientos;
	}

	public void setDetalleTipoEnfeTratamientos(List<DetalleTipoEnfeTratamiento> detalleTipoEnfeTratamientos) {
		this.detalleTipoEnfeTratamientos = detalleTipoEnfeTratamientos;
	}
	
	public List<DetalleTratMed> getDetalleTratMeds() {
		return this.detalleTratMeds;
	}

	public void setDetalleTratMeds(List<DetalleTratMed> detalleTratMeds) {
		this.detalleTratMeds = detalleTratMeds;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}