package apiario.edu.pe.dao;

import java.util.List;
import apiario.edu.pe.bean.Apiario;

public interface IApiarioDAO {
	public abstract List<Apiario> listarTodosApiarios() throws Exception;
	public abstract Apiario guardarApiario(Apiario instance) throws Exception;
	public abstract List<Apiario> buscarApiario(Apiario instance) throws Exception;
	public abstract Apiario obtenerPorIdApiario(int id) throws Exception;
	public abstract Apiario eliminarApiario(Apiario instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdApiario() throws Exception;

}
