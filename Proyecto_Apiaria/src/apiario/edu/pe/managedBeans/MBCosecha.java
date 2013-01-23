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

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Balde;
import apiario.edu.pe.bean.Centrifugadora;
import apiario.edu.pe.bean.Decantadora;
import apiario.edu.pe.bean.PlanillaCosechaAlza;
import apiario.edu.pe.bean.PlanillaExtraccionAlza;
import apiario.edu.pe.bean.PlanillaRevisionAlza;
import apiario.edu.pe.bean.Temporada;
import apiario.edu.pe.bean.Usuario;
import apiario.edu.pe.bean.UsuarioApiario;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadora;
import apiario.edu.pe.bean.UsuarioDecantadoraCentrifugadoraBalde;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBCosecha implements Serializable{
	private SeleccionService service = new SeleccionService();
	private UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora;
	private UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadoraSeleccionado;
	private List<UsuarioDecantadoraCentrifugadora> listaUDC= new ArrayList<UsuarioDecantadoraCentrifugadora>();
	private DualListModel<PlanillaExtraccionAlza> dListaPEA= new DualListModel<PlanillaExtraccionAlza>();
	private DualListModel<Balde> dListaBalde = new DualListModel<Balde>();
	
	private boolean mostrarComboRegistro;
	private boolean mostrarComboModificacion;

	
	

	public DualListModel<Balde> getdListaBalde() {
		return dListaBalde;
	}
	public void setdListaBalde(DualListModel<Balde> dListaBalde) {
		this.dListaBalde = dListaBalde;
	}
	public DualListModel<PlanillaExtraccionAlza> getdListaPEA() {
		return dListaPEA;
	}
	public void setdListaPEA(DualListModel<PlanillaExtraccionAlza> dListaPEA) {
		this.dListaPEA = dListaPEA;
	}
	public boolean isMostrarComboModificacion() {
		return mostrarComboModificacion;
	}
	public void setMostrarComboModificacion(boolean mostrarComboModificacion) {
		this.mostrarComboModificacion = mostrarComboModificacion;
	}
	public boolean isMostrarComboRegistro() {
		return mostrarComboRegistro;
	}
	public void setMostrarComboRegistro(boolean mostrarComboRegistro) {
		this.mostrarComboRegistro = mostrarComboRegistro;
	}
	public UsuarioDecantadoraCentrifugadora getUsuarioDecantadoraCentrifugadora() {
		return usuarioDecantadoraCentrifugadora;
	}
	public void setUsuarioDecantadoraCentrifugadora(
			UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadora) {
		this.usuarioDecantadoraCentrifugadora = usuarioDecantadoraCentrifugadora;
	}
	public UsuarioDecantadoraCentrifugadora getUsuarioDecantadoraCentrifugadoraSeleccionado() {
		return usuarioDecantadoraCentrifugadoraSeleccionado;
	}
	public void setUsuarioDecantadoraCentrifugadoraSeleccionado(
			UsuarioDecantadoraCentrifugadora usuarioDecantadoraCentrifugadoraSeleccionado) {
		this.usuarioDecantadoraCentrifugadoraSeleccionado = usuarioDecantadoraCentrifugadoraSeleccionado;
	}
	public List<UsuarioDecantadoraCentrifugadora> getListaUDC() {
		return listaUDC;
	}
	public void setListaUDC(List<UsuarioDecantadoraCentrifugadora> listaUDC) {
		this.listaUDC = listaUDC;
	}
	
	public void limpiarUsuarioDecantadoraCentrifugadora(){
		usuarioDecantadoraCentrifugadora= new UsuarioDecantadoraCentrifugadora();
		usuarioDecantadoraCentrifugadora.setCentrifugadora(new Centrifugadora());
		usuarioDecantadoraCentrifugadora.setDecantadora(new Decantadora());
		usuarioDecantadoraCentrifugadora.setUsuario(new Usuario());
		usuarioDecantadoraCentrifugadora.setTemporada(new Temporada());
		usuarioDecantadoraCentrifugadoraSeleccionado= new UsuarioDecantadoraCentrifugadora();
		
	}
	public String abrirUsuarioDecantadoraCentrifugadora(){
		return "successMantenimientoUsuarioDecantadoraCentrifugadora";
	}
	public String abrirRegistrarUsuarioDecantadoraCentrifugadora() throws Exception{
		mostrarComboModificacion=false;
		mostrarComboRegistro=true;
		limpiarUsuarioDecantadoraCentrifugadora();
		return "successNuevaAsignacionCosechaa";
	}
	public void listarUsuarioDecantadoraCentrifugadora() throws Exception{
		UsuarioDecantadoraCentrifugadora objUDC= new UsuarioDecantadoraCentrifugadora();
		Temporada objTemporada = new Temporada();
		Usuario objUsuario=null;
		objUsuario=((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		
		objTemporada.setEstadoTemporada(true);
		objTemporada.setEtapaTemporada("cosecha");
		List<Temporada> listaT = new ArrayList<Temporada>();
		listaT=service.buscarTemporada(objTemporada);
		
		if(listaT.size()>0){
			objUDC.setUsuario(new Usuario());
			objUDC.setTemporada(new Temporada());
			objUDC.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
			objUDC.getTemporada().setIdTemporada(listaT.get(0).getIdTemporada());
			
			listaUDC = service.buscarUsuarioDecantadoraCentrifugadora(objUDC);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Esta fuera de Temnporada")); 
		}
		
	
	}
	public void guardarUsuarioDecantadoraCentrifugadora() throws Exception{
		UsuarioDecantadoraCentrifugadora confirm = null;
		Temporada objTemporada = new Temporada();
		objTemporada.setEstadoTemporada(true);
		objTemporada.setEtapaTemporada("cosecha");
		List<Temporada> listaT = new ArrayList<Temporada>();
		listaT=service.buscarTemporada(objTemporada);
		
		Usuario objUsuario=null;
		objUsuario=((Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("usuario"));
		
		
		usuarioDecantadoraCentrifugadora.getUsuario().setIdUsuario(objUsuario.getIdUsuario());
		usuarioDecantadoraCentrifugadora.setFechaAsignacion(new Date());
		usuarioDecantadoraCentrifugadora.setEstadoAsignacion("asignado");
		if(listaT.size()>0){
			usuarioDecantadoraCentrifugadora.getTemporada().setIdTemporada(listaT.get(0).getIdTemporada());
			confirm=service.guardarUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora);
			if(confirm.isSuccess()){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se grabo la asignacion correctamente"));
				
				Decantadora objDecantadora = new Decantadora();
				Decantadora confimD = new Decantadora();
				objDecantadora.setIdDecantadora(usuarioDecantadoraCentrifugadora.getDecantadora().getIdDecantadora());
				objDecantadora.setDisponibilidadDecantadora(false);
				confimD=service.guardarDecantadora(objDecantadora);
				if(confimD.isSuccess()){
					System.out.println("se modifico la decantadora");
				}else{
					System.out.println("error en modificacion de decantadora");
				}
				Centrifugadora objCentrifugadora = new Centrifugadora();
				Centrifugadora confimC = new Centrifugadora();
				objCentrifugadora.setIdCentrifugadora(usuarioDecantadoraCentrifugadora.getCentrifugadora().getIdCentrifugadora());
				objCentrifugadora.setDisponibilidadCentrifugadora(false);
				confimC=service.guardarCentrifugadora(objCentrifugadora);
				if(confimC.isSuccess()){
					System.out.println("se modifico la centrifugadora");
				}else{
					System.out.println("error en modificacion de centrifugadora");
				}
					
				
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error:", "No se grabo la asignacion"));
			}
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atención", "Esta fuera de Temnporada")); 
		}
		
		
	}
	public void abrirModificarUsuarioDecantadoraCentrifugadora(int id) throws Exception{
		mostrarComboModificacion=true;
		mostrarComboRegistro=false;
		usuarioDecantadoraCentrifugadora=service.obtenerPorIdUsuarioDecantadoraCentrifugadora(id);
		
		Temporada objT = new Temporada();
		objT.setEtapaTemporada("extraccion");
		
		List<Integer> listaOrden= new ArrayList<Integer>();
		listaOrden=service.obtenerUltimaTemporada(objT);
		List<Temporada> listaTemporada = new ArrayList<Temporada>();
		Temporada objTemporada = new Temporada();
		if(listaOrden.size()>0){
			objTemporada.setEtapaTemporada("extraccion");
			objTemporada.setOrdenTemporada(listaOrden.get(0));
			
			listaTemporada=service.buscarTemporada(objTemporada);
		}else{
			System.out.println("no se encontro temporada para llenar fuente de pick list");
		}
		
		
		List<PlanillaExtraccionAlza> fuente = new ArrayList<PlanillaExtraccionAlza>();
		PlanillaExtraccionAlza objFuentePEA = new PlanillaExtraccionAlza();
		objFuentePEA.setUsuarioApiario(new UsuarioApiario());
		objFuentePEA.getUsuarioApiario().setTemporada(new Temporada());
		objFuentePEA.getUsuarioApiario().getTemporada().setIdTemporada(listaTemporada.get(0).getIdTemporada());
		fuente=service.buscarPlanillaExtraccionAlza(objFuentePEA);
		
		List<PlanillaCosechaAlza> listaRemueveRepetidos= new ArrayList<PlanillaCosechaAlza>();
		PlanillaCosechaAlza objRemueveRepetidos= new PlanillaCosechaAlza();
		objRemueveRepetidos.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objRemueveRepetidos.getUsuarioDecantadoraCentrifugadora().setTemporada(new Temporada());
		objRemueveRepetidos.getUsuarioDecantadoraCentrifugadora().getTemporada().setIdTemporada(usuarioDecantadoraCentrifugadora.getTemporada().getIdTemporada());
		List<Integer> listIdsCont= new ArrayList<Integer>();
		
		listaRemueveRepetidos=service.buscarPlanillaCosechaAlza(objRemueveRepetidos);
		if(listaRemueveRepetidos.size()>0){
			if(fuente.size()>0){
				for (int i = 0; i < fuente.size(); i++) {
				
					for (int j = 0; j < listaRemueveRepetidos.size(); j++) {
						System.out.println("fuente "+fuente.get(i).getPlanillaRevisionAlza().getAlza().getIdAlza()+" == "+
								"remueve "+listaRemueveRepetidos.get(j).getPlanillaExtraccionAlza().getPlanillaRevisionAlza().getAlza().getIdAlza());
						if(fuente.get(i).getPlanillaRevisionAlza().getIdPlanillaRevisionAlza().intValue()==
							listaRemueveRepetidos.get(j).getPlanillaExtraccionAlza().getPlanillaRevisionAlza().getIdPlanillaRevisionAlza().intValue()){
//							fuente.remove(i);
							listIdsCont.add(fuente.get(i).getPlanillaRevisionAlza().getAlza().getIdAlza());
						}
					}
				}
			}
		}
		if(listIdsCont.size()>0){
			if(fuente.size()>0){
				for (int i = 0; i < fuente.size(); i++) {
					for (int j = 0; j < listIdsCont.size(); j++) {
						System.out.println("fuente "+fuente.get(i).getPlanillaRevisionAlza().getAlza().getIdAlza()+" == "+
								"remover integer "+listIdsCont.get(j));
						if(fuente.get(i).getPlanillaRevisionAlza().getAlza().getIdAlza().intValue()==listIdsCont.get(j).intValue()){
							fuente.remove(i);
						}
					}
					
				}
		
			}
		}
		
		List<PlanillaExtraccionAlza> destino = new ArrayList<PlanillaExtraccionAlza>();
		List<PlanillaCosechaAlza> listaBuscaPCA= new ArrayList<PlanillaCosechaAlza>();
		
		PlanillaCosechaAlza objPCA=new PlanillaCosechaAlza();
		objPCA.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objPCA.getUsuarioDecantadoraCentrifugadora().setUsuario(new Usuario());
		objPCA.getUsuarioDecantadoraCentrifugadora().getUsuario().setIdUsuario(usuarioDecantadoraCentrifugadora.getUsuario().getIdUsuario());
		objPCA.getUsuarioDecantadoraCentrifugadora().setTemporada(new Temporada());
		objPCA.getUsuarioDecantadoraCentrifugadora().getTemporada().setIdTemporada(usuarioDecantadoraCentrifugadora.getTemporada().getIdTemporada());
		
		
		listaBuscaPCA=service.buscarPlanillaCosechaAlza(objPCA);
		if(listaBuscaPCA.size()>0){
			for (PlanillaCosechaAlza planillasCosecha : listaBuscaPCA) {
				destino.add(planillasCosecha.getPlanillaExtraccionAlza());
			}
		}
		
		
		dListaPEA= new DualListModel<PlanillaExtraccionAlza>(fuente, destino);
		
		//baldes
		
		List<Balde> fuenteBalde = new ArrayList<Balde>();
		Balde objFuente = new Balde();
		objFuente.setDisponibilidadBalde(true);
		
		fuenteBalde=service.buscarBalde(objFuente);
		
		List<UsuarioDecantadoraCentrifugadoraBalde> listaRemoverUDCBrepetido= new ArrayList<UsuarioDecantadoraCentrifugadoraBalde>();
		UsuarioDecantadoraCentrifugadoraBalde objRemover = new UsuarioDecantadoraCentrifugadoraBalde();
		objRemover.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objRemover.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		listaRemoverUDCBrepetido=service.buscarUsuarioDecantadoraCentrifugadoraBalde(objRemover);
		
		
		if(fuenteBalde.size()>0){
			for (int i = 0; i < fuenteBalde.size(); i++) {
				if(listaRemoverUDCBrepetido.size()>0){
					for (int j = 0; j < listaRemoverUDCBrepetido.size(); j++) {
						if(fuenteBalde.get(i).getIdBalde().intValue()==listaRemoverUDCBrepetido.get(j).getBalde().getIdBalde().intValue()){
							fuenteBalde.remove(i);
						}
					}
				}
			}
		}
		
		
		List<Balde> destinoBalde = new ArrayList<Balde>();
		List<UsuarioDecantadoraCentrifugadoraBalde> listaUDCB= new ArrayList<UsuarioDecantadoraCentrifugadoraBalde>();
		UsuarioDecantadoraCentrifugadoraBalde objUDCB = new UsuarioDecantadoraCentrifugadoraBalde();
		objUDCB.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objUDCB.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		
		
		listaUDCB=service.buscarUsuarioDecantadoraCentrifugadoraBalde(objUDCB);
		if(listaUDCB.size()>0){
			for (UsuarioDecantadoraCentrifugadoraBalde objetosUDCB : listaUDCB) {
				destinoBalde.add(objetosUDCB.getBalde());
			}
		}
		
		
		dListaBalde = new DualListModel<Balde>(fuenteBalde, destinoBalde);
		
		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext
        .getCurrentInstance().getApplication()
        .getNavigationHandler();
		handler.performNavigation("successNuevaAsignacionCosechaa");
		
	}
	public void guardarPlanillaCosechaAlza() throws Exception{
		PlanillaCosechaAlza guardar= new PlanillaCosechaAlza();

		guardar.setPlanillaExtraccionAlza(new PlanillaExtraccionAlza());
		guardar.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		guardar.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		
		PlanillaCosechaAlza obj = new PlanillaCosechaAlza();
		obj.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		obj.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		List<PlanillaCosechaAlza> listaPCA = new ArrayList<PlanillaCosechaAlza>();
		listaPCA=service.buscarPlanillaCosechaAlza(obj);
		
		validarDatosRepetidosPlanillaCosechaAlza(dListaPEA.getTarget(), listaPCA, guardar);
		validarEliminacionPlanillaExtraccion(listaPCA, dListaPEA.getSource());
		
		validarTerminoAsignacion();
	}
	
	public void validarDatosRepetidosPlanillaCosechaAlza(List<PlanillaExtraccionAlza> listaTarget,List<PlanillaCosechaAlza> listaTabla,PlanillaCosechaAlza obj) throws Exception{
		PlanillaCosechaAlza confirm= new PlanillaCosechaAlza();
		List<String> listaIds= new ArrayList<String>();
		if(listaTarget.size()>0){
			for (int i = 0; i < listaTarget.size(); i++) {
				listaIds.add(listaTarget.get(i).getIdPlanillaExtraccionAlza().toString());
			}
		}
		String id="";
		
		
		if(listaTabla.size()>0){
			//validar la actualizacion e una tabla llena
			if(dListaPEA.getTarget().size()>0){
				for (int i = 0; i < dListaPEA.getTarget().size(); i++) {
					for (int j = 0; j < listaTabla.size(); j++) {
						System.out.println("lista "+listaTabla.get(j).getPlanillaExtraccionAlza().getIdPlanillaExtraccionAlza()+
								" == "+"target "+dListaPEA.getTarget().get(i).getIdPlanillaExtraccionAlza());
						if(listaTabla.get(j).getPlanillaExtraccionAlza().getIdPlanillaExtraccionAlza().intValue()==
							dListaPEA.getTarget().get(i).getIdPlanillaExtraccionAlza().intValue()){
							System.out.println("entra if");
							id=dListaPEA.getTarget().get(i).getIdPlanillaExtraccionAlza().toString();
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
					obj.getPlanillaExtraccionAlza().setIdPlanillaExtraccionAlza(Integer.parseInt(listaIds.get(i)));
					confirm=service.guardarPlanillaCosechaAlza(obj);
					/////////////////////
					PlanillaExtraccionAlza objPEA=null;
					objPEA=service.obtenerPorIdPlanillaExtraccionAlza(obj.getPlanillaExtraccionAlza().getIdPlanillaExtraccionAlza());
					
					Alza confirmar=null;
					Alza objAlza= new Alza();
					objAlza=objPEA.getPlanillaRevisionAlza().getAlza();
					objAlza.setEstadoAlza("en almacen");
					confirmar=service.guardarAlza(objAlza);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objAlza.getIdAlza()+"en tabla llena");
					}else{
						System.out.println("error en tabla llena");
					}
					///////////////////////
				}
				if(confirm.isSuccess()){
					System.out.println("ms1");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Cosecha"));  
				}else{
					System.out.println("ms2");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Cosecha")); 
				}
			}else{
				System.out.println("lista id vacia");
			}
			
			
		}else{
			//validar la actualizacion e una tabla vacia
			if(dListaPEA.getTarget().size()>0){
				for (int i = 0; i < dListaPEA.getTarget().size(); i++) {
					obj.getPlanillaExtraccionAlza().setIdPlanillaExtraccionAlza(dListaPEA.getTarget().get(i).getIdPlanillaExtraccionAlza());
					confirm=service.guardarPlanillaCosechaAlza(obj);	
					
					/////////////////////
					PlanillaExtraccionAlza objPEA=null;
					objPEA=service.obtenerPorIdPlanillaExtraccionAlza(obj.getPlanillaExtraccionAlza().getIdPlanillaExtraccionAlza());
					
					Alza confirmar=null;
					Alza objAlza= new Alza();
					objAlza=objPEA.getPlanillaRevisionAlza().getAlza();
					objAlza.setEstadoAlza("en almacen");
					confirmar=service.guardarAlza(objAlza);
					
					if(confirmar.isSuccess()){
						System.out.println("guardo "+objAlza.getIdAlza()+"en tabla vacia");
					}else{
						System.out.println("error en tabla vacia");
					}
					///////////////////////
					
				}
				if(confirm.isSuccess()){
					System.out.println("ms3");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Cosecha"));  
				}else{
					System.out.println("ms4");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Cosecha")); 
				}
			}
		}
		
	}
	public void validarEliminacionPlanillaExtraccion(List<PlanillaCosechaAlza> listaTabla,List<PlanillaExtraccionAlza> listaSource) throws Exception{
		List<Integer> listaI= new ArrayList<Integer>();
		if(listaTabla.size()>0){
			for (int i = 0; i < listaTabla.size(); i++) {
				if(listaSource.size()>0){
					for (int j = 0; j < listaSource.size(); j++) {
						if(listaTabla.get(i).getPlanillaExtraccionAlza().getIdPlanillaExtraccionAlza()==listaSource.get(j).getIdPlanillaExtraccionAlza()){
							listaI.add(listaTabla.get(i).getIdPlanillaCosechaAlza());
						}
					}
				}
			
			}
		}
		
		System.out.println("tamaño listaI "+listaI.size());
		if(listaI.size()>0){
		PlanillaCosechaAlza eliminar= new PlanillaCosechaAlza();
		eliminar.setListaEliminar(listaI);
		PlanillaCosechaAlza confirmEliminar=null;
		/////////////////////
		for (int i = 0; i < listaI.size(); i++) {
			PlanillaCosechaAlza objPCA =null;
			objPCA=service.obtenerPorIdPlanillaCosechaAlza(listaI.get(i));
			/////////////////////
			
			
			Alza confirmar=null;
			Alza objAlza= new Alza();
			objAlza=objPCA.getPlanillaExtraccionAlza().getPlanillaRevisionAlza().getAlza();
			objAlza.setEstadoAlza("en cosecha");
			confirmar=service.guardarAlza(objAlza);
			
			if(confirmar.isSuccess()){
				System.out.println("guardo "+objAlza.getIdAlza()+"en eliminacion");
			}else{
				System.out.println("error en eliminacion");
			}
			///////////////////////
		}
		//////////////////////////////
		confirmEliminar=service.eliminarPlanillaCosechaAlza(eliminar);
		
			if(confirmEliminar.isSuccess()){
				System.out.println("ms5");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Cosecha"));  
			}else{
				System.out.println("ms6");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Cosecha")); 
			}
		}
	}
	public void guardarLlenadoBaldes() throws Exception{
		UsuarioDecantadoraCentrifugadoraBalde guardar= new UsuarioDecantadoraCentrifugadoraBalde();
		guardar.setBalde(new Balde());
		guardar.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		guardar.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		
		UsuarioDecantadoraCentrifugadoraBalde obj = new UsuarioDecantadoraCentrifugadoraBalde();
		obj.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		obj.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		List<UsuarioDecantadoraCentrifugadoraBalde> listaUDCB = new ArrayList<UsuarioDecantadoraCentrifugadoraBalde>();
		listaUDCB=service.buscarUsuarioDecantadoraCentrifugadoraBalde(obj);
		
		validarDatosRepetidosUsuarioDecantadoraCentrifugadoraBalde(dListaBalde.getTarget(), listaUDCB, guardar);
		validarEliminacionUsuarioDecantadoraCentrifugadoraBalde(listaUDCB, dListaBalde.getSource());
		
		validarTerminoAsignacion();
	}
	
	public void validarEliminacionUsuarioDecantadoraCentrifugadoraBalde(List<UsuarioDecantadoraCentrifugadoraBalde> listaTabla,List<Balde> listaSource) throws Exception{
		List<Integer> listaI= new ArrayList<Integer>();
		if(listaTabla.size()>0){
			for (int i = 0; i < listaTabla.size(); i++) {
				if(listaSource.size()>0){
					for (int j = 0; j < listaSource.size(); j++) {
						if(listaTabla.get(i).getBalde().getIdBalde()==listaSource.get(j).getIdBalde()){
							listaI.add(listaTabla.get(i).getIdUsuarioDecantadoraCentrifugadoraBalde());
						}
					}
				}
			
			}
		}
		
		System.out.println("tamaño listaI "+listaI.size());
		if(listaI.size()>0){
		UsuarioDecantadoraCentrifugadoraBalde eliminar= new UsuarioDecantadoraCentrifugadoraBalde();
		eliminar.setListaEliminar(listaI);
		UsuarioDecantadoraCentrifugadoraBalde confirmEliminar=null;
		/////////////////////
		for (int i = 0; i < listaI.size(); i++) {
			UsuarioDecantadoraCentrifugadoraBalde objUDCB =null;
			objUDCB=service.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(listaI.get(i));
			/////////////////////
			
			
			Balde confirmar=null;
			Balde objBalde= new Balde();
			objBalde=objUDCB.getBalde();
			objBalde.setDisponibilidadBalde(true);
			confirmar=service.guardarBalde(objBalde);
			
			if(confirmar.isSuccess()){
				System.out.println("guardo "+objBalde.getIdBalde()+"en eliminacion");
			}else{
				System.out.println("error en eliminacion");
			}
			///////////////////////
		}
		//////////////////////////////
		confirmEliminar=service.eliminarUsuarioDecantadoraCentrifugadoraBalde(eliminar);
		
			if(confirmEliminar.isSuccess()){
				System.out.println("ms5");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro el Llenado de Balde"));  
			}else{
				System.out.println("ms6");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro el Llenado de Balde")); 
			}
		}
	}
	public void validarDatosRepetidosUsuarioDecantadoraCentrifugadoraBalde(List<Balde> listaTarget,List<UsuarioDecantadoraCentrifugadoraBalde> listaTabla,UsuarioDecantadoraCentrifugadoraBalde obj) throws Exception{
		UsuarioDecantadoraCentrifugadoraBalde confirm= new UsuarioDecantadoraCentrifugadoraBalde();
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
					
					Balde obteniendo = null;
					obteniendo=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					obj.setKilos(obteniendo.getCapacidadBalde());
					confirm=service.guardarUsuarioDecantadoraCentrifugadoraBalde(obj);
					/////////////////////
//					UsuarioDecantadoraCentrifugadoraBalde objUDCB=null;
//					objUDCB=service.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(obj.getIdUsuarioDecantadoraCentrifugadoraBalde());
					
					Balde confirmar=null;
					Balde objBalde= new Balde();
					objBalde=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					objBalde.setDisponibilidadBalde(false);
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
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro la Cosecha"));  
				}else{
					System.out.println("ms2");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro la Cosecha")); 
				}
			}else{
				System.out.println("lista id vacia");
			}
			
			
		}else{
			//validar la actualizacion e una tabla vacia
			if(dListaBalde.getTarget().size()>0){
				for (int i = 0; i < dListaBalde.getTarget().size(); i++) {
					obj.getBalde().setIdBalde(dListaBalde.getTarget().get(i).getIdBalde());
					
					Balde obteniendo = null;
					obteniendo=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					obj.setKilos(obteniendo.getCapacidadBalde());
					
					confirm=service.guardarUsuarioDecantadoraCentrifugadoraBalde(obj);	
					
					/////////////////////
//					UsuarioDecantadoraCentrifugadoraBalde objUDCB=null;
//					objUDCB=service.obtenerPorIdUsuarioDecantadoraCentrifugadoraBalde(obj.getIdUsuarioDecantadoraCentrifugadoraBalde());
					
					
					Balde confirmar=null;
					Balde objBalde= new Balde();
					objBalde=service.obtenerPorIdBalde(obj.getBalde().getIdBalde());
					objBalde.setDisponibilidadBalde(false);
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
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bien!", "Se registro el Llenado de Balde"));  
				}else{
					System.out.println("ms4");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se registro el Llenado de Balde")); 
				}
			}
		}
		
	}
	public String obtenerKilosExtraidos(int id) throws Exception{
		System.out.println("entro a obtener kilos totales");
		String retorno="0";
		System.out.println("id "+id);
		UsuarioDecantadoraCentrifugadoraBalde obj = new UsuarioDecantadoraCentrifugadoraBalde();
		obj.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		obj.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(id);
		
		List<UsuarioDecantadoraCentrifugadoraBalde> lista = new ArrayList<UsuarioDecantadoraCentrifugadoraBalde>();
		lista=service.buscarUsuarioDecantadoraCentrifugadoraBalde(obj);
		System.out.println("tamaño lista "+lista.size());
		if(lista.size()>0){
			Integer kilostotales=0;
			for (int i = 0; i < lista.size(); i++) {
				kilostotales+=lista.get(i).getKilos();
			}
			retorno=kilostotales.toString();
		}
		System.out.println("retorno "+retorno);
		return retorno;
	}
	public void validarTerminoAsignacion() throws Exception{
		boolean planillaCosechaAlzaOK=false;
		int contPlanillaCosechaAlzaOK=0;
		boolean llenadoBaldesOK=false;
		int contLlenadoBaldesOk=0;
		
		List<PlanillaCosechaAlza> listaPCA= new ArrayList<PlanillaCosechaAlza>();
		PlanillaCosechaAlza objPCA = new PlanillaCosechaAlza();
		objPCA.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objPCA.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		
		listaPCA=service.buscarPlanillaCosechaAlza(objPCA);
		
		for (int i = 0; i < listaPCA.size(); i++) {
			contPlanillaCosechaAlzaOK++;
		}
		
		if(contPlanillaCosechaAlzaOK>=4){
			planillaCosechaAlzaOK=true;
		}
		
		List<UsuarioDecantadoraCentrifugadoraBalde> listaUDCB= new ArrayList<UsuarioDecantadoraCentrifugadoraBalde>();
		UsuarioDecantadoraCentrifugadoraBalde objUDCB= new UsuarioDecantadoraCentrifugadoraBalde();
		objUDCB.setUsuarioDecantadoraCentrifugadora(new UsuarioDecantadoraCentrifugadora());
		objUDCB.getUsuarioDecantadoraCentrifugadora().setIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
		
		listaUDCB=service.buscarUsuarioDecantadoraCentrifugadoraBalde(objUDCB);
		
		for (int i = 0; i < listaUDCB.size(); i++) {
			contLlenadoBaldesOk++;
		}
		
		if(contLlenadoBaldesOk>=1){
			llenadoBaldesOK=true;
		}
		
		if(planillaCosechaAlzaOK && llenadoBaldesOK){
			UsuarioDecantadoraCentrifugadora obj= new UsuarioDecantadoraCentrifugadora();
			obj=service.obtenerPorIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
			obj.setEstadoAsignacion("completo");
			obj.setFechaTermino(new Date());
			UsuarioDecantadoraCentrifugadora confirm= null;
			confirm=service.guardarUsuarioDecantadoraCentrifugadora(obj);
			if(confirm.isSuccess()){
				System.out.println("se cambio el estado de la asignacion a completo");
			}else{
				System.out.println("erro en cambio de estado a completo");
			}
		}else{
			UsuarioDecantadoraCentrifugadora obj= new UsuarioDecantadoraCentrifugadora();
			obj=service.obtenerPorIdUsuarioDecantadoraCentrifugadora(usuarioDecantadoraCentrifugadora.getIdUsuarioDecantadoraCentrifugadora());
			obj.setEstadoAsignacion("asignado");
			obj.setFechaTermino(null);
			UsuarioDecantadoraCentrifugadora confirm= null;
			confirm=service.guardarUsuarioDecantadoraCentrifugadora(obj);
			if(confirm.isSuccess()){
				System.out.println("se cambio el estado de la asignacion a asignado");
			}else{
				System.out.println("erro en cambio de estado a asignado");
			}
		}
		
	}
}
