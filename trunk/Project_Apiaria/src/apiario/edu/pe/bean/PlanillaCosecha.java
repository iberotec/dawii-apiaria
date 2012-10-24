package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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

	//bi-directional many-to-one association to DetalleCentrifugadoraPlanillaCosecha
	@OneToMany(mappedBy="planillaCosecha")
	private Set<DetalleCentrifugadoraPlanillaCosecha> detalleCentrifugadoraPlanillaCosechas;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="idcolmena")
	private Colmena colmena;

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

	public Set<DetalleCentrifugadoraPlanillaCosecha> getDetalleCentrifugadoraPlanillaCosechas() {
		return this.detalleCentrifugadoraPlanillaCosechas;
	}

	public void setDetalleCentrifugadoraPlanillaCosechas(Set<DetalleCentrifugadoraPlanillaCosecha> detalleCentrifugadoraPlanillaCosechas) {
		this.detalleCentrifugadoraPlanillaCosechas = detalleCentrifugadoraPlanillaCosechas;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
}