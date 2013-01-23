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
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;

@SuppressWarnings(value={"unchecked"})
public class MySqlUsuarioDecantadoraCentrifugadoraDAO implements IUsuarioDecantadoraCentrifugadoraDAO{
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
	public List<UsuarioDecantadoraCentrifugadora> listarTodosUsuarioDecantadoraCentrifugadora()
			throws Exception {
		List<UsuarioDecantadoraCentrifugadora> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from UsuarioDecantadoraCentrifugadora model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadora()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDecantadoraCentrifugadora guardarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
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
	public List<UsuarioDecantadoraCentrifugadora> buscarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<UsuarioDecantadoraCentrifugadora> criteria = builder.createQuery( UsuarioDecantadoraCentrifugadora.class );
		Root<UsuarioDecantadoraCentrifugadora> usuarioDecantadoraCentrifugadoraRoot = criteria.from( UsuarioDecantadoraCentrifugadora.class );
		Join<UsuarioDecantadoraCentrifugadora,Usuario> usuarioRoot = usuarioDecantadoraCentrifugadoraRoot.join( "usuario" );
		Join<UsuarioDecantadoraCentrifugadora,Temporada> temporadaRoot = usuarioDecantadoraCentrifugadoraRoot.join( "temporada" );
		criteria.select( usuarioDecantadoraCentrifugadoraRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdUsuarioDecantadoraCentrifugadora()!=null && instance.getIdUsuarioDecantadoraCentrifugadora().intValue()>0){
				Predicate condition=builder.equal(usuarioDecantadoraCentrifugadoraRoot.get("idUsuarioDecantadoraCentrifugadora"), instance.getIdUsuarioDecantadoraCentrifugadora());
				p.add(condition);
			}
			if(instance.getTemporada()!=null){
				if(instance.getTemporada().getIdTemporada()!=null && instance.getTemporada().getIdTemporada().intValue()>0){
					Predicate condition=builder.equal(temporadaRoot.get("idTemporada"), instance.getTemporada().getIdTemporada());
					p.add(condition);
				}
			}
			if(instance.getUsuario()!=null){
				if(instance.getUsuario().getIdUsuario()!=null && instance.getUsuario().getIdUsuario().intValue()>0){
					Predicate condition=builder.equal(usuarioRoot.get("idUsuario"), instance.getUsuario().getIdUsuario());
					p.add(condition);
				}
			}
		}
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<UsuarioDecantadoraCentrifugadora> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public UsuarioDecantadoraCentrifugadora obtenerPorIdUsuarioDecantadoraCentrifugadora(int id)
			throws Exception {
		try {
			Open();
			UsuarioDecantadoraCentrifugadora instance = em.find(UsuarioDecantadoraCentrifugadora.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public UsuarioDecantadoraCentrifugadora eliminarUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora instance) throws Exception {
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
				String hql="delete from UsuarioDecantadoraCentrifugadora a where a.idUsuarioDecantadoraCentrifugadora in (:v_ids)";		
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
