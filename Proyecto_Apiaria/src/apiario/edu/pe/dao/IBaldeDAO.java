package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Balde;



public interface IBaldeDAO {

	public abstract List<Balde> listarTodosBalde() throws Exception;
	public abstract Balde guardarBalde(Balde instance) throws Exception;
	public abstract List<Balde> buscarBalde(Balde instance) throws Exception;
	public abstract Balde obtenerPorIdBalde(int id) throws Exception;
	public abstract Balde eliminarBalde(Balde instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdBalde() throws Exception;
}
