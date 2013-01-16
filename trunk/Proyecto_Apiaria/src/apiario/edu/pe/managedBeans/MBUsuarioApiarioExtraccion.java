package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import apiario.edu.pe.bean.UsuarioApiario;
@SuppressWarnings("serial")
public class MBUsuarioApiarioExtraccion implements Serializable{
	private List<UsuarioApiario> listaUsuarioApiarioExtraccion=new ArrayList<UsuarioApiario>();
	private UsuarioApiario usuarioApiarioExtraccionSeleccionado;
	
	
	

	public UsuarioApiario getUsuarioApiarioExtraccionSeleccionado() {
		return usuarioApiarioExtraccionSeleccionado;
	}

	public void setUsuarioApiarioExtraccionSeleccionado(
			UsuarioApiario usuarioApiarioExtraccionSeleccionado) {
		this.usuarioApiarioExtraccionSeleccionado = usuarioApiarioExtraccionSeleccionado;
	}

	public List<UsuarioApiario> getListaUsuarioApiarioExtraccion() {
		return listaUsuarioApiarioExtraccion;
	}

	public void setListaUsuarioApiarioExtraccion(
			List<UsuarioApiario> listaUsuarioApiarioExtraccion) {
		this.listaUsuarioApiarioExtraccion = listaUsuarioApiarioExtraccion;
	}

	public MBUsuarioApiarioExtraccion() {
		// TODO Auto-generated constructor stub
	}
	
	public String abrirMantenimientoUsuarioApiarioExtraccion(){
		return "successMantenimientoUsuarioApiarioExtraccion";
	}
}
