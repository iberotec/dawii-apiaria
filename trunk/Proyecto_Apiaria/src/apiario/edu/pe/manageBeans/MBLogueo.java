package apiario.edu.pe.manageBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import apiario.edu.pe.util.JUtilities;

@ManagedBean(name = "MBLogueo")
@SessionScoped
public class MBLogueo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	private String value = "This editor is provided by PrimeFaces";
	public MBLogueo(){}
	@SuppressWarnings("unused")
	private void save(){};
	@SuppressWarnings("unused")
	private void update(){};
	@SuppressWarnings("unused")
	private void delete(){};
	public void login(ActionEvent event) throws IOException {
		
			JUtilities.redirect("/seleccion/main.xhtml");
		
		
	};
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
