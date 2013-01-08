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

import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.NormaSeguridad;
@SuppressWarnings(value={"unchecked"})
public class MysqlNormaSeguridadDAO implements INormaSeguridadDAO {

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
	public List<NormaSeguridad> listaNormaSeguridad() {
		List<NormaSeguridad> lista=null;
		Open();
		try {
			Query q=em.createQuery("select a from NormaSeguridad a");
			 lista=q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		return lista;
	}

	@Override
	public List<NormaSeguridad> listarTodosNormaSeguridades() throws Exception {
		List<NormaSeguridad> lista=null;
		Open();
		try {
			Query sql=em.createQuery("select n from NormaSeguridad n");
			lista=sql.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		return lista;
	}

	@Override
	public NormaSeguridad guardarNormaSeguridad(NormaSeguridad instance)
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
	public List<NormaSeguridad> buscarNormaSeguridad(NormaSeguridad instance)
			throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<NormaSeguridad> criteria=builder.createQuery(NormaSeguridad.class);
		Root<NormaSeguridad> colmenaRoot=criteria.from(NormaSeguridad.class);
		
		criteria.select(colmenaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdNormaSeguridad()!=null && instance.getIdNormaSeguridad()>0){
				Predicate condition=builder.equal(colmenaRoot.get("idNormaSeguridad"),instance.getIdNormaSeguridad());
				p.add(condition);
			}
			if(instance.getDescripcionNormaSeguridad() !=null && instance.getDescripcionNormaSeguridad().length()>0){
				Predicate condition=builder.equal(colmenaRoot.get("descripcionNormaSeguridad"),instance.getDescripcionNormaSeguridad());
				p.add(condition);
			}
			if(instance.getActivo()!=null){
				Predicate condition=builder.equal(colmenaRoot.get("activo"),instance.getActivo());
				p.add(condition);
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<NormaSeguridad> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public NormaSeguridad obtenerPorIdNormaSeguridad(int id) throws Exception {
		try {
			Open();
			NormaSeguridad instance=em.find(NormaSeguridad.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}

	@Override
	public NormaSeguridad eliminarNormaSeguridad(NormaSeguridad instance)
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
				String hql="delete from NormaSeguridad n where n.idNormaSeguridad in (:v_ids)";		
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
