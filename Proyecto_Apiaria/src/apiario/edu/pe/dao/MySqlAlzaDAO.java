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
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.PlanillaRevision;
import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings(value={"unchecked"})
public class MySqlAlzaDAO  implements IAlzaDAO{

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
	public List<Alza> listarTodosAlzas() throws Exception {
		List<Alza> lista=null;
		
		try {
			Open();
			em.getTransaction().begin();
			
			Query sql=em.createQuery("select a from Alza a");
			lista=sql.getResultList();
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally{
			Close();
		}
		
		return lista;
	}

	@Override
	public Alza guardarAlza(Alza instance) throws Exception {
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
	public List<Alza> buscarAlza(Alza instance) throws Exception {
		Open();
		CriteriaBuilder builder=emf.getCriteriaBuilder();
		CriteriaQuery<Alza> criteria=builder.createQuery(Alza.class);
		Root<Alza> alzaRoot=criteria.from(Alza.class);
		Join<Alza,Piso> pisoRoot = alzaRoot.join( "piso" );
		Join<Piso,Colmena> colmenaRoot = pisoRoot.join( "colmena" );
		Join<Colmena,Apiario> apiarioRoot = colmenaRoot.join( "apiario" );
		
		criteria.select(alzaRoot);
		List<Predicate> p=new ArrayList<Predicate>();
		
		if(instance!=null){
			if(instance.getIdAlza()!=null && instance.getIdAlza().intValue()>0){
				Predicate condition=builder.equal(alzaRoot.get("idalza"),instance.getIdAlza());
				p.add(condition);
			}
			if(instance.getEstadoAlza()!=null && instance.getEstadoAlza().length()>0){
				Predicate condition=builder.like(alzaRoot.<String>get("estadoAlza"), instance.getEstadoAlza());
				p.add(condition);
			}
			if(instance.getPiso()!=null){
				if(instance.getPiso().getIdPiso()!=null && instance.getPiso().getIdPiso().intValue()>0){
					Predicate condition=builder.equal(pisoRoot.get("idPiso"),instance.getPiso().getIdPiso());
					p.add(condition);
				}
				
				if(instance.getPiso().getColmena()!=null){
					if(instance.getPiso().getColmena().getIdColmena()!=null && instance.getPiso().getColmena().getIdColmena().intValue()>0){
						Predicate condition=builder.equal(colmenaRoot.get("idColmena"),instance.getPiso().getColmena().getIdColmena());
						p.add(condition);
					}
					if(instance.getPiso().getColmena().getApiario()!=null){
						if(instance.getPiso().getColmena().getApiario().getIdApiario()!=null && instance.getPiso().getColmena().getApiario().getIdApiario().intValue()>0){
							Predicate condition=builder.equal(apiarioRoot.get("idApiario"),instance.getPiso().getColmena().getApiario().getIdApiario());
							p.add(condition);
						}
					}
				}
			}
		}
		Predicate[] predicates=new Predicate[p.size()];
		p.toArray(predicates);
		criteria.where(predicates);
		
		List<Alza> lista=em.createQuery(criteria).getResultList();
		Close();
		return lista;
	}

	@Override
	public Alza obtenerPorIdAlza(int id) throws Exception {
		try {
			Open();
			Alza instance=em.find(Alza.class, id);
			return instance;
		} catch (RuntimeException e) {
			throw e;
		} finally{
			Close();
		}
	}

	@Override
	public Alza eliminarAlza(Alza instance) throws Exception {
		if(!(instance!=null && instance.getListaEliminar().size()>0)){
			instance.setSuccess(false);
			return instance;
		}
		List<Integer> listaIds = instance.getListaEliminar();
		instance.setSuccess(false);
		try {
			em.getTransaction().begin();
			for (int i = 0; i < listaIds.size(); i++) {
				String hql="delete from Alza a where a.idAlza in (:v_ids)";		
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

	@Override
	public List<Alza> listarAlzaporPiso(Integer codpiso) {
		List lista = null;
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("select u from Alza u where u.piso=:xpiso");
				sql.setParameter("xpiso", codpiso);
				lista = sql.getResultList();
				
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		return lista;
	}
	@Override
	public List<Integer> obtenerMaximoIdAlza() throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(a.idAlza) from Alza a");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO alza "+e.getMessage());
		}
		Close();
		System.out.println("Tama�o lista DAO "+lista.size());
		return lista;
	}

}
