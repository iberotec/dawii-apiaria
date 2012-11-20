package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.Colmena;

public interface IColmenaDAO {

	public abstract List<Colmena> listarTodosColmenas() throws Exception;
	public abstract Colmena guardarColmena(Colmena instance) throws Exception;
	public abstract List<Colmena> buscarColmena(Colmena instance) throws Exception;
	public abstract Colmena obtenerPorIdColmena(int id) throws Exception;
	public abstract Colmena eliminarColmena(Colmena instance) throws Exception;
	
}
