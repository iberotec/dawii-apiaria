package apiario.edu.pe.service;

import java.io.Serializable;
import java.util.List;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;

import apiario.edu.pe.bean.EstadoRevision;

import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;

import apiario.edu.pe.bean.Balde;
import apiario.edu.pe.bean.Centrifugadora;
import apiario.edu.pe.bean.Decantadora;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;
import apiario.edu.pe.bean.OrdenPedido;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.bean.PlanillaEnvasado;
import apiario.edu.pe.bean.PlanillaExtraccionAlza;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Reina;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.TipoAlimentacion;
import apiario.edu.pe.bean.TipoAlza;
import apiario.edu.pe.bean.TipoEnfermedad;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadoraBalde;
import apiario.edu.pe.dao.IAlzaDAO;
import apiario.edu.pe.dao.IApiarioDAO;
import apiario.edu.pe.dao.IBaldeDAO;
import apiario.edu.pe.dao.ICentrifugadoraDAO;
import apiario.edu.pe.dao.IColmenaDAO;
import apiario.edu.pe.dao.IDecantadoraDAO;
import apiario.edu.pe.dao.IEstadoRevisionDAO;
import apiario.edu.pe.dao.IDetalleEquipoTrabajo;
import apiario.edu.pe.dao.INormaSeguridadUsuarioApiarioDAO;
import apiario.edu.pe.dao.INormaSeguridadDAO;
import apiario.edu.pe.dao.IOrdenPedidoDAO;
import apiario.edu.pe.dao.IPisoDAO;
import apiario.edu.pe.dao.IPlanillaCosechaAlzaDAO;
import apiario.edu.pe.dao.IPlanillaEnvasadoDAO;
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
import apiario.edu.pe.dao.IUsuarioDecantadoraCentrifugadoraBaldeDAO;
import apiario.edu.pe.dao.IUsuarioDecantadoraCentrifugadoraDAO;
import apiario.edu.pe.factoria.DAOFactory;
import apiario.edu.pe.factoria.DAOFactory.TipoFabrica;

@SuppressWarnings("serial")
public class SeleccionService implements IUsuarioApiarioDAO,IApiarioDAO,IPlanillaSeguimientoDAO,INormaSeguridadDAO,
IColmenaDAO,IPisoDAO,IAlzaDAO,ITipoAlimentacionDAO,ITipoEnfermedadDAO,
IDetalleEquipoTrabajo,IEstadoRevisionDAO,IUsuario, IPlanillaRevisionDAO, IPlanillaRevisionAlzaDAO,
ITemporadaDAO,INormaSeguridadUsuarioApiarioDAO,IReinaDAO, IPlanillaRevisionTipoAlimentacionDAO,
IPlanillaRevisionTipoEnfermedadDAO, ITipoAlzaDAO, ICentrifugadoraDAO, IDecantadoraDAO,IPlanillaCosechaAlzaDAO ,
IPlanillaExtraccionAlzaDAO,IUsuarioDecantadoraCentrifugadoraDAO,IBaldeDAO,IUsuarioDecantadoraCentrifugadoraBaldeDAO,IOrdenPedidoDAO,IPlanillaEnvasadoDAO,Serializable{
	DAOFactory objDAOFactory= DAOFactory.getDAOFactory(TipoFabrica.MYSQL);
	IApiarioDAO daoApiario = objDAOFactory.getIApiarioDAO();
	INormaSeguridadDAO daoNormaSeguridad=objDAOFactory.getINormaSeguridadDAO();
	IPlanillaSeguimientoDAO daoPlanillaSeguimiento=objDAOFactory.getIPlanillaSeguimientoDAO();
	IUsuario daoUsuario = objDAOFactory.getIUsuarioDAO();
	IColmenaDAO daoColmena=objDAOFactory.getIColmenaDAO();
	IPisoDAO daoPiso=objDAOFactory.getIPisoDAO();
	IAlzaDAO daoAlza=objDAOFactory.getIAlzaDAO();
	ITipoAlimentacionDAO daoTipoAlimentacion=objDAOFactory.getITipoAlimentacionDAO();
	ITipoEnfermedadDAO daoTipoEnfermedad=objDAOFactory.getTipoEnfermedadDAO();
	IEstadoRevisionDAO daoEstadoRevision=objDAOFactory.getEstadoRevisionDAO();
	IDetalleEquipoTrabajo daoDetalleEquipoTrabajo = objDAOFactory.getIDetalleEquipoTrabajo();
	IPlanillaRevisionDAO daoPlanillaRevision =objDAOFactory.getIPlanillaRevisionDAO();
	IPlanillaRevisionAlzaDAO daoPlanillaRevisionAlza = objDAOFactory.getIPlanillaRevisionAlza();
	INormaSeguridadUsuarioApiarioDAO daoNormaSeguidadApiario=objDAOFactory.getINormaSeguridadApiario();
	ITemporadaDAO daoTemporada = objDAOFactory.getITemporadaDAO();
	IUsuarioApiarioDAO daoUsuarioApiario = objDAOFactory.getIUsuarioApiarioDAO();
	IReinaDAO daoReina=objDAOFactory.getIReinaDAO();
	IPlanillaRevisionTipoEnfermedadDAO daoPlanillaTipoEnfermedad=objDAOFactory.getPlanillaTipoRevisionEnfermedadDAO();
	IPlanillaRevisionTipoAlimentacionDAO daoPlanillaRevisionTipoAlimentacion=objDAOFactory.getiPlanillaRevisionTipoAlimentacionDAO();
	ITipoAlzaDAO daoTipoAlza=objDAOFactory.getTipoAlzaDAO();
	ICentrifugadoraDAO daoCentrifugadora=objDAOFactory.getCentrifugadoraDAO();
	IDecantadoraDAO daoDecantadoraDAO=objDAOFactory.getDecantadoraDAO();
	IPlanillaCosechaAlzaDAO daoPlanillaCosechaAlzaDAO=objDAOFactory.getPlanillaCosechaAlzaDAO();
	IPlanillaExtraccionAlzaDAO daoPlanillaExtraccionAlzaDAO=objDAOFactory.getIPlanillaExtraccionAlzaDAO();
	IUsuarioDecantadoraCentrifugadoraDAO daoUsuarioDecantadoraCentrifugadoraDAO=objDAOFactory.getIUsuarioDecantadoraCentrifugadoraDAO();
	IBaldeDAO daoBaldeDAO=objDAOFactory.getIBaldeDAO();
	IUsuarioDecantadoraCentrifugadoraBaldeDAO daoUsuarioDecantadoraCentrifugadoraBaldeDAO=objDAOFactory.getIUsuarioDecantadoraCentrifugadoraBaldeDAO();
	IOrdenPedidoDAO daoOrdenPedidoDAO = objDAOFactory.getIOrdenPedidoDAO();
	IPlanillaEnvasadoDAO daoPlanillaEnvasadoDAO = objDAOFactory.getIPlanillaEnvasadoDAO();
	
	public List<NormaSeguridad> listaNormaSeguridad() {
		return daoNormaSeguridad.listaNormaSeguridad();
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

	@Override
	public List<PlanillaRevision> listaPlanillaRevision(Integer colmena) {
		
		return daoPlanillaRevision.listaPlanillaRevision(colmena);
	}

	@Override
	public List<Alza> listarAlzaporPiso(Integer codpiso) {
		
		return daoAlza.listarAlzaporPiso(codpiso);
	}


	@Override
	public List<NormaSeguridad> listarTodosNormaSeguridades() throws Exception {
		return daoNormaSeguridad.listarTodosNormaSeguridades();
	}

	@Override
	public NormaSeguridad guardarNormaSeguridad(NormaSeguridad instance)
			throws Exception {
		return daoNormaSeguridad.guardarNormaSeguridad(instance);
	}

	@Override
	public List<NormaSeguridad> buscarNormaSeguridad(NormaSeguridad instance)
			throws Exception {
		return daoNormaSeguridad.buscarNormaSeguridad(instance);
	}

	@Override
	public NormaSeguridad obtenerPorIdNormaSeguridad(int id) throws Exception {
		return daoNormaSeguridad.obtenerPorIdNormaSeguridad(id);
	}

	@Override
	public NormaSeguridad eliminarNormaSeguridad(NormaSeguridad instance)
			throws Exception {
		return daoNormaSeguridad.eliminarNormaSeguridad(instance);
	}

	@Override
	public List<NormaSeguridadUsuarioApiario> listarTodosNormaSeguridadUsuarioApiarioes()
			throws Exception {
		return daoNormaSeguidadApiario.listarTodosNormaSeguridadUsuarioApiarioes();
	}

	@Override
	public NormaSeguridadUsuarioApiario guardarNormaSeguridadUsuarioApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
		return daoNormaSeguidadApiario.guardarNormaSeguridadUsuarioApiario(instance);
	}

	@Override
	public List<NormaSeguridadUsuarioApiario> buscarNormaSeguridadUsuarioApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
		return daoNormaSeguidadApiario.buscarNormaSeguridadUsuarioApiario(instance);
	}

	@Override
	public NormaSeguridadUsuarioApiario obtenerPorIdNormaSeguridadUsuarioApiario(int id)
			throws Exception {
		return daoNormaSeguidadApiario.obtenerPorIdNormaSeguridadUsuarioApiario(id);
	}

	@Override
	public NormaSeguridadUsuarioApiario eliminarNormaSeguridadUsuarioApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
		return daoNormaSeguidadApiario.eliminarNormaSeguridadUsuarioApiario(instance);
	}


	@Override
	public List<Temporada> listarTodosTemporada() throws Exception {
		return daoTemporada.listarTodosTemporada();
	}

	@Override
	public Temporada guardarTemporada(Temporada instance) throws Exception {
		return daoTemporada.guardarTemporada(instance);
	}

	@Override
	public List<Temporada> buscarTemporada(Temporada instance) throws Exception {
		return daoTemporada.buscarTemporada(instance);
	}

	@Override
	public Temporada obtenerPorIdTemporada(int id) throws Exception {
		return daoTemporada.obtenerPorIdTemporada(id);
	}

	@Override
	public Temporada eliminarTemporada(Temporada instance) throws Exception {
		return daoTemporada.eliminarTemporada(instance);
	}

	@Override
	public List<UsuarioApiario> listarTodosUsuarioApiario() throws Exception {
		return daoUsuarioApiario.listarTodosUsuarioApiario();
	}

	@Override
	public UsuarioApiario guardarUsuarioApiario(UsuarioApiario instance)
			throws Exception {
		return daoUsuarioApiario.guardarUsuarioApiario(instance);
	}

	@Override
	public List<UsuarioApiario> buscarUsuarioApiario(UsuarioApiario instance)
			throws Exception {
		return daoUsuarioApiario.buscarUsuarioApiario(instance);
	}

	@Override
	public UsuarioApiario obtenerPorIdUsuarioApiario(int id) throws Exception {
		return daoUsuarioApiario.obtenerPorIdUsuarioApiario(id);
	}

	@Override
	public UsuarioApiario eliminarUsuarioApiario(UsuarioApiario instance)
			throws Exception {
		return daoUsuarioApiario.eliminarUsuarioApiario(instance);

	}

	@Override
	public List<PlanillaRevision> listarTodosPlanillaRevisions()
			throws Exception {
		return daoPlanillaRevision.listarTodosPlanillaRevisions();
	}

	@Override
	public PlanillaRevision guardarPlanillaRevision(PlanillaRevision instance)
			throws Exception {
		return daoPlanillaRevision.guardarPlanillaRevision(instance);
	}

	@Override
	public List<PlanillaRevision> buscarPlanillaRevision(
			PlanillaRevision instance) throws Exception {
		return daoPlanillaRevision.buscarPlanillaRevision(instance);
	}

	@Override
	public PlanillaRevision obtenerPorIdPlanillaRevision(int id)
			throws Exception {
		return daoPlanillaRevision.obtenerPorIdPlanillaRevision(id);
	}

	@Override
	public PlanillaRevision eliminarPlanillaRevision(PlanillaRevision instance)
			throws Exception {
		return daoPlanillaRevision.eliminarPlanillaRevision(instance);
	}

	@Override
	public List<Reina> listarTodosReinas() throws Exception {
		return daoReina.listarTodosReinas();
	}

	@Override
	public Reina guardarReina(Reina instance) throws Exception {
		return daoReina.guardarReina(instance);
	}

	@Override
	public List<Reina> buscarReina(Reina instance) throws Exception {
		return daoReina.buscarReina(instance);
	}

	@Override
	public Reina obtenerPorIdReina(int id) throws Exception {
		return daoReina.obtenerPorIdReina(id);
	}

	@Override
	public Reina eliminarReina(Reina instance) throws Exception {
		return daoReina.eliminarReina(instance);
	}

	@Override
	public List<EstadoRevisionEquipamientoTrabajo> listarTodosEstadoRevisionEquipamientoTrabajo()
			throws Exception {
		return daoDetalleEquipoTrabajo.listarTodosEstadoRevisionEquipamientoTrabajo();
	}

	@Override
	public EstadoRevisionEquipamientoTrabajo guardarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		return daoDetalleEquipoTrabajo.guardarEstadoRevisionEquipamientoTrabajo(instance);
	}

	@Override
	public List<EstadoRevisionEquipamientoTrabajo> buscarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		return daoDetalleEquipoTrabajo.buscarEstadoRevisionEquipamientoTrabajo(instance);
	}

	@Override
	public EstadoRevisionEquipamientoTrabajo obtenerPorIdEstadoRevisionEquipamientoTrabajo(
			int id) throws Exception {
		return daoDetalleEquipoTrabajo.obtenerPorIdEstadoRevisionEquipamientoTrabajo(id);
	}

	@Override
	public EstadoRevisionEquipamientoTrabajo eliminarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		return daoDetalleEquipoTrabajo.eliminarEstadoRevisionEquipamientoTrabajo(instance);
	}

	@Override
	public List<PlanillaRevisionTipoEnfermedad> listarTodosPlanillaRevisionTipoEnfermedads()
			throws Exception {
		return daoPlanillaTipoEnfermedad.listarTodosPlanillaRevisionTipoEnfermedads();
	}

	@Override
	public PlanillaRevisionTipoEnfermedad guardarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		return daoPlanillaTipoEnfermedad.guardarPlanillaRevisionTipoEnfermedad(instance);
	}

	@Override
	public List<PlanillaRevisionTipoEnfermedad> buscarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		return daoPlanillaTipoEnfermedad.buscarPlanillaRevisionTipoEnfermedad(instance);
	}

	@Override
	public PlanillaRevisionTipoEnfermedad obtenerPorIdPlanillaRevisionTipoEnfermedad(
			int id) throws Exception {
		return daoPlanillaTipoEnfermedad.obtenerPorIdPlanillaRevisionTipoEnfermedad(id);
	}

	@Override
	public PlanillaRevisionTipoEnfermedad eliminarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		return daoPlanillaTipoEnfermedad.eliminarPlanillaRevisionTipoEnfermedad(instance);
	}

	@Override
	public List<PlanillaRevisionTipoAlimentacion> listarTodosPlanillaRevisionTipoAlimentacions()
			throws Exception {
		return daoPlanillaRevisionTipoAlimentacion.listarTodosPlanillaRevisionTipoAlimentacions();
	}

	@Override
	public PlanillaRevisionTipoAlimentacion guardarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
		return daoPlanillaRevisionTipoAlimentacion.guardarPlanillaRevisionTipoAlimentacion(instance);
	}

	@Override
	public List<PlanillaRevisionTipoAlimentacion> buscarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
		return daoPlanillaRevisionTipoAlimentacion.buscarPlanillaRevisionTipoAlimentacion(instance);
	}

	@Override
	public PlanillaRevisionTipoAlimentacion obtenerPorIdPlanillaRevisionTipoAlimentacion(
			int id) throws Exception {
		return daoPlanillaRevisionTipoAlimentacion.obtenerPorIdPlanillaRevisionTipoAlimentacion(id);
	}

	@Override
	public PlanillaRevisionTipoAlimentacion eliminarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
		return daoPlanillaRevisionTipoAlimentacion.eliminarPlanillaRevisionTipoAlimentacion(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdUsuarioApiario()
			throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioApiario.obtenerMaximoIdUsuarioApiario();
	}

	@Override
	public List<Integer> obtenerMaximoIdPlanillaRevision() throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevision.obtenerMaximoIdPlanillaRevision();
	}

	@Override
	public List<Integer> obtenerMaximoIdApiario() throws Exception {
		return daoApiario.obtenerMaximoIdApiario();
	}

	@Override
	public List<Integer> obtenerMaximoIdAlza() throws Exception {
		return daoAlza.obtenerMaximoIdAlza();
	}

	@Override
	public List<Integer> obtenerMaximoIdPiso() throws Exception {
		return daoPiso.obtenerMaximoIdPiso();
	}

	@Override
	public List<Integer> obtenerMaximoIdColmena() throws Exception {
		return daoColmena.obtenerMaximoIdColmena();
	}

	@Override
	public List<TipoAlza> listarTodosTipoAlzas() throws Exception {
		return daoTipoAlza.listarTodosTipoAlzas();
	}

	@Override
	public TipoAlza guardarTipoAlza(TipoAlza instance) throws Exception {
		return daoTipoAlza.guardarTipoAlza(instance);
	}

	@Override
	public List<TipoAlza> buscarTipoAlza(TipoAlza instance) throws Exception {
		return daoTipoAlza.buscarTipoAlza(instance);
	}

	@Override
	public TipoAlza obtenerPorIdTipoAlza(int id) throws Exception {
		return daoTipoAlza.obtenerPorIdTipoAlza(id);
	}

	@Override
	public TipoAlza eliminarTipoAlza(TipoAlza instance) throws Exception {
		return daoTipoAlza.eliminarTipoAlza(instance);
	}

	@Override
	public List<PlanillaRevisionAlza> listarTodosPlanillaRevisionAlza()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.listarTodosPlanillaRevisionAlza();
	}

	@Override
	public PlanillaRevisionAlza guardarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.guardarPlanillaRevisionAlza(instance);
	}

	@Override
	public List<PlanillaRevisionAlza> buscarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.buscarPlanillaRevisionAlza(instance);
	}

	@Override
	public PlanillaRevisionAlza obtenerPorIdPlanillaRevisionAlza(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.obtenerPorIdPlanillaRevisionAlza(id);
	}

	@Override
	public PlanillaRevisionAlza eliminarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.eliminarPlanillaRevisionAlza(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdPlanillaRevisionAlza() throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaRevisionAlza.obtenerMaximoIdPlanillaRevisionAlza();
	}

	@Override
	public List<Centrifugadora> listarTodosCentrifugadoras() throws Exception {
		return daoCentrifugadora.listarTodosCentrifugadoras();
	}

	@Override
	public Centrifugadora guardarCentrifugadora(Centrifugadora instance)
			throws Exception {
		return daoCentrifugadora.guardarCentrifugadora(instance);
	}

	@Override
	public List<Centrifugadora> buscarCentrifugadora(Centrifugadora instance)
			throws Exception {
		return daoCentrifugadora.buscarCentrifugadora(instance);
	}

	@Override
	public Centrifugadora obtenerPorIdCentrifugadora(int id) throws Exception {
		return daoCentrifugadora.obtenerPorIdCentrifugadora(id);
	}

	@Override
	public Centrifugadora eliminarCentrifugadora(Centrifugadora instance)
			throws Exception {
		return daoCentrifugadora.eliminarCentrifugadora(instance);
	}

	@Override
	public List<Decantadora> listarTodosDecantadoras() throws Exception {
		return daoDecantadoraDAO.listarTodosDecantadoras();
	}

	@Override
	public Decantadora guardarDecantadora(Decantadora instance)
			throws Exception {
		return daoDecantadoraDAO.guardarDecantadora(instance);
	}

	@Override
	public List<Decantadora> buscarDecantadora(Decantadora instance)
			throws Exception {
		return daoDecantadoraDAO.buscarDecantadora(instance);
	}

	@Override
	public Decantadora obtenerPorIdDecantadora(int id) throws Exception {
		return daoDecantadoraDAO.obtenerPorIdDecantadora(id);
	}

	@Override
	public Decantadora eliminarDecantadora(Decantadora instance)
			throws Exception {
		return daoDecantadoraDAO.eliminarDecantadora(instance);
	}

	@Override
	public List<PlanillaCosechaAlza> listarTodosPlanillaCosechaAlza()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.listarTodosPlanillaCosechaAlza();
	}

	@Override
	public PlanillaCosechaAlza guardarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.guardarPlanillaCosechaAlza(instance);
	}

	@Override
	public List<PlanillaCosechaAlza> buscarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.buscarPlanillaCosechaAlza(instance);
	}

	@Override
	public PlanillaCosechaAlza obtenerPorIdPlanillaCosechaAlza(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.obtenerPorIdPlanillaCosechaAlza(id);
	}

	@Override
	public PlanillaCosechaAlza eliminarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.eliminarPlanillaCosechaAlza(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdPlanillaCosechaAlza() throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaCosechaAlzaDAO.obtenerMaximoIdPlanillaCosechaAlza();
	}



	@Override
	public List<PlanillaExtraccionAlza> listarTodosPlanillaExtraccionAlza()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.listarTodosPlanillaExtraccionAlza();
	}

	@Override
	public PlanillaExtraccionAlza guardarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.guardarPlanillaExtraccionAlza(instance);
	}

	@Override
	public List<PlanillaExtraccionAlza> buscarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.buscarPlanillaExtraccionAlza(instance);
	}

	@Override
	public PlanillaExtraccionAlza obtenerPorIdPlanillaExtraccionAlza(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.obtenerPorIdPlanillaExtraccionAlza(id);
	}

	@Override
	public PlanillaExtraccionAlza eliminarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.eliminarPlanillaExtraccionAlza(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdPlanillaExtraccionAlza()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaExtraccionAlzaDAO.obtenerMaximoIdPlanillaExtraccionAlza();
	}

	@Override
	public List<Integer> obtenerUltimaTemporada(Temporada instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoTemporada.obtenerUltimaTemporada(instance);
	}

	@Override
	public List<Apiario> buscarApiarioCosechableDistinto(
			PlanillaRevision instance) throws Exception {
		// TODO Auto-generated method stub
		return daoApiario.buscarApiarioCosechableDistinto(instance);
	}

	@Override
	public List<UsuarioDecantadoraCentrifugadora> listarTodosUsuarioDecantadoraCentrifugadora()
			throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.listarTodosUsuarioDecantadoraCentrifugadora();
	}

	@Override
	public List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadora()
			throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.obtenerMaximoIdUsuarioDecantadoraCentrifugadora();
	}

	@Override
	public UsuarioDecantadoraCentrifugadora guardarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.guardarUsuarioDecantadoraCentrifugadora(instance);
	}

	@Override
	public List<UsuarioDecantadoraCentrifugadora> buscarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.buscarUsuarioDecantadoraCentrifugadora(instance);
	}

	@Override
	public UsuarioDecantadoraCentrifugadora obtenerPorIdUsuarioDecantadoraCentrifugadora(
			int id) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.obtenerPorIdUsuarioDecantadoraCentrifugadora(id);
	}

	@Override
	public UsuarioDecantadoraCentrifugadora eliminarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraDAO.eliminarUsuarioDecantadoraCentrifugadora(instance);
	}

	@Override
	public List<Balde> listarTodosBalde() throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.listarTodosBalde();
	}

	@Override
	public Balde guardarBalde(Balde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.guardarBalde(instance);
	}

	@Override
	public List<Balde> buscarBalde(Balde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.buscarBalde(instance);
	}

	@Override
	public Balde obtenerPorIdBalde(int id) throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.obtenerPorIdBalde(id);
	}

	@Override
	public Balde eliminarBalde(Balde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.eliminarBalde(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdBalde() throws Exception {
		// TODO Auto-generated method stub
		return daoBaldeDAO.obtenerMaximoIdBalde();
	}

	@Override
	public List<UsuarioDecantadoraCentrifugadoraBalde> listarTodosUsuarioDecantadoraCentrifugadoraBalde()
			throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.listarTodosUsuarioDecantadoraCentrifugadoraBalde();
	}

	@Override
	public UsuarioDecantadoraCentrifugadoraBalde guardarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.guardarUsuarioDecantadoraCentrifugadoraBalde(instance);
	}

	@Override
	public List<UsuarioDecantadoraCentrifugadoraBalde> buscarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.buscarUsuarioDecantadoraCentrifugadoraBalde(instance);
	}

	@Override
	public UsuarioDecantadoraCentrifugadoraBalde obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(
			int id) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(id);
	}

	@Override
	public UsuarioDecantadoraCentrifugadoraBalde eliminarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.eliminarUsuarioDecantadoraCentrifugadoraBalde(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadoraBalde()
			throws Exception {
		// TODO Auto-generated method stub
		return daoUsuarioDecantadoraCentrifugadoraBaldeDAO.obtenerMaximoIdUsuarioDecantadoraCentrifugadoraBalde();
	}

	@Override
	public List<OrdenPedido> listarTodosOrdenPedido() throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.listarTodosOrdenPedido();
	}

	@Override
	public OrdenPedido guardarOrdenPedido(OrdenPedido instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.guardarOrdenPedido(instance);
	}

	@Override
	public List<OrdenPedido> buscarOrdenPedido(OrdenPedido instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.buscarOrdenPedido(instance);
	}

	@Override
	public OrdenPedido obtenerPorIdOrdenPedido(int id) throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.obtenerPorIdOrdenPedido(id);
	}

	@Override
	public OrdenPedido eliminarOrdenPedido(OrdenPedido instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.eliminarOrdenPedido(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdOrdenPedido() throws Exception {
		// TODO Auto-generated method stub
		return daoOrdenPedidoDAO.obtenerMaximoIdOrdenPedido();
	}

	@Override
	public List<PlanillaEnvasado> listarTodosPlanillaEnvasado()
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.listarTodosPlanillaEnvasado();
	}

	@Override
	public PlanillaEnvasado guardarPlanillaEnvasado(PlanillaEnvasado instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.guardarPlanillaEnvasado(instance);
	}

	@Override
	public List<PlanillaEnvasado> buscarPlanillaEnvasado(
			PlanillaEnvasado instance) throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.buscarPlanillaEnvasado(instance);
	}

	@Override
	public PlanillaEnvasado obtenerPorIdPlanillaEnvasado(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.obtenerPorIdPlanillaEnvasado(id);
	}

	@Override
	public PlanillaEnvasado eliminarPlanillaEnvasado(PlanillaEnvasado instance)
			throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.eliminarPlanillaEnvasado(instance);
	}

	@Override
	public List<Integer> obtenerMaximoIdPlanillaEnvasado() throws Exception {
		// TODO Auto-generated method stub
		return daoPlanillaEnvasadoDAO.obtenerMaximoIdPlanillaEnvasado();
	}



}
