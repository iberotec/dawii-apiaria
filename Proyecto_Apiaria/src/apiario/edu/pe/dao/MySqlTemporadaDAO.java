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

import apiario.edu.pe.bean.Temporada;
@SuppressWarnings(value={"unchecked"})
public class MySqlTemporadaDAO implements ITemporadaDAO{
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
	public List<Temporada> listarTodosTemporada() throws Exception {
		List<Temporada> lista=null;
		Open();
		try {
			Query q=em.createQuery("select t from Temporada t");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		
		return lista;
	}

	@Override
	public Temporada guardarTemporada(Temporada instance) throws Exception {
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
	public List<Temporada> buscarTemporada(Temporada instance) throws Exception {
		Open();
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Temporada> criteria = builder.createQuery( Temporada.class );
		Root<Temporada> temporadaRoot = criteria.from( Temporada.class );

		
		criteria.select( temporadaRoot );
		List<Predicate> p = new ArrayList<Predicate>();
		
		if(instance!=null){
			System.out.println("temporada");
			if(instance.getIdTemporada()!=null && instance.getIdTemporada()>0){
				System.out.println("temporada.idTemporada");
				Predicate condition=builder.equal(temporadaRoot.get("idTemporada"), instance.getIdTemporada());
				p.add(condition);
			}
			if(instance.getPeriodoInicial()!=null){
				System.out.println("temporada.periodoInicial");
				Predicate condition=builder.equal(temporadaRoot.get("periodoInicial"), instance.getPeriodoInicial());
				p.add(condition);
			}
			if(instance.getPeriodoFinal()!=null){
				System.out.println("temporada.periodoFinal");
				Predicate condition=builder.equal(temporadaRoot.get("periodoFinal"), instance.getPeriodoFinal());
				p.add(condition);
			}
			if(instance.getEstadoTemporada()!=null){
				Predicate condition=builder.equal(temporadaRoot.get("estadoTemporada"), instance.getEstadoTemporada());
				p.add(condition);
			}
			if(instance.getEtapaTemporada()!=null){
				Predicate condition=builder.equal(temporadaRoot.get("etapaTemporada"), instance.getEtapaTemporada());
				p.add(condition);
			}
			if(instance.getOrdenTemporada()!=null && instance.getOrdenTemporada().intValue()>0){
				Predicate condition=builder.equal(temporadaRoot.get("ordenTemporada"), instance.getOrdenTemporada());
				p.add(condition);
			}
		}
		Predicate[] predicates = new Predicate[p.size()];
	    p.toArray(predicates);
	    criteria.where(predicates);
	    
	    List<Temporada> lista = em.createQuery( criteria ).getResultList();
	    em.close();
	    return lista;
	}

	@Override
	public Temporada obtenerPorIdTemporada(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada eliminarTemporada(Temporada instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integer> obtenerUltimaTemporada() throws Exception {
		List<Integer> lista=null;
		Open();
		try {
			Query q=em.createQuery("select MAX(model.ordenTemporada) from Temporada model");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("DAO "+e.getMessage());
			// TODO: handle exception
		}
		Close();
		System.out.println("lista??dAO "+lista);
		return lista;
	}

}
