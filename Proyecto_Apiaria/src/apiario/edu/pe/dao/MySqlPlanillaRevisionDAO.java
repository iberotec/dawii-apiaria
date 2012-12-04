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
import apiario.edu.pe.bean.PlanillaRevision;

public class MySqlPlanillaRevisionDAO implements IPlanillaRevisionDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public List<PlanillaRevision> listaPlanillaRevision(Integer colmena) {
		
		List<PlanillaRevision> lista = null;
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("Select u from PlanillaRevision u where u.colmena.idColmena=:xcolmena");
				sql.setParameter("xcolmena", colmena);
				lista = sql.getResultList();
				
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
		return lista;
	}

	@Override
	public List<PlanillaRevision> listarTodosPlanillaRevisions()
			throws Exception {
		List<PlanillaRevision> lista=null;
		
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from PlanillaRevision c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally{
			em.close();
			emf.close();
		}
		
		return lista;
	}

	@Override
	public PlanillaRevision guardarPlanillaRevision(PlanillaRevision instance)
			throws Exception {
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
	public List<PlanillaRevision> buscarPlanillaRevision(
			PlanillaRevision instance) throws Exception {
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaRevision> criteria=builder.createQuery(PlanillaRevision.class);
		Root<PlanillaRevision> colmenaRoot=criteria.from(PlanillaRevision.class);
		
		criteria.select(colmenaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdPlanillaRevision()>0){
				Predicate condition=builder.equal(colmenaRoot.get("idPlanillaRevision"),instance.getIdPlanillaRevision());
				p.add(condition);
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<PlanillaRevision> lista=em.createQuery(criteria).getResultList();
		em.close();
		return lista;
	}

	@Override
	public PlanillaRevision obtenerPorIdPlanillaRevision(int id)
			throws Exception {
		try {
			PlanillaRevision instance=em.find(PlanillaRevision.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public PlanillaRevision eliminarPlanillaRevision(PlanillaRevision instance)
			throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from PlanillaRevision c where c.idPlanillaRevision in (:v_ids)";		
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
