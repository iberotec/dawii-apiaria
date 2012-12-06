package apiario.edu.pe.managedBeans;


import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.service.SeleccionService;

public class MBLogueo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	private SeleccionService service= new SeleccionService();
	private Usuario usuarioLogin;
	public MBLogueo(){}

	
	
	public String ingresarSistema(){
	
		Usuario objusuariojpa = new Usuario();
		objusuariojpa = service.validarUsuario(usuario, pass);
		if(objusuariojpa!=null){
			setUsuarioLogin(objusuariojpa);
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) context.getSession(false);
            session.setAttribute("usuario", this.getUsuarioLogin());
			
			System.out.println("entro login");
			return "successBienvenida";	
		}
		else{
			return "successLogin";
		}
		
	}
	
	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String cerrarSession(){
		System.out.println("cerrando session...");
		return "successLogin";
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
