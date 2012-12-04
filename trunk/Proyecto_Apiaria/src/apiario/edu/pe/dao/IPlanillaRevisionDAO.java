package apiario.edu.pe.dao;

import java.util.List;
import apiario.edu.pe.bean.*;

public interface IPlanillaRevisionDAO {

	public abstract List<PlanillaRevision> listaPlanillaRevision(Integer colmena);
	
	public abstract List<PlanillaRevision> listarTodosPlanillaRevisions() throws Exception;
	public abstract PlanillaRevision guardarPlanillaRevision(PlanillaRevision instance) throws Exception;
	public abstract List<PlanillaRevision> buscarPlanillaRevision(PlanillaRevision instance) throws Exception;
	public abstract PlanillaRevision obtenerPorIdPlanillaRevision(int id) throws Exception;
	public abstract PlanillaRevision eliminarPlanillaRevision(PlanillaRevision instance) throws Exception;
	
	
}
