package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_usuario_enva database table.
 * 
 */
@Entity
@Table(name="detalle_usuario_enva")
public class DetalleUsuarioEnva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleUsuarioEnvaPK id;

	@Column(name="fecha_uso")
	private String fechaUso;

	//bi-directional many-to-one association to Envasadora
    @ManyToOne
	@JoinColumn(name="idEnvasadora")
	private Envasadora envasadora;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

    public DetalleUsuarioEnva() {
    }

	public DetalleUsuarioEnvaPK getId() {
		return this.id;
	}

	public void setId(DetalleUsuarioEnvaPK id) {
		this.id = id;
	}
	
	public String getFechaUso() {
		return this.fechaUso;
	}

	public void setFechaUso(String fechaUso) {
		this.fechaUso = fechaUso;
	}

	public Envasadora getEnvasadora() {
		return this.envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}