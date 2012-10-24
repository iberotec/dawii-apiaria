package apiario.edu.pe.dao.seleccion;

import java.util.List;

import apiario.edu.pe.bean.Apiario;

public interface ApiarioDAO {

	public abstract List<Apiario> buscarTodos();
	
	public abstract List<Apiario> buscarApiarios(Apiario instance);
	
	public abstract Apiario obtenerporId(Integer id);
	
	public abstract List<Apiario> buscarPorPropiedad(String propiedad,Object valor);
	
	public abstract Apiario guardarInstancia(Apiario instance);
	
	public abstract Apiario guardarInstancias(List<Apiario> lista);
	
	public abstract Apiario eliminarInstancia(Apiario instance);
	
}
