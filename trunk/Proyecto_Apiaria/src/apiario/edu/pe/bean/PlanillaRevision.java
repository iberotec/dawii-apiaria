package apiario.edu.pe.bean;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the planilla_revision database table.
 * 
 */
@Entity
@Table(name="planilla_revision")
public class PlanillaRevision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_planilla_revision")
	private int idPlanillaRevision;

	private String comportamiento;

	@Column(name="estado_cosecha")
	private String estadoCosecha;

	@Column(name="existencia_reina")
	private byte existenciaReina;

	@Column(name="falta_alza")
	private String faltaAlza;

	@Column(name="falta_espacio_camara")
	private byte faltaEspacioCamara;

	@Column(name="necesidad_alimentacion")
	private byte necesidadAlimentacion;

	@Column(name="necesidad_curacion")
	private byte necesidadCuracion;
	
	//bi-directional many-to-one association to Colmena
    @ManyToOne
	@JoinColumn(name="id_colmena")
	private Colmena colmena;

	//bi-directional many-to-one association to Reina
    @ManyToOne
	@JoinColumn(name="id_reina")
	private Reina reina;

	//bi-directional many-to-one association to EstadoRevision
    @ManyToOne
	@JoinColumn(name="id_estado_revision")
	private EstadoRevision estadoRevision;
    
    @ManyToOne
	@JoinColumn(name="id_usuario_apiario")
	private UsuarioApiario usuarioApiario;
    
	//bi-directional many-to-one association to PlanillaRevisionAlza
	@OneToMany(mappedBy="planillaRevision")
	private List<PlanillaRevisionAlza> planillaRevisionAlzas;

	//bi-directional many-to-one association to PlanillaRevisionTipoAlimentacion
	@OneToMany(mappedBy="planillaRevision")
	private List<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions;

	//bi-directional many-to-one association to PlanillaRevisionTipoEnfermedad
	@OneToMany(mappedBy="planillaRevision")
	private List<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads;

    public PlanillaRevision() {
    }
    
	public UsuarioApiario getUsuarioApiario() {
		return usuarioApiario;
	}

	public void setUsuarioApiario(UsuarioApiario usuarioApiario) {
		this.usuarioApiario = usuarioApiario;
	}

	public int getIdPlanillaRevision() {
		return this.idPlanillaRevision;
	}

	public void setIdPlanillaRevision(int idPlanillaRevision) {
		this.idPlanillaRevision = idPlanillaRevision;
	}

	public String getComportamiento() {
		return this.comportamiento;
	}

	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}

	public String getEstadoCosecha() {
		return this.estadoCosecha;
	}

	public void setEstadoCosecha(String estadoCosecha) {
		this.estadoCosecha = estadoCosecha;
	}

	public byte getExistenciaReina() {
		return this.existenciaReina;
	}

	public void setExistenciaReina(byte existenciaReina) {
		this.existenciaReina = existenciaReina;
	}

	public String getFaltaAlza() {
		return this.faltaAlza;
	}

	public void setFaltaAlza(String faltaAlza) {
		this.faltaAlza = faltaAlza;
	}

	public byte getFaltaEspacioCamara() {
		return this.faltaEspacioCamara;
	}

	public void setFaltaEspacioCamara(byte faltaEspacioCamara) {
		this.faltaEspacioCamara = faltaEspacioCamara;
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

	public Colmena getColmena() {
		return this.colmena;
	}

	public void setColmena(Colmena colmena) {
		this.colmena = colmena;
	}
	
	public Reina getReina() {
		return this.reina;
	}

	public void setReina(Reina reina) {
		this.reina = reina;
	}
	
	public EstadoRevision getEstadoRevision() {
		return this.estadoRevision;
	}

	public void setEstadoRevision(EstadoRevision estadoRevision) {
		this.estadoRevision = estadoRevision;
	}
	
	public List<PlanillaRevisionAlza> getPlanillaRevisionAlzas() {
		return this.planillaRevisionAlzas;
	}

	public void setPlanillaRevisionAlzas(List<PlanillaRevisionAlza> planillaRevisionAlzas) {
		this.planillaRevisionAlzas = planillaRevisionAlzas;
	}
	
	public List<PlanillaRevisionTipoAlimentacion> getPlanillaRevisionTipoAlimentacions() {
		return this.planillaRevisionTipoAlimentacions;
	}

	public void setPlanillaRevisionTipoAlimentacions(List<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacions) {
		this.planillaRevisionTipoAlimentacions = planillaRevisionTipoAlimentacions;
	}
	
	public List<PlanillaRevisionTipoEnfermedad> getPlanillaRevisionTipoEnfermedads() {
		return this.planillaRevisionTipoEnfermedads;
	}

	public void setPlanillaRevisionTipoEnfermedads(List<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedads) {
		this.planillaRevisionTipoEnfermedads = planillaRevisionTipoEnfermedads;
	}
	
}