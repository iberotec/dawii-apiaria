package apiario.edu.pe.managedBeans.commons;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import apiario.edu.pe.bean.Alza;
import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.bean.EstadoRevision;
import apiario.edu.pe.bean.NormaSeguridad;
import apiario.edu.pe.bean.Piso;
import apiario.edu.pe.bean.TipoAlimentacion;
import apiario.edu.pe.bean.TipoEnfermedad;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBSelectItems implements Serializable{
	//lalalala
	public MBSelectItems() {
		
	}
	public SelectItem[] getCboApiario() throws Exception { 
		System.out.println("entro a apiario");
		SeleccionService service = new SeleccionService();
		List<Apiario> lista = service.listarTodosApiarios();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		int api;
		String apia="";
		for (int i = 0; i < cbo.length - 1; i++){
			api=lista.get(i).getIdApiario();
			apia="Apiario "+api;
			cbo[i+1] = new SelectItem(lista.get(i).getIdApiario(),apia);
		}return cbo;
	}
	
	public SelectItem[] getCboColmena() throws Exception { 
		System.out.println("entro a colmena");
		SeleccionService service = new SeleccionService();
		List<Colmena> lista = service.listarTodosColmenas();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		Integer col;
		String colm;
		for (int i = 0; i < cbo.length - 1; i++){
			col=lista.get(i).getIdColmena();
			colm=col.toString();
			cbo[i+1] = new SelectItem(lista.get(i).getIdColmena(),colm);			
		}return cbo;
	}
	
	public SelectItem[] getCboAlza() throws Exception { 
		System.out.println("entro a alza");
		SeleccionService service = new SeleccionService();
		List<Alza> lista = service.listarTodosAlzas();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		Integer al;
		String alz;
		for (int i = 0; i < cbo.length - 1; i++){
			al=lista.get(i).getIdAlza();
			alz=al.toString();
			cbo[i+1] = new SelectItem(lista.get(i).getIdAlza(),alz);			
		}return cbo;
	}
	
	public SelectItem[] getCboPiso() throws Exception { 
		System.out.println("entro a piso");
		SeleccionService service = new SeleccionService();
		List<Piso> lista = service.listarTodosPisos();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		Integer pis;
		String piso;
		for (int i = 0; i < cbo.length - 1; i++){
			pis=lista.get(i).getIdPiso();
			piso=pis.toString();
			cbo[i+1] = new SelectItem(lista.get(i).getIdPiso(),piso);			
		}return cbo;
	}
	
	public SelectItem[] getCboColmenaxApiario(Colmena instance) throws Exception { 
		System.out.println("entro a ColmenaxApiario");
		SeleccionService service = new SeleccionService();
		List<Colmena> lista = service.buscarColmena(instance);
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		Integer col;
		String cole;
		for (int i = 0; i < cbo.length - 1; i++){
			col=lista.get(i).getIdColmena();
			cole=col.toString();
			cbo[i+1] = new SelectItem(lista.get(i).getIdColmena(),cole);			
		}return cbo;
	}
	
	public SelectItem[] getCboTipoAlimentacion() throws Exception { 
		System.out.println("entro a tipoAlimentacion");
		SeleccionService service = new SeleccionService();
		List<TipoAlimentacion> lista = service.listarTodosTipoAlimentacions();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdTipoAlimentacion(),lista.get(i).getDescripcionTipoAlimentacion());			
		}return cbo;
	}
	
	public SelectItem[] getCboTipoEnfermedad() throws Exception { 
		System.out.println("entro a tipoEnfermedad");
		SeleccionService service = new SeleccionService();
		List<TipoEnfermedad> lista = service.listarTodosTipoEnfermedades();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdTipoEnfermedad(),lista.get(i).getDescripcionTipoEnfermedad());			
		}return cbo;
	}
	
	public SelectItem[] getCboGradoPeligroColmena() throws Exception { 
		System.out.println("entro a gradoPeligroColmena");
		SeleccionService service = new SeleccionService();
		List<EstadoRevision> lista = service.listarTodosEstadoRevisiones();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdEstadoRevision(),lista.get(i).getDescripcionEstadoRevision());			
		}return cbo;
	}
	
	public SelectItem[] getCboNormaSeguridad() throws Exception { 
		System.out.println("entro a normaSeguridad");
		SeleccionService service = new SeleccionService();
		List<NormaSeguridad> lista = service.listaNormaSeguridad();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdNormaSeguridad(),lista.get(i).getDescripcionNormaSeguridad());
		}return cbo;
	}
	
}
