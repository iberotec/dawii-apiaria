package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.NormaSeguridad;

public class MysqlNormaSeguridadDAO implements INormaSeguridadDAO {

	@Override
	public List<NormaSeguridad> listaNormaSeguridad() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from NormaSeguridad a");
		List<NormaSeguridad> lista=q.getResultList();
		return lista;
	}


	
}
