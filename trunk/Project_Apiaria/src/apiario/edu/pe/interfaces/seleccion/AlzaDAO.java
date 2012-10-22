package apiario.edu.pe.interfaces.seleccion;

import java.util.List;

import apiario.edu.pe.bean.Alza;

public interface AlzaDAO {

	public abstract List<Alza> buscarTodos();
	public abstract List<Alza> buscarAlzas(Alza instance);
	public abstract Alza obtenerporId(Integer id);
	public abstract List<Alza> buscarPorPropiedad(String propiedad,Object valor);
	public abstract Alza guardarInstancia(Alza instance);
	public abstract Alza guardarInstancias(List<Alza> lista);
	public abstract Alza eliminarInstancia(Alza instance);
	
}
