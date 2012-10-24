package apiario.edu.pe.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Zona;

public class Test {

	public Test() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Project_Apiaria");
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createQuery("select z from Zona z");
			List<Zona> listaZona = q.getResultList();
			for (Zona zona : listaZona) {
				System.out.println(zona.getIdzona()+" - "+zona.getDescripcion());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public static void main(String[] args) {
		new Test();

	}

}
