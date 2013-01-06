package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.DetalleCentrifugadoraPlanillaCosecha;

public class MySqlDetalleCentrifugadoraPlanillaCosechaDAO implements
		IDetalleCentrifugadoraPlanillaCosechaDAO {

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
	public List<DetalleCentrifugadoraPlanillaCosecha> listarTodosDetalleCentrifugadoraPlanillaCosechas()
			throws Exception {
		List<DetalleCentrifugadoraPlanillaCosecha> lista=null;
		Open();
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from DetalleCentrifugadoraPlanillaCosecha c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		Close();
		return lista;
	}

	@Override
	public DetalleCentrifugadoraPlanillaCosecha guardarDetalleCentrifugadoraPlanillaCosecha(
			DetalleCentrifugadoraPlanillaCosecha instance) throws Exception {
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
	public List<DetalleCentrifugadoraPlanillaCosecha> buscarDetalleCentrifugadoraPlanillaCosecha(
			DetalleCentrifugadoraPlanillaCosecha instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleCentrifugadoraPlanillaCosecha obtenerPorIdDetalleCentrifugadoraPlanillaCosecha(
			int id) throws Exception {
		try {
			DetalleCentrifugadoraPlanillaCosecha instance=em.find(DetalleCentrifugadoraPlanillaCosecha.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public DetalleCentrifugadoraPlanillaCosecha eliminarDetalleCentrifugadoraPlanillaCosecha(
			DetalleCentrifugadoraPlanillaCosecha instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from DetalleCentrifugadoraPlanillaCosecha c where c.idDetalleCentrifugadoraPlanillaCosecha in (:v_ids)";		
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
