package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.commons.UsuarioDAO;
import apiario.edu.pe.dao.seleccion.ApiarioDAO;




public abstract class DAOFactory {
	public enum TipoFabrica {
		MYSQL, SQL, ORACLE
	};
	//public abstract IEspecialidadDAO getIEspecialidadDAO();
	public abstract ApiarioDAO getApiarioDAO();
	public abstract UsuarioDAO getUsuarioDAO();
//	public abstract IProductoDAO getIProductoDAO();
	
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
