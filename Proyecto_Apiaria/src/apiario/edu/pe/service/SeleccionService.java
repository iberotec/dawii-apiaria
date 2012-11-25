package apiario.edu.pe.service;

import java.io.Serializable;
import java.util.List;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;

import apiario.edu.pe.bean.EstadoRevision;

import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;

import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.TipoAlimentacion;
import apiario.edu.pe.bean.TipoEnfermedad;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.dao.IAlzaDAO;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IColmenaDAO;
import apiario.edu.pe.dao.IDetalleApiarioNormaSeguridad;
import apiario.edu.pe.dao.IEstadoRevisionDAO;
import apiario.edu.pe.dao.IDetalleEquipoTrabajo;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IPisoDAO;
import apiario.edu.pe.dao.IPlanillaSeguimientoDAO;
import apiario.edu.pe.dao.ITipoAlimentacionDAO;
import apiario.edu.pe.dao.ITipoEnfermedadDAO;
import apiario.edu.pe.dao.IUsuario;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

@SuppressWarnings("serial")
public class SeleccionService implements IApiarioDAO,IPlanillaSeguimientoDAO,INormaSeguridadDAO,IDetalleApiarioNormaSeguridad,IColmenaDAO,IPisoDAO,IAlzaDAO,ITipoAlimentacionDAO,ITipoEnfermedadDAO,IDetalleEquipoTrabajo,IEstadoRevisionDAO,IUsuario,Serializable{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	IApiarioDAO daoApiario = objDAOFactory.getIApiarioDAO();
	INormaSeguridadDAO daoNormaSeguridad=objDAOFactory.getINormaSeguridadDAO();
	IDetalleApiarioNormaSeguridad daoDetalleApiarioNormaSeguridad=objDAOFactory.getDetalleApiarioNormaSeguridad();
	IPlanillaSeguimientoDAO daoPlanillaSeguimiento=objDAOFactory.getIPlanillaSeguimientoDAO();
	IUsuario daoUsuario = objDAOFactory.getIUsuarioDAO();
	IColmenaDAO daoColmena=objDAOFactory.getIColmenaDAO();
	IPisoDAO daoPiso=objDAOFactory.getIPisoDAO();
	IAlzaDAO daoAlza=objDAOFactory.getIAlzaDAO();
	ITipoAlimentacionDAO daoTipoAlimentacion=objDAOFactory.getITipoAlimentacionDAO();
	ITipoEnfermedadDAO daoTipoEnfermedad=objDAOFactory.getTipoEnfermedadDAO();
	IEstadoRevisionDAO daoEstadoRevision=objDAOFactory.getEstadoRevisionDAO();
	IDetalleEquipoTrabajo daoDetalleEquipoTrabajo = objDAOFactory.getIDetalleEquipoTrabajo();


	public List<NormaSeguridad> listaNormaSeguridad() {
		return daoNormaSeguridad.listaNormaSeguridad();
	}

	@Override
	public int insertarDetalleApiarioNormaSeguridad(Apiario apiario,NormaSeguridad normaSeguridad) {
		return	daoDetalleApiarioNormaSeguridad.insertarDetalleApiarioNormaSeguridad(apiario, normaSeguridad);
	}

	@Override
	public List<Apiario> listarTodosApiarios() throws Exception {
		return daoApiario.listarTodosApiarios();
	}

	@Override
	public Apiario guardarApiario(Apiario instance) throws Exception {
		return daoApiario.guardarApiario(instance);
	}

	@Override
	public List<Apiario> buscarApiario(Apiario instance) throws Exception {
		return daoApiario.buscarApiario(instance);
	}

	@Override
	public Apiario obtenerPorIdApiario(int id) throws Exception {
		return daoApiario.obtenerPorIdApiario(id);
	}

	@Override
	public Apiario eliminarApiario(Apiario instance) throws Exception {
		return daoApiario.eliminarApiario(instance);
	}

	@Override
	public List<PlanillaSeguimiento> listarTodosPlanillaSeguimiento()
			throws Exception {
		return daoPlanillaSeguimiento.listarTodosPlanillaSeguimiento();
	}

	@Override
	public PlanillaSeguimiento guardarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		return daoPlanillaSeguimiento.guardarPlanillaSeguimiento(instance);
	}

	@Override
	public List<PlanillaSeguimiento> buscarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		return daoPlanillaSeguimiento.buscarPlanillaSeguimiento(instance);
	}

	@Override
	public PlanillaSeguimiento obtenerPorIdPlanillaSeguimiento(int id)
			throws Exception {
		return daoPlanillaSeguimiento.obtenerPorIdPlanillaSeguimiento(id);
	}

	@Override
	public PlanillaSeguimiento eliminarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		return daoPlanillaSeguimiento.eliminarPlanillaSeguimiento(instance);
	}

	@Override
	public Usuario validarUsuario(String usuario, String clave) {
		return daoUsuario.validarUsuario(usuario, clave);
	}

	@Override
	public List<Colmena> listarTodosColmenas() throws Exception {
		return daoColmena.listarTodosColmenas();
	}

	@Override
	public Colmena guardarColmena(Colmena instance) throws Exception {
		return daoColmena.guardarColmena(instance);
	}

	@Override
	public List<Colmena> buscarColmena(Colmena instance) throws Exception {
		return daoColmena.buscarColmena(instance);
	}

	@Override
	public Colmena obtenerPorIdColmena(int id) throws Exception {
		return daoColmena.obtenerPorIdColmena(id);
	}

	@Override
	public Colmena eliminarColmena(Colmena instance) throws Exception {
		return daoColmena.eliminarColmena(instance);
	}

	@Override
	public List<Alza> listarTodosAlzas() throws Exception {
		return daoAlza.listarTodosAlzas();
	}

	@Override
	public Alza guardarAlza(Alza instance) throws Exception {
		return daoAlza.guardarAlza(instance);
	}

	@Override
	public List<Alza> buscarAlza(Alza instance) throws Exception {
		return daoAlza.buscarAlza(instance);
	}

	@Override
	public Alza obtenerPorIdAlza(int id) throws Exception {
		return daoAlza.obtenerPorIdAlza(id);
	}

	@Override
	public Alza eliminarAlza(Alza instance) throws Exception {
		return daoAlza.eliminarAlza(instance);
	}

	@Override
	public List<Piso> listarTodosPisos() throws Exception {
		return daoPiso.listarTodosPisos();
	}

	@Override
	public Piso guardarPiso(Piso instance) throws Exception {
		return daoPiso.guardarPiso(instance);
	}

	@Override
	public List<Piso> buscarPiso(Piso instance) throws Exception {
		return daoPiso.buscarPiso(instance);
	}

	@Override
	public Piso obtenerPorIdPiso(int id) throws Exception {
		return daoPiso.obtenerPorIdPiso(id);
	}

	@Override
	public Piso eliminarPiso(Piso instance) throws Exception {
		return daoPiso.eliminarPiso(instance);
	}

	@Override
	public List<TipoAlimentacion> listarTodosTipoAlimentacions()
			throws Exception {
		return daoTipoAlimentacion.listarTodosTipoAlimentacions();
	}

	@Override
	public TipoAlimentacion guardarTipoAlimentacion(TipoAlimentacion instance)
			throws Exception {
		return daoTipoAlimentacion.guardarTipoAlimentacion(instance);
	}

	@Override
	public List<TipoAlimentacion> buscarTipoAlimentacion(
			TipoAlimentacion instance) throws Exception {
		return daoTipoAlimentacion.buscarTipoAlimentacion(instance);
	}

	@Override
	public TipoAlimentacion obtenerPorIdTipoAlimentacion(int id)
			throws Exception {
		return daoTipoAlimentacion.obtenerPorIdTipoAlimentacion(id);
	}

	@Override
	public TipoAlimentacion eliminarTipoAlimentacion(TipoAlimentacion instance)
			throws Exception {
		return daoTipoAlimentacion.eliminarTipoAlimentacion(instance);
	}

	@Override
	public List<TipoEnfermedad> listarTodosTipoEnfermedades() throws Exception {
		return daoTipoEnfermedad.listarTodosTipoEnfermedades();
	}

	@Override
	public TipoEnfermedad guardarTipoEnfermedad(TipoEnfermedad instance)
			throws Exception {
		return daoTipoEnfermedad.guardarTipoEnfermedad(instance);
	}

	@Override
	public List<TipoEnfermedad> buscarTipoEnfermedad(TipoEnfermedad instance)
			throws Exception {
		return daoTipoEnfermedad.buscarTipoEnfermedad(instance);
	}

	@Override
	public TipoEnfermedad obtenerPorIdTipoEnfermedad(int id) throws Exception {
		return daoTipoEnfermedad.obtenerPorIdTipoEnfermedad(id);
	}

	@Override
	public TipoEnfermedad eliminarTipoEnfermedad(TipoEnfermedad instance)
			throws Exception {
		return daoTipoEnfermedad.eliminarTipoEnfermedad(instance);
	}

	@Override
	public List<EstadoRevision> listarTodosEstadoRevisiones() throws Exception {
		return daoEstadoRevision.listarTodosEstadoRevisiones();
	}

	@Override
	public EstadoRevision guardarEstadoRevision(EstadoRevision instance)
			throws Exception {
		return daoEstadoRevision.guardarEstadoRevision(instance);
	}

	@Override
	public List<EstadoRevision> buscarEstadoRevision(EstadoRevision instance)
			throws Exception {
		return daoEstadoRevision.buscarEstadoRevision(instance);
	}

	@Override
	public EstadoRevision obtenerPorIdEstadoRevision(int id) throws Exception {
		return daoEstadoRevision.obtenerPorIdEstadoRevision(id);
	}

	@Override
	public EstadoRevision eliminarEstadoRevision(EstadoRevision instance)
			throws Exception {
		return daoEstadoRevision.eliminarEstadoRevision(instance);
	}


	@Override
	public List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(
			Integer codEstadoRevision) {
		return daoDetalleEquipoTrabajo.listarDetalleEquipoTrabajo(codEstadoRevision);
	}

}
