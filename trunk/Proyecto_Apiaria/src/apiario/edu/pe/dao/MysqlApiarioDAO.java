package apiario.edu.pe.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import apiario.edu.pe.bean.Apiario;


@SuppressWarnings(value={"unchecked"})
public class MysqlApiarioDAO implements IApiarioDAO {
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
	public List<Apiario> listarTodosApiarios() throws Exception {
		List<Apiario> lista=null;
		Open();
		try {
			Query q=em.createQuery("select a from Apiario a");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public Apiario guardarApiario(Apiario instance) throws Exception {
		try {
			instance.setSuccess(false);
			Open();
			em.getTransaction().begin();
			em.merge(instance);
			em.getTransaction().commit();
			instance.setSuccess(true);
			return instance;
		} catch (RuntimeException re) {
			instance.setSuccess(false);
			instance.setMsgResult("Error al grabar el parametro.");
			System.out.println("DAO "+re.getMessage());
			em.getTransaction().rollback();
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public List<Apiario> buscarApiario(Apiario instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Apiario> criteria = builder.createQuery( Apiario.class );
		Root<Apiario> apiarioRoot = criteria.from( Apiario.class );

		
		criteria.select( apiarioRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("apiario");
			if(instance.getIdapiario()!=null && instance.getIdapiario()>0){
				System.out.println("apiario.getIdapiario");
				Predicate condition=builder.equal(apiarioRoot.get("idapiario"), instance.getIdapiario());
				p.add(condition);
			}
			if(instance.getDescripcion()!=null && instance.getDescripcion().length()>0){
				System.out.println("apiario.getDescripcion");
				Predicate condition=builder.like(apiarioRoot.<String>get("descripcion"), "%"+instance.getDescripcion()+"%");
				p.add(condition);
			}
			
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Apiario> lista = em.createQuery( criteria ).getResultList();
	    em.close();
	    return lista;
	}

	@Override
	public Apiario obtenerPorIdApiario(int id) throws Exception {
		try {
			Open();
			Apiario instance = em.find(Apiario.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public Apiario eliminarApiario(Apiario instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			Open();
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from Apiario a where a.idapiario in (:v_ids)";		
				em.createQuery(hql).setParameter("v_ids", listaIds.get(i)).executeUpdate();
			}
			em.getTransaction().commit();
			instance.setSuccess(true);
		} catch (RuntimeException re) {
			instance.setSuccess(false);
			em.getTransaction().rollback();
			instance.setMsgResult("No se puede eliminar por estar relacionado con otra(s) Tablas");
			re.printStackTrace();
		}finally{
			Close();
		}
		return instance;
	}

	

}
