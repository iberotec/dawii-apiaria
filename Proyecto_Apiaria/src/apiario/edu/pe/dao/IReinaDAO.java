package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Reina;

public interface IReinaDAO {

	public abstract List<Reina> listarTodosReinas() throws Exception;
	public abstract Reina guardarReina(Reina instance) throws Exception;
	public abstract List<Reina> buscarReina(Reina instance) throws Exception;
	public abstract Reina obtenerPorIdReina(int id) throws Exception;
	public abstract Reina eliminarReina(Reina instance) throws Exception;
	
}
