package apiario.edu.pe.bean.seleccion;

import apiario.edu.pe.bean.commons.UsuarioBEAN;

public class PlanillaRevisionBEAN {

	private int idplanillaRevision;
	private String estadoColmena;
	private String necesidadAlimentacion;
	private String necesidadCuracion;
	private String faltaEspacioCamaradeCria;
	private String peligroColmena;
	private EstadoRevisionBEAN beanEstadoRevision;
	private String comportamiento;
	private ReinaBEAN beanReina;
	private boolean faltaAlza;
	private boolean existenciaReina;
	private UsuarioBEAN beanUsuario;
	private ColmenaBEAN beanColmena;
	
	public PlanillaRevisionBEAN(int idplanillaRevision, String estadoColmena,
			String necesidadAlimentacion, String necesidadCuracion,
			String faltaEspacioCamaradeCria, String peligroColmena,
			EstadoRevisionBEAN beanEstadoRevision, String comportamiento,
			ReinaBEAN beanReina, boolean faltaAlza, boolean existenciaReina,
			UsuarioBEAN beanUsuario, ColmenaBEAN beanColmena) {
		super();
		this.idplanillaRevision = idplanillaRevision;
		this.estadoColmena = estadoColmena;
		this.necesidadAlimentacion = necesidadAlimentacion;
		this.necesidadCuracion = necesidadCuracion;
		this.faltaEspacioCamaradeCria = faltaEspacioCamaradeCria;
		this.peligroColmena = peligroColmena;
		this.beanEstadoRevision = beanEstadoRevision;
		this.comportamiento = comportamiento;
		this.beanReina = beanReina;
		this.faltaAlza = faltaAlza;
		this.existenciaReina = existenciaReina;
		this.beanUsuario = beanUsuario;
		this.beanColmena = beanColmena;
	}
	public PlanillaRevisionBEAN(String estadoColmena,
			String necesidadAlimentacion, String necesidadCuracion,
			String faltaEspacioCamaradeCria, String peligroColmena,
			EstadoRevisionBEAN beanEstadoRevision, String comportamiento,
			ReinaBEAN beanReina, boolean faltaAlza, boolean existenciaReina,
			UsuarioBEAN beanUsuario, ColmenaBEAN beanColmena) {
		super();
		this.estadoColmena = estadoColmena;
		this.necesidadAlimentacion = necesidadAlimentacion;
		this.necesidadCuracion = necesidadCuracion;
		this.faltaEspacioCamaradeCria = faltaEspacioCamaradeCria;
		this.peligroColmena = peligroColmena;
		this.beanEstadoRevision = beanEstadoRevision;
		this.comportamiento = comportamiento;
		this.beanReina = beanReina;
		this.faltaAlza = faltaAlza;
		this.existenciaReina = existenciaReina;
		this.beanUsuario = beanUsuario;
		this.beanColmena = beanColmena;
	}
	public int getIdplanillaRevision() {
		return idplanillaRevision;
	}
	public void setIdplanillaRevision(int idplanillaRevision) {
		this.idplanillaRevision = idplanillaRevision;
	}
	public String getEstadoColmena() {
		return estadoColmena;
	}
	public void setEstadoColmena(String estadoColmena) {
		this.estadoColmena = estadoColmena;
	}
	public String getNecesidadAlimentacion() {
		return necesidadAlimentacion;
	}
	public void setNecesidadAlimentacion(String necesidadAlimentacion) {
		this.necesidadAlimentacion = necesidadAlimentacion;
	}
	public String getNecesidadCuracion() {
		return necesidadCuracion;
	}
	public void setNecesidadCuracion(String necesidadCuracion) {
		this.necesidadCuracion = necesidadCuracion;
	}
	public String getFaltaEspacioCamaradeCria() {
		return faltaEspacioCamaradeCria;
	}
	public void setFaltaEspacioCamaradeCria(String faltaEspacioCamaradeCria) {
		this.faltaEspacioCamaradeCria = faltaEspacioCamaradeCria;
	}
	public String getPeligroColmena() {
		return peligroColmena;
	}
	public void setPeligroColmena(String peligroColmena) {
		this.peligroColmena = peligroColmena;
	}
	public EstadoRevisionBEAN getBeanEstadoRevision() {
		return beanEstadoRevision;
	}
	public void setBeanEstadoRevision(EstadoRevisionBEAN beanEstadoRevision) {
		this.beanEstadoRevision = beanEstadoRevision;
	}
	public String getComportamiento() {
		return comportamiento;
	}
	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}
	public ReinaBEAN getBeanReina() {
		return beanReina;
	}
	public void setBeanReina(ReinaBEAN beanReina) {
		this.beanReina = beanReina;
	}
	public boolean isFaltaAlza() {
		return faltaAlza;
	}
	public void setFaltaAlza(boolean faltaAlza) {
		this.faltaAlza = faltaAlza;
	}
	public boolean isExistenciaReina() {
		return existenciaReina;
	}
	public void setExistenciaReina(boolean existenciaReina) {
		this.existenciaReina = existenciaReina;
	}
	public UsuarioBEAN getBeanUsuario() {
		return beanUsuario;
	}
	public void setBeanUsuario(UsuarioBEAN beanUsuario) {
		this.beanUsuario = beanUsuario;
	}
	public ColmenaBEAN getBeanColmena() {
		return beanColmena;
	}
	public void setBeanColmena(ColmenaBEAN beanColmena) {
		this.beanColmena = beanColmena;
	}
	
	
}
