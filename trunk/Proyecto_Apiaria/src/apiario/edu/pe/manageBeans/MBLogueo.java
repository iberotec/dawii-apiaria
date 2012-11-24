package apiario.edu.pe.manageBeans;


import java.io.Serializable;

import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.service.SeleccionService;

public class MBLogueo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	private SeleccionService service= new SeleccionService();
	public MBLogueo(){}

	
	
	public String ingresarSistema(){
	
		Usuario objusuariojpa = new Usuario();
		objusuariojpa = service.validarUsuario(usuario, pass);
		if(objusuariojpa!=null){
			System.out.println("entro login");
			return "successBienvenida";	
		}
		else{
			return "successLogin";
		}
		
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
