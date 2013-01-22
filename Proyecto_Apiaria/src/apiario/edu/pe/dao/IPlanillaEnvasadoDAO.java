package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.PlanillaEnvasado;



public interface IPlanillaEnvasadoDAO {
	public abstract List<PlanillaEnvasado> listarTodosPlanillaEnvasado() throws Exception;
	public abstract PlanillaEnvasado guardarPlanillaEnvasado(PlanillaEnvasado instance) throws Exception;
	public abstract List<PlanillaEnvasado> buscarPlanillaEnvasado(PlanillaEnvasado instance) throws Exception;
	public abstract PlanillaEnvasado obtenerPorIdPlanillaEnvasado(int id) throws Exception;
	public abstract PlanillaEnvasado eliminarPlanillaEnvasado(PlanillaEnvasado instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdPlanillaEnvasado() throws Exception;
}
