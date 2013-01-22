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
import apiario.edu.pe.bean.OrdenPedido;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
@SuppressWarnings(value={"unchecked"})
public class MySqlOrdenPedidoDAO implements IOrdenPedidoDAO{
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
	public List<OrdenPedido> listarTodosOrdenPedido() throws Exception {
		List<OrdenPedido> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from OrdenPedido model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public OrdenPedido guardarOrdenPedido(OrdenPedido instance)
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
	public List<OrdenPedido> buscarOrdenPedido(OrdenPedido instance)
			throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<OrdenPedido> criteria = builder.createQuery( OrdenPedido.class );
		Root<OrdenPedido> ordenPedidoRoot = criteria.from( OrdenPedido.class );
		criteria.select( ordenPedidoRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdOrdenPedido()!=null && instance.getIdOrdenPedido().intValue()>0){
				Predicate condition=builder.equal(ordenPedidoRoot.get("idOrdenPedido"), instance.getIdOrdenPedido());
				p.add(condition);
			}
		}
		
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<OrdenPedido> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}

	@Override
	public OrdenPedido obtenerPorIdOrdenPedido(int id) throws Exception {
		try {
			Open();
			OrdenPedido instance = em.find(OrdenPedido.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}

	@Override
	public OrdenPedido eliminarOrdenPedido(OrdenPedido instance)
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
				String hql="delete from OrdenPedido a where a.idOrdenPedido in (:v_ids)";		
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
	public List<Integer> obtenerMaximoIdOrdenPedido() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
