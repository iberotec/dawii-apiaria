package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.EquipamientoTrabajo;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;

public class MySqlEquipoTrabajoDAO implements IEquipoTrabajo {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(int codEstadoRevision) {
		
		EquipamientoTrabajo objequipotrabajo = null;
		
		try {
			em.getTransaction().begin();
				Query sql = em.createQuery("Select u from EquipamientoTrabajo u where u.idEquipamientoTrabajo=:xcodequitrab");
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		return null;
	}

}
