package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Apiario;

public class MysqlApiarioDAO implements IApiarioDAO {

	@SuppressWarnings("unchecked")
	public List<Apiario> ListarTodos() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Apiario a");
		List<Apiario> lista=q.getResultList();
		return lista;
	}

}
