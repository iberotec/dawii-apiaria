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

import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadApiario;

public class MySqlNormaSeguridadApiarioDAO implements INormaSeguridadApiarioDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	@Override
	public List<NormaSeguridadApiario> listarTodosNormaSeguridadApiarioes()
			throws Exception {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from NormaSeguridadApiario a");
		List<NormaSeguridadApiario> lista=q.getResultList();
		return lista;
	}

	@Override
	public NormaSeguridadApiario guardarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
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
	public List<NormaSeguridadApiario> buscarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<NormaSeguridadApiario> criteria=builder.createQuery(NormaSeguridadApiario.class);
		Root<NormaSeguridadApiario> colmenaRoot=criteria.from(NormaSeguridadApiario.class);
		
		criteria.select(colmenaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdNormaSeguridadApiario()>0){
				Predicate condition=builder.equal(colmenaRoot.get("idNormaSeguridadApiario"),instance.getIdNormaSeguridadApiario());
				p.add(condition);
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<NormaSeguridadApiario> lista=em.createQuery(criteria).getResultList();
		em.close();
		return lista;
	}

	@Override
	public NormaSeguridadApiario obtenerPorIdNormaSeguridadApiario(int id)
			throws Exception {
		try {
			NormaSeguridadApiario instance=em.find(NormaSeguridadApiario.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public NormaSeguridadApiario eliminarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from NormaSeguridadApiario n where n.idNormaSeguridadApiario in (:v_ids)";		
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
