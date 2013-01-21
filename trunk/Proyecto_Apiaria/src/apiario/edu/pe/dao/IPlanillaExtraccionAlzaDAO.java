package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaExtraccionAlza;



public interface IPlanillaExtraccionAlzaDAO {
	public abstract List<PlanillaExtraccionAlza> listarTodosPlanillaExtraccionAlza() throws Exception;
	public abstract PlanillaExtraccionAlza guardarPlanillaExtraccionAlza(PlanillaExtraccionAlza instance) throws Exception;
	public abstract List<PlanillaExtraccionAlza> buscarPlanillaExtraccionAlza(PlanillaExtraccionAlza instance) throws Exception;
	public abstract PlanillaExtraccionAlza obtenerPorIdPlanillaExtraccionAlza(int id) throws Exception;
	public abstract PlanillaExtraccionAlza eliminarPlanillaExtraccionAlza(PlanillaExtraccionAlza instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdPlanillaExtraccionAlza() throws Exception;
}
