package apiario.edu.pe.service;

import java.util.List;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

public class SeleccionService implements IApiarioDAO,INormaSeguridadDAO,IDetalleApiarioNormaSeguridad{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	IApiarioDAO daoApiario = objDAOFactory.getIApiarioDAO();
	INormaSeguridadDAO daoNormaSeguridad=objDAOFactory.getINormaSeguridadDAO();
	IDetalleApiarioNormaSeguridad daoDetalleApiarioNormaSeguridad=objDAOFactory.getDetalleApiarioNormaSeguridad();

	public List<Apiario> ListarTodos() {
		return daoApiario.ListarTodos();
	}

	public List<NormaSeguridad> listaNormaSeguridad() {
		return daoNormaSeguridad.listaNormaSeguridad();
	}

	@Override
	public int insertarDetalleApiarioNormaSeguridad(Apiario apiario,NormaSeguridad normaSeguridad) {
		return	daoDetalleApiarioNormaSeguridad.insertarDetalleApiarioNormaSeguridad(apiario, normaSeguridad);
	}
	
	
}
