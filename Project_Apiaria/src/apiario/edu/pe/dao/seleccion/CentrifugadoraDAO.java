package apiario.edu.pe.dao.seleccion;

import java.util.List;

import apiario.edu.pe.bean.Centrifugadora;


public interface CentrifugadoraDAO {

public abstract List<Centrifugadora> buscarTodos();
	
	public abstract List<Centrifugadora> buscarCentrifugadoras(Centrifugadora instance);
	
	public abstract Centrifugadora obtenerporId(Integer id);
	
	public abstract List<Centrifugadora> buscarPorPropiedad(String propiedad,Object valor);
	
	public abstract Centrifugadora guardarInstancia(Centrifugadora instance);
	
	public abstract Centrifugadora guardarInstancias(List<Centrifugadora> lista);
	
	public abstract Centrifugadora eliminarInstancia(Centrifugadora instance);
	
}
