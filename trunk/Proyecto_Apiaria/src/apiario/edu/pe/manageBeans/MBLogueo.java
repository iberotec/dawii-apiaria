package apiario.edu.pe.manageBeans;


import java.io.Serializable;

import javax.faces.event.ActionEvent;

import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.service.SeleccionService;

public class MBLogueo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	//private String value = "This editor is provided by PrimeFaces";
	private SeleccionService service= new SeleccionService();
	public MBLogueo(){}

	
	
	public String ingresarSistema(){
	
		Usuario objusuariojpa = new Usuario();
//		objusuariojpa.setNomUsu(getUsuario());
//		objusuariojpa.setClave(getPass());
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
//	public String getValue() {
//		return value;
//	}
//
//	public void setValue(String value) {
//		this.value = value;
//	}
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
