package apiario.edu.pe.service;

import java.util.List;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

public class SeleccionService implements IApiarioDAO{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	IApiarioDAO daoApiario = objDAOFactory.getIApiarioDAO();

	@Override
	public List<Apiario> ListarTodos() {
		// TODO Auto-generated method stub
		return daoApiario.ListarTodos();
	}

}
