package apiario.edu.pe.managedBeans.commons;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.bean.Colmena;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBSelectItems implements Serializable{
	
	public MBSelectItems() {
		
	}
	public SelectItem[] getCboApiario() throws Exception { 
		SeleccionService service = new SeleccionService();
		List<Apiario> lista = service.listarTodosApiarios();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdapiario(),lista.get(i).getDescripcion());			
		}return cbo;
	}
	
	public SelectItem[] getCboColmena() throws Exception { 
		SeleccionService service = new SeleccionService();
		List<Colmena> lista = service.listarTodosColmenas();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		Integer col;
		String colm;
		for (int i = 0; i < cbo.length - 1; i++){
			col=lista.get(i).getIdcolmena();
			colm=col.toString();
			cbo[i+1] = new SelectItem(lista.get(i).getIdcolmena(),colm);			
		}return cbo;
	}
	
	
}
