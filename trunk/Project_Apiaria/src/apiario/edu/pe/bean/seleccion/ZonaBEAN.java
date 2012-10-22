package apiario.edu.pe.bean.seleccion;

public class ZonaBEAN {

	private int idZona;
	private String descripcion;
	private UbigeoBEAN beanUbigeo;
	
	public ZonaBEAN(int idZona, String descripcion, UbigeoBEAN beanUbigeo) {
		super();
		this.idZona = idZona;
		this.descripcion = descripcion;
		this.beanUbigeo = beanUbigeo;
	}
	public ZonaBEAN(String descripcion, UbigeoBEAN beanUbigeo) {
		super();
		this.descripcion = descripcion;
		this.beanUbigeo = beanUbigeo;
	}
	public int getIdZona() {
		return idZona;
	}
	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UbigeoBEAN getBeanUbigeo() {
		return beanUbigeo;
	}
	public void setBeanUbigeo(UbigeoBEAN beanUbigeo) {
		this.beanUbigeo = beanUbigeo;
	}
	
	
}
