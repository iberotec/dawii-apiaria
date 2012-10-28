package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.INormaSeguridadDAO;





public abstract class DAOFactory {
	public enum TipoFabrica {
		MYSQL, SQL, ORACLE
	};
	public abstract IApiarioDAO getIApiarioDAO();
	public abstract INormaSeguridadDAO getINormaSeguridadDAO();
	
	public static DAOFactory getDAOFactory(TipoFabrica tipo) {
		switch (tipo) {
		case MYSQL:
			return  new  MySqlDAOFactory();
		case SQL:
			return null;//se invoca a la fabrica de para SQLServer
		case ORACLE:
			return null;//se invoca a la fabrica de para Oracle
		default:
			return null;
		}
	}
}
