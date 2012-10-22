package apiario.edu.pe.bean;

public class TipoRecursoNaturalBEAN {

	private int idTipoRecursoNatural;
	private String descripcion;
	
	public TipoRecursoNaturalBEAN() {
		super();
	}
	public TipoRecursoNaturalBEAN(int idTipoRecursoNatural, String descripcion) {
		super();
		this.idTipoRecursoNatural = idTipoRecursoNatural;
		this.descripcion = descripcion;
	}
	public TipoRecursoNaturalBEAN(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public int getIdTipoRecursoNatural() {
		return idTipoRecursoNatural;
	}
	public void setIdTipoRecursoNatural(int idTipoRecursoNatural) {
		this.idTipoRecursoNatural = idTipoRecursoNatural;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
