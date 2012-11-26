package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.NormaSeguridadApiario;

public interface INormaSeguridadApiarioDAO {

	public abstract List<NormaSeguridadApiario> listarTodosNormaSeguridadApiarioes() throws Exception;
	public abstract NormaSeguridadApiario guardarNormaSeguridadApiario(NormaSeguridadApiario instance) throws Exception;
	public abstract List<NormaSeguridadApiario> buscarNormaSeguridadApiario(NormaSeguridadApiario instance) throws Exception;
	public abstract NormaSeguridadApiario obtenerPorIdNormaSeguridadApiario(int id) throws Exception;
	public abstract NormaSeguridadApiario eliminarNormaSeguridadApiario(NormaSeguridadApiario instance) throws Exception;
	
}
