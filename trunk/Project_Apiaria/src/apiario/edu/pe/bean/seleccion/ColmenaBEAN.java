package apiario.edu.pe.bean.seleccion;

public class ColmenaBEAN {

	private int idColmena;
	private ApiarioBEAN beanApiario;
	
	public ColmenaBEAN(int idColmena, ApiarioBEAN beanApiario) {
		super();
		this.idColmena = idColmena;
		this.beanApiario = beanApiario;
	}
	public ColmenaBEAN(ApiarioBEAN beanApiario) {
		super();
		this.beanApiario = beanApiario;
	}
	public int getIdColmena() {
		return idColmena;
	}
	public void setIdColmena(int idColmena) {
		this.idColmena = idColmena;
	}
	public ApiarioBEAN getBeanApiario() {
		return beanApiario;
	}
	public void setBeanApiario(ApiarioBEAN beanApiario) {
		this.beanApiario = beanApiario;
	}
	
}
