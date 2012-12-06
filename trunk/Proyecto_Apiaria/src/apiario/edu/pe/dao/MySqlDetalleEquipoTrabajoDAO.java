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

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.EquipamientoTrabajo;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlDetalleEquipoTrabajoDAO implements IDetalleEquipoTrabajo {

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
	public List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(Integer codEstadoRevision) {

		List lista = null;
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("Select e from EstadoRevisionEquipamientoTrabajo e where e.equipamientoTrabajo=:xcodequitrab");
				sql.setParameter("xcodequitrab", codEstadoRevision);
				
				lista = sql.getResultList();
				
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		return lista;
	}
	@Override
	public List<EstadoRevisionEquipamientoTrabajo> listarTodosEstadoRevisionEquipamientoTrabajo()
			throws Exception {
		// TODO Auto-generated method stub
		List<EstadoRevisionEquipamientoTrabajo> lista=null;
		Open();
		try {
			Query q=em.createQuery("select model from EstadoRevisionEquipamientoTrabajo model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}
	@Override
	public EstadoRevisionEquipamientoTrabajo guardarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		try {
			instance.setSuccess(false);
			Open();
			em.getTransaction().begin();
			em.merge(instance);
			em.getTransaction().commit();
			instance.setSuccess(true);
			return instance;
		} catch (RuntimeException re) {
			instance.setSuccess(false);
			instance.setMsgResult("Error al grabar el parametro.");
			System.out.println("DAO "+re.getMessage());
			em.getTransaction().rollback();
			throw re;
		}finally{
			Close();
		}
	}
	@Override
	public List<EstadoRevisionEquipamientoTrabajo> buscarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		// TODO Auto-generated method stub
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<EstadoRevisionEquipamientoTrabajo> criteria = builder.createQuery( EstadoRevisionEquipamientoTrabajo.class );
		Root<EstadoRevisionEquipamientoTrabajo> estadoRevisionEquipamientoTrabajoRoot = criteria.from( EstadoRevisionEquipamientoTrabajo.class );
		Join<EstadoRevisionEquipamientoTrabajo,EstadoRevision> estadoRevisionRoot = estadoRevisionEquipamientoTrabajoRoot.join( "estadoRevision" );
		Join<EstadoRevisionEquipamientoTrabajo,EquipamientoTrabajo> equipamientoTrabajoRoot = estadoRevisionEquipamientoTrabajoRoot.join( "equipamientoTrabajo" );
		
		criteria.select( estadoRevisionEquipamientoTrabajoRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("apiario");
			if(instance.getIdEstadoRevisionEquipamientoTrabajo()!=null && instance.getIdEstadoRevisionEquipamientoTrabajo().intValue()>0){
				Predicate condition=builder.equal(estadoRevisionEquipamientoTrabajoRoot.get("idEstadoRevisionEquipamientoTrabajo"), instance.getIdEstadoRevisionEquipamientoTrabajo());
				p.add(condition);
			}
			
			if(instance.getEstadoRevision()!=null){
				if(instance.getEstadoRevision().getIdEstadoRevision()!=null && instance.getEstadoRevision().getIdEstadoRevision().intValue()>0){
					Predicate condition=builder.equal(estadoRevisionRoot.get("idEstadoRevision"), instance.getEstadoRevision().getIdEstadoRevision());
					p.add(condition);
				}
			}
			if(instance.getEquipamientoTrabajo()!=null){
				if(instance.getEquipamientoTrabajo().getIdEquipamientoTrabajo()!=null && instance.getEquipamientoTrabajo().getIdEquipamientoTrabajo().intValue()>0){
					Predicate condition=builder.equal(equipamientoTrabajoRoot.get("idEquipamientoTrabajo"), instance.getEquipamientoTrabajo().getIdEquipamientoTrabajo());
					p.add(condition);
				}
			}
			
			
			
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<EstadoRevisionEquipamientoTrabajo> lista = em.createQuery( criteria ).getResultList();
	    Close();
	    return lista;
	}
	@Override
	public EstadoRevisionEquipamientoTrabajo obtenerPorIdEstadoRevisionEquipamientoTrabajo(
			int id) throws Exception {
		try {
			Open();
			EstadoRevisionEquipamientoTrabajo instance = em.find(EstadoRevisionEquipamientoTrabajo.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}finally{
			Close();
		}
	}
	@Override
	public EstadoRevisionEquipamientoTrabajo eliminarEstadoRevisionEquipamientoTrabajo(
			EstadoRevisionEquipamientoTrabajo instance) throws Exception {
		// TODO Auto-generated method stub
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
				String hql="delete from EstadoRevisionEquipamientoTrabajo a where a.idEstadoRevisionEquipamientoTrabajo in (:v_ids)";		
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

}
