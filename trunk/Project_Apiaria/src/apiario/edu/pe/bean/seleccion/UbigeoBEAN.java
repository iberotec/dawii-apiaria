package apiario.edu.pe.bean.seleccion;

public class UbigeoBEAN {

	private int idUbigeo;
	private String departamento;
	private String provincia;
	private String distrito;
	private PaisBEAN beanPais;
	
	public UbigeoBEAN(int idUbigeo, String departamento, String provincia,
			String distrito, PaisBEAN beanPais) {
		super();
		this.idUbigeo = idUbigeo;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.beanPais = beanPais;
	}
	public UbigeoBEAN(String departamento, String provincia, String distrito,
			PaisBEAN beanPais) {
		super();
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.beanPais = beanPais;
	}
	public int getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(int idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public PaisBEAN getBeanPais() {
		return beanPais;
	}
	public void setBeanPais(PaisBEAN beanPais) {
		this.beanPais = beanPais;
	}
	
	
}
