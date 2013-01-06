package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;

public interface INormaSeguridadUsuarioApiarioDAO {

	public abstract List<NormaSeguridadUsuarioApiario> listarTodosNormaSeguridadUsuarioApiarioes() throws Exception;
	public abstract NormaSeguridadUsuarioApiario guardarNormaSeguridadUsuarioApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	public abstract List<NormaSeguridadUsuarioApiario> buscarNormaSeguridadUsuarioApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	public abstract NormaSeguridadUsuarioApiario obtenerPorIdNormaSeguridadUsuarioApiario(int id) throws Exception;
	public abstract NormaSeguridadUsuarioApiario eliminarNormaSeguridadUsuarioApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	
}
