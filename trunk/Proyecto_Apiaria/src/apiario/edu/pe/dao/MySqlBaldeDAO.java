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
import apiario.edu.pe.bean.Balde;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
@SuppressWarnings(value={"unchecked"})
public class MySqlBaldeDAO implements IBaldeDAO{

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
	public List<Balde> listarTodosBalde() throws Exception {
		List<Balde> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from Balde model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public Balde guardarBalde(Balde instance) throws Exception {
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
	public List<Balde> buscarBalde(Balde instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Balde> criteria = builder.createQuery( Balde.class );
		Root<Balde> baldeRoot = criteria.from( Balde.class );
		criteria.select( baldeRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdBalde()!=null && instance.getIdBalde().intValue()>0){
				Predicate condition=builder.equal(baldeRoot.get("idBalde"), instance.getIdBalde());
				p.add(condition);
			}
			if(instance.getDisponibilidadBalde()!=null){
				Predicate condition=builder.equal(baldeRoot.get("disponibilidadBalde"), instance.getDisponibilidadBalde());
				p.add(condition);
			}
			if(instance.getCapacidadBalde()!=null && instance.getCapacidadBalde().intValue()>0){
				Predicate condition=builder.equal(baldeRoot.get("capacidadBalde"), instance.getCapacidadBalde());
				p.add(condition);
			}
		}
	
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Balde> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public Balde obtenerPorIdBalde(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Open();
			Balde instance = em.find(Balde.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public Balde eliminarBalde(Balde instance) throws Exception {
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
				String hql="delete from Balde a where a.idBalde in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdBalde() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
