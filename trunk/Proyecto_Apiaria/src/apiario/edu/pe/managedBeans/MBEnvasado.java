package apiario.edu.pe.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DualListModel;

import apiario.edu.pe.bean.Balde;
import apiario.edu.pe.bean.OrdenPedido;
import apiario.edu.pe.bean.PlanillaEnvasado;
import apiario.edu.pe.bean.Usuario;
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
	public void guardarPlanillaEnvasado(){
		Usuario objUsuario=null;
		objUsuario=((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		PlanillaEnvasado guardar = new PlanillaEnvasado();
		guardar.setOrdenPedido(new OrdenPedido());
		guardar.getOrdenPedido().setIdOrdenPedido(ordenPedido.getIdOrdenPedido());
		guardar.setUsuario(new Usuario());
		guardar.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		guardar.setFechaEnvasado(new Date());
		
		
		
	}
}
