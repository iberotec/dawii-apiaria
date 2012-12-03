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
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlUsuarioApiarioDAO implements IUsuarioApiarioDAO{
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
	public List<UsuarioApiario> listarTodosUsuarioApiario() throws Exception {
		List<UsuarioApiario> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from UsuarioApiario model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		System.out.println("lista??dAO "+lista);
		return lista;
	}
	

	@Override
	public UsuarioApiario guardarUsuarioApiario(UsuarioApiario instance)
			throws Exception {
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
	public List<UsuarioApiario> buscarUsuarioApiario(UsuarioApiario instance)
			throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<UsuarioApiario> criteria = builder.createQuery( UsuarioApiario.class );
		Root<UsuarioApiario> UsuarioApiarioRoot = criteria.from( UsuarioApiario.class );
		Join<UsuarioApiario,Apiario> apiarioRoot = UsuarioApiarioRoot.join( "apiario" );
		Join<UsuarioApiario,Usuario> usuarioRoot = UsuarioApiarioRoot.join( "usuario" );
		Join<UsuarioApiario,Temporada> temporadaRoot = UsuarioApiarioRoot.join( "temporada" );
		
		criteria.select( UsuarioApiarioRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("usuarioApiario");
			if(instance.getIdUsuarioApiario()!=null && instance.getIdUsuarioApiario().intValue()>0){
				System.out.println("usuarioApiario.idUsuarioApiario");
				Predicate condition=builder.equal(UsuarioApiarioRoot.get("idUsuarioApiario"), instance.getIdUsuarioApiario());
				p.add(condition);
			}
			if(instance.getApiario()!=null){
				if(instance.getApiario().getIdApiario()!=null && instance.getApiario().getIdApiario().intValue()>0){
					System.out.println("apiario.idApiario");
					Predicate condition=builder.equal(apiarioRoot.get("idApiario"), instance.getApiario().getIdApiario());
					p.add(condition);
				}
			}
			if(instance.getUsuario()!=null){
				if(instance.getUsuario().getIdUsuario()!=null && instance.getUsuario().getIdUsuario().intValue()>0){
					System.out.println("usuario.idUsuario");
					Predicate condition=builder.equal(usuarioRoot.get("idUsuario"), instance.getUsuario().getIdUsuario());
					p.add(condition);
				}
			}
			if(instance.getTemporada()!=null){
				if(instance.getTemporada().getIdTemporada()!=null && instance.getTemporada().getIdTemporada().intValue()>0){
					System.out.println("temporada.idTemporada");
					Predicate condition=builder.equal(temporadaRoot.get("idTemporada"), instance.getTemporada().getIdTemporada());
					p.add(condition);
				}
			}
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<UsuarioApiario> lista = em.createQuery( criteria ).getResultList();
	    em.close();
	    return lista;
	}

	@Override
	public UsuarioApiario obtenerPorIdUsuarioApiario(int id) throws Exception {
		try {
			Open();
			UsuarioApiario instance = em.find(UsuarioApiario.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public UsuarioApiario eliminarUsuarioApiario(UsuarioApiario instance)
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
				String hql="delete from UsuarioApiario p where p.idUsuarioApiario in (:v_ids)";		
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
