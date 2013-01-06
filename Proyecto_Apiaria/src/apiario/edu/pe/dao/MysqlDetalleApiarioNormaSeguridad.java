package apiario.edu.pe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.NormaSeguridadUsuarioApiario;

public class MysqlDetalleApiarioNormaSeguridad implements IDetalleApiarioNormaSeguridad{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em=emf.createEntityManager();
	@Override
	public int insertarDetalleApiarioNormaSeguridad(Apiario apiario,
			NormaSeguridad normaSeguridad) {
		
//		try {
//			em.getTransaction().begin();
//			NormaSeguridadUsuarioApiario detalle=new NormaSeguridadUsuarioApiario();	
//			detalle.setApiario(apiario);
//			detalle.setNormaSeguridad(normaSeguridad);
//			// Grabar datos, si no va el persist no se graba
//			em.persist(detalle);
//			
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			em.getTransaction().rollback();
//			System.out.println("Error " + e.getMessage());
//			
//		}finally {
//			em.close();
//			emf.close();
//		}
//		
//		
		return -1;
		
	}

}
