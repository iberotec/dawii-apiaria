package apiario.edu.pe.bean.seleccion;

import apiario.edu.pe.bean.TipoRecursoNaturalBEAN;

public class RecursoNaturalBEAN {

	private int idRecursoNatural;
	private String descripcion;
	private TipoRecursoNaturalBEAN beanTipoRecursoNatural;
	
	public RecursoNaturalBEAN(int idRecursoNatural, String descripcion,
			TipoRecursoNaturalBEAN beanTipoRecursoNatural) {
		super();
		this.idRecursoNatural = idRecursoNatural;
		this.descripcion = descripcion;
		this.beanTipoRecursoNatural = beanTipoRecursoNatural;
	}
	public RecursoNaturalBEAN(String descripcion,
			TipoRecursoNaturalBEAN beanTipoRecursoNatural) {
		super();
		this.descripcion = descripcion;
		this.beanTipoRecursoNatural = beanTipoRecursoNatural;
	}
	public int getIdRecursoNatural() {
		return idRecursoNatural;
	}
	public void setIdRecursoNatural(int idRecursoNatural) {
		this.idRecursoNatural = idRecursoNatural;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoRecursoNaturalBEAN getBeanTipoRecursoNatural() {
		return beanTipoRecursoNatural;
	}
	public void setBeanTipoRecursoNatural(
			TipoRecursoNaturalBEAN beanTipoRecursoNatural) {
		this.beanTipoRecursoNatural = beanTipoRecursoNatural;
	}
	
	
}
