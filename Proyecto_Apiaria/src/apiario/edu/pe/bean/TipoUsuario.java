package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtipo_usuario")
	private int idtipoUsuario;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoUsuario")
	private List<Usuario> usuarios;

    public TipoUsuario() {
    }

	public int getIdtipoUsuario() {
		return this.idtipoUsuario;
	}

	public void setIdtipoUsuario(int idtipoUsuario) {
		this.idtipoUsuario = idtipoUsuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}