package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Decantadora;

public interface IDecantadoraDAO {

	public abstract List<Decantadora> listarTodosDecantadoras() throws Exception;
	public abstract Decantadora guardarDecantadora(Decantadora instance) throws Exception;
	public abstract List<Decantadora> buscarDecantadora(Decantadora instance) throws Exception;
	public abstract Decantadora obtenerPorIdDecantadora(int id) throws Exception;
	public abstract Decantadora eliminarDecantadora(Decantadora instance) throws Exception;
	
}
