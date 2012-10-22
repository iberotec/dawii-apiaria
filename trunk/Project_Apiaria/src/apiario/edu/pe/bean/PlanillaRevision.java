package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planilla_revision database table.
 * 
 */
@Entity
@Table(name="planilla_revision")
public class PlanillaRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idplanilla_revision")
	private int idplanillaRevision;

	private String comportamiento;

	@Column(name="estado_colmena")
	private String estadoColmena;

	@Column(name="existencia_reina")
	private byte existenciaReina;

	@Column(name="falta_alza")
	private byte faltaAlza;

	@Column(name="falta_espacio_camara_cria")
	private byte faltaEspacioCamaraCria;

	@Column(name="necesidad_alimentacion")
	private byte necesidadAlimentacion;

	@Column(name="necesidad_curacion")
	private byte necesidadCuracion;

	@Column(name="peligro_colmena")
	private String peligroColmena;

	//bi-directional many-to-one association to DetallePlanillaRevisionAlza
	@OneToMany(mappedBy="planillaRevision")
	private List<DetallePlanillaRevisionAlza> detallePlanillaRevisionAlzas;

	//bi-directional many-to-one association to DetallePlanillaRevisionTipoEnfermedad
	@OneToMany(mappedBy="planillaRevision")
	private List<DetallePlanillaRevisionTipoEnfermedad> detallePlanillaRevisionTipoEnfermedads;

	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="idcolmena")
	private Colmena colmena;

	//bi-directional many-to-one association to EstadoRevision
    @ManyToOne
	@JoinColumn(name="idestado_revision")
	private EstadoRevision estadoRevision;

	//bi-directional many-to-one association to Reina
    @ManyToOne
	@JoinColumn(name="idreina")
	private Reina reina;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

    public PlanillaRevision() {
    }

	public int getIdplanillaRevision() {
		return this.idplanillaRevision;
	}

	public void setIdplanillaRevision(int idplanillaRevision) {
		this.idplanillaRevision = idplanillaRevision;
	}

	public String getComportamiento() {
		return this.comportamiento;
	}

	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}

	public String getEstadoColmena() {
		return this.estadoColmena;
	}

	public void setEstadoColmena(String estadoColmena) {
		this.estadoColmena = estadoColmena;
	}

	public byte getExistenciaReina() {
		return this.existenciaReina;
	}

	public void setExistenciaReina(byte existenciaReina) {
		this.existenciaReina = existenciaReina;
	}

	public byte getFaltaAlza() {
		return this.faltaAlza;
	}

	public void setFaltaAlza(byte faltaAlza) {
		this.faltaAlza = faltaAlza;
	}

	public byte getFaltaEspacioCamaraCria() {
		return this.faltaEspacioCamaraCria;
	}

	public void setFaltaEspacioCamaraCria(byte faltaEspacioCamaraCria) {
		this.faltaEspacioCamaraCria = faltaEspacioCamaraCria;
	}

	public byte getNecesidadAlimentacion() {
		return this.necesidadAlimentacion;
	}

	public void setNecesidadAlimentacion(byte necesidadAlimentacion) {
		this.necesidadAlimentacion = necesidadAlimentacion;
	}

	public byte getNecesidadCuracion() {
		return this.necesidadCuracion;
	}

	public void setNecesidadCuracion(byte necesidadCuracion) {
		this.necesidadCuracion = necesidadCuracion;
	}

	public String getPeligroColmena() {
		return this.peligroColmena;
	}

	public void setPeligroColmena(String peligroColmena) {
		this.peligroColmena = peligroColmena;
	}

	public List<DetallePlanillaRevisionAlza> getDetallePlanillaRevisionAlzas() {
		return this.detallePlanillaRevisionAlzas;
	}

	public void setDetallePlanillaRevisionAlzas(List<DetallePlanillaRevisionAlza> detallePlanillaRevisionAlzas) {
		this.detallePlanillaRevisionAlzas = detallePlanillaRevisionAlzas;
	}
	
	public List<DetallePlanillaRevisionTipoEnfermedad> getDetallePlanillaRevisionTipoEnfermedads() {
		return this.detallePlanillaRevisionTipoEnfermedads;
	}

	public void setDetallePlanillaRevisionTipoEnfermedads(List<DetallePlanillaRevisionTipoEnfermedad> detallePlanillaRevisionTipoEnfermedads) {
		this.detallePlanillaRevisionTipoEnfermedads = detallePlanillaRevisionTipoEnfermedads;
	}
	
	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
	public EstadoRevision getEstadoRevision() {
		return this.estadoRevision;
	}

	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	
	public Reina getReina() {
		return this.reina;
	}

	public void setReina(Reina reina) {
		this.reina = reina;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}