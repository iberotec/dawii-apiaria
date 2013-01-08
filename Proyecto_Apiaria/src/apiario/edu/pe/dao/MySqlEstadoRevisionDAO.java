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

import apiario.edu.pe.bean.EstadoRevision;
@SuppressWarnings(value={"unchecked"})
public class MySqlEstadoRevisionDAO implements IEstadoRevisionDAO {

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
	public List<EstadoRevision> listarTodosEstadoRevisiones() throws Exception {
		List<EstadoRevision> lista=null;
		Open();
		try {
			Query sql=em.createQuery("select e from EstadoRevision e");
			lista=sql.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
		}
		Close();
		return lista;
	}

	@Override
	public EstadoRevision guardarEstadoRevision(EstadoRevision instance)
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
	public List<EstadoRevision> buscarEstadoRevision(EstadoRevision instance)
			throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<EstadoRevision> criteria=builder.createQuery(EstadoRevision.class);
		Root<EstadoRevision> estadoRevisionRoot=criteria.from(EstadoRevision.class);
		
		criteria.select(estadoRevisionRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdEstadoRevision()!=null && instance.getIdEstadoRevision().intValue()>0){
				Predicate condition=builder.equal(estadoRevisionRoot.get("idEstadoRevision"),instance.getIdEstadoRevision());
				p.add(condition);
			}
			if(instance.getDescripcionEstadoRevision() !=null && instance.getDescripcionEstadoRevision().length()>0){
				Predicate condition=builder.like(estadoRevisionRoot.<String>get("descripcionEstadoRevision"), "%"+instance.getDescripcionEstadoRevision()+"%");
				p.add(condition);
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<EstadoRevision> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public EstadoRevision obtenerPorIdEstadoRevision(int id) throws Exception {
		try {
			EstadoRevision instance=em.find(EstadoRevision.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			emf.close();
			em.close();
		}
	}

	@Override
	public EstadoRevision eliminarEstadoRevision(EstadoRevision instance)
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
				String hql="delete from EstadoRevision e where e.idEstadoRevision in (:v_ids)";		
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
