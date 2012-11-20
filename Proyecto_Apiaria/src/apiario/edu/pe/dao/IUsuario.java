package apiario.edu.pe.dao;

import apiario.edu.pe.bean.Usuario;

public interface IUsuario {

	public abstract Usuario validarUsuario(String usuario, String clave);
	
}
