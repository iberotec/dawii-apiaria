package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import apiario.edu.pe.bean.PlanillaSeguimiento;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.service.SeleccionService;
@SuppressWarnings("serial")
public class MBUsuarioApiarioExtraccion implements Serializable{
	private List<UsuarioApiario> listaUsuarioApiarioExtraccion=new ArrayList<UsuarioApiario>();
	private UsuarioApiario usuarioApiarioExtraccionSeleccionado;
	private SeleccionService service = new SeleccionService();
	
	

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
	public void listarTodosUsuarioApiarioExtraccion() throws Exception{
		Usuario objU=new Usuario();
		objU=(Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario");
		
		UsuarioApiario obj = new UsuarioApiario();
		obj.setTemporada(new Temporada());
		obj.setUsuario(new Usuario());
		obj.getTemporada().setEtapaTemporada("extraccion");
		obj.getTemporada().setEstadoTemporada(true);
		obj.getUsuario().setIdUsuario(objU.getIdUsuario());
		
		listaUsuarioApiarioExtraccion=service.buscarUsuarioApiario(obj);
		
		
	}
	public String obtenerProvincia(Set<PlanillaSeguimiento> set){
		String retorno="";
		System.out.println("tamaño planilla seguimiento provincia"+set.size());
		if(set.size()>0){
			System.out.println("entro al primer if");
			for (PlanillaSeguimiento planillaSeguimiento : set) {
				System.out.println("entro al for");
				if(planillaSeguimiento!=null){
					System.out.println("entro al segundo if");
					if(planillaSeguimiento.getZona()!=null){
						System.out.println("entro al tercer if");
						if(planillaSeguimiento.getZona().getUbigeo()!=null){
							System.out.println("entro al cuarto if");
							if(planillaSeguimiento.getZona().getUbigeo().getProvincia()!=null &&
									planillaSeguimiento.getZona().getUbigeo().getProvincia().length()>0){
								System.out.println("entro al quinto if");
								retorno=planillaSeguimiento.getZona().getUbigeo().getProvincia();
								System.out.println("retorno "+retorno);
							}
						}
					}
				}
				
			}
		}
		
		
		return retorno;
	}
	public String obtenerDepartamento(Set<PlanillaSeguimiento> set){
		String retorno="";
		System.out.println("tamaño planilla seguimiento departamento"+set.size());
		if(set.size()>0){
			System.out.println("entro al primer if");
			for (PlanillaSeguimiento planillaSeguimiento : set) {
				System.out.println("entro al for");
				if(planillaSeguimiento!=null){
					System.out.println("entro al segundo if");
					if(planillaSeguimiento.getZona()!=null){
						System.out.println("entro al tercer if");
						if(planillaSeguimiento.getZona().getUbigeo()!=null){
							System.out.println("entro al cuarto if");
							if(planillaSeguimiento.getZona().getUbigeo().getProvincia()!=null &&
									planillaSeguimiento.getZona().getUbigeo().getDepartamento().length()>0){
								System.out.println("entro al quinto if");
								retorno=planillaSeguimiento.getZona().getUbigeo().getDepartamento();
								System.out.println("retorno "+retorno);
							}
						}
					}
				}
				
			}
		}
		
		
		return retorno;
	}
}
