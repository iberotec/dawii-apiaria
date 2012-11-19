package apiario.edu.pe.manageBeans;


import java.io.Serializable;

import javax.faces.event.ActionEvent;




public class MBLogueo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	private String value = "This editor is provided by PrimeFaces";
	public MBLogueo(){}

	
	
	public String login(){
		System.out.println("entro login");
		return "successBienvenida";
	}
	public String cerrarSession(){
		System.out.println("cerrando session...");
		return "successLogin";
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
