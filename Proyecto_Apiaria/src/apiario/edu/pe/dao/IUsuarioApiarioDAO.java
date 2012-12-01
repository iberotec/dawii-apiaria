package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.UsuarioApiario;


public interface IUsuarioApiarioDAO {
	public abstract List<UsuarioApiario> listarTodosUsuarioApiario() throws Exception;
	public abstract UsuarioApiario guardarUsuarioApiario(UsuarioApiario instance) throws Exception;
	public abstract List<UsuarioApiario> buscarUsuarioApiario(UsuarioApiario instance) throws Exception;
	public abstract UsuarioApiario obtenerPorIdUsuarioApiario(int id) throws Exception;
	public abstract UsuarioApiario eliminarUsuarioApiario(UsuarioApiario instance) throws Exception;
}
