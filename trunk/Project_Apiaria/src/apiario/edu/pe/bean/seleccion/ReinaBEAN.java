package apiario.edu.pe.bean.seleccion;

public class ReinaBEAN {

	private int idReina;
	private String descripcion;
	private ColmenaBEAN beanColmena;
	private String genetica;
	
	public ReinaBEAN(int idReina, String descripcion, ColmenaBEAN beanColmena,
			String genetica) {
		super();
		this.idReina = idReina;
		this.descripcion = descripcion;
		this.beanColmena = beanColmena;
		this.genetica = genetica;
	}
	public ReinaBEAN(String descripcion, ColmenaBEAN beanColmena,
			String genetica) {
		super();
		this.descripcion = descripcion;
		this.beanColmena = beanColmena;
		this.genetica = genetica;
	}
	public int getIdReina() {
		return idReina;
	}
	public void setIdReina(int idReina) {
		this.idReina = idReina;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ColmenaBEAN getBeanColmena() {
		return beanColmena;
	}
	public void setBeanColmena(ColmenaBEAN beanColmena) {
		this.beanColmena = beanColmena;
	}
	public String getGenetica() {
		return genetica;
	}
	public void setGenetica(String genetica) {
		this.genetica = genetica;
	}
	
	
}
