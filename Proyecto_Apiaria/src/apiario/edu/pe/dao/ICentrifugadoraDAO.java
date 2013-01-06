package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Centrifugadora;

public interface ICentrifugadoraDAO {

	public abstract List<Centrifugadora> listarTodosCentrifugadoras() throws Exception;
	public abstract Centrifugadora guardarCentrifugadora(Centrifugadora instance) throws Exception;
	public abstract List<Centrifugadora> buscarCentrifugadora(Centrifugadora instance) throws Exception;
	public abstract Centrifugadora obtenerPorIdCentrifugadora(int id) throws Exception;
	public abstract Centrifugadora eliminarCentrifugadora(Centrifugadora instance) throws Exception;
	
}
