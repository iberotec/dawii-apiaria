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


@SuppressWarnings(value={"unchecked"})
public class MysqlApiarioDAO implements IApiarioDAO {
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
	public List<Apiario> listarTodosApiarios() throws Exception {
		List<Apiario> lista=null;
		Open();
		try {
			Query q=em.createQuery("select a from Apiario a");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public Apiario guardarApiario(Apiario instance) throws Exception {
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
	public List<Apiario> buscarApiario(Apiario instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Apiario> criteria = builder.createQuery( Apiario.class );
		Root<Apiario> apiarioRoot = criteria.from( Apiario.class );

		
		criteria.select( apiarioRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("apiario");
			if(instance.getIdApiario()!=null && instance.getIdApiario()>0){
				System.out.println("apiario.getIdapiario");
				Predicate condition=builder.equal(apiarioRoot.get("idApiario"), instance.getIdApiario());
				p.add(condition);
			}
			
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Apiario> lista = em.createQuery( criteria ).getResultList();
	    em.close();
	    return lista;
	}

	@Override
	public Apiario obtenerPorIdApiario(int id) throws Exception {
		try {
			Open();
			Apiario instance = em.find(Apiario.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public Apiario eliminarApiario(Apiario instance) throws Exception {
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
				String hql="delete from Apiario a where a.idApiario in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdApiario() throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(a.idApiario) from Apiario a");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO aPiario"+e.getMessage());
		}
		Close();
		System.out.println("Tamaño lista DAO "+lista.size());
		return lista;
	}
	@Override
	public List<Apiario> buscarApiarioCosechableDistinto(PlanillaRevision instance)
			throws Exception {
		List<Apiario> lista=null;
		Open();
		try {
			String sql;
			sql="select DISTINCT apiario from PlanillaRevision planillaRevision " +
					"join planillaRevision.usuarioApiario as usuarioApiario " +
					"join usuarioApiario.temporada as temporada " +
					"join usuarioApiario.apiario as apiario " +
							"where 0=0 ";
			if(instance!=null){
				if(instance.getEstadoCosecha()!=null && instance.getEstadoCosecha().length()>0){
					sql+="and planillaRevision.estadoCosecha = '"+instance.getEstadoCosecha()+"' ";
				}
				if(instance.getUsuarioApiario()!=null){
					if(instance.getUsuarioApiario().getTemporada()!=null){
						if(instance.getUsuarioApiario().getTemporada().getEtapaTemporada()!=null
								&& instance.getUsuarioApiario().getTemporada().getEtapaTemporada().length()>0){
							sql+="and temporada.etapaTemporada = '"+instance.getUsuarioApiario().getTemporada().getEtapaTemporada()+"' ";
						}
						if(instance.getUsuarioApiario().getTemporada().getOrdenTemporada()!=null &&
								instance.getUsuarioApiario().getTemporada().getOrdenTemporada().intValue()>0){
							sql+="and temporada.ordenTemporada = '"+instance.getUsuarioApiario().getTemporada().getOrdenTemporada()+"' ";
						}
					}
				}
			}
			System.out.println(sql);
			Query q=em.createQuery(sql);
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
