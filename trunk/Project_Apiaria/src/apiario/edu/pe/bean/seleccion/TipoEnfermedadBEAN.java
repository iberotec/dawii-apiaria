package apiario.edu.pe.bean.seleccion;

public class TipoEnfermedadBEAN {

	private int idTipoEnfermedad;
	private String descripcion;
	
	public TipoEnfermedadBEAN(int idTipoEnfermedad, String descripcion) {
		super();
		this.idTipoEnfermedad = idTipoEnfermedad;
		this.descripcion = descripcion;
	}
	public TipoEnfermedadBEAN(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public int getIdTipoEnfermedad() {
		return idTipoEnfermedad;
	}
	public void setIdTipoEnfermedad(int idTipoEnfermedad) {
		this.idTipoEnfermedad = idTipoEnfermedad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
