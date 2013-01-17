package apiario.edu.pe.dao;

import java.util.List;


import apiario.edu.pe.bean.PlanillaCosechaAlza;

public interface IPlanillaCosechaAlzaDAO {

	public abstract List<PlanillaCosechaAlza> listarTodosPlanillaCosechaAlza() throws Exception;
	public abstract PlanillaCosechaAlza guardarPlanillaCosechaAlza(PlanillaCosechaAlza instance) throws Exception;
	public abstract List<PlanillaCosechaAlza> buscarPlanillaCosechaAlza(PlanillaCosechaAlza instance) throws Exception;
	public abstract PlanillaCosechaAlza obtenerPorIdPlanillaCosechaAlza(int id) throws Exception;
	public abstract PlanillaCosechaAlza eliminarPlanillaCosechaAlza(PlanillaCosechaAlza instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdPlanillaCosechaAlza() throws Exception;
	
}
