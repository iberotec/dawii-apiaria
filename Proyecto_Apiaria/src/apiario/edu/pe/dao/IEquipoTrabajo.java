package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.*;

public interface IEquipoTrabajo {

	public abstract List<EstadoRevisionEquipamientoTrabajo> listarDetalleEquipoTrabajo(int codEstadoRevision);
	
	
}
