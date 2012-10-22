package apiario.edu.pe.bean.commons;

public class UsuarioBEAN {

	private int idUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
	private TipoUsuarioBEAN beanTipoUsuario;
	
	public UsuarioBEAN(int idUsuario, String nombreUsuario,
			String apellidoUsuario, TipoUsuarioBEAN beanTipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.beanTipoUsuario = beanTipoUsuario;
	}
	public UsuarioBEAN(String nombreUsuario, String apellidoUsuario,
			TipoUsuarioBEAN beanTipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.beanTipoUsuario = beanTipoUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public TipoUsuarioBEAN getBeanTipoUsuario() {
		return beanTipoUsuario;
	}
	public void setBeanTipoUsuario(TipoUsuarioBEAN beanTipoUsuario) {
		this.beanTipoUsuario = beanTipoUsuario;
	}
	
	
}
