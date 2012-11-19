package apiario.edu.pe.service;

import java.io.Serializable;
import java.util.List;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

@SuppressWarnings("serial")
public class SeleccionService implements IApiarioDAO,IPlanillaSeguimientoDAO,INormaSeguridadDAO,IDetalleApiarioNormaSeguridad,Serializable{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	IApiarioDAO daoApiario = objDAOFactory.getIApiarioDAO();
	INormaSeguridadDAO daoNormaSeguridad=objDAOFactory.getINormaSeguridadDAO();
	IDetalleApiarioNormaSeguridad daoDetalleApiarioNormaSeguridad=objDAOFactory.getDetalleApiarioNormaSeguridad();
	IPlanillaSeguimientoDAO daoPlanillaSeguimiento=objDAOFactory.getIPlanillaSeguimientoDAO();
	

	public List<NormaSeguridad> listaNormaSeguridad() {
		return daoNormaSeguridad.listaNormaSeguridad();
	}

	@Override
	public int insertarDetalleApiarioNormaSeguridad(Apiario apiario,NormaSeguridad normaSeguridad) {
		return	daoDetalleApiarioNormaSeguridad.insertarDetalleApiarioNormaSeguridad(apiario, normaSeguridad);
	}

	@Override
	public List<Apiario> listarTodosApiarios() throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.listarTodosApiarios();
	}

	@Override
	public Apiario guardarApiario(Apiario instance) throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.guardarApiario(instance);
	}

	@Override
	public List<Apiario> buscarApiario(Apiario instance) throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.buscarApiario(instance);
	}

	@Override
	public Apiario obtenerPorIdApiario(int id) throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.obtenerPorIdApiario(id);
	}

	@Override
	public Apiario eliminarApiario(Apiario instance) throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.eliminarApiario(instance);
	}

	@Override
	public List<PlanillaSeguimiento> listarTodosPlanillaSeguimiento()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaSeguimiento.listarTodosPlanillaSeguimiento();
	}

	@Override
	public PlanillaSeguimiento guardarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaSeguimiento.guardarPlanillaSeguimiento(instance);
	}

	@Override
	public List<PlanillaSeguimiento> buscarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaSeguimiento.buscarPlanillaSeguimiento(instance);
	}

	@Override
	public PlanillaSeguimiento obtenerPorIdPlanillaSeguimiento(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaSeguimiento.obtenerPorIdPlanillaSeguimiento(id);
	}

	@Override
	public PlanillaSeguimiento eliminarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaSeguimiento.eliminarPlanillaSeguimiento(instance);
	}
	
	
}
