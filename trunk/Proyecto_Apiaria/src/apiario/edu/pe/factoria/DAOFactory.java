package apiario.edu.pe.factoria;

import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.dao.IAlzaDAO;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.ICentrifugadoraDAO;
import apiario.edu.pe.dao.IColmenaDAO;
import apiario.edu.pe.dao.IDecantadoraDAO;
import apiario.edu.pe.dao.IEstadoRevisionDAO;
import apiario.edu.pe.dao.IDetalleEquipoTrabajo;
import apiario.edu.pe.dao.INormaSeguridadUsuarioApiarioDAO;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPisoDAO;
import apiario.edu.pe.dao.IPlanillaCosechaAlzaDAO;
import apiario.edu.pe.dao.IPlanillaExtraccionAlzaDAO;
import apiario.edu.pe.dao.IPlanillaRevisionAlzaDAO;
import apiario.edu.pe.dao.IPlanillaRevisionDAO;
import apiario.edu.pe.dao.IPlanillaRevisionTipoAlimentacionDAO;
import apiario.edu.pe.dao.IPlanillaRevisionTipoEnfermedadDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.IReinaDAO;
import apiario.edu.pe.dao.ITemporadaDAO;
import apiario.edu.pe.dao.ITipoAlimentacionDAO;
import apiario.edu.pe.dao.ITipoAlzaDAO;
import apiario.edu.pe.dao.ITipoEnfermedadDAO;
import apiario.edu.pe.dao.IUsuario;
import apiario.edu.pe.dao.IUsuarioApiarioDAO;

public abstract class DAOFactory {
	public enum TipoFabrica {
		MYSQL, SQL, ORACLE
	};
	
	
	public abstract IApiarioDAO getIApiarioDAO();
	public abstract INormaSeguridadDAO getINormaSeguridadDAO();
	public abstract IPlanillaSeguimientoDAO getIPlanillaSeguimientoDAO();
	public abstract IUsuario getIUsuarioDAO();
	public abstract IColmenaDAO getIColmenaDAO();
	public abstract IPisoDAO getIPisoDAO();
	public abstract IAlzaDAO getIAlzaDAO();
	public abstract ITipoAlimentacionDAO getITipoAlimentacionDAO();
	public abstract ITipoEnfermedadDAO getTipoEnfermedadDAO();
	public abstract IEstadoRevisionDAO getEstadoRevisionDAO();
	public abstract IDetalleEquipoTrabajo getIDetalleEquipoTrabajo();
	public abstract IPlanillaRevisionDAO getIPlanillaRevisionDAO();
	public abstract IPlanillaRevisionAlzaDAO getIPlanillaRevisionAlza();
	public abstract INormaSeguridadUsuarioApiarioDAO getINormaSeguridadApiario();
	public abstract ITemporadaDAO getITemporadaDAO();
	public abstract IUsuarioApiarioDAO getIUsuarioApiarioDAO();
	public abstract IReinaDAO getIReinaDAO();
	public abstract IPlanillaRevisionTipoAlimentacionDAO getiPlanillaRevisionTipoAlimentacionDAO();
	public abstract IPlanillaRevisionTipoEnfermedadDAO getPlanillaTipoRevisionEnfermedadDAO();
	public abstract ITipoAlzaDAO getTipoAlzaDAO();
	public abstract ICentrifugadoraDAO getCentrifugadoraDAO();
	public abstract IDecantadoraDAO getDecantadoraDAO();
	public abstract IPlanillaCosechaAlzaDAO getPlanillaCosechaAlzaDAO();
	public abstract IPlanillaExtraccionAlzaDAO getIPlanillaExtraccionAlzaDAO();
	
	
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
