package apiario.edu.pe.bean.seleccion;

public class AlzaBEAN {

	private int idAlza;
	private PisoBEAN beanPiso;
	private TipoAlzaBEAN beanTipoAlza;
	
	public AlzaBEAN(int idAlza, PisoBEAN beanPiso, TipoAlzaBEAN beanTipoAlza) {
		super();
		this.idAlza = idAlza;
		this.beanPiso = beanPiso;
		this.beanTipoAlza = beanTipoAlza;
	}
	public AlzaBEAN(PisoBEAN beanPiso, TipoAlzaBEAN beanTipoAlza) {
		super();
		this.beanPiso = beanPiso;
		this.beanTipoAlza = beanTipoAlza;
	}
	public int getIdAlza() {
		return idAlza;
	}
	public void setIdAlza(int idAlza) {
		this.idAlza = idAlza;
	}
	public PisoBEAN getBeanPiso() {
		return beanPiso;
	}
	public void setBeanPiso(PisoBEAN beanPiso) {
		this.beanPiso = beanPiso;
	}
	public TipoAlzaBEAN getBeanTipoAlza() {
		return beanTipoAlza;
	}
	public void setBeanTipoAlza(TipoAlzaBEAN beanTipoAlza) {
		this.beanTipoAlza = beanTipoAlza;
	}
	
	
}
