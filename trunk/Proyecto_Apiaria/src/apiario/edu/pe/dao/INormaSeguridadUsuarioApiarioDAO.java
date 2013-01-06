package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;

public interface INormaSeguridadUsuarioApiarioDAO {

	public abstract List<NormaSeguridadUsuarioApiario> listarTodosNormaSeguridadApiarioes() throws Exception;
	public abstract NormaSeguridadUsuarioApiario guardarNormaSeguridadApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	public abstract List<NormaSeguridadUsuarioApiario> buscarNormaSeguridadApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	public abstract NormaSeguridadUsuarioApiario obtenerPorIdNormaSeguridadApiario(int id) throws Exception;
	public abstract NormaSeguridadUsuarioApiario eliminarNormaSeguridadApiario(NormaSeguridadUsuarioApiario instance) throws Exception;
	
}
