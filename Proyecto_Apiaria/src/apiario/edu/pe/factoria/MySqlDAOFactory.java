package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.IAlzaDAO;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IColmenaDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.IEstadoRevisionDAO;
import apiario.edu.pe.dao.IDetalleEquipoTrabajo;
import apiario.edu.pe.dao.INormaSeguridadApiarioDAO;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPisoDAO;
import apiario.edu.pe.dao.IPlanillaRevisionAlzaDAO;
import apiario.edu.pe.dao.IPlanillaRevisionDAO;
import apiario.edu.pe.dao.IPlanillaRevisionTipoAlimentacionDAO;
import apiario.edu.pe.dao.IPlanillaRevisionTipoEnfermedadDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.IReinaDAO;
import apiario.edu.pe.dao.ITemporadaDAO;
import apiario.edu.pe.dao.ITipoAlimentacionDAO;
import apiario.edu.pe.dao.ITipoEnfermedadDAO;
import apiario.edu.pe.dao.IUsuario;
import apiario.edu.pe.dao.IUsuarioApiarioDAO;
import apiario.edu.pe.dao.MySqlAlzaDAO;
import apiario.edu.pe.dao.MySqlColmenaDAO;
import apiario.edu.pe.dao.MySqlEstadoRevisionDAO;
import apiario.edu.pe.dao.MySqlDetalleEquipoTrabajoDAO;
import apiario.edu.pe.dao.MySqlNormaSeguridadApiarioDAO;
import apiario.edu.pe.dao.MySqlPisoDAO;
import apiario.edu.pe.dao.MySqlPlanillaRevisionAlzaDAO;
import apiario.edu.pe.dao.MySqlPlanillaRevisionDAO;
import apiario.edu.pe.dao.MySqlPlanillaRevisionTipoAlimentacionDAO;
import apiario.edu.pe.dao.MySqlPlanillaRevisionTipoEnfermedadDAO;
import apiario.edu.pe.dao.MySqlPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.MySqlReinaDAO;
import apiario.edu.pe.dao.MySqlTemporadaDAO;
import apiario.edu.pe.dao.MySqlTipoAlimentacionDAO;
import apiario.edu.pe.dao.MySqlTipoEnfermedadDAO;
import apiario.edu.pe.dao.MySqlUsuarioApiarioDAO;
import apiario.edu.pe.dao.MysqlApiarioDAO;
import apiario.edu.pe.dao.MysqlDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.MysqlNormaSeguridadDAO;
import apiario.edu.pe.dao.MysqlUsuarioDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public IApiarioDAO getIApiarioDAO() {
		return new MysqlApiarioDAO();
	}

	@Override
	public INormaSeguridadDAO getINormaSeguridadDAO() {
		return new MysqlNormaSeguridadDAO();
	}

	@Override
	public IDetalleApiarioNormaSeguridad getDetalleApiarioNormaSeguridad() {
		return new MysqlDetalleApiarioNormaSeguridad();
	}

	@Override
	public IPlanillaSeguimientoDAO getIPlanillaSeguimientoDAO() {
		return new MySqlPlanillaSeguimientoDAO();
	}

	@Override
	public IUsuario getIUsuarioDAO() {
		return new MysqlUsuarioDAO();
	}

	@Override
	public IColmenaDAO getIColmenaDAO() {
		return new MySqlColmenaDAO();
	}

	@Override
	public IPisoDAO getIPisoDAO() {
		return new MySqlPisoDAO();
	}

	@Override
	public IAlzaDAO getIAlzaDAO() {
		return new MySqlAlzaDAO();
	}

	@Override
	public ITipoAlimentacionDAO getITipoAlimentacionDAO() {
		return new MySqlTipoAlimentacionDAO();
	}

	@Override
	public ITipoEnfermedadDAO getTipoEnfermedadDAO() {
		return new MySqlTipoEnfermedadDAO();
	}

	@Override
	public IEstadoRevisionDAO getEstadoRevisionDAO() {
		return new MySqlEstadoRevisionDAO();
	}

	@Override
	public IDetalleEquipoTrabajo getIDetalleEquipoTrabajo() {
		
		return new MySqlDetalleEquipoTrabajoDAO();
	}

	@Override
	public IPlanillaRevisionDAO getIPlanillaRevisionDAO() {
		
		return new MySqlPlanillaRevisionDAO();
	}

	@Override
	public IPlanillaRevisionAlzaDAO getIPlanillaRevisionAlza() {
		
		return new MySqlPlanillaRevisionAlzaDAO();
	}

	@Override
	public INormaSeguridadApiarioDAO getINormaSeguridadApiario() {
		return new MySqlNormaSeguridadApiarioDAO();
	}

	@Override
	public ITemporadaDAO getITemporadaDAO() {
		return new MySqlTemporadaDAO();
	}

	@Override
	public IUsuarioApiarioDAO getIUsuarioApiarioDAO() {
		return new MySqlUsuarioApiarioDAO();
	}

	@Override
	public IReinaDAO getIReinaDAO() {
		return new MySqlReinaDAO();
	}

	@Override
	public IPlanillaRevisionTipoAlimentacionDAO getiPlanillaRevisionTipoAlimentacionDAO() {
		return new MySqlPlanillaRevisionTipoAlimentacionDAO();
	}

	@Override
	public IPlanillaRevisionTipoEnfermedadDAO getPlanillaTipoRevisionEnfermedadDAO() {
		return new MySqlPlanillaRevisionTipoEnfermedadDAO();
	}




	


	
	
}
