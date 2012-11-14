package apiario.edu.pe.managedBeans.commons;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

@SuppressWarnings("serial")
public class MBSelectItems implements Serializable{
	
	public MBSelectItems() {
		
	}
	public SelectItem[] getCboApiario() { 
		SeleccionService service = new SeleccionService();
		List<Apiario> lista = service.ListarTodos();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem(lista.get(i).getIdapiario(),lista.get(i).getDescripcion());			
		}return cbo;
	}
	
	
}
