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

import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;

public class MySqlPlanillaRevisionTipoAlimentacionDAO implements
		IPlanillaRevisionTipoAlimentacionDAO {

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
	public List<PlanillaRevisionTipoAlimentacion> listarTodosPlanillaRevisionTipoAlimentacions()
			throws Exception {
		List<PlanillaRevisionTipoAlimentacion> lista=null;
		Open();
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from PlanillaRevisionTipoAlimentacion c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		Close();
		return lista;
	}

	@Override
	public PlanillaRevisionTipoAlimentacion guardarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
		try {
			Open();
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
			Close();
		}
	}

	@Override
	public List<PlanillaRevisionTipoAlimentacion> buscarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaRevisionTipoAlimentacion> criteria=builder.createQuery(PlanillaRevisionTipoAlimentacion.class);
		Root<PlanillaRevisionTipoAlimentacion> planillaRevisionTipoAlimentacionRoot=criteria.from(PlanillaRevisionTipoAlimentacion.class);
		Join<PlanillaRevisionTipoAlimentacion,PlanillaRevision> planillaRevisionRoot = planillaRevisionTipoAlimentacionRoot.join("planillaRevision");
		
		criteria.select(planillaRevisionTipoAlimentacionRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdPlanillaRevisionTipoAlimentacion()!=null && instance.getIdPlanillaRevisionTipoAlimentacion().intValue()>0){
				Predicate condition=builder.equal(planillaRevisionTipoAlimentacionRoot.get("idPlanillaRevisionTipoAlimentacion"),instance.getIdPlanillaRevisionTipoAlimentacion());
				p.add(condition);
			}
			if(instance.getPlanillaRevision()!=null){
				if(instance.getPlanillaRevision().getIdPlanillaRevision()!=null && instance.getPlanillaRevision().getIdPlanillaRevision().intValue()>0){
					Predicate condition=builder.equal(planillaRevisionRoot.get("idPlanillaRevision"),instance.getPlanillaRevision().getIdPlanillaRevision());
					p.add(condition);
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<PlanillaRevisionTipoAlimentacion> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public PlanillaRevisionTipoAlimentacion obtenerPorIdPlanillaRevisionTipoAlimentacion(
			int id) throws Exception {
		try {
			PlanillaRevisionTipoAlimentacion instance=em.find(PlanillaRevisionTipoAlimentacion.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public PlanillaRevisionTipoAlimentacion eliminarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
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
				String hql="delete from PlanillaRevisionTipoAlimentacion c where c.idPlanillaRevisionTipoAlimentacion in (:v_ids)";		
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
