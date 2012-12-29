package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.TipoAlza;

public interface ITipoAlzaDAO {

	public abstract List<TipoAlza> listarTodosTipoAlzas() throws Exception;
	public abstract TipoAlza guardarTipoAlza(TipoAlza instance) throws Exception;
	public abstract List<TipoAlza> buscarTipoAlza(TipoAlza instance) throws Exception;
	public abstract TipoAlza obtenerPorIdTipoAlza(int id) throws Exception;
	public abstract TipoAlza eliminarTipoAlza(TipoAlza instance) throws Exception;
	
}
