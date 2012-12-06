package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;

public interface IPlanillaRevisionTipoAlimentacionDAO {

	public abstract List<PlanillaRevisionTipoAlimentacion> listarTodosPlanillaRevisionTipoAlimentacions() throws Exception;
	public abstract PlanillaRevisionTipoAlimentacion guardarPlanillaRevisionTipoAlimentacion(PlanillaRevisionTipoAlimentacion instance) throws Exception;
	public abstract List<PlanillaRevisionTipoAlimentacion> buscarPlanillaRevisionTipoAlimentacion(PlanillaRevisionTipoAlimentacion instance) throws Exception;
	public abstract PlanillaRevisionTipoAlimentacion obtenerPorIdPlanillaRevisionTipoAlimentacion(int id) throws Exception;
	public abstract PlanillaRevisionTipoAlimentacion eliminarPlanillaRevisionTipoAlimentacion(PlanillaRevisionTipoAlimentacion instance) throws Exception;
	
}
