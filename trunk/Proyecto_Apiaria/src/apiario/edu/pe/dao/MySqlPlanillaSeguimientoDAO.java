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
import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Zona;
@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaSeguimientoDAO implements IPlanillaSeguimientoDAO{
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
	public List<PlanillaSeguimiento> listarTodosPlanillaSeguimiento()
			throws Exception {
		List<PlanillaSeguimiento> lista=null;
		Open();
		try {
			Query q=em.createQuery("select p from PlanillaSeguimiento p");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public PlanillaSeguimiento guardarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
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
	public List<PlanillaSeguimiento> buscarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaSeguimiento> criteria = builder.createQuery( PlanillaSeguimiento.class );
		Root<PlanillaSeguimiento> planillaSeguimientoRoot = criteria.from( PlanillaSeguimiento.class );
		Join<PlanillaSeguimiento,Apiario> apiarioRoot = planillaSeguimientoRoot.join( "apiario" );
		Join<PlanillaSeguimiento,Zona> zonaRoot = planillaSeguimientoRoot.join( "zona" );
		
		criteria.select( planillaSeguimientoRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("PlanillaSeguimiento");
			if(instance.getIdPlanillaSeguimiento()!=null && instance.getIdPlanillaSeguimiento()>0){
				System.out.println("PlanillaSeguimiento.getIdplanillaSeguimiento");
				Predicate condition=builder.equal(planillaSeguimientoRoot.get("idPlanillaSeguimiento"), instance.getIdPlanillaSeguimiento());
				p.add(condition);
			}
			if(instance.getApiario()!=null){
				System.out.println("PlanillaSeguimiento.getApiario()");
				if(instance.getApiario().getIdApiario()!=null && instance.getApiario().getIdApiario()>0){
					System.out.println("PlanillaSeguimiento.getApiario().getIdapiario");
					Predicate condition=builder.equal(apiarioRoot.get("idApiario"), instance.getApiario().getIdApiario());
					p.add(condition);
				}
				
			}
			if(instance.getZona()!=null){
				System.out.println("instance.getZona()");
				if(instance.getZona().getIdZona()!=null && instance.getZona().getIdZona()>0){
				Predicate condition=builder.equal(zonaRoot.get("idZona"), instance.getZona().getIdZona());
				p.add(condition);
				}
			}
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<PlanillaSeguimiento> lista = em.createQuery( criteria ).getResultList();
	    em.close();
	    return lista;
	}

	@Override
	public PlanillaSeguimiento obtenerPorIdPlanillaSeguimiento(int id)
			throws Exception {
		try {
			Open();
			PlanillaSeguimiento instance = em.find(PlanillaSeguimiento.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public PlanillaSeguimiento eliminarPlanillaSeguimiento(
			PlanillaSeguimiento instance) throws Exception {
		// TODO Auto-generated method stub
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
				String hql="delete from PlanillaSeguimiento p where p.idplanillaSeguimiento in (:v_ids)";		
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
