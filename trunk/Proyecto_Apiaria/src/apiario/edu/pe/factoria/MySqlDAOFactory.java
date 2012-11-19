package apiario.edu.pe.factoria;

import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.MySqlPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.MysqlApiarioDAO;
import apiario.edu.pe.dao.MysqlDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.MysqlNormaSeguridadDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public IApiarioDAO getIApiarioDAO() {
		// TODO Auto-generated method stub
		return new MysqlApiarioDAO();
	}

	@Override
	public INormaSeguridadDAO getINormaSeguridadDAO() {
		// TODO Auto-generated method stub
		return new MysqlNormaSeguridadDAO();
	}

	@Override
	public IDetalleApiarioNormaSeguridad getDetalleApiarioNormaSeguridad() {
		// TODO Auto-generated method stub
		return new MysqlDetalleApiarioNormaSeguridad();
	}

	@Override
	public IPlanillaSeguimientoDAO getIPlanillaSeguimientoDAO() {
		// TODO Auto-generated method stub
		return new MySqlPlanillaSeguimientoDAO();
	}

	


	
	
}
