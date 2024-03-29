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
	private int idusuario;

	@Column(name="ape_usu")
	private String apeUsu;

	@Column(name="nom_usu")
	private String nomUsu;

	//bi-directional many-to-one association to DetalleUsuarioEnva
	@OneToMany(mappedBy="usuario")
	private Set<DetalleUsuarioEnva> detalleUsuarioEnvas;

	//bi-directional many-to-one association to PlanillaCosecha
	@OneToMany(mappedBy="usuario")
	private Set<PlanillaCosecha> planillaCosechas;

	//bi-directional many-to-one association to PlanillaRevision
	@OneToMany(mappedBy="usuario")
	private Set<PlanillaRevision> planillaRevisions;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="usuario")
	private Set<Tratamiento> tratamientos;

	//bi-directional many-to-one association to TipoUsuario
    @ManyToOne
	@JoinColumn(name="idtipo_usuario")
	private TipoUsuario tipoUsuario;

    public Usuario() {
    }

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getApeUsu() {
		return this.apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public String getNomUsu() {
		return this.nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public Set<DetalleUsuarioEnva> getDetalleUsuarioEnvas() {
		return this.detalleUsuarioEnvas;
	}

	public void setDetalleUsuarioEnvas(Set<DetalleUsuarioEnva> detalleUsuarioEnvas) {
		this.detalleUsuarioEnvas = detalleUsuarioEnvas;
	}
	
	public Set<PlanillaCosecha> getPlanillaCosechas() {
		return this.planillaCosechas;
	}

	public void setPlanillaCosechas(Set<PlanillaCosecha> planillaCosechas) {
		this.planillaCosechas = planillaCosechas;
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
	
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}