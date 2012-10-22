package apiario.edu.pe.bean.seleccion;

public class PisoBEAN {

	private int idPiso;
	private ColmenaBEAN beanColmena;
	
	public PisoBEAN(int idPiso, ColmenaBEAN beanColmena) {
		super();
		this.idPiso = idPiso;
		this.beanColmena = beanColmena;
	}
	public PisoBEAN(ColmenaBEAN beanColmena) {
		super();
		this.beanColmena = beanColmena;
	}
	public int getIdPiso() {
		return idPiso;
	}
	public void setIdPiso(int idPiso) {
		this.idPiso = idPiso;
	}
	public ColmenaBEAN getBeanColmena() {
		return beanColmena;
	}
	public void setBeanColmena(ColmenaBEAN beanColmena) {
		this.beanColmena = beanColmena;
	}
	
	
}
