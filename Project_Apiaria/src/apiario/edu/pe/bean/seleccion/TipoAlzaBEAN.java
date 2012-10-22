package apiario.edu.pe.bean.seleccion;

public class TipoAlzaBEAN {

	private int idAlza;
	private String descripcion;
	
	public TipoAlzaBEAN(int idAlza, String descripcion) {
		super();
		this.idAlza = idAlza;
		this.descripcion = descripcion;
	}
	public TipoAlzaBEAN(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getIdAlza() {
		return idAlza;
	}
	public void setIdAlza(int idAlza) {
		this.idAlza = idAlza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
