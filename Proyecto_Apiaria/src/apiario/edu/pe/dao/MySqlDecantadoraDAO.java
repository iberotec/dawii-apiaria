package apiario.edu.pe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import apiario.edu.pe.bean.Decantadora;

@SuppressWarnings(value={"unchecked"})
public class MySqlDecantadoraDAO implements IDecantadoraDAO {

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
	public List<Decantadora> listarTodosDecantadoras() throws Exception {
		List<Decantadora> lista=null;
		Open();
		try {
			Query sql=em.createQuery("select c from Decantadora c");
			lista=sql.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		return lista;
	}

	@Override
	public Decantadora guardarDecantadora(Decantadora instance)
			throws Exception {
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
	public List<Decantadora> buscarDecantadora(Decantadora instance)
			throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Decantadora> criteria = builder.createQuery( Decantadora.class );
		Root<Decantadora> decantadoraRoot = criteria.from( Decantadora.class );
		criteria.select( decantadoraRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdDecantadora()!=null && instance.getIdDecantadora().intValue()>0){
				Predicate condition=builder.equal(decantadoraRoot.get("idDecantadora"), instance.getIdDecantadora());
				p.add(condition);
			}
			if(instance.getDisponibilidadDecantadora()!=null){
				Predicate condition=builder.equal(decantadoraRoot.get("disponibilidadDecantadora"), instance.getDisponibilidadDecantadora());
				p.add(condition);
			}
		}
		
		
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Decantadora> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public Decantadora obtenerPorIdDecantadora(int id) throws Exception {
		try {
			Decantadora instance=em.find(Decantadora.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public Decantadora eliminarDecantadora(Decantadora instance)
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
				String hql="delete from Decantadora c where c.idDecantadora in (:v_ids)";		
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
