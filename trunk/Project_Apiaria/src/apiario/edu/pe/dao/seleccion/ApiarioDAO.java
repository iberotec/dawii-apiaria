package apiario.edu.pe.dao.seleccion;

import java.util.List;

import apiario.edu.pe.bean.Apiario;

public interface ApiarioDAO {

	public List<Apiario> listarApiarios() throws Exception;
	public Apiario buscarApiarioporId(Integer codigo) throws Exception;
	public void actualizarApiario(Apiario entidad) throws Exception;
	public void registrarApiario(Apiario entidad) throws Exception;
	
//	public abstract List<MaSolicitud> buscarTodos();
//	
//	public abstract List<MaSolicitud> buscarSolicitudes(MaSolicitud instance);
//	
//	public abstract MaSolicitud obtenerporId(Integer id);
//	
//	public abstract List<MaSolicitud> buscarPorPropiedad(String propiedad,Object valor);
//	
//	public abstract MaSolicitud guardarInstancia(MaSolicitud instance);
//	
//	public abstract MaSolicitud guardarInstancias(List<MaSolicitud> lista);
//	
//	public abstract MaSolicitud eliminarInstancia(MaSolicitud instance);
//	
//	public abstract MaSolicitud guardarSolicitud(MaSolicitud solicitud);
	
}
