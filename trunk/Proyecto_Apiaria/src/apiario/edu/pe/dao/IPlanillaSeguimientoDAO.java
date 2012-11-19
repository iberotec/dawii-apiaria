package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaSeguimiento;



public interface IPlanillaSeguimientoDAO {
	public abstract List<PlanillaSeguimiento> listarTodosPlanillaSeguimiento() throws Exception;
	public abstract PlanillaSeguimiento guardarPlanillaSeguimiento(PlanillaSeguimiento instance) throws Exception;
	public abstract List<PlanillaSeguimiento> buscarPlanillaSeguimiento(PlanillaSeguimiento instance) throws Exception;
	public abstract PlanillaSeguimiento obtenerPorIdPlanillaSeguimiento(int id) throws Exception;
	public abstract PlanillaSeguimiento eliminarPlanillaSeguimiento(PlanillaSeguimiento instance) throws Exception;
}
