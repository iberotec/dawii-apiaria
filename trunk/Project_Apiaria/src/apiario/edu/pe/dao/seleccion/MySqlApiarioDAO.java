package apiario.edu.pe.dao.seleccion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Apiario;

public class MySqlApiarioDAO implements ApiarioDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Project_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	@Override
	public List<Apiario> listarApiarios() throws Exception {
		
		List<Apiario> lista=new ArrayList<Apiario>();
		
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select a from Apiario a");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return lista;
	}

	@Override
	public Apiario buscarApiarioporId(Integer codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarApiario(Apiario entidad) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarApiario(Apiario entidad) throws Exception {
		try {
			em.getTransaction().begin();
			
			em.persist(entidad);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
