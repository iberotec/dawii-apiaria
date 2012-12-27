package apiario.edu.pe.dao;

import java.util.List;


import apiario.edu.pe.bean.PlanillaRevisionAlza;

public interface IPlanillaRevisionAlzaDAO {

	public abstract List<PlanillaRevisionAlza> listarTodosPlanillaRevisionAlza() throws Exception;
	public abstract PlanillaRevisionAlza guardarPlanillaRevisionAlza(PlanillaRevisionAlza instance) throws Exception;
	public abstract List<PlanillaRevisionAlza> buscarPlanillaRevisionAlza(PlanillaRevisionAlza instance) throws Exception;
	public abstract PlanillaRevisionAlza obtenerPorIdPlanillaRevisionAlza(int id) throws Exception;
	public abstract PlanillaRevisionAlza eliminarPlanillaRevisionAlza(PlanillaRevisionAlza instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdPlanillaRevisionAlza() throws Exception;
	
}
