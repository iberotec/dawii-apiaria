package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.NormaSeguridad;

public interface INormaSeguridadDAO {	
	
	public abstract List<NormaSeguridad>listaNormaSeguridad();
	
	public abstract List<NormaSeguridad> listarTodosNormaSeguridades() throws Exception;
	public abstract NormaSeguridad guardarNormaSeguridad(NormaSeguridad instance) throws Exception;
	public abstract List<NormaSeguridad> buscarNormaSeguridad(NormaSeguridad instance) throws Exception;
	public abstract NormaSeguridad obtenerPorIdNormaSeguridad(int id) throws Exception;
	public abstract NormaSeguridad eliminarNormaSeguridad(NormaSeguridad instance) throws Exception;
	
}
