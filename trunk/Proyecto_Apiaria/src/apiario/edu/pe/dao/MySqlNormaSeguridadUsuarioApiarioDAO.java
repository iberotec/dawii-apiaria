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
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlNormaSeguridadUsuarioApiarioDAO implements INormaSeguridadUsuarioApiarioDAO{

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
	public List<NormaSeguridadUsuarioApiario> listarTodosNormaSeguridadApiarioes()
			throws Exception {
		List<NormaSeguridadUsuarioApiario> lista=null;
		Open();
		try {
			Query q=em.createQuery("select a from NormaSeguridadUsuarioApiario a");
			lista=q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		
		
		Close();
		return lista;
	}

	@Override
	public NormaSeguridadUsuarioApiario guardarNormaSeguridadApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
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
	public List<NormaSeguridadUsuarioApiario> buscarNormaSeguridadApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<NormaSeguridadUsuarioApiario> criteria=builder.createQuery(NormaSeguridadUsuarioApiario.class);
		Root<NormaSeguridadUsuarioApiario> normaSeguridadUsuarioApiarioRoot=criteria.from(NormaSeguridadUsuarioApiario.class);
		Join<NormaSeguridadUsuarioApiario,UsuarioApiario> usuarioApiarioRoot = normaSeguridadUsuarioApiarioRoot.join( "usuarioApiario" );
		Join<NormaSeguridadUsuarioApiario,NormaSeguridad> normaSeguridadRoot = normaSeguridadUsuarioApiarioRoot.join( "normaSeguridad" );
		criteria.select(normaSeguridadUsuarioApiarioRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdNormaSeguridadUsuarioApiario()!=null && instance.getIdNormaSeguridadUsuarioApiario().intValue()>0){
				Predicate condition=builder.equal(normaSeguridadUsuarioApiarioRoot.get("idNormaSeguridadUsuarioApiario"),instance.getIdNormaSeguridadUsuarioApiario());
				p.add(condition);
			}
			if(instance.getUsuarioApiario()!=null){
				if(instance.getUsuarioApiario().getIdUsuarioApiario()!=null && instance.getUsuarioApiario().getIdUsuarioApiario().intValue()>0){
					Predicate condition=builder.equal(usuarioApiarioRoot.get("idUsuarioApiario"),instance.getUsuarioApiario().getIdUsuarioApiario());
					p.add(condition);
				}
			}
			if(instance.getNormaSeguridad()!=null){
				if(instance.getNormaSeguridad().getIdNormaSeguridad()!=null && instance.getNormaSeguridad().getIdNormaSeguridad().intValue()>0){
					Predicate condition=builder.equal(normaSeguridadRoot.get("idNormaSeguridad"),instance.getNormaSeguridad().getIdNormaSeguridad());
					p.add(condition);
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<NormaSeguridadUsuarioApiario> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public NormaSeguridadUsuarioApiario obtenerPorIdNormaSeguridadApiario(int id)
			throws Exception {
		try {
			Open();
			NormaSeguridadUsuarioApiario instance=em.find(NormaSeguridadUsuarioApiario.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}

	@Override
	public NormaSeguridadUsuarioApiario eliminarNormaSeguridadApiario(
			NormaSeguridadUsuarioApiario instance) throws Exception {
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
				String hql="delete from NormaSeguridadUsuarioApiario n where n.idNormaSeguridadApiario in (:v_ids)";		
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
