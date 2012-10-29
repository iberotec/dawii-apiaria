package apiaria.edu.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Zona;

public class Test {
@SuppressWarnings("unchecked")
public Test(){
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select z from Zona z");
	List<Zona> x=q.getResultList();
	for (Zona zona : x) {
		System.out.println(""+zona.getDescripcion());
	}
}
public static void main(String[] args) {
	new Test();
	
}
}
