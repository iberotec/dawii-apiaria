package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.MysqlApiarioDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public IApiarioDAO getIApiarioDAO() {
		// TODO Auto-generated method stub
		return new MysqlApiarioDAO();
	}

	


	
	
}
