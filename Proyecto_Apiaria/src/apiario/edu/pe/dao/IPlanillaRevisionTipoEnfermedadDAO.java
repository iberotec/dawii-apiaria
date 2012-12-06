package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;

public interface IPlanillaRevisionTipoEnfermedadDAO {

	public abstract List<PlanillaRevisionTipoEnfermedad> listarTodosPlanillaRevisionTipoEnfermedads() throws Exception;
	public abstract PlanillaRevisionTipoEnfermedad guardarPlanillaRevisionTipoEnfermedad(PlanillaRevisionTipoEnfermedad instance) throws Exception;
	public abstract List<PlanillaRevisionTipoEnfermedad> buscarPlanillaRevisionTipoEnfermedad(PlanillaRevisionTipoEnfermedad instance) throws Exception;
	public abstract PlanillaRevisionTipoEnfermedad obtenerPorIdPlanillaRevisionTipoEnfermedad(int id) throws Exception;
	public abstract PlanillaRevisionTipoEnfermedad eliminarPlanillaRevisionTipoEnfermedad(PlanillaRevisionTipoEnfermedad instance) throws Exception;
	
}
