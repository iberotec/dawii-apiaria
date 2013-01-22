package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Temporada;



public interface ITemporadaDAO {
	public abstract List<Temporada> listarTodosTemporada() throws Exception;
	public abstract Temporada guardarTemporada(Temporada instance) throws Exception;
	public abstract List<Temporada> buscarTemporada(Temporada instance) throws Exception;
	public abstract Temporada obtenerPorIdTemporada(int id) throws Exception;
	public abstract Temporada eliminarTemporada(Temporada instance) throws Exception;
	public abstract List<Integer> obtenerUltimaTemporada(Temporada instance) throws Exception;
}
