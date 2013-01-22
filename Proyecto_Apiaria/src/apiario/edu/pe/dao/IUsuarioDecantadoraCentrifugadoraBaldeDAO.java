package apiario.edu.pe.dao;

import java.util.List;

import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadoraBalde;



public interface IUsuarioDecantadoraCentrifugadoraBaldeDAO {
	public abstract List<UsuarioDecantadoraCentrifugadoraBalde> listarTodosUsuarioDecantadoraCentrifugadoraBalde() throws Exception;
	public abstract UsuarioDecantadoraCentrifugadoraBalde guardarUsuarioDecantadoraCentrifugadoraBalde(UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception;
	public abstract List<UsuarioDecantadoraCentrifugadoraBalde> buscarUsuarioDecantadoraCentrifugadoraBalde(UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception;
	public abstract UsuarioDecantadoraCentrifugadoraBalde obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(int id) throws Exception;
	public abstract UsuarioDecantadoraCentrifugadoraBalde eliminarUsuarioDecantadoraCentrifugadoraBalde(UsuarioDecantadoraCentrifugadoraBalde instance) throws Exception;
	public abstract List<Integer> obtenerMaximoIdUsuarioDecantadoraCentrifugadoraBalde() throws Exception;
}
