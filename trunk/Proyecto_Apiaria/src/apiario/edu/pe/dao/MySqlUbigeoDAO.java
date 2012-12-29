package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Pai;
import apiario.edu.pe.bean.Ubigeo;

public class MySqlUbigeoDAO implements IUbigeoDAO{
	
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
	public void attachClean(Ubigeo instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(Ubigeo instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ubigeo persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(Ubigeo instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ubigeo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ubigeo merge(Ubigeo detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ubigeo transientInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listDpto(Pai instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listProv(Ubigeo instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listDis(Ubigeo instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ubigeo buscarPorCodigo(String ubiCodigo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
