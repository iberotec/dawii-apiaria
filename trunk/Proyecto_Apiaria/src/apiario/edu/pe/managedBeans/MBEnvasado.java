package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DualListModel;

import apiario.edu.pe.bean.Balde;
import apiario.edu.pe.bean.OrdenPedido;
import apiario.edu.pe.bean.PlanillaEnvasado;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadoraBalde;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBEnvasado implements Serializable{

	private List<OrdenPedido> listaOP = new ArrayList<OrdenPedido>();
	private PlanillaEnvasado planillaEnvasado;
	private SeleccionService service = new SeleccionService();
	private OrdenPedido ordenPedido;
	private OrdenPedido ordenPedidoSeleccionado;
	DualListModel<Balde> dListaBalde = new DualListModel<Balde>();
	
	private String producto;
	private String tipoEnvase;
	private String cantidad;
	private String insumos;
	
	
	
	public OrdenPedido getOrdenPedido() {
		return ordenPedido;
	}
	public void setOrdenPedido(OrdenPedido ordenPedido) {
		this.ordenPedido = ordenPedido;
	}
	public DualListModel<Balde> getdListaBalde() {
		return dListaBalde;
	}
	public void setdListaBalde(DualListModel<Balde> dListaBalde) {
		this.dListaBalde = dListaBalde;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getTipoEnvase() {
		return tipoEnvase;
	}
	public void setTipoEnvase(String tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getInsumos() {
		return insumos;
	}
	public void setInsumos(String insumos) {
		this.insumos = insumos;
	}
	public OrdenPedido getOrdenPedidoSeleccionado() {
		return ordenPedidoSeleccionado;
	}
	public void setOrdenPedidoSeleccionado(OrdenPedido ordenPedidoSeleccionado) {
		this.ordenPedidoSeleccionado = ordenPedidoSeleccionado;
	}
	public List<OrdenPedido> getListaOP() {
		return listaOP;
	}
	public void setListaOP(List<OrdenPedido> listaOP) {
		this.listaOP = listaOP;
	}
	public PlanillaEnvasado getPlanillaEnvasado() {
		return planillaEnvasado;
	}
	public void setPlanillaEnvasado(PlanillaEnvasado planillaEnvasado) {
		this.planillaEnvasado = planillaEnvasado;
	}
	
	public MBEnvasado() {
		// TODO Auto-generated constructor stub
	}
	public String abrirListadoOrdenPedido(){
		return "successListadoOrdenPedido";
	}
	public void abrirRegistroPlanillaEnvasado(int id) throws Exception{
		
		ordenPedido=service.obtenerPorIdOrdenPedido(id);
		Usuario objUsuario=null;
		objUsuario=((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		
		List<Balde> fuente= new ArrayList<Balde>();
		Balde objBalde = new Balde();
		objBalde.setDisponibilidadBalde(false);
		fuente=service.buscarBalde(objBalde);
		
		List<Balde> destino = new ArrayList<Balde>();
		List<PlanillaEnvasado> listaRemover= new ArrayList<PlanillaEnvasado>();
		PlanillaEnvasado objRemover = new PlanillaEnvasado();
		objRemover.setUsuario(new Usuario());
		objRemover.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		objRemover.setOrdenPedido(new OrdenPedido());
		objRemover.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		listaRemover=service.buscarPlanillaEnvasado(objRemover);
		
		List<Integer> listaIds= new ArrayList<Integer>();
		
		if(listaRemover.size()>0){
			if(fuente.size()>0){
				for (int i = 0; i < fuente.size(); i++) {
					for (int j = 0; j < listaRemover.size(); j++) {
						if(fuente.get(i).getIdBalde().intValue()==listaRemover.get(j).getBalde().getIdBalde().intValue()){
							listaIds.add(fuente.get(i).getIdBalde().intValue());
						}
					}
				}
			}
		}
		
		if(listaIds.size()>0){
			if(fuente.size()>0){
				for (int i = 0; i < fuente.size(); i++) {
					for (int j = 0; j < listaIds.size(); j++) {
						if(fuente.get(i).getIdBalde().intValue()==listaIds.get(j).intValue()){
							fuente.remove(i);
						}
					}
				}
			}
		}
		
		
		List<PlanillaEnvasado> listaPE= new ArrayList<PlanillaEnvasado>();
		
		PlanillaEnvasado objPE= new PlanillaEnvasado();
		objPE.setUsuario(new Usuario());
		objPE.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		objPE.setOrdenPedido(new OrdenPedido());
		objPE.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		listaPE=service.buscarPlanillaEnvasado(objPE);
		
		if(listaPE.size()>0){
			for (PlanillaEnvasado planillasEnvasado : listaPE) {
				destino.add(planillasEnvasado.getBalde());
			}
		}
		
		dListaBalde = new DualListModel<Balde>(fuente, destino);
		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext
        .getCurrentInstance().getApplication()
        .getNavigationHandler();
		handler.performNavigation("successRegistrarPlanillaEnvasado");
		
	}
	public void listarOrdenPedido() throws Exception{
		listaOP=service.listarTodosOrdenPedido();
	}
	public void guardarPlanillaEnvasado() throws Exception{
		Usuario objUsuario=null;
		objUsuario=((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		PlanillaEnvasado guardar = new PlanillaEnvasado();
		guardar.setOrdenPedido(new OrdenPedido());
		guardar.setBalde(new Balde());
		guardar.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		guardar.setUsuario(new Usuario());
		guardar.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		guardar.setFechaEnvasado(new Date());
		
		List<PlanillaEnvasado> listaPE= new ArrayList<PlanillaEnvasado>();
		PlanillaEnvasado objPE= new PlanillaEnvasado();
		objPE.setUsuario(new Usuario());
		objPE.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		objPE.setOrdenPedido(new OrdenPedido());
		objPE.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		listaPE=service.buscarPlanillaEnvasado(objPE);
		
		validarDatosRepetidosPlanillaEnvasado(dListaBalde.getTarget(), listaPE, guardar);
		validarEliminacionPlanillaEnvasado(listaPE, dListaBalde.getSource());
		validarTerminoPedido();
	}
	
	public void validarDatosRepetidosPlanillaEnvasado(List<Balde> listaTarget,List<PlanillaEnvasado> listaTabla,PlanillaEnvasado obj) throws Exception{
		PlanillaEnvasado confirm= new PlanillaEnvasado();
		List<String> listaIds= new ArrayList<String>();
		if(listaTarget.size()>0){
			for (int i = 0; i < listaTarget.size(); i++) {
				listaIds.add(listaTarget.get(i).getIdBalde().toString());
			}
		}
		String id="";
		
		
		if(listaTabla.size()>0){
			//validar la actualizacion e una tabla llena
			if(dListaBalde.getTarget().size()>0){
				for (int i = 0; i < dListaBalde.getTarget().size(); i++) {
					for (int j = 0; j < listaTabla.size(); j++) {
						System.out.println("lista "+listaTabla.get(j).getBalde().getIdBalde()+
								" == "+"target "+dListaBalde.getTarget().get(i).getIdBalde());
						if(listaTabla.get(j).getBalde().getIdBalde().intValue()==
							dListaBalde.getTarget().get(i).getIdBalde().intValue()){
							System.out.println("entra if");
							id=dListaBalde.getTarget().get(i).getIdBalde().toString();
							System.out.println("id a remover "+id);
							listaIds.remove(id);
							
						}else{
							System.out.println("entra else");
						
						}
					}
					
			
				}
			}
			if(listaIds.size()>0){
				for (int i = 0; i < listaIds.size(); i++) {
					System.out.println("ids "+listaIds.get(i));
					obj.getBalde().setIdBalde(Integer.parseInt(listaIds.get(i)));
					

					confirm=service.guardarPlanillaEnvasado(obj);
					/////////////////////
//					UsuarioDecantadoraCentrifugadoraBalde objUDCB=null;
//					objUDCB=service.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(obj.getIdUsuarioDecantadoraCentrifugadoraBalde());
					
					Balde confirmar=null;
					Balde objBalde= new Balde();
					objBalde=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					objBalde.setDisponibilidadBalde(true);
					confirmar=service.guardarBalde(objBalde);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objBalde.getIdBalde()+"en tabla llena");
					}else{
						System.out.println("error en tabla llena");
					}
					///////////////////////
				}
				if(confirm.isSuccess()){
					System.out.println("ms1");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Planilla de Envasado"));  
				}else{
					System.out.println("ms2");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Planilla de Envasado")); 
				}
			}else{
				System.out.println("lista id vacia");
			}
			
			
		}else{
			//validar la actualizacion e una tabla vacia
			if(dListaBalde.getTarget().size()>0){
				for (int i = 0; i < dListaBalde.getTarget().size(); i++) {
					obj.getBalde().setIdBalde(dListaBalde.getTarget().get(i).getIdBalde());
					
				
					
					confirm=service.guardarPlanillaEnvasado(obj);	
					
					/////////////////////
//					UsuarioDecantadoraCentrifugadoraBalde objUDCB=null;
//					objUDCB=service.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(obj.getIdUsuarioDecantadoraCentrifugadoraBalde());
					
					
					Balde confirmar=null;
					Balde objBalde= new Balde();
					objBalde=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					objBalde.setDisponibilidadBalde(true);
					confirmar=service.guardarBalde(objBalde);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objBalde.getIdBalde()+"en tabla vacia");
					}else{
						System.out.println("error en tabla vacia");
					}
					///////////////////////
					
				}
				if(confirm.isSuccess()){
					System.out.println("ms3");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Planilla de Envasado"));  
				}else{
					System.out.println("ms4");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Planilla de Envasado")); 
				}
			}
		}
		
	}
	
	
	public void validarEliminacionPlanillaEnvasado(List<PlanillaEnvasado> listaTabla,List<Balde> listaSource) throws Exception{
		List<Integer> listaI= new ArrayList<Integer>();
		if(listaTabla.size()>0){
			for (int i = 0; i < listaTabla.size(); i++) {
				if(listaSource.size()>0){
					for (int j = 0; j < listaSource.size(); j++) {
						if(listaTabla.get(i).getBalde().getIdBalde()==listaSource.get(j).getIdBalde()){
							listaI.add(listaTabla.get(i).getIdPlanillaEnvasado());
						}
					}
				}
			
			}
		}
		
		System.out.println("tamaño listaI "+listaI.size());
		if(listaI.size()>0){
		PlanillaEnvasado eliminar= new PlanillaEnvasado();
		eliminar.setListaEliminar(listaI);
		PlanillaEnvasado confirmEliminar=null;
		/////////////////////
		for (int i = 0; i < listaI.size(); i++) {
			PlanillaEnvasado objPE =null;
			objPE=service.obtenerPorIdPlanillaEnvasado(listaI.get(i));
			/////////////////////
			
			
			Balde confirmar=null;
			Balde objBalde= new Balde();
			objBalde=objPE.getBalde();
			objBalde.setDisponibilidadBalde(false);
			confirmar=service.guardarBalde(objBalde);
			
			if(confirmar.isSuccess()){
				System.out.println("guardo "+objBalde.getIdBalde()+"en eliminacion");
			}else{
				System.out.println("error en eliminacion");
			}
			///////////////////////
		}
		//////////////////////////////
		confirmEliminar=service.eliminarPlanillaEnvasado(eliminar);
		
			if(confirmEliminar.isSuccess()){
				System.out.println("ms5");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Planilla de Envasado"));  
			}else{
				System.out.println("ms6");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Planilla de Envasado")); 
			}
		}
	}
	public void validarTerminoPedido() throws Exception{
		
		Double envase=Double.parseDouble(ordenPedido.getEnvase().getTipoEnvase().getDescripcionTipoEnvase());
		
		Double EnvaseXCantidad=envase*ordenPedido.getCantidadOrdenPedido();
		System.out.println("envaseXCantidad "+EnvaseXCantidad );
		
		List<PlanillaEnvasado> listaPE=new ArrayList<PlanillaEnvasado>();
		PlanillaEnvasado objPE = new PlanillaEnvasado();
		objPE.setOrdenPedido(new OrdenPedido());
		objPE.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		listaPE=service.buscarPlanillaEnvasado(objPE);
		int kilosTotales=0;
		if(listaPE.size()>0){
			for (int i = 0; i < listaPE.size(); i++) {
				kilosTotales+=listaPE.get(i).getBalde().getCapacidadBalde();
			}
		}
		if(EnvaseXCantidad==kilosTotales){
			OrdenPedido objOP = new OrdenPedido();
			objOP=service.obtenerPorIdOrdenPedido(ordenPedido.getIdOrdenPedido());
			objOP.setEstadoOrdenPedido("antendido");
			OrdenPedido confirm =null;
			confirm=service.guardarOrdenPedido(objOP);
			if(confirm.isSuccess()){
				System.out.println("se antendio el pedido");
			}else{
				System.out.println("erro en antecion de pedido");
			}
			
		}else{
			OrdenPedido objOP = new OrdenPedido();
			objOP=service.obtenerPorIdOrdenPedido(ordenPedido.getIdOrdenPedido());
			objOP.setEstadoOrdenPedido("pendiente");
			OrdenPedido confirm =null;
			confirm=service.guardarOrdenPedido(objOP);
			if(confirm.isSuccess()){
				System.out.println("pedido pendiente");
			}else{
				System.out.println("error en cambio a pendiente");
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Antecion!", "Se excedio o no se puso la cantidad exacta para el pedido"));  
		}
	}
}
