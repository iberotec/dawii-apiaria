package apiario.edu.pe.bean.seleccion;

public class PaisBEAN {

	private int idPais;
	private String nombrePais;
	
	public PaisBEAN(int idPais, String nombrePais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}
	public PaisBEAN(String nombrePais) {
		super();
		this.nombrePais = nombrePais;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	
}
