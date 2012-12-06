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
	public List<PlanillaRevisionTipoAlimentacion> buscarPlanillaRevisionTipoAlimentacion(
			PlanillaRevisionTipoAlimentacion instance) throws Exception {
//		Open();
//		CriteriaBuilder builder=emf.getCriteriaBuilder();
//		CriteriaQuery<Colmena> criteria=builder.createQuery(Colmena.class);
//		Root<Colmena> colmenaRoot=criteria.from(Colmena.class);
//		Join<Colmena,Apiario> apiarioRoot = colmenaRoot.join("apiario");
//		
//		System.out.println("entro aqui DAO?");
//		
//		criteria.select(colmenaRoot);
//		List<Predicate> p=new ArrayList<Predicate>();
//		
//		if(instance!=null){
//			if(instance.getIdColmena()!=null && instance.getIdColmena()>0){
//				System.out.println("entro?????? DAO");
//				Predicate condition=builder.equal(colmenaRoot.get("idColmena"),instance.getIdColmena());
//				p.add(condition);
//			}
//			if(instance.getApiario()!=null){
//				if(instance.getApiario().getIdApiario()!=null && instance.getApiario().getIdApiario()>0){
//					Predicate condition=builder.equal(apiarioRoot.get("idApiario"),instance.getApiario().getIdApiario());
//					p.add(condition);
//				}
//			}
//		}
//		Predicate[] predicates=new Predicate[p.size()];
//		p.toArray(predicates);
//		criteria.where(predicates);
//		
//		List<Colmena> lista=em.createQuery(criteria).getResultList();
//		Close();
//		return lista;
		return null;
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
			emf.close();
			em.close();
		}
		return instance;
	}

}
