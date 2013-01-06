package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.DetalleCentrifugadoraPlanillaCosecha;

public interface IDetalleCentrifugadoraPlanillaCosechaDAO {

	public abstract List<DetalleCentrifugadoraPlanillaCosecha> listarTodosDetalleCentrifugadoraPlanillaCosechas() throws Exception;
	public abstract DetalleCentrifugadoraPlanillaCosecha guardarDetalleCentrifugadoraPlanillaCosecha(DetalleCentrifugadoraPlanillaCosecha instance) throws Exception;
	public abstract List<DetalleCentrifugadoraPlanillaCosecha> buscarDetalleCentrifugadoraPlanillaCosecha(DetalleCentrifugadoraPlanillaCosecha instance) throws Exception;
	public abstract DetalleCentrifugadoraPlanillaCosecha obtenerPorIdDetalleCentrifugadoraPlanillaCosecha(int id) throws Exception;
	public abstract DetalleCentrifugadoraPlanillaCosecha eliminarDetalleCentrifugadoraPlanillaCosecha(DetalleCentrifugadoraPlanillaCosecha instance) throws Exception;
	
}
