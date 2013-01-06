package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaCosecha;

public interface IPlanillaCosechaDAO {

	public abstract List<PlanillaCosecha> listarTodosPlanillaCosechas() throws Exception;
	public abstract PlanillaCosecha guardarPlanillaCosecha(PlanillaCosecha instance) throws Exception;
	public abstract List<PlanillaCosecha> buscarPlanillaCosecha(PlanillaCosecha instance) throws Exception;
	public abstract PlanillaCosecha obtenerPorIdPlanillaCosecha(int id) throws Exception;
	public abstract PlanillaCosecha eliminarPlanillaCosecha(PlanillaCosecha instance) throws Exception;
	
}
