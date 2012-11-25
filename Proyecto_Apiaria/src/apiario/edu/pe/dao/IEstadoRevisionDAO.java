package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.EstadoRevision;

public interface IEstadoRevisionDAO {

	public abstract List<EstadoRevision> listarTodosEstadoRevisiones() throws Exception;
	public abstract EstadoRevision guardarEstadoRevision(EstadoRevision instance) throws Exception;
	public abstract List<EstadoRevision> buscarEstadoRevision(EstadoRevision instance) throws Exception;
	public abstract EstadoRevision obtenerPorIdEstadoRevision(int id) throws Exception;
	public abstract EstadoRevision eliminarEstadoRevision(EstadoRevision instance) throws Exception;
	
}
