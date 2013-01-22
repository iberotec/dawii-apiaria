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
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;
@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaCosechaAlzaDAO implements IPlanillaCosechaAlzaDAO {

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
	public List<PlanillaCosechaAlza> listarTodosPlanillaCosechaAlza()
			throws Exception {
		List<PlanillaCosechaAlza> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from PlanillaCosechaAlza model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}
	@Override
	public PlanillaCosechaAlza guardarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
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
	public List<PlanillaCosechaAlza> buscarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaCosechaAlza> criteria = builder.createQuery( PlanillaCosechaAlza.class );
		Root<PlanillaCosechaAlza> planillaCosechaAlzaRoot = criteria.from( PlanillaCosechaAlza.class );
		Join<PlanillaCosechaAlza,UsuarioDecantadoraCentrifugadora> usuarioDecantadoraCentrifugadoraRoot = planillaCosechaAlzaRoot.join( "usuarioDecantadoraCentrifugadora" );
		Join<UsuarioDecantadoraCentrifugadora,Usuario> usuarioRoot = usuarioDecantadoraCentrifugadoraRoot.join( "usuario" );
		Join<UsuarioDecantadoraCentrifugadora,Temporada> temporadaRoot = usuarioDecantadoraCentrifugadoraRoot.join( "temporada" );
		criteria.select( planillaCosechaAlzaRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdPlanillaCosechaAlza()!=null && instance.getIdPlanillaCosechaAlza().intValue()>0){
				Predicate condition=builder.equal(planillaCosechaAlzaRoot.get("idPlanillaCosechaAlza"),instance.getIdPlanillaCosechaAlza());
				p.add(condition);
			}
			if(instance.getUsuarioDecantadoraCentrifugadora()!=null){
				if(instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora()!=null && instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora().intValue()>0){
					Predicate condition=builder.equal(usuarioDecantadoraCentrifugadoraRoot.get("idUsuarioDecantadoraCentrifugadora"),instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora());
					p.add(condition);
				}
				
				if(instance.getUsuarioDecantadoraCentrifugadora().getUsuario()!=null){
					if(instance.getUsuarioDecantadoraCentrifugadora().getUsuario().getIdUsuario()!=null && instance.getUsuarioDecantadoraCentrifugadora().getUsuario().getIdUsuario().intValue()>0){
						Predicate condition=builder.equal(usuarioRoot.get("idUsuario"),instance.getUsuarioDecantadoraCentrifugadora().getUsuario().getIdUsuario());
						p.add(condition);
					}
				}
				if(instance.getUsuarioDecantadoraCentrifugadora().getTemporada()!=null){
					if(instance.getUsuarioDecantadoraCentrifugadora().getTemporada().getIdTemporada()!=null && instance.getUsuarioDecantadoraCentrifugadora().getTemporada().getIdTemporada().intValue()>0){
						Predicate condition=builder.equal(temporadaRoot.get("idTemporada"),instance.getUsuarioDecantadoraCentrifugadora().getTemporada().getIdTemporada());
						p.add(condition);
					}
				}
			}
		}
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<PlanillaCosechaAlza> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}
	@Override
	public PlanillaCosechaAlza obtenerPorIdPlanillaCosechaAlza(int id)
			throws Exception {
		
		try {
			Open();
			PlanillaCosechaAlza instance=em.find(PlanillaCosechaAlza.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}
	@Override
	public PlanillaCosechaAlza eliminarPlanillaCosechaAlza(
			PlanillaCosechaAlza instance) throws Exception {
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
				String hql="delete from PlanillaCosechaAlza a where a.idPlanillaCosechaAlza in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdPlanillaCosechaAlza() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
