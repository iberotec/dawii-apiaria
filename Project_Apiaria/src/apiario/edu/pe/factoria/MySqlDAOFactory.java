package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.commons.MySqlUsuarioDAO;
import apiario.edu.pe.dao.commons.UsuarioDAO;
import apiario.edu.pe.dao.seleccion.ApiarioDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySqlUsuarioDAO();
	}

	@Override
	public ApiarioDAO getApiarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
