package apiario.edu.pe.bean.seleccion;

public class EstadoRevisionBEAN {

	private int idEstadoRevision;
	private String descripcion;
	
	public EstadoRevisionBEAN(int idEstadoRevision, String descripcion) {
		super();
		this.idEstadoRevision = idEstadoRevision;
		this.descripcion = descripcion;
	}
	public EstadoRevisionBEAN(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getIdEstadoRevision() {
		return idEstadoRevision;
	}
	public void setIdEstadoRevision(int idEstadoRevision) {
		this.idEstadoRevision = idEstadoRevision;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
