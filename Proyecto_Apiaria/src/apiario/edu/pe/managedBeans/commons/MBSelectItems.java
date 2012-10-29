package apiario.edu.pe.managedBeans.commons;

import java.util.List;

import javax.faces.model.SelectItem;

import apiario.edu.pe.bean.Apiario;
import apiario.edu.pe.service.SeleccionService;

public class MBSelectItems {
	
	public MBSelectItems() {
		
	}
	public SelectItem[] getCboApiario() { 
		SeleccionService service = new SeleccionService();
		List<Apiario> lista = service.ListarTodos();
		SelectItem[] cbo = new SelectItem[lista.size() + 1];
		cbo[0] = new SelectItem(0, "Seleccione...");
		for (int i = 0; i < cbo.length - 1; i++){
			cbo[i+1] = new SelectItem("hola", "chay");			
		}return cbo;
	}
	
	
}
