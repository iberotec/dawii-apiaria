package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.Usuario;

public class MysqlUsuarioDAO implements IUsuario {

	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Usuario validarUsuario(String usuario, String clave) {
		Usuario objusuario = new Usuario();
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("select u from Usuario u where u.nomUsu=:xuser and u.clave=:xcla");
				sql.setParameter("xuser", usuario);
				sql.setParameter("xcla", clave);
				List lista = sql.getResultList();
				if(lista.size()>0){
					
					objusuario = (Usuario) lista.get(0);
					
				}else{
					
					System.out.println("No ingresó");
				}
				
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
		
		return objusuario;
	}

}
