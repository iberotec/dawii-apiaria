package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.commons.UsuarioDAO;

public abstract class DAOFactory {

	public static final int MYSQL=1;
	
	public abstract UsuarioDAO getUsuarioDAO();
	
	public static DAOFactory getDaoFactory(int op){
		switch (op) {
		case 1:
			return new MySqlDAOFactory();

		default:
			return null;
		}
	}
	
}