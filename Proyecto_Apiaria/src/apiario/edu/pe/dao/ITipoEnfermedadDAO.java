package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.TipoEnfermedad;

public interface ITipoEnfermedadDAO {

	public abstract List<TipoEnfermedad> listarTodosTipoEnfermedades() throws Exception;
	public abstract TipoEnfermedad guardarTipoEnfermedad(TipoEnfermedad instance) throws Exception;
	public abstract List<TipoEnfermedad> buscarTipoEnfermedad(TipoEnfermedad instance) throws Exception;
	public abstract TipoEnfermedad obtenerPorIdTipoEnfermedad(int id) throws Exception;
	public abstract TipoEnfermedad eliminarTipoEnfermedad(TipoEnfermedad instance) throws Exception;
	
}
