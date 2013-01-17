package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apiario.edu.pe.bean.PlanillaCosechaAlza;
@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaCosechaAlzaDAO implements IPlanillaCosechaAlzaDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public void Open(){
		emf=Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		em=emf.createEntityManager();
	}
	public void Close(){
		em.close();
		emf.close();
	}
	@Override
	public List<PlanillaCosechaAlza> listarTodosPlanillaCosechaAlza()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PlanillaCosechaAlza guardarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<PlanillaCosechaAlza> buscarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PlanillaCosechaAlza obtenerPorIdPlanillaCosechaAlza(int id)
			throws Exception {
		
		try {
			Open();
			PlanillaCosechaAlza instance=em.find(PlanillaCosechaAlza.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}
	@Override
	public PlanillaCosechaAlza eliminarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integer> obtenerMaximoIdPlanillaCosechaAlza() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
