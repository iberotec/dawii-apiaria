package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the planilla_cosecha database table.
 * 
 */
@Entity
@Table(name="planilla_cosecha")
public class PlanillaCosecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_cosecha")
	private int idplanillaCosecha;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_cosecha")
	private Date fechaCosecha;

	//bi-directional many-to-many association to Centrifugadora
    @ManyToMany
	@JoinTable(
		name="detalle_centrifugadora_planilla_cosecha"
		, joinColumns={
			@JoinColumn(name="idplanilla_cosecha")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcentrifugadora")
			}
		)
	private List<Centrifugadora> centrifugadoras;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="idcolmena")
	private Colmena colmena;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

    public PlanillaCosecha() {
    }

	public int getIdplanillaCosecha() {
		return this.idplanillaCosecha;
	}

	public void setIdplanillaCosecha(int idplanillaCosecha) {
		this.idplanillaCosecha = idplanillaCosecha;
	}

	public Date getFechaCosecha() {
		return this.fechaCosecha;
	}

	public void setFechaCosecha(Date fechaCosecha) {
		this.fechaCosecha = fechaCosecha;
	}

	public List<Centrifugadora> getCentrifugadoras() {
		return this.centrifugadoras;
	}

	public void setCentrifugadoras(List<Centrifugadora> centrifugadoras) {
		this.centrifugadoras = centrifugadoras;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}