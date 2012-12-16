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
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadApiario;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.UsuarioApiario;

public class MySqlNormaSeguridadApiarioDAO implements INormaSeguridadApiarioDAO{

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
	public List<NormaSeguridadApiario> listarTodosNormaSeguridadApiarioes()
			throws Exception {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from NormaSeguridadApiario a");
		List<NormaSeguridadApiario> lista=q.getResultList();
		return lista;
	}

	@Override
	public NormaSeguridadApiario guardarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
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
	public List<NormaSeguridadApiario> buscarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<NormaSeguridadApiario> criteria=builder.createQuery(NormaSeguridadApiario.class);
		Root<NormaSeguridadApiario> normaSeguridadApiarioRoot=criteria.from(NormaSeguridadApiario.class);
		Join<NormaSeguridadApiario,Apiario> apiarioRoot = normaSeguridadApiarioRoot.join( "apiario" );
		
		criteria.select(normaSeguridadApiarioRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdNormaSeguridadApiario()!=null && instance.getIdNormaSeguridadApiario().intValue()>0){
				Predicate condition=builder.equal(normaSeguridadApiarioRoot.get("idNormaSeguridadApiario"),instance.getIdNormaSeguridadApiario());
				p.add(condition);
			}
			if(instance.getApiario()!=null){
				if(instance.getApiario().getIdApiario()!=null && instance.getApiario().getIdApiario().intValue()>0){
					Predicate condition=builder.equal(apiarioRoot.get("idApiario"),instance.getApiario().getIdApiario());
					p.add(condition);
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<NormaSeguridadApiario> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public NormaSeguridadApiario obtenerPorIdNormaSeguridadApiario(int id)
			throws Exception {
		try {
			NormaSeguridadApiario instance=em.find(NormaSeguridadApiario.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public NormaSeguridadApiario eliminarNormaSeguridadApiario(
			NormaSeguridadApiario instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from NormaSeguridadApiario n where n.idNormaSeguridadApiario in (:v_ids)";		
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
