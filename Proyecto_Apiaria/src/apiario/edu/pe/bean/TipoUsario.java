package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_usario database table.
 * 
 */
@Entity
@Table(name="tipo_usario")
public class TipoUsario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_usario")
	private int idTipoUsario;

	@Column(name="descripcion_usuario")
	private String descripcionUsuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoUsario")
	private Set<Usuario> usuarios;

    public TipoUsario() {
    }

	public int getIdTipoUsario() {
		return this.idTipoUsario;
	}

	public void setIdTipoUsario(int idTipoUsario) {
		this.idTipoUsario = idTipoUsario;
	}

	public String getDescripcionUsuario() {
		return this.descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}