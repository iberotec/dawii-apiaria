package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.PlanillaRevision;

public class MySqlPlanillaRevisionDAO implements IPlanillaRevisionDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public List<PlanillaRevision> listaPlanillaRevision(Integer colmena) {
		
		List lista = null;
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("Select u from PlanillaRevision u where u.colmena.idColmena=:xcolmena");
				sql.setParameter("xcolmena", colmena);
				lista = sql.getResultList();
				
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
		return lista;
	}

}
