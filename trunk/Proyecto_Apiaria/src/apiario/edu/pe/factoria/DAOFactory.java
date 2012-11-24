package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.IAlzaDAO;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IColmenaDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPisoDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.ITipoAlimentacionDAO;
import apiario.edu.pe.dao.ITipoEnfermedadDAO;
import apiario.edu.pe.dao.IUsuario;





public abstract class DAOFactory {
	public enum TipoFabrica {
		MYSQL, SQL, ORACLE
	};
	public abstract IApiarioDAO getIApiarioDAO();
	public abstract INormaSeguridadDAO getINormaSeguridadDAO();
	public abstract IDetalleApiarioNormaSeguridad getDetalleApiarioNormaSeguridad();
	public abstract IPlanillaSeguimientoDAO getIPlanillaSeguimientoDAO();
	public abstract IUsuario getIUsuarioDAO();
	public abstract IColmenaDAO getIColmenaDAO();
	public abstract IPisoDAO getIPisoDAO();
	public abstract IAlzaDAO getIAlzaDAO();
	public abstract ITipoAlimentacionDAO getITipoAlimentacionDAO();
	public abstract ITipoEnfermedadDAO getTipoEnfermedadDAO();
	
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
