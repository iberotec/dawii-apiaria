package apiario.edu.pe.dao.seleccion;

import java.util.List;

import apiario.edu.pe.bean.Apiario;

public interface ApiarioDAO {

	public List<Apiario> listarApiarios() throws Exception;
	public Apiario buscarApiarioporId(Integer codigo) throws Exception;
	public void actualizarApiario(Apiario entidad) throws Exception;
	public void registrarApiario(Apiario entidad) throws Exception;
	
}
