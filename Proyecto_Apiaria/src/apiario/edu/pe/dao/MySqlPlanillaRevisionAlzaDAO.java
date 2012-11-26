package apiario.edu.pe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apiario.edu.pe.bean.PlanillaRevisionAlza;

public class MySqlPlanillaRevisionAlzaDAO implements IPlanillaRevisionAlzaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em= emf.createEntityManager();
	
	@Override
	public int registrarPlanillaRevisionAlza(PlanillaRevisionAlza obj) {
		
		obj = new PlanillaRevisionAlza();
		int resultado = 0;
		
		try {
			em.getTransaction().begin();
				em.persist(obj);
			em.getTransaction().commit();
			resultado =1;
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultado=0;
		}
		
		return resultado;
	}

}
