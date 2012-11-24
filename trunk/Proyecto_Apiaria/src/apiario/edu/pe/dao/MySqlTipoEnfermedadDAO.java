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

import apiario.edu.pe.bean.TipoAlimentacion;
import apiario.edu.pe.bean.TipoEnfermedad;

public class MySqlTipoEnfermedadDAO implements ITipoEnfermedadDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em=emf.createEntityManager();
	
	@Override
	public List<TipoEnfermedad> listarTodosTipoEnfermedades() throws Exception {
		List<TipoEnfermedad> lista=null;
		try {
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select t from TipoEnfermedad t");
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
	public TipoEnfermedad guardarTipoEnfermedad(TipoEnfermedad instance)
			throws Exception {
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
	public List<TipoEnfermedad> buscarTipoEnfermedad(TipoEnfermedad instance)
			throws Exception {
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<TipoEnfermedad> criteria=builder.createQuery(TipoEnfermedad.class);
		Root<TipoEnfermedad> colmenaRoot=criteria.from(TipoEnfermedad.class);
		
		criteria.select(colmenaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdTipoEnfermedad()>0){
				Predicate condition=builder.equal(colmenaRoot.get("idtipoEnfermedad"),instance.getIdTipoEnfermedad());
				p.add(condition);
			}
			if(instance.getDescripcionTipoEnfermedad()!=null && instance.getDescripcionTipoEnfermedad().length()>0){
				Predicate condition=builder.equal(colmenaRoot.get("descripcionTipoEnfermedad"),instance.getDescripcionTipoEnfermedad() );
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<TipoEnfermedad> lista=em.createQuery(criteria).getResultList();
		em.close();
		return lista;
	}

	@Override
	public TipoEnfermedad obtenerPorIdTipoEnfermedad(int id) throws Exception {
		try {
			TipoEnfermedad instance=em.find(TipoEnfermedad.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public TipoEnfermedad eliminarTipoEnfermedad(TipoEnfermedad instance)
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
				String hql="delete from TipoEnfermedad t where t.idtipoEnfermedad in (:v_ids)";		
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
