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
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadoraBalde;

@SuppressWarnings(value={"unchecked"})
public class MySqlUsuarioDecantadoraCentrifugadoraBaldeDAO implements IUsuarioDecantadoraCentrifugadoraBaldeDAO{
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
	public List<UsuarioDecantadoraCentrifugadoraBalde> listarTodosUsuarioDecantadoraCentrifugadoraBalde()
			throws Exception {
		List<UsuarioDecantadoraCentrifugadoraBalde> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from UsuarioDecantadoraCentrifugadoraBalde model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}
	@Override
	public UsuarioDecantadoraCentrifugadoraBalde guardarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
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
	public List<UsuarioDecantadoraCentrifugadoraBalde> buscarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<UsuarioDecantadoraCentrifugadoraBalde> criteria = builder.createQuery( UsuarioDecantadoraCentrifugadoraBalde.class );
		Root<UsuarioDecantadoraCentrifugadoraBalde> usuarioDecantadoraCentrifugadoraBaldeRoot = criteria.from( UsuarioDecantadoraCentrifugadoraBalde.class );
		Join<UsuarioDecantadoraCentrifugadoraBalde,UsuarioDecantadoraCentrifugadora> usuarioDecantadoraCentrifugadoraRoot = usuarioDecantadoraCentrifugadoraBaldeRoot.join( "usuarioDecantadoraCentrifugadora" );
		criteria.select( usuarioDecantadoraCentrifugadoraBaldeRoot );
		List<Predicate> p = new ArrayList<Predicate>();
	
		if(instance!=null){
			if(instance.getIdUsuarioDecantadoraCentrifugadoraBalde()!=null && instance.getIdUsuarioDecantadoraCentrifugadoraBalde().intValue()>0){
				Predicate condition=builder.equal(usuarioDecantadoraCentrifugadoraBaldeRoot.get("idUsuarioDecantadoraCentrifugadoraBalde"), instance.getIdUsuarioDecantadoraCentrifugadoraBalde());
				p.add(condition);
			}
			if(instance.getUsuarioDecantadoraCentrifugadora()!=null){
				if(instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora()!=null &&
						instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora().intValue()>0){
					Predicate condition=builder.equal(usuarioDecantadoraCentrifugadoraRoot.get("idUsuarioDecantadoraCentrifugadora"), instance.getUsuarioDecantadoraCentrifugadora().getIdUsuarioDecantadoraCentrifugadora());
					p.add(condition);
				}
			}
		}
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<UsuarioDecantadoraCentrifugadoraBalde> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}
	@Override
	public UsuarioDecantadoraCentrifugadoraBalde obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(
			int id) throws Exception {
		try {
			Open();
			UsuarioDecantadoraCentrifugadoraBalde instance = em.find(UsuarioDecantadoraCentrifugadoraBalde.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}
	@Override
	public UsuarioDecantadoraCentrifugadoraBalde eliminarUsuarioDecantadoraCentrifugadoraBalde(
			UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception {
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
				String hql="delete from UsuarioDecantadoraCentrifugadoraBalde a where a.idUsuarioDecantadoraCentrifugadoraBalde in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadoraBalde()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
