package apiario.edu.pe.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.PlanillaRevision;

public class Test {
	
	public Test() {
		// TODO Auto-generated constructor stub
		EntityManagerFactory emf;
		EntityManager em;
		emf=Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		em=emf.createEntityManager();
		
		
		List<PlanillaRevision> lista=null;
		
		try {
			Query q=em.createQuery("select model from PlanillaRevision model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		em.close();
		emf.close();
		System.out.println("lista??dAO "+lista);
		
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("id "+lista.get(i).getIdPlanillaRevision());
			System.out.println("valor tiny "+lista.get(i).getFaltaEspacioCamara());
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
