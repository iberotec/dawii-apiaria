package apiario.edu.pe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import apiario.edu.pe.bean.Colmena;

public class MySqlColmenaDAO implements IColmenaDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	@Override
	public List<Colmena> listarTodosColmenas() throws Exception {
		List lista=null;
		
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from Colmena c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		return lista;
	}

	@Override
	public Colmena guardarColmena(Colmena instance) throws Exception {
		try {
			instance.setSuccess(false);
			em.getTransaction().begin();
			em.merge(instance);
			em.getTransaction().commit();
			instance.setSuccess(true);
			return instance;
		} catch (RuntimeException e) {
			instance.setSuccess(false);
			instance.setMsgResult("Error al grabar el parametro.");
			System.out.println("DAO "+e.getMessage());
			em.getTransaction().rollback();
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public List<Colmena> buscarColmena(Colmena instance) throws Exception {
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<Colmena> criteria=builder.createQuery(Colmena.class);
		Root<Colmena> colmenaRoot=criteria.from(Colmena.class);
		
		criteria.select(colmenaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdcolmena()>0){
				Predicate condition=builder.equal(colmenaRoot.get("idcolmena"),instance.getIdcolmena());
				p.add(condition);
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<Colmena> lista=em.createQuery(criteria).getResultList();
		em.close();
		return lista;
	}

	@Override
	public Colmena obtenerPorIdColmena(int id) throws Exception {
		try {
			Colmena instance=em.find(Colmena.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public Colmena eliminarColmena(Colmena instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from Colmena c where c.idcolmena in (:v_ids)";		
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
			emf.close();
			em.close();
		}
		return instance;
	}

}
