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


import apiario.edu.pe.bean.Centrifugadora;


@SuppressWarnings(value={"unchecked"})
public class MySqlCentrifugadoraDAO implements ICentrifugadoraDAO {

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
	public List<Centrifugadora> listarTodosCentrifugadoras() throws Exception {
		List<Centrifugadora> lista=null;
		Open();
		try {
			Query sql=em.createQuery("select c from Centrifugadora c");
			lista=sql.getResultList();			
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		return lista;
	}

	@Override
	public Centrifugadora guardarCentrifugadora(Centrifugadora instance)
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
	public List<Centrifugadora> buscarCentrifugadora(Centrifugadora instance)
			throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Centrifugadora> criteria = builder.createQuery( Centrifugadora.class );
		Root<Centrifugadora> centrifugadoraRoot = criteria.from( Centrifugadora.class );
		criteria.select( centrifugadoraRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdCentrifugadora()!=null && instance.getIdCentrifugadora().intValue()>0){
				Predicate condition=builder.equal(centrifugadoraRoot.get("idCentrifugadora"), instance.getIdCentrifugadora());
				p.add(condition);
			}
			if(instance.getDisponibilidadCentrifugadora()!=null){
				Predicate condition=builder.equal(centrifugadoraRoot.get("disponibilidadCentrifugadora"), instance.getDisponibilidadCentrifugadora());
				p.add(condition);
			}
		}
		
		
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Centrifugadora> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public Centrifugadora obtenerPorIdCentrifugadora(int id) throws Exception {
		try {
			Centrifugadora instance=em.find(Centrifugadora.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public Centrifugadora eliminarCentrifugadora(Centrifugadora instance)
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
				String hql="delete from Centrifugadora c where c.idCentrifugadora in (:v_ids)";		
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
