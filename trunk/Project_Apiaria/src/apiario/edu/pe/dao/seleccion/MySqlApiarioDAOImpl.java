package apiario.edu.pe.dao.seleccion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Apiario;

public class MySqlApiarioDAOImpl implements ApiarioDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Project_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	@Override
	public List<Apiario> buscarTodos() {
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
	public List<Apiario> buscarApiarios(Apiario instance) {

		return null;
	}
	@Override
	public Apiario obtenerporId(Integer id) {
//		try {
//			em.getTransaction().begin();
//			
//			Query sql=em.createQuery("select a from Apiario a where idapiario= ?1");
//			
//			
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//		}
		return null;
	}
	@Override
	public List<Apiario> buscarPorPropiedad(String propiedad, Object valor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Apiario guardarInstancia(Apiario instance) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Apiario guardarInstancias(List<Apiario> lista) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Apiario eliminarInstancia(Apiario instance) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
