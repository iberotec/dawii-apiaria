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
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaRevisionAlzaDAO implements IPlanillaRevisionAlzaDAO {

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
	public List<PlanillaRevisionAlza> listarTodosPlanillaRevisionAlza()
			throws Exception {
		List<PlanillaRevisionAlza> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from PlanillaRevisionAlza model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}
	@Override
	public PlanillaRevisionAlza guardarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
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
	public List<PlanillaRevisionAlza> buscarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaRevisionAlza> criteria = builder.createQuery( PlanillaRevisionAlza.class );
		Root<PlanillaRevisionAlza> planillaRevisionAlzaRoot = criteria.from( PlanillaRevisionAlza.class );
		Join<PlanillaRevisionAlza,PlanillaRevision> planillaRevisionRoot = planillaRevisionAlzaRoot.join( "planillaRevision" );
		Join<PlanillaRevision,Colmena> colmenaPrRoot = planillaRevisionRoot.join( "colmena" );
		Join<PlanillaRevisionAlza,Alza> alzaRoot = planillaRevisionAlzaRoot.join( "alza" );
		Join<Alza,Piso> pisoRoot = alzaRoot.join( "piso" );
		Join<Piso,Colmena> colmenaRoot = pisoRoot.join( "colmena" );
		criteria.select( planillaRevisionAlzaRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		
		Predicate conditionExterno=builder.ge(planillaRevisionAlzaRoot.<Double>get("porcentajeMiel"), 75);
		p.add(conditionExterno);
		
		
		if(instance!=null){	
			if(instance.getIdPlanillaRevisionAlza()!=null && instance.getIdPlanillaRevisionAlza().intValue()>0){
				Predicate condition=builder.equal(planillaRevisionAlzaRoot.get("idPlanillaRevisionAlza"), instance.getIdPlanillaRevisionAlza());
				p.add(condition);
			}
			if(instance.getPlanillaRevision()!=null){
				if(instance.getPlanillaRevision().getIdPlanillaRevision()!=null && instance.getPlanillaRevision().getIdPlanillaRevision().intValue()>0){
					Predicate condition=builder.equal(planillaRevisionRoot.get("idPlanillaRevision"), instance.getPlanillaRevision().getIdPlanillaRevision());
					p.add(condition);
				}
				if(instance.getPlanillaRevision().getComportamiento()!=null && instance.getPlanillaRevision().getComportamiento().length()>0){
					Predicate condition=builder.equal(planillaRevisionRoot.get("comportamiento"), instance.getPlanillaRevision().getComportamiento());
					p.add(condition);
				}
				if(instance.getPlanillaRevision().getColmena()!=null){
					if(instance.getPlanillaRevision().getColmena().getIdColmena()!=null && instance.getPlanillaRevision().getColmena().getIdColmena().intValue()>0){
						Predicate condition=builder.equal(colmenaPrRoot.get("idColmena"), instance.getPlanillaRevision().getColmena().getIdColmena());
						p.add(condition);
					}
				}
				
				
			}
			if(instance.getAlza()!=null){
				if(instance.getAlza().getIdAlza()!=null && instance.getAlza().getIdAlza().intValue()>0){
					Predicate condition=builder.equal(alzaRoot.get("idAlza"), instance.getAlza().getIdAlza());
					p.add(condition);
				}
				
				if(instance.getAlza().getEstadoAlza()!=null && instance.getAlza().getEstadoAlza().length()>0){
					Predicate condition=builder.like(alzaRoot.<String>get("estadoAlza"), "%"+instance.getAlza().getEstadoAlza()+"%");
					p.add(condition);
				}
				
				if(instance.getAlza().getPiso()!=null){
					if(instance.getAlza().getPiso().getColmena()!=null){
						if(instance.getAlza().getPiso().getColmena().getIdColmena()!=null && instance.getAlza().getPiso().getColmena().getIdColmena().intValue()>0){
							Predicate condition=builder.equal(colmenaRoot.get("idColmena"), instance.getAlza().getPiso().getColmena().getIdColmena());
							p.add(condition);
						}
					}
				}
			}
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<PlanillaRevisionAlza> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}
	@Override
	public PlanillaRevisionAlza obtenerPorIdPlanillaRevisionAlza(int id)
			throws Exception {
		try {
			Open();
			PlanillaRevisionAlza instance = em.find(PlanillaRevisionAlza.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}
	@Override
	public PlanillaRevisionAlza eliminarPlanillaRevisionAlza(
			PlanillaRevisionAlza instance) throws Exception {
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
				String hql="delete from PlanillaRevisionAlza a where a.idPlanillaRevisionAlza in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdPlanillaRevisionAlza() throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(model.idPlanillaRevisionAlza) from PlanillaRevisionAlza model");
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
