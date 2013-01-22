package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;


public interface IUsuarioDecantadoraCentrifugadoraDAO {
	public abstract List<UsuarioDecantadoraCentrifugadora> listarTodosUsuarioDecantadoraCentrifugadora() throws Exception;
	public abstract List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadora() throws Exception;
	public abstract UsuarioDecantadoraCentrifugadora guardarUsuarioDecantadoraCentrifugadora(UsuarioDecantadoraCentrifugadora instance) throws Exception;
	public abstract List<UsuarioDecantadoraCentrifugadora> buscarUsuarioDecantadoraCentrifugadora(UsuarioDecantadoraCentrifugadora instance) throws Exception;
	public abstract UsuarioDecantadoraCentrifugadora obtenerPorIdUsuarioDecantadoraCentrifugadora(int id) throws Exception;
	public abstract UsuarioDecantadoraCentrifugadora eliminarUsuarioDecantadoraCentrifugadora(UsuarioDecantadoraCentrifugadora instance) throws Exception;
}
