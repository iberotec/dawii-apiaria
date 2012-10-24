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

	@Id
	@Column(name="idusuario_envasadora")
	private int idusuarioEnvasadora;

	@Column(name="fecha_uso")
	private String fechaUso;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to Envasadora
    @ManyToOne
	private Envasadora envasadora;

    public DetalleUsuarioEnva() {
    }

	public int getIdusuarioEnvasadora() {
		return this.idusuarioEnvasadora;
	}

	public void setIdusuarioEnvasadora(int idusuarioEnvasadora) {
		this.idusuarioEnvasadora = idusuarioEnvasadora;
	}

	public String getFechaUso() {
		return this.fechaUso;
	}

	public void setFechaUso(String fechaUso) {
		this.fechaUso = fechaUso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Envasadora getEnvasadora() {
		return this.envasadora;
	}

	public void setEnvasadora(Envasadora envasadora) {
		this.envasadora = envasadora;
	}
	
}