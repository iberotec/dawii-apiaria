package apiario.edu.pe.bean.commons;

public class TipoUsuarioBEAN {

	private int idTipoUsuario;
	private String descripcion;
	
	public TipoUsuarioBEAN(int idTipoUsuario, String descripcion) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.descripcion = descripcion;
	}
	public TipoUsuarioBEAN(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
