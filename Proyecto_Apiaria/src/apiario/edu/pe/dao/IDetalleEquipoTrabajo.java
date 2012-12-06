package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.EstadoRevisionEquipamientoTrabajo;



public interface IDetalleEquipoTrabajo {

	public abstract List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(Integer codEstadoRevision);
	public abstract List<EstadoRevisionEquipamientoTrabajo> listarTodosEstadoRevisionEquipamientoTrabajo() throws Exception;
	public abstract EstadoRevisionEquipamientoTrabajo guardarEstadoRevisionEquipamientoTrabajo(EstadoRevisionEquipamientoTrabajo instance) throws Exception;
	public abstract List<EstadoRevisionEquipamientoTrabajo> buscarEstadoRevisionEquipamientoTrabajo(EstadoRevisionEquipamientoTrabajo instance) throws Exception;
	public abstract EstadoRevisionEquipamientoTrabajo obtenerPorIdEstadoRevisionEquipamientoTrabajo(int id) throws Exception;
	public abstract EstadoRevisionEquipamientoTrabajo eliminarEstadoRevisionEquipamientoTrabajo(EstadoRevisionEquipamientoTrabajo instance) throws Exception;
	
}
