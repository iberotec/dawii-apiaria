package apiario.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apiario.edu.pe.bean.EquipamientoTrabajo;
import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;

public class MySqlDetalleEquipoTrabajoDAO implements IDetalleEquipoTrabajo {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_Apiaria");
	EntityManager em = emf.createEntityManager();
	
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

}