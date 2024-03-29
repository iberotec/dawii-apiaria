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
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;

public class MySqlPlanillaRevisionTipoEnfermedadDAO implements
		IPlanillaRevisionTipoEnfermedadDAO {

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
	public List<PlanillaRevisionTipoEnfermedad> listarTodosPlanillaRevisionTipoEnfermedads()
			throws Exception {
		List<PlanillaRevisionTipoEnfermedad> lista=null;
		Open();
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from PlanillaRevisionTipoEnfermedad c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		Close();
		return lista;
	}

	@Override
	public PlanillaRevisionTipoEnfermedad guardarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
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
	public List<PlanillaRevisionTipoEnfermedad> buscarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaRevisionTipoEnfermedad> criteria=builder.createQuery(PlanillaRevisionTipoEnfermedad.class);
		Root<PlanillaRevisionTipoEnfermedad> planillaRevisionTipoEnfermedadRoot=criteria.from(PlanillaRevisionTipoEnfermedad.class);
		Join<PlanillaRevisionTipoEnfermedad,PlanillaRevision> planillaRevisionRoot = planillaRevisionTipoEnfermedadRoot.join("planillaRevision");
		
		criteria.select(planillaRevisionTipoEnfermedadRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdPlanillaRevisionTipoEnfermedad()!=null && instance.getIdPlanillaRevisionTipoEnfermedad().intValue()>0){
				Predicate condition=builder.equal(planillaRevisionTipoEnfermedadRoot.get("idPlanillaRevisionTipoEnfermedad"),instance.getIdPlanillaRevisionTipoEnfermedad());
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
		
		List<PlanillaRevisionTipoEnfermedad> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public PlanillaRevisionTipoEnfermedad obtenerPorIdPlanillaRevisionTipoEnfermedad(
			int id) throws Exception {
		try {
			PlanillaRevisionTipoEnfermedad instance=em.find(PlanillaRevisionTipoEnfermedad.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public PlanillaRevisionTipoEnfermedad eliminarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
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
				String hql="delete from PlanillaRevisionTipoEnfermedad c where c.idPlanillaRevisionTipoEnfermedad in (:v_ids)";		
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
