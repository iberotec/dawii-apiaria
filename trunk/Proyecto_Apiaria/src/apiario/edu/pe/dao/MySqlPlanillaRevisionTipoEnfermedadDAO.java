package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.PlanillaRevisionTipoAlimentacion;
import apiario.edu.pe.bean.PlanillaRevisionTipoEnfermedad;

public class MySqlPlanillaRevisionTipoEnfermedadDAO implements
		IPlanillaRevisionTipoEnfermedadDAO {

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
	public List<PlanillaRevisionTipoEnfermedad> listarTodosPlanillaRevisionTipoEnfermedads()
			throws Exception {
		List<PlanillaRevisionTipoEnfermedad> lista=null;
		Open();
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select c from PlanillaRevisionTipoEnfermedad c");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		Close();
		return lista;
	}

	@Override
	public PlanillaRevisionTipoEnfermedad guardarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
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
	public List<PlanillaRevisionTipoEnfermedad> buscarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		return null;
	}

	@Override
	public PlanillaRevisionTipoEnfermedad obtenerPorIdPlanillaRevisionTipoEnfermedad(
			int id) throws Exception {
		try {
			PlanillaRevisionTipoEnfermedad instance=em.find(PlanillaRevisionTipoEnfermedad.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public PlanillaRevisionTipoEnfermedad eliminarPlanillaRevisionTipoEnfermedad(
			PlanillaRevisionTipoEnfermedad instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from PlanillaRevisionTipoEnfermedad c where c.idPlanillaRevisionTipoEnfermedad in (:v_ids)";		
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
