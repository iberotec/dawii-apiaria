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

import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Reina;

public class MySqlReinaDAO implements IReinaDAO{

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
	public List<Reina> listarTodosReinas() throws Exception {
		List<Reina> lista=null;
		
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select r from Reina r");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally{
			em.close();
			emf.close();
		}
		
		return lista;
	}

	@Override
	public Reina guardarReina(Reina instance) throws Exception {
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
	public List<Reina> buscarReina(Reina instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<Reina> criteria=builder.createQuery(Reina.class);
		Root<Reina> reinaRoot=criteria.from(Reina.class);
		Join<Reina,Colmena> colmenaRoot = reinaRoot.join("colmena");
		
		criteria.select(reinaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		if(instance!=null){
			if(instance.getIdReina()!=null && instance.getIdReina()>0){
				Predicate condition=builder.equal(reinaRoot.get("idReina"),instance.getIdReina());
				p.add(condition);
			}
			if(instance.getColmena()!=null){
				if(instance.getColmena().getIdColmena()!=null && instance.getColmena().getIdColmena()>0){
					Predicate condition=builder.equal(colmenaRoot.get("idColmena"),instance.getColmena().getIdColmena());
					p.add(condition);
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<Reina> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public Reina obtenerPorIdReina(int id) throws Exception {
		try {
			Open();
			Reina instance=em.find(Reina.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}

	@Override
	public Reina eliminarReina(Reina instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from Reina r where r.idReina in (:v_ids)";		
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
