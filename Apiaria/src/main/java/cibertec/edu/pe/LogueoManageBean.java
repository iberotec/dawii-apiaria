package cibertec.edu.pe;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "editor")
@SessionScoped
public class LogueoManageBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	private String value = "This editor is provided by PrimeFaces";
	public LogueoManageBean(){}
	@SuppressWarnings("unused")
	private void save(){};
	@SuppressWarnings("unused")
	private void update(){};
	@SuppressWarnings("unused")
	private void delete(){};
	public void login(ActionEvent event) throws IOException {
			JUtilities.redirect("/index.xhtml");
		
		
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
