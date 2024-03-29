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
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlPlanillaRevisionDAO implements IPlanillaRevisionDAO{

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
		Open();
		try {
			Query sql=em.createQuery("select c from PlanillaRevision c");
			lista=sql.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		return lista;
	}

	@Override
	public PlanillaRevision guardarPlanillaRevision(PlanillaRevision instance)
			throws Exception {
		try {
			Open();
			
//			instance.setExistenciaReina(null);
//			instance.setNecesidadAlimentacion(null);
//			instance.setNecesidadCuracion(null);
//			instance.setFaltaEspacioCamara(null);
//			instance.setFaltaAlza(null);
			
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
	public List<PlanillaRevision> buscarPlanillaRevision(
			PlanillaRevision instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<PlanillaRevision> criteria=builder.createQuery(PlanillaRevision.class);
		Root<PlanillaRevision> planillarevisionRoot=criteria.from(PlanillaRevision.class);
		Join<PlanillaRevision,UsuarioApiario> usuarioApiarioRoot = planillarevisionRoot.join( "usuarioApiario" );
		Join<UsuarioApiario,Apiario> apiarioRoot = usuarioApiarioRoot.join( "apiario" );
		Join<UsuarioApiario,Temporada> temporadaRoot = usuarioApiarioRoot.join( "temporada" );
		criteria.select(planillarevisionRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("1");
			if(instance.getIdPlanillaRevision()!=null && instance.getIdPlanillaRevision().intValue()>0){
				System.out.println("2");
				Predicate condition=builder.equal(planillarevisionRoot.get("idPlanillaRevision"),instance.getIdPlanillaRevision());
				p.add(condition);
			}
			if(instance.getEstadoCosecha()!=null && instance.getEstadoCosecha().length()>0){
				System.out.println("3");
				Predicate condition=builder.like(planillarevisionRoot.<String>get("estadoCosecha"), instance.getEstadoCosecha());
				p.add(condition);
			}
			if(instance.getUsuarioApiario()!=null){
				System.out.println("4");
				if(instance.getUsuarioApiario().getIdUsuarioApiario()!=null && instance.getUsuarioApiario().getIdUsuarioApiario().intValue()>0){
					System.out.println("5");
					Predicate condition=builder.equal(usuarioApiarioRoot.get("idUsuarioApiario"),instance.getUsuarioApiario().getIdUsuarioApiario());
					p.add(condition);
				}
				
				if(instance.getUsuarioApiario().getApiario()!=null){
					System.out.println("6");
					if(instance.getUsuarioApiario().getApiario().getIdApiario()!=null && instance.getUsuarioApiario().getApiario().getIdApiario().intValue()>0){
						System.out.println("");
						Predicate condition=builder.equal(apiarioRoot.get("idApiario"),instance.getUsuarioApiario().getApiario().getIdApiario());
						p.add(condition);
					}
				}
				if(instance.getUsuarioApiario().getTemporada()!=null){
					System.out.println("7");
					if(instance.getUsuarioApiario().getTemporada().getIdTemporada()!=null && instance.getUsuarioApiario().getTemporada().getIdTemporada().intValue()>0){
						System.out.println("8");
						Predicate condition=builder.equal(temporadaRoot.get("idTemporada"),instance.getUsuarioApiario().getTemporada().getIdTemporada());
						p.add(condition);
					}
					if(instance.getUsuarioApiario().getTemporada().getOrdenTemporada()!=null && instance.getUsuarioApiario().getTemporada().getOrdenTemporada().intValue()>0){
						System.out.println("9");
						Predicate condition=builder.equal(temporadaRoot.get("ordenTemporada"),instance.getUsuarioApiario().getTemporada().getOrdenTemporada());
						p.add(condition);
					}
					if(instance.getUsuarioApiario().getTemporada().getEtapaTemporada()!=null && instance.getUsuarioApiario().getTemporada().getEtapaTemporada().length()>0){
						System.out.println("10");
						Predicate condition=builder.like(temporadaRoot.<String>get("etapaTemporada"), "%"+instance.getUsuarioApiario().getTemporada().getEtapaTemporada()+"%");
						p.add(condition);
					}
					if(instance.getUsuarioApiario().getTemporada().getEstadoTemporada()!=null){
						System.out.println("11");
						Predicate condition=builder.equal(temporadaRoot.get("estadoTemporada"),instance.getUsuarioApiario().getTemporada().getEstadoTemporada());
						p.add(condition);
					}
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<PlanillaRevision> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public PlanillaRevision obtenerPorIdPlanillaRevision(int id)
			throws Exception {
		try {
			Open();
			PlanillaRevision instance=em.find(PlanillaRevision.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
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
	@Override
	public List<Integer> obtenerMaximoIdPlanillaRevision() throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(model.idPlanillaRevision) from PlanillaRevision model");
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
