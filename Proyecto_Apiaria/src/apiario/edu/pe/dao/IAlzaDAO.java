package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Alza;

public interface IAlzaDAO {

	public abstract List<Alza> listarTodosAlzas() throws Exception;
	public abstract Alza guardarAlza(Alza instance) throws Exception;
	public abstract List<Alza> buscarAlza(Alza instance) throws Exception;
	public abstract Alza obtenerPorIdAlza(int id) throws Exception;
	public abstract Alza eliminarAlza(Alza instance) throws Exception;
	
}
