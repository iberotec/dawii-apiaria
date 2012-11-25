package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.*;

public interface IDetalleEquipoTrabajo {

	public abstract List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(Integer codEstadoRevision);
	
	
}
