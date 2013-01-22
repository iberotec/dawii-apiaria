package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.OrdenPedido;



public interface IOrdenPedidoDAO {
	public abstract List<OrdenPedido> listarTodosOrdenPedido() throws Exception;
	public abstract OrdenPedido guardarOrdenPedido(OrdenPedido instance) throws Exception;
	public abstract List<OrdenPedido> buscarOrdenPedido(OrdenPedido instance) throws Exception;
	public abstract OrdenPedido obtenerPorIdOrdenPedido(int id) throws Exception;
	public abstract OrdenPedido eliminarOrdenPedido(OrdenPedido instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdOrdenPedido() throws Exception;
}
