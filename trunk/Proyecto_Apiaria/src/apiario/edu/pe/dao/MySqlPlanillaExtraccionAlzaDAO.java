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
import apiario.edu.pe.bean.PlanillaExtraccionAlza;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.UsuarioApiario;

@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaExtraccionAlzaDAO implements IPlanillaExtraccionAlzaDAO{

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
	public List<PlanillaExtraccionAlza> listarTodosPlanillaExtraccionAlza()
			throws Exception {
		List<PlanillaExtraccionAlza> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from PlanillaExtraccionAlza model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public PlanillaExtraccionAlza guardarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
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
	public List<PlanillaExtraccionAlza> buscarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaExtraccionAlza> criteria = builder.createQuery( PlanillaExtraccionAlza.class );
		Root<PlanillaExtraccionAlza> planillaExtraccionAlzaRoot = criteria.from( PlanillaExtraccionAlza.class );
		Join<PlanillaExtraccionAlza,PlanillaRevisionAlza> planillaRevisionAlzaRoot = planillaExtraccionAlzaRoot.join( "planillaRevisionAlza" );
		Join<PlanillaRevisionAlza,PlanillaRevision> planillaRevisionRoot = planillaRevisionAlzaRoot.join( "planillaRevision" );
		Join<PlanillaExtraccionAlza,UsuarioApiario> usuarioApiarioRoot = planillaExtraccionAlzaRoot.join( "usuarioApiario" );
		Join<UsuarioApiario,Temporada> temporadaRoot = usuarioApiarioRoot.join( "temporada" );
		criteria.select( planillaExtraccionAlzaRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		
		if(instance!=null){
			if(instance.getIdPlanillaExtraccionAlza()!=null && instance.getIdPlanillaExtraccionAlza().intValue()>0){
				Predicate condition=builder.equal(planillaExtraccionAlzaRoot.get("idPlanillaExtraccionAlza"), instance.getIdPlanillaExtraccionAlza());
				p.add(condition);
			}
			
			if(instance.getUsuarioApiario()!=null){
				if(instance.getUsuarioApiario().getTemporada()!=null){
					if(instance.getUsuarioApiario().getTemporada().getIdTemporada()!=null && instance.getUsuarioApiario().getTemporada().getIdTemporada().intValue()>0){
						Predicate condition=builder.equal(temporadaRoot.get("idTemporada"), instance.getUsuarioApiario().getTemporada().getIdTemporada());
						p.add(condition);
					}
				}
			}
			
			if(instance.getPlanillaRevisionAlza()!=null){
				if(instance.getPlanillaRevisionAlza().getPlanillaRevision()!=null){
					if(instance.getPlanillaRevisionAlza().getPlanillaRevision().getIdPlanillaRevision()!=null && instance.getPlanillaRevisionAlza().getPlanillaRevision().getIdPlanillaRevision().intValue()>0){
						Predicate condition=builder.equal(planillaRevisionRoot.get("idPlanillaRevision"), instance.getPlanillaRevisionAlza().getPlanillaRevision().getIdPlanillaRevision());
						p.add(condition);
					}
				}
			}
		}
		
		
	
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<PlanillaExtraccionAlza> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public PlanillaExtraccionAlza obtenerPorIdPlanillaExtraccionAlza(int id)
			throws Exception {
		try {
			Open();
			PlanillaExtraccionAlza instance = em.find(PlanillaExtraccionAlza.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public PlanillaExtraccionAlza eliminarPlanillaExtraccionAlza(
			PlanillaExtraccionAlza instance) throws Exception {
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
				String hql="delete from PlanillaExtraccionAlza a where a.idPlanillaExtraccionAlza in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdPlanillaExtraccionAlza()
			throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(model.idPlanillaExtraccionAlza) from PlanillaExtraccionAlza model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		System.out.println("lista??dAO "+lista);
		return lista;
	}

}
