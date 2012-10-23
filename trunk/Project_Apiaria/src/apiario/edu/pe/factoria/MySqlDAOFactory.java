package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.commons.MySqlUsuarioDAO;
import apiario.edu.pe.dao.commons.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySqlUsuarioDAO();
	}

	
	
}
