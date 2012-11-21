package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Piso;

public interface IPisoDAO {

	public abstract List<Piso> listarTodosPisos() throws Exception;
	public abstract Piso guardarPiso(Piso instance) throws Exception;
	public abstract List<Piso> buscarPiso(Piso instance) throws Exception;
	public abstract Piso obtenerPorIdPiso(int id) throws Exception;
	public abstract Piso eliminarPiso(Piso instance) throws Exception;
	
}
