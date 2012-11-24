package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.TipoAlimentacion;

public interface ITipoAlimentacionDAO {

	public abstract List<TipoAlimentacion> listarTodosTipoAlimentacions() throws Exception;
	public abstract TipoAlimentacion guardarTipoAlimentacion(TipoAlimentacion instance) throws Exception;
	public abstract List<TipoAlimentacion> buscarTipoAlimentacion(TipoAlimentacion instance) throws Exception;
	public abstract TipoAlimentacion obtenerPorIdTipoAlimentacion(int id) throws Exception;
	public abstract TipoAlimentacion eliminarTipoAlimentacion(TipoAlimentacion instance) throws Exception;
	
}
