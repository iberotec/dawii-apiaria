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

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaEnvasado;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;

@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaEnvasadoDAO implements IPlanillaEnvasadoDAO{
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
	public List<PlanillaEnvasado> listarTodosPlanillaEnvasado()
			throws Exception {
		List<PlanillaEnvasado> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from PlanillaEnvasado model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public PlanillaEnvasado guardarPlanillaEnvasado(PlanillaEnvasado instance)
			throws Exception {
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
	public List<PlanillaEnvasado> buscarPlanillaEnvasado(
			PlanillaEnvasado instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaEnvasado> criteria = builder.createQuery( PlanillaEnvasado.class );
		Root<PlanillaEnvasado> planillaEnvasadoRoot = criteria.from( PlanillaEnvasado.class );
		criteria.select( planillaEnvasadoRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdPlanillaEnvasado()!=null && instance.getIdPlanillaEnvasado().intValue()>0){
				Predicate condition=builder.equal(planillaEnvasadoRoot.get("idPlanillaEnvasado"), instance.getIdPlanillaEnvasado());
				p.add(condition);
			}
		}
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<PlanillaEnvasado> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public PlanillaEnvasado obtenerPorIdPlanillaEnvasado(int id)
			throws Exception {
		try {
			Open();
			PlanillaEnvasado instance = em.find(PlanillaEnvasado.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public PlanillaEnvasado eliminarPlanillaEnvasado(PlanillaEnvasado instance)
			throws Exception {
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
				String hql="delete from PlanillaEnvasado a where a.idPlanillaEnvasado in (:v_ids)";		
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

	@Override
	public List<Integer> obtenerMaximoIdPlanillaEnvasado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
