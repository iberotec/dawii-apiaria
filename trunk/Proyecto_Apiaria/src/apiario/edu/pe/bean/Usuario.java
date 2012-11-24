package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="ape_mater_usuario")
	private String apeMaterUsuario;

	@Column(name="ape_pater_usuario")
	private String apePaterUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="usuario")
	private Set<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="usuario")
	private Set<Tratamiento> tratamientos;

	//bi-directional many-to-one association to TipoUsario
    @ManyToOne
	@JoinColumn(name="id_tipo_usario")
	private TipoUsario tipoUsario;

    public Usuario() {
    }

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApeMaterUsuario() {
		return this.apeMaterUsuario;
	}

	public void setApeMaterUsuario(String apeMaterUsuario) {
		this.apeMaterUsuario = apeMaterUsuario;
	}

	public String getApePaterUsuario() {
		return this.apePaterUsuario;
	}

	public void setApePaterUsuario(String apePaterUsuario) {
		this.apePaterUsuario = apePaterUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Set<PlanillaRevision> getPlanillaRevisions() {
		return this.planillaRevisions;
	}

	public void setPlanillaRevisions(Set<PlanillaRevision> planillaRevisions) {
		this.planillaRevisions = planillaRevisions;
	}
	
	public Set<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(Set<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	public TipoUsario getTipoUsario() {
		return this.tipoUsario;
	}

	public void setTipoUsario(TipoUsario tipoUsario) {
		this.tipoUsario = tipoUsario;
	}
	
}